package com.codenjoy.dojo.snakebattle.strategy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.snakebattle.model.Board;
import com.codenjoy.dojo.snakebattle.model.DirectionCollector;
import com.codenjoy.dojo.snakebattle.model.Vector;


/**
 * Created by Tall Tamias on 09.02.2019.
 */
public abstract class AbstractStrategy implements Strategy {

    @Override
    public List<Direction> selectBestDirections(Board board) {
        return Direction.onlyDirections().stream()
                .collect(DirectionCollector::new,
                        (directionCollector, direction) -> directionCollector.addDirection(direction, getDirectionWeight(direction, board)),
                        (c1, c2) -> {
                        }).getMax();
    }

    @Override
    public List<Direction> selectBestDirections(List<Direction> directions, Board board) {
        return directions;
    }

    @Override
    public Direction selectBestDirection(List<Direction> directions, Board board) {
        if (directions.isEmpty()) return Direction.random();

        Collections.shuffle(directions);

        return directions.get(0);
    }

    List<Direction> filterDirections(Vector vector, List<Direction> directions) {
        if (directions.contains(vector.getDirection())) return Collections.singletonList(vector.getDirection());
        if (directions.contains(vector.getAlternative())) return Collections.singletonList(vector.getAlternative());

        List<Direction> moreAlternatives = new LinkedList<>();

        if (directions.contains(vector.getClockwise())) moreAlternatives.add(vector.getClockwise());
        if (directions.contains(vector.getUnClockwise())) moreAlternatives.add(vector.getUnClockwise());

        return moreAlternatives.isEmpty() ? directions : moreAlternatives;
    }

    private int getDirectionWeight(Direction direction, Board board) {
        Point nextPoint = direction.change(board.getMe());
        return board.getAt(nextPoint).getWeight(board, nextPoint);
    }
}