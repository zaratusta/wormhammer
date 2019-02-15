package com.codenjoy.dojo.snakebattle.client;

import com.codenjoy.dojo.snakebattle.model.Board;
import com.codenjoy.dojo.snakebattle.strategy.Mode;


public class DirectionTool {

    String getDirection(Board board) {
        return Mode.calculateMode(board).getDirection().toString();
    }
}