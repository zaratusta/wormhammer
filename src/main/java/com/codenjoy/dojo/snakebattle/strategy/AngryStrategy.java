package com.codenjoy.dojo.snakebattle.strategy;

import java.util.Collections;
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
public class AngryStrategy extends AbstractStrategy {

    @Override
    public List<Direction> selectBestDirections(List<Direction> directions, Board board) {
        System.out.println("I am fury hunting");

        Optional<Point> targetBody = board.enemyNearestBody();

        if (targetBody.isPresent()) {
            return filterDirections(Vector.getVector(targetBody.get(), board), directions);
        }

        Optional<Vector> vector = board.findNearestEnemy().map(enemy -> Vector.getVectorForEnemy(enemy, board));

        if (vector.isPresent()) {
            return vector.map(v -> filterDirections(v, directions)).get();
        }

        Optional<Point> targetStone = board.findNearestStone(Collections.emptySet());

        if (targetStone.isPresent()) {
            return filterDirections(Vector.getVector(targetStone.get(), board), directions);
        }

        return directions;
    }
}