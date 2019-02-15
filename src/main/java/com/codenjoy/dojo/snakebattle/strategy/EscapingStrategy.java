package com.codenjoy.dojo.snakebattle.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.snakebattle.model.Board;
import com.codenjoy.dojo.snakebattle.model.Elements;
import com.codenjoy.dojo.snakebattle.model.Vector;


/**
 * Created by Tall Tamias on 09.02.2019.
 */
public class EscapingStrategy extends AbstractStrategy {

    public static EscapingStrategy of() {
        return new EscapingStrategy();
    }

    private Direction check(Point me, Point enemy) {
        int dy = me.getY() - enemy.getY();
        int dx = me.getX() - enemy.getX();

        if (Math.abs(dy) == 1 && Math.abs(dx) > 2) {
            if (dy < 0) return Direction.UP;
            if (dy > 0) return Direction.DOWN;
        } else if (Math.abs(dx) == 1 && Math.abs(dy) > 2) {
            if (dx < 0) return Direction.RIGHT;
            if (dx > 0) return Direction.LEFT;
        }

        return null;
    }

    @Override
    public List<Direction> selectBestDirections(List<Direction> directions, Board board) {
        System.out.println("I am escaping");

        Optional<Point> enemyPoint = board.findNearestEnemy();
        boolean isEnemyAngry = enemyPoint.map(board::getAt).map(e -> e.equals(Elements.ENEMY_HEAD_EVIL)).orElse(false);
        Vector vector = enemyPoint.map(enemy -> Vector.getVector(enemy, board)).get().reverse();

        if (!isEnemyAngry) {
            Direction d = check(board.getMe(), enemyPoint.get());

            if (d != null) {
                Point p = d.change(board.getMe());
                if (board.getAt(p).getWeight(board, p) > 6)
                return Collections.singletonList(d);
            }

            if (board.getMe().distance(enemyPoint.get()) > 3) {
                vector = board.findNearestFury().map(fury -> Vector.getVector(fury, board)).orElse(vector);
            }
        }

        return filterDirections(vector, directions);
    }
}
