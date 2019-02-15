package com.codenjoy.dojo.snakebattle.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.snakebattle.model.Board;
import com.codenjoy.dojo.snakebattle.model.Vector;

import lombok.NoArgsConstructor;


/**
 * Created by Tall Tamias on 09.02.2019.
 */
@NoArgsConstructor(staticName = "of")
public class CrawlingStrategy extends AbstractStrategy {
    Point target = null;
    int i = 10;
    Set<Point> blackList = new HashSet<>();

    @Override
    public List<Direction> selectBestDirections(List<Direction> directions, Board board) {
        System.out.println("Looking for food");

        Vector direction = null;

        Optional<Point> pointOptional = board.findNearestStone(blackList);
        if (board.godDiet(10) && pointOptional.isPresent()) {
            blackList(pointOptional.get());
            direction = Vector.getVector(target, board);
        } else {
            pointOptional = board.findNearestFood();

            if (pointOptional.isPresent()) {
                blackList(pointOptional.get());

                direction = pointOptional.map(enemy -> Vector.getVector(enemy, board)).get();
            }
        }
        System.out.println("Vector " + direction);
        return direction == null ? directions : filterDirections(direction, directions);
    }

    private void blackList(Point point) {
        if (point.equals(target)) {
            if (i < 0) {
                blackList.add(target);
                i = 10;
            }
            i--;
        }

        target = point;

        if (blackList.size() > 5) {
            blackList.clear();
        }
    }
}