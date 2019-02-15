package com.codenjoy.dojo.snakebattle.client;

import com.codenjoy.dojo.services.Direction;
import org.junit.Test;


/**
 * Created by Tall Tamias on 10.02.2019.
 */
public class HuntingTest extends SolverTestCase {

    @Test
    public void test1() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼         ○                 ☼\n" +
                        "☼#           ×>    ▲         ☼\n" +
                        "☼☼  ○    ●         ╚═╕       ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼ ○         ●    ○          ☼\n" +
                        "☼☼     ☼☼☼☼☼                 ☼\n" +
                        "☼☼     ☼                     ☼\n" +
                        "☼#     ☼☼☼     ○  ☼☼☼☼#      ☼\n" +
                        "☼☼     ☼          ☼   ☼  ●   ☼\n" +
                        "☼☼     ☼☼☼☼#      ☼☼☼☼#      ☼\n" +
                        "☼☼                ☼          ☼\n" +
                        "☼☼○               ☼         $☼\n" +
                        "☼☼  ○ ●  ○                   ☼\n" +
                        "☼#             ○      ○      ☼\n" +
                        "☼☼   ○       ○               ☼\n" +
                        "☼☼        ☼☼☼                ☼\n" +
                        "☼☼   ○   ☼  ☼                ☼\n" +
                        "☼☼      ☼☼☼☼#     ☼☼   ☼#    ☼\n" +
                        "☼☼      ☼   ☼   ● ☼ ☼ ☼ ☼ ○  ☼\n" +
                        "☼#      ☼   ☼     ☼  ☼  ☼    ☼\n" +
                        "☼☼                ☼     ☼    ☼\n" +
                        "☼☼     ●          ☼     ☼    ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼                  ○        ☼\n" +
                        "☼☼ ○    ○      ●         ○   ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼               ○           ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼"
                , Direction.LEFT);
    }

    @Test
    public void test2() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼         ╔═╕               ☼\n" +
                        "☼#         ║                 ☼\n" +
                        "☼☼        ╔╝                 ☼\n" +
                        "☼☼     æ●╔╝    ┌ö            ☼\n" +
                        "☼☼    ┌┘◄╝     │             ☼\n" +
                        "☼☼    ˅☼☼☼☼☼  ┌┘       ○     ☼\n" +
                        "☼☼     ☼      └┐             ☼\n" +
                        "☼# ○   ☼☼☼     ˅  ☼☼☼☼#      ☼\n" +
                        "☼☼     ☼          ☼   ☼  ●   ☼\n" +
                        "☼☼     ☼☼☼☼#      ☼☼☼☼#      ☼\n" +
                        "☼☼                ☼          ☼\n" +
                        "☼☼        ●       ☼          ☼\n" +
                        "☼☼    ●                      ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼        ☼☼☼      ○         ☼\n" +
                        "☼☼       ☼  ☼                ☼\n" +
                        "☼☼      ☼☼☼☼#     ☼☼   ☼#    ☼\n" +
                        "☼☼      ☼   ☼   ● ☼ ☼ ☼ ☼    ☼\n" +
                        "☼#      ☼   ☼     ☼  ☼  ☼    ☼\n" +
                        "☼☼                ☼     ☼    ☼\n" +
                        "☼☼     ●          ☼     ☼○   ☼\n" +
                        "☼☼                  ○       $☼\n" +
                        "☼☼   ○              ©   ©    ☼\n" +
                        "☼☼             ●             ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼  ●                        ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼"
                , Direction.UP);
    }

    @Test
    public void test3() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼                           ☼\n" +
                        "☼#                         ○ ☼\n" +
                        "☼☼                 ○         ☼\n" +
                        "☼☼                      ○○   ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼     ☼☼☼☼☼                 ☼\n" +
                        "☼☼     ☼●                    ☼\n" +
                        "☼#     ☼☼☼        ☼☼☼☼#      ☼\n" +
                        "☼☼     ☼          ☼   ☼      ☼\n" +
                        "☼☼     ☼☼☼☼#      ☼☼☼☼# ●    ☼\n" +
                        "☼☼○               ☼          ☼\n" +
                        "☼☼                ☼       ○  ☼\n" +
                        "☼☼    ●       ○              ☼\n" +
                        "☼#     ○               $     ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼        ☼☼☼                ☼\n" +
                        "☼☼       ☼  ☼                ☼\n" +
                        "☼☼      ☼☼☼☼#     ☼☼   ☼#    ☼\n" +
                        "☼☼      ☼   ☼   ● ☼ ☼ ☼ ☼    ☼\n" +
                        "☼#      ☼   ☼     ☼  ☼  ☼    ☼\n" +
                        "☼☼   ©            ☼     ☼    ☼\n" +
                        "☼☼○    ●  ©    ×─>☼  ®  ☼    ☼\n" +
                        "☼☼                ▲          ☼\n" +
                        "☼☼    ●           ║        ○ ☼\n" +
                        "☼☼ ○    ○      ●  ╚╗         ☼\n" +
                        "☼#               ╔╗║         ☼\n" +
                        "☼☼○              ║║║         ☼\n" +
                        "☼☼              ╘╝╚╝    ®    ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼"
                , Direction.LEFT);
    }

    @Test
    public void test4() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼         ○                 ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼       ●                   ☼\n" +
                        "☼☼          ○         ○      ☼\n" +
                        "☼☼    ©      ●               ☼\n" +
                        "☼☼     ☼☼☼☼☼                 ☼\n" +
                        "☼☼     ☼                     ☼\n" +
                        "☼#     ☼☼☼        ☼☼☼☼#○     ☼\n" +
                        "☼☼     ☼          ☼   ☼  ●   ☼\n" +
                        "☼☼     ☼☼☼☼#      ☼☼☼☼#      ☼\n" +
                        "☼☼       ●       ○☼          ☼\n" +
                        "☼☼                ☼  ®       ☼\n" +
                        "☼☼    ●                      ☼\n" +
                        "☼#        ╘╗          ○      ☼\n" +
                        "☼☼         ╚═╗               ☼\n" +
                        "☼☼        ☼☼☼║               ☼\n" +
                        "☼☼       ☼  ☼║               ☼\n" +
                        "☼☼      ☼☼☼☼#║    ☼☼   ☼#    ☼\n" +
                        "☼☼      ☼   ☼║  ● ☼ ☼ ☼ ☼ ○  ☼\n" +
                        "☼#      ☼   ☼▼ ○  ☼○●☼  ☼    ☼\n" +
                        "☼☼         ┌>     ☼     ☼    ☼\n" +
                        "☼☼     ●   │      ☼    ○☼  ○ ☼\n" +
                        "☼☼    ×────┘   $             ☼\n" +
                        "☼☼               ○  ○      ○ ☼\n" +
                        "☼☼             ● ®       ○   ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼               ○          ○☼\n" +
                        "☼☼  ○               ○        ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼"
                , Direction.DOWN);
    }

    @Test
    public void test5() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼      ○                    ☼\n" +
                        "☼#   ©         ○○            ☼\n" +
                        "☼☼    $  ●  ○                ☼\n" +
                        "☼☼                         ○○☼\n" +
                        "☼☼           ●               ☼\n" +
                        "☼☼     ☼☼☼☼☼                 ☼\n" +
                        "☼☼     ☼                   $ ☼\n" +
                        "☼#     ☼☼☼        ☼☼☼☼#      ☼\n" +
                        "☼☼     ☼          ☼   ☼  ●   ☼\n" +
                        "☼☼     ☼☼☼☼#○     ☼☼☼☼#      ☼\n" +
                        "☼☼                ☼          ☼\n" +
                        "☼☼ ○              ☼          ☼\n" +
                        "☼☼●                 ○        ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼                          ○☼\n" +
                        "☼☼        ☼☼☼                ☼\n" +
                        "☼☼       ☼  ☼                ☼\n" +
                        "☼☼©     ☼☼☼☼#     ☼☼   ☼#    ☼\n" +
                        "☼☼      ☼   ☼   ● ☼ ☼ ☼ ☼    ☼\n" +
                        "☼#      ☼ ○ ☼  ˄  ☼  ☼  ☼    ☼\n" +
                        "☼☼          ◄╗ └┐ ☼     ☼    ☼\n" +
                        "☼☼     ●     ╚╗ └ö☼     ☼    ☼\n" +
                        "☼☼            ╚╕             ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼             ●             ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼",
                Direction.DOWN);
    }

    @Test
    public void test6() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼      ○                    ☼\n" +
                        "☼#   ©         ○○            ☼\n" +
                        "☼☼    $  ●  ○                ☼\n" +
                        "☼☼                         ○○☼\n" +
                        "☼☼           ●               ☼\n" +
                        "☼☼     ☼☼☼☼☼                 ☼\n" +
                        "☼☼     ☼                   $ ☼\n" +
                        "☼#     ☼☼☼        ☼☼☼☼#      ☼\n" +
                        "☼☼     ☼          ☼   ☼  ●   ☼\n" +
                        "☼☼     ☼☼☼☼#○     ☼☼☼☼#      ☼\n" +
                        "☼☼                ☼          ☼\n" +
                        "☼☼ ○              ☼          ☼\n" +
                        "☼☼●                 ○        ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼                          ○☼\n" +
                        "☼☼        ☼☼☼                ☼\n" +
                        "☼☼       ☼  ☼                ☼\n" +
                        "☼☼©     ☼☼☼☼#     ☼☼   ☼#    ☼\n" +
                        "☼☼      ☼   ☼   ● ☼ ☼ ☼ ☼    ☼\n" +
                        "☼#      ☼ ○ ☼     ☼  ☼  ☼    ☼\n" +
                        "☼☼                ☼     ☼    ☼\n" +
                        "☼☼     ●          ☼     ☼    ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼             ●             ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼         ◄═════════╕       ☼\n" +
                        "☼☼               <─────────ö ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼"
                , Direction.DOWN);
    }

    @Test
    public void test7() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼      ○                    ☼\n" +
                        "☼#   ©         ○○            ☼\n" +
                        "☼☼    $  ●  ○                ☼\n" +
                        "☼☼                         ○○☼\n" +
                        "☼☼           ●               ☼\n" +
                        "☼☼     ☼☼☼☼☼                 ☼\n" +
                        "☼☼     ☼                   $ ☼\n" +
                        "☼#     ☼☼☼        ☼☼☼☼#      ☼\n" +
                        "☼☼     ☼          ☼   ☼  ●   ☼\n" +
                        "☼☼     ☼☼☼☼#○     ☼☼☼☼#      ☼\n" +
                        "☼☼                ☼          ☼\n" +
                        "☼☼ ○              ☼          ☼\n" +
                        "☼☼●                 ○        ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼                          ○☼\n" +
                        "☼☼        ☼☼☼                ☼\n" +
                        "☼☼       ☼  ☼                ☼\n" +
                        "☼☼©     ☼☼☼☼#     ☼☼   ☼#    ☼\n" +
                        "☼☼      ☼   ☼   ● ☼ ☼ ☼ ☼    ☼\n" +
                        "☼#      ☼ ○ ☼     ☼  ☼  ☼    ☼\n" +
                        "☼☼                ☼     ☼    ☼\n" +
                        "☼☼     ●          ☼     ☼    ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼             ●             ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼     <──────ö              ☼\n" +
                        "☼☼             ◄═══════════╕ ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼"
                , Direction.UP);
    }

    @Test
    public void test8() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼○                          ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼       ●        ○          ☼\n" +
                        "☼☼                      ○    ☼\n" +
                        "☼☼           ●               ☼\n" +
                        "☼☼     ☼☼☼☼☼                 ☼\n" +
                        "☼☼     ☼                     ☼\n" +
                        "☼#     ☼☼☼        ☼☼☼☼#      ☼\n" +
                        "☼☼     ☼          ☼   ☼  ●   ☼\n" +
                        "☼☼     ☼☼☼☼#      ☼☼☼☼#      ☼\n" +
                        "☼☼                ☼  ○       ☼\n" +
                        "☼☼                ☼     ○   $☼\n" +
                        "☼☼    ●                      ☼\n" +
                        "☼#   ©                ○      ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼        ☼☼☼                ☼\n" +
                        "☼☼   ●   ☼  ☼                ☼\n" +
                        "☼☼      ☼☼☼☼#     ☼☼ ○ ☼#    ☼\n" +
                        "☼☼      ☼   ☼   ● ☼○☼ ☼ ☼ ○  ☼\n" +
                        "☼#      ☼   ☼     ☼  ☼  ☼    ☼\n" +
                        "☼☼                ☼     ☼    ☼\n" +
                        "☼☼     ● ○        ☼╔╗   ☼ ○  ☼\n" +
                        "☼☼   ©           ╔═╝║        ☼\n" +
                        "☼☼        $      ╙  ║        ☼\n" +
                        "☼☼ ○    ○      ● ×─┐║    ○   ☼\n" +
                        "☼#                 │♥        ☼\n" +
                        "☼☼            ○  ○ │         ☼\n" +
                        "☼☼     ○           └>        ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼"
                , Direction.LEFT);
    }
}