package com.codenjoy.dojo.snakebattle.model;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import com.codenjoy.dojo.client.AbstractBoard;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.PointImpl;
import com.codenjoy.dojo.snakebattle.util.Pair;
import static com.codenjoy.dojo.snakebattle.model.Elements.*;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Board extends AbstractBoard<Elements> {
    private final static BoardCache BOARD_CACHE = new BoardCache();
    EnumSet<Elements> elements = EnumSet.of(BODY_HORIZONTAL, BODY_LEFT_DOWN, BODY_LEFT_UP, BODY_RIGHT_DOWN, BODY_RIGHT_UP, BODY_VERTICAL, TAIL_INACTIVE, TAIL_END_DOWN, TAIL_END_LEFT, TAIL_END_RIGHT, TAIL_END_UP);
    Elements[] mySnake = {HEAD_DOWN, HEAD_LEFT, HEAD_RIGHT, HEAD_UP, HEAD_SLEEP, HEAD_EVIL, HEAD_FLY, BODY_HORIZONTAL, BODY_LEFT_DOWN, BODY_LEFT_UP, BODY_RIGHT_DOWN, BODY_RIGHT_UP, BODY_VERTICAL, TAIL_INACTIVE, TAIL_END_DOWN, TAIL_END_LEFT, TAIL_END_RIGHT, TAIL_END_UP};

    @Override
    public Elements valueOf(char ch) {
        return Elements.valueOf(ch);
    }

    @Override
    protected int inversionY(int y) {
        return size - 1 - y;
    }

    public boolean isBarrierAt(int x, int y) {
        return isAt(x, y, WALL, START_FLOOR, ENEMY_HEAD_SLEEP, ENEMY_TAIL_INACTIVE, TAIL_INACTIVE);
    }

    public boolean isBarrierAt(Point point) {
        return isBarrierAt(point.getX(), point.getY());
    }

    public Point getMe() {
        return getMyHead().get(0);
    }

    public boolean isGameOver() {
        return getMyHead().isEmpty();
    }

    public List<Point> getMyHead() {
        return get(HEAD_DOWN, HEAD_LEFT, HEAD_RIGHT, HEAD_UP, HEAD_SLEEP, HEAD_EVIL, HEAD_FLY);
    }

    public boolean isStoneAt(int x, int y) {
        return isAt(x, y, STONE);
    }

    public boolean isMe(Elements element) {
        return elements.contains(element);
    }

    public List<Point> myElements() {
        return get(mySnake);
    }

    public List<Point> wall() {
        return get(WALL);
    }

    private List<Point> enemy() {
        return get(Stream.of(Elements.values()).filter(e -> ElementType.ENEMY.equals(e.getElementType())).toArray(Elements[]::new));
    }

    private List<Point> food() {
        return get(Stream.of(Elements.values()).filter(e -> ElementType.BONUS.equals(e.getElementType())).toArray(Elements[]::new));
    }

    public Point myTail() {
        List<Point> points = get(TAIL_INACTIVE, TAIL_END_DOWN, TAIL_END_LEFT, TAIL_END_RIGHT, TAIL_END_UP);
        return points.isEmpty() ? getMe() : points.get(0);
    }

    public List<Point> enemyHead() {
        return get(ENEMY_HEAD_UP, ENEMY_HEAD_DOWN, ENEMY_HEAD_LEFT, ENEMY_HEAD_RIGHT);
    }

    public List<Point> enemyHeadWithFury() {
        return get(ENEMY_HEAD_UP, ENEMY_HEAD_DOWN, ENEMY_HEAD_LEFT, ENEMY_HEAD_RIGHT, ENEMY_HEAD_EVIL);
    }

    public List<Point> enemyHeadAll() {
        return get(ENEMY_HEAD_UP, ENEMY_HEAD_DOWN, ENEMY_HEAD_LEFT, ENEMY_HEAD_RIGHT, ENEMY_HEAD_EVIL, ENEMY_HEAD_FLY);
    }

    public Optional<Point> findNearestFood() {
        Point me = getMe();
        Optional<Point> res = food().stream()
                .filter(p -> !isBlind(p))
                .map((p) -> Pair.of(p, me.distance(p)))
                .min(Comparator.comparingDouble(Pair::snd))
                .map(Pair::fst);
        System.out.println("Nearest " + res.map(this::getAt).orElse(Elements.NONE) + "  "
                + res.map(me::distance).orElse(0.0) + " " + res.orElse(new PointImpl(0, 0)));
        return res;
    }

    public boolean godDiet(int w) {
        return findNearestStone(Collections.emptySet()).map(stone ->
                (getMe().distance(stone) < 5 && getMySize() > w && enemy().size() > 1) || get(HEAD_EVIL).size() > 0
        ).orElse(false);
    }

    public Optional<Point> findNearestStone(Set<Point> blackList) {
        Point me = getMe();
        Optional<Point> res = get(STONE).stream()
                .filter(p -> !isBlind(p))
                .filter(p -> !blackList.contains(p))
                .map((p) -> Pair.of(p, me.distance(p)))
                .min(Comparator.comparingDouble(Pair::snd))
                .map(Pair::fst);
        System.out.println("Nearest " + res.map(this::getAt).orElse(Elements.NONE) + "  "
                + res.map(me::distance).orElse(0.0) + " " + res.orElse(new PointImpl(0, 0)));
        return res;
    }

    public Optional<Point> findNearestMine() {
        Point me = getMe();
        Optional<Point> res = get(Elements.GOLD).stream()
                .filter(p -> !isBlind(p))
                .map((p) -> Pair.of(p, me.distance(p)))
                .min(Comparator.comparingDouble(Pair::snd))
                .map(Pair::fst);
        System.out.println("Nearest " + res.map(this::getAt).orElse(Elements.NONE) + "  "
                + res.map(me::distance).orElse(0.0) + " " + res.orElse(new PointImpl(0, 0)));
        return res;
    }

    public Optional<Point> findNearestFury() {
        Point me = getMe();
        Optional<Point> res = get(Elements.FURY_PILL).stream()
                .filter(p -> !isBlind(p))
                .map((p) -> Pair.of(p, me.distance(p)))
                .min(Comparator.comparingDouble(Pair::snd))
                .map(Pair::fst);
        System.out.println("Nearest " + res.map(this::getAt).orElse(Elements.NONE) + "  "
                + res.map(me::distance).orElse(0.0) + " " + res.orElse(new PointImpl(0, 0)));
        return res;
    }

    public boolean enemyIsOneAndWeak() {
        System.out.println("My size: " + getMySize());
        System.out.println("Enemy size: " + getNearestEnemySize());

        return getMySize() - 2 >= getNearestEnemySize() && !dangerIsHere() && checkEnemyNearMyHeadForHunt();
    }

    private boolean isNearOneOfPoint(Point point, List<Point> targetPoints) {
        return targetPoints.stream().anyMatch(targetPoint -> {
            int dy = Math.abs(point.getY() - targetPoint.getY());
            int dx = Math.abs(point.getX() - targetPoint.getX());
            return dx <= 1 && dy <= 1;
        });
    }

    private boolean isNearOneOfPoint(Point point, Point targetPoint) {
        int dy = Math.abs(point.getY() - targetPoint.getY());
        int dx = Math.abs(point.getX() - targetPoint.getX());
        return dx == 1 && dy == 0 || dx == 0 && dy == 1;
    }

    private List<Point> getFigure(Point head) {
        Elements element = getAt(head);
        List<Point> points = get(element);

        LinkedList<Point> siblings = new LinkedList<>();
        siblings.add(head);
        points.remove(head);

        Point nextPoint;
        do {
            nextPoint = points.stream().filter(p -> isNearOneOfPoint(p, siblings)).findFirst().orElse(null);
            if (nextPoint != null) {
                siblings.add(nextPoint);
                points.remove(nextPoint);
            }
        } while (nextPoint != null);

        return siblings;
    }

    private List<Constraint> calculateDarkZones() {
        List<Point> allPoint = get(Elements.WALL).stream()
                .filter(p -> p.getY() > 3 && p.getY() < 28 && p.getX() > 3 && p.getX() < 28).collect(Collectors.toList());

        List<List<Point>> objects = new LinkedList<>();

        while (!allPoint.isEmpty()) {
            List<Point> list = getFigure(allPoint.get(0));
            allPoint.removeAll(list);
            objects.add(list);
        }

        return objects.stream().map(Constraint::getConstraint).collect(Collectors.toList());
    }

    List<Constraint> getDarkZones() {
        if (BOARD_CACHE.getDarkZones() == null) {
            BOARD_CACHE.setDarkZones(calculateDarkZones());
        }

        return BOARD_CACHE.getDarkZones();
    }

    private int getNearestEnemySize() {
        if (enemyHeadAll().size() == 1) {
            return enemy().size();
        }

        return findNearestEnemy().map(head -> {
            List<Point> points = enemy();
            LinkedList<Point> enemyPoints = new LinkedList<>();
            enemyPoints.add(head);
            points.remove(head);

            Point nextPoint;
            do {
                nextPoint = points.stream().filter(p -> isNearOneOfPoint(p, enemyPoints.getLast())).findFirst().orElse(null);
                if (nextPoint != null) {
                    enemyPoints.add(nextPoint);
                    points.remove(nextPoint);
                }
            } while (nextPoint != null);

            return enemyPoints.size();
        }).orElse(100);
    }

    public boolean iAmHunting() {
        return (amIAngry() && checkEnemyNearMyHeadForHunt() || enemyIsOneAndWeak());
    }

    public boolean dangerIsHere() {
        return findNearestEnemy().map(this::getAt).map(Elements.ENEMY_HEAD_EVIL::equals).orElse(false);
    }

    public int getMySize() {
        return myElements().size();
    }

    public boolean amIAngry() {
        return Elements.HEAD_EVIL.equals(getAt(getMe()));
    }

    public boolean isBlind(Point point) {
        List<Elements> elements = Direction.onlyDirections().stream().map(d -> getAt(d.change(point))).collect(Collectors.toList());

        return elementsAreNarrow(elements.get(0), elements.get(1)) ||
                elementsAreNarrow(elements.get(2), elements.get(3))

                ;
    }

    boolean elementsAreNarrow(Elements e1) {
        return Stream.of(Elements.WALL, ENEMY_TAIL_END_DOWN, ENEMY_TAIL_END_UP, ENEMY_TAIL_END_LEFT, ENEMY_TAIL_END_RIGHT, ENEMY_BODY_LEFT_DOWN, ENEMY_BODY_LEFT_UP, ENEMY_BODY_RIGHT_UP, ENEMY_BODY_RIGHT_DOWN, ENEMY_BODY_HORIZONTAL, ENEMY_BODY_VERTICAL)
                .anyMatch(e1::equals);
    }

    boolean elementsAreNarrow(Elements e1, Elements e2) {
        return elementsAreNarrow(e1) && elementsAreNarrow(e2);
    }

    private boolean elementsAreEqualAndType(Elements e1, Elements e2, Elements type) {
        return e1.equals(e2) && e1.equals(type);
    }

    public Optional<Point> findNearestEnemy() {
        return enemyHeadAll().stream().map((p) -> Pair.of(p, getMe().distance(p))).min(Comparator.comparingDouble(Pair::snd))
                .map(Pair::fst);
    }

    public boolean checkEnemyNearMyHeadForHunt() {
        return checkEnemyNearMyHead(10, enemyHead());
    }

    public boolean checkEnemyNearMyHead(int distance, List<Point> enemyHeads) {
        Point me = getMe();

        System.out.println("Enemy heads:" + enemyHeads);

        return enemyHeads.stream().map(me::distance).peek(x -> System.out.println("Distance to enemy: " + x)).anyMatch(d -> d < distance);
    }

    public Optional<Point> enemyNearestBody() {
        return enemy().stream().filter(this::pointIsNearMyHead).findFirst();
    }

    public boolean pointIsNearMyHead(Point candidate) {
        Point me = getMe();
        int dx = Math.abs(me.getX() - candidate.getX());
        int dy = Math.abs(me.getY() - candidate.getY());
        return dx == 0 && dy == 1 || dx == 1 && dy == 0;
    }

    public Point getBarrierInShortestWay(Point startPoint, Point endPoint) {
        int i = 100;
        Point prevPoint;
        Point currentPoint = startPoint.copy();

        while (!currentPoint.equals(endPoint) && i-- > 0) {
            prevPoint = currentPoint.copy();
            currentPoint.change(Vector.getVector(startPoint, endPoint).getDirection());
            if (getAt(currentPoint).equals(Elements.WALL)) return prevPoint;
        }

        return endPoint;
    }

    public Optional<Point> isEnemyInTrap() {
        return enemyHead().stream().filter(this::headInTrap).findFirst();
    }

    public boolean headInTrap(Point point) {
        List<Elements> elements = Direction.onlyDirections().stream().map(d -> getAt(d.change(point))).collect(Collectors.toList());

        return isTrap(elements.get(0), elements.get(1)) || isTrap(elements.get(2), elements.get(3));
    }

    public boolean isTrap(Elements p1, Elements p2) {
        return elementIsOneOfMeAndWall(p1) && elementIsOneOfMeAndWall(p2);
    }

    public boolean elementIsOneOfMeAndWall(Elements e) {
        return Stream.of(BODY_HORIZONTAL, BODY_VERTICAL, BODY_LEFT_DOWN, BODY_LEFT_UP, BODY_RIGHT_DOWN, BODY_RIGHT_UP, TAIL_END_DOWN, TAIL_END_DOWN, TAIL_END_LEFT, TAIL_END_RIGHT, WALL).anyMatch(e::equals);
    }
}