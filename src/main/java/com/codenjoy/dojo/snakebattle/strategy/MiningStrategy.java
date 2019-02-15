package com.codenjoy.dojo.snakebattle.strategy;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.snakebattle.model.Board;
import com.codenjoy.dojo.snakebattle.model.Vector;


/**
 * Created by Tall Tamias on 09.02.2019.
 */
@AllArgsConstructor(staticName = "of")
public class MiningStrategy extends AbstractStrategy {

    @Override
    public List<Direction> selectBestDirections(List<Direction> directions, Board board) {
        System.out.println("Looking for GOLD");
        Optional<Vector> direction = board.findNearestMine().map(enemy -> Vector.getVector(enemy, board));
        direction.ifPresent(d -> System.out.println("Vector " + d));
        return direction.map(d -> filterDirections(d, directions)).orElse(directions);
    }
}