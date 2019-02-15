package com.codenjoy.dojo.snakebattle.strategy;

import java.util.List;
import java.util.Optional;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.snakebattle.model.Board;
import com.codenjoy.dojo.snakebattle.model.Vector;

import lombok.AllArgsConstructor;


/**
 * Created by Tall Tamias on 09.02.2019.
 */
@AllArgsConstructor(staticName = "of")
public class TrapStrategy extends AbstractStrategy {

    @Override
    public List<Direction> selectBestDirections(List<Direction> directions, Board board) {
        System.out.println("I am trap");
        Optional<Vector> vector = board.isEnemyInTrap().map(enemy ->
            coralate(enemy, board, Vector.getVectorForEnemy(enemy, board))
        );
        return vector.map(v -> filterDirections(v, directions)).orElse(directions);
    }

    private Vector coralate(Point point, Board board, Vector vector) {
        Point me = board.getMe();

        int dx = me.getX() - point.getX();
        int dy = me.getY() - point.getY();

        return dx == 0 || dy == 0 ? vector.reverse() : vector;
    }
}