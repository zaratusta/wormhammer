package com.codenjoy.dojo.snakebattle.client;

import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.snakebattle.model.Board;
import org.junit.Before;
import static org.junit.Assert.assertEquals;


/**
 * Created by Tall Tamias on 10.02.2019.
 */
public abstract class SolverTestCase {
    private Solver ai;

    private Board board(String board) {
        return (Board) new Board().forString(board);
    }

    @Before
    public void setup() {
        ai = new MySolver();
    }

    void assertAI(String board, Direction expected) {
        String actual = ai.get(board(board));
        assertEquals(expected.toString(), actual);
    }
}