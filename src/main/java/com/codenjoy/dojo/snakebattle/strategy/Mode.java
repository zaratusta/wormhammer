package com.codenjoy.dojo.snakebattle.strategy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.snakebattle.model.Board;


/**
 * Created by Tall Tamias on 07.02.2019.
 */
public enum Mode {
    HUNTING(HuntingStrategy.of()), ANGRY(AngryStrategy.of(), CrawlingStrategy.of()), STURWING(CrawlingStrategy.of()), ESCAPING(EscapingStrategy.of()), MINING(MiningStrategy.of(), CrawlingStrategy.of()), TRAP(TrapStrategy.of(), CrawlingStrategy.of());

    private final LinkedList<Strategy> linkedList = new LinkedList<>();
    private static Board currentBoard;

    Mode(Strategy... strategies) {
        Stream.of(strategies).collect(Collectors.toCollection(() -> linkedList));
    }

    public static Mode calculateMode(Board board) {
        currentBoard = board;
        if (currentBoard.amIAngry()) return Mode.ANGRY;
        if (currentBoard.isEnemyInTrap().isPresent()) return Mode.TRAP;
        if (currentBoard.iAmHunting()) return Mode.HUNTING;
        if (currentBoard.checkEnemyNearMyHead(4, board.enemyHeadAll())) return Mode.ESCAPING;
        if (currentBoard.getMySize() > 8) return Mode.MINING;
        return Mode.STURWING;
    }

    public Direction getDirection() {
        Iterator<Strategy> strategyIterator = linkedList.iterator();

        Strategy current = linkedList.getFirst();
        List<Direction> directions = current.selectBestDirections(currentBoard);
        while (strategyIterator.hasNext()) {
            current = strategyIterator.next();
            directions = current.selectBestDirections(directions, currentBoard);
        }
        return current.selectBestDirection(directions, currentBoard);
    }
}