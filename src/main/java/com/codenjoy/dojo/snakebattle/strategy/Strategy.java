package com.codenjoy.dojo.snakebattle.strategy;

import java.util.List;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.snakebattle.model.Board;


/**
 * Created by Tall Tamias on 09.02.2019.
 */
public interface Strategy {
    List<Direction> selectBestDirections(Board board);
    List<Direction> selectBestDirections(List<Direction> directions, Board board);
    Direction selectBestDirection(List<Direction> directions, Board board);
}