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
public class HuntingStrategy extends AbstractStrategy {

    @Override
    public List<Direction> selectBestDirections(List<Direction> directions, Board board) {
        System.out.println("I am hunting");
        Optional<Vector> vector = board.findNearestEnemy().map(enemy -> Vector.getVectorForEnemy(enemy, board));
        return vector.map(v -> filterDirections(v, directions)).orElse(directions);
    }
}