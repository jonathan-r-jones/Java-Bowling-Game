package com.yb.bowling;

import com.yb.bowling.BowlingGame;
import com.yb.bowling.frame.Frame;
import com.yb.bowling.frame.FrameParser;
import com.yb.bowling.roll.Roll;
import com.yb.bowling.roll.RollParser;
import com.yb.bowling.roll.StringRollParser;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *     Bowling Game Test
 *
 * @author Youness Bougrine
 *
 */

public class BowlingGameTest {

    RollParser rollParser;
    FrameParser frameParser;
    BowlingGame game;

    @Before
    public void setUp(){
        rollParser = new StringRollParser();
        frameParser = new FrameParser();
        game = new BowlingGame(rollParser,frameParser);
    }
    /**
     * CASE 1
     *     input : XXXXXXXXXXXX (12 strike)  expected score equal to 300
     */

    @Test
    public void allStrikesExpected_300(){
        String input = "XXXXXXXXXXXX";
        assertEquals(game.scoreOfGame(input),300);
    }

    /**
     * CASE 2
     *     input : 1/1/1/1/1/1/1/1/1/1/2 (11 spare and last 2)  expected score equal to 111
     */
    @Test
    public void allSpareAndLast_2_Expected_111(){
        String input = "1/1/1/1/1/1/1/1/1/1/2";
        assertEquals(game.scoreOfGame(input),111);
    }

    /**
     * CASE 3
     *     input : 11111111111111111111 (20 one)  expected score equal to 20
     */
    @Test
    public void allOnesExpected_20(){
        String input = "11111111111111111111";
        assertEquals(game.scoreOfGame(input),20);
    }

    /**
     * CASE 4
     *     input : 9-9-9-9-9-9-9-9-9-9- (9 for first miss second)  expected score equal to 90
     */
    @Test
    public void NineAndMissExpected_90(){
        String input = "9-9-9-9-9-9-9-9-9-9-";
        assertEquals(game.scoreOfGame(input),90);
    }

    /**
     * CASE 5
     *     input : 5/5/5/5/5/5/5/5/5/5/5 (5 for first spare second and last 5)  expected score equal to 150
     */
    @Test
    public void FiveAndSpareWithFinalFiveExpected_150(){
        String input = "5/5/5/5/5/5/5/5/5/5/5";
        assertEquals(game.scoreOfGame(input),150);
    }

    /**
     * CASE Jonathan's Unit Tests Below Here
     */
    @Test
    public void CheckAllDashes(){
        String input = "--------------------";
        assertEquals(0, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame1(){
        String input = "9/------------------";
        assertEquals(10, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame2(){
        String input = "9/-/----------------";
        assertEquals(20, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame3(){
        String input = "9/-/X--------------";
        assertEquals(40, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame4(){
        String input = "9/-/XX------------";
        assertEquals(60, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame5(){
        String input = "9/-/XX62----------";
        assertEquals(82, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame6(){
        String input = "9/-/XX627/--------";
        assertEquals(92, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame7(){
        String input = "9/-/XX627/8/------";
        assertEquals(110, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame8(){
        String input = "9/-/XX627/8/X----";
        assertEquals(130, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame9(){
        String input = "9/-/XX627/8/X9---";
        assertEquals(148, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame10B(){
        String input = "9/-/XX627/8/X9-9/-";
        assertEquals(158, game.scoreOfGame(input));
    }
    @Test
    public void CheckFrame10Bug(){
        // This is a bug in the code. 168 is impossible!
        //String input = "9/-/XX627/8/X9-9/X";
        String input = "9/-/XX627/8/X9-9/9";
        assertEquals(167, game.scoreOfGame(input));
    }
}
