package com.codenjoy.dojo.snakebattle.model;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.PointImpl;
import static com.codenjoy.dojo.services.Direction.DOWN;
import static com.codenjoy.dojo.services.Direction.LEFT;
import static com.codenjoy.dojo.services.Direction.RIGHT;
import static com.codenjoy.dojo.services.Direction.UP;


/**
 * Created by Tall Tamias on 07.02.2019.
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Vector {
    Direction direction;
    Direction alternative;

    public static Vector getVectorForEnemy(Point point, Board board) {
        Elements head = board.getAt(point);
        System.out.println(head);

        Point me = board.getMe();

        int x = me.getX();
        int y = me.getY();

        int dx = Math.abs(x - point.getX());
        int dy = Math.abs(y - point.getY());

        System.out.println("Delta X " + dx + " Y " + dy);

        Point delta = new PointImpl();
        delta.setX(0);
        delta.setY(0);

        if (head.equals(Elements.ENEMY_HEAD_DOWN)) {
            delta.setY(dy == 1 ? -dy : -dy / 2);
        }
        if (head.equals(Elements.ENEMY_HEAD_UP)) {
            delta.setY(dy == 1 ? dy : dy / 2);
        }
        if (head.equals(Elements.ENEMY_HEAD_LEFT)) {
            delta.setX(dx == 1 ? -dx : -dx / 2);
        }
        if (head.equals(Elements.ENEMY_HEAD_RIGHT)) {
            delta.setX(dx == 1 ? dx : dx / 2);
        }

        System.out.println("before point " + point);

        Point newPoint = new PointImpl();
        newPoint.setY(point.getY() + delta.getY());
        newPoint.setX(point.getX() + delta.getX());

        newPoint = board.getBarrierInShortestWay(point, newPoint);

        System.out.println("new delta " + delta);
        System.out.println("after " + newPoint);

        return getVector(newPoint, board);
    }

    public static Vector getVector(Point point, Board board) {
        return getVector(board.getMe(), point);
    }

    public static Vector getVector(Point startPoint, Point endPoint) {
        int dx = endPoint.getX() - startPoint.getX();
        int dy = endPoint.getY() - startPoint.getY();

        return Stream.of(
                buildVector(dx, dy, Vector::firstQ, RIGHT, UP),
                buildVector(dx, dy, Vector::secondQ, LEFT, UP),
                buildVector(dx, dy, Vector::thirdQ, LEFT, DOWN),
                buildVector(dx, dy, Vector::forthQ, RIGHT, DOWN),
                new Vector(chooseDirection(dx, dy), null)
        ).filter(Objects::nonNull).findFirst().get();
    }

    private static Direction chooseDirection(int x, int y) {
        if (x == 0) {
            if (y > 0) {
                return UP;
            } else {
                return DOWN;
            }
        } else if (y == 0) {
            if (x > 0) {
                return RIGHT;
            } else {
                return LEFT;
            }
        }

        return null;
    }

    private static Vector buildVector(int x, int y, BiFunction<Integer, Integer, Boolean> comparator, Direction main, Direction alternative) {

        if (comparator.apply(x, y)) {
            if (compareByAbs(x, y)) {
                return new Vector(main, alternative);
            } else {
                return new Vector(alternative, main);
            }
        } else {
            return null;
        }
    }

    private static boolean firstQ(int x, int y) {
        return (x > 0 && y > 0);
    }

    private static boolean secondQ(int x, int y) {
        return (x < 0 && y > 0);
    }

    private static boolean thirdQ(int x, int y) {
        return (x < 0 && y < 0);
    }

    private static boolean forthQ(int x, int y) {
        return (x > 0 && y < 0);
    }

    private static boolean compareByAbs(int x, int y) {
        return Math.abs(x) > Math.abs(y);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "direction=" + direction +
                ", alternative=" + alternative +
                '}';
    }

    public Vector reverse() {
        return new Vector(getDirection().inverted(), getAlternative() == null ? null : getAlternative().inverted());
    }

    public Direction getClockwise() {
        return direction.clockwise();
    }

    public Direction getUnClockwise() {
        return direction.clockwise().inverted();
    }
}
