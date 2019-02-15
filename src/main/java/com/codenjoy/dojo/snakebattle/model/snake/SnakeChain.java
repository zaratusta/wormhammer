package com.codenjoy.dojo.snakebattle.model.snake;

import java.util.List;
import com.codenjoy.dojo.snakebattle.model.Elements;

public interface SnakeChain {

    Elements element();
    List<SnakeChain> possibleChainsFromHead();
}