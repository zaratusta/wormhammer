package com.codenjoy.dojo.snakebattle.client;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.services.Direction;
import org.junit.Test;


public class CrawlerTest extends SolverTestCase {

    @Test
    public void test1() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼                           ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼       ●                   ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼     ╘════╗●               ☼\n" +
                        "☼☼     ☼☼☼☼☼║                ☼\n" +
                        "☼☼     ☼    ║              ○ ☼\n" +
                        "☼#     ☼☼☼  ║     ☼☼☼☼#      ☼\n" +
                        "☼☼     ☼   ◄╝     ☼   ☼  ●   ☼\n" +
                        "☼☼     ☼☼☼☼#      ☼☼☼☼#    ○ ☼\n" +
                        "☼☼                ☼     ●    ☼\n" +
                        "☼☼                ☼         ˄☼\n" +
                        "☼☼    ●               ┌ö    │☼\n" +
                        "☼#                    └─────┘☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼        ☼☼☼○               ☼\n" +
                        "☼☼       ☼  ☼        ○      ○☼\n" +
                        "☼☼      ☼☼☼☼#     ☼☼   ☼#    ☼\n" +
                        "☼☼      ☼   ☼   ● ☼ ☼ ☼ ☼ ○○ ☼\n" +
                        "☼#      ☼   ☼ ®   ☼  ☼  ☼   ○☼\n" +
                        "☼☼     ○          ☼     ☼    ☼\n" +
                        "☼☼     ●     ○    ☼     ☼    ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼         ○        ○        ☼\n" +
                        "☼☼ ○    ○      ●         ○   ☼\n" +
                        "☼#                     ○     ☼\n" +
                        "☼☼               ○           ☼\n" +
                        "☼☼ ©   ©      ®              ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼"
                , Direction.UP);
    }

    @Test
    public void test2() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼                           ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼       ●                   ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼     ╘════╗●               ☼\n" +
                        "☼☼     ☼☼☼☼☼║                ☼\n" +
                        "☼☼     ☼    ║              ○ ☼\n" +
                        "☼#     ☼☼☼  ║     ☼☼☼☼#      ☼\n" +
                        "☼☼     ☼   ○▼     ☼   ☼  ●   ☼\n" +
                        "☼☼     ☼☼☼☼#      ☼☼☼☼#    ○ ☼\n" +
                        "☼☼                ☼     ●    ☼\n" +
                        "☼☼                ☼    æ    $☼\n" +
                        "☼☼    ●               ┌┘    ˄☼\n" +
                        "☼#                    └─────┘☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼        ☼☼☼○               ☼\n" +
                        "☼☼       ☼  ☼        ○      ○☼\n" +
                        "☼☼      ☼☼☼☼#     ☼☼   ☼#    ☼\n" +
                        "☼☼      ☼   ☼   ● ☼ ☼ ☼ ☼ ○○ ☼\n" +
                        "☼#      ☼   ☼ ®   ☼  ☼  ☼   ○☼\n" +
                        "☼☼     ○          ☼     ☼    ☼\n" +
                        "☼☼     ●     ○    ☼     ☼    ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼         ○        ○        ☼\n" +
                        "☼☼ ○    ○      ●         ○   ☼\n" +
                        "☼#                     ○     ☼\n" +
                        "☼☼               ○           ☼\n" +
                        "☼☼ ©   ©      ®              ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼"
                , Direction.RIGHT);
    }

    @Test
    public void test3() {
        assertAI("☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼\n" +
                        "☼☼         ○                 ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼  ○    ●         ○         ☼\n" +
                        "☼☼                      ○    ☼\n" +
                        "☼☼ ○         ●    ○        ○ ☼\n" +
                        "☼☼     ☼☼☼☼☼                 ☼\n" +
                        "☼☼     ☼                     ☼\n" +
                        "☼#     ☼☼☼     ○  ☼☼☼☼#      ☼\n" +
                        "☼☼     ☼          ☼   ☼  ●   ☼\n" +
                        "☼☼     ☼☼☼☼#      ☼☼☼☼#      ☼\n" +
                        "☼☼                ☼          ☼\n" +
                        "☼☼○               ☼         $☼\n" +
                        "☼☼    ●  ○           ×─>     ☼\n" +
                        "☼#                ×───>      ☼\n" +
                        "☼☼           ○               ☼\n" +
                        "☼☼        ☼☼☼                ☼\n" +
                        "☼☼   ○   ☼  ☼                ☼\n" +
                        "☼☼      ☼☼☼☼#     ☼☼   ☼#    ☼\n" +
                        "☼☼      ☼   ☼   ● ☼©☼ ☼ ☼ ○  ☼\n" +
                        "☼#      ☼╘╗ ☼     ☼  ☼  ☼    ☼\n" +
                        "☼☼       ◄╝       ☼     ☼    ☼\n" +
                        "☼☼     ●          ☼     ☼    ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼                  ○        ☼\n" +
                        "☼☼             ●         ○   ☼\n" +
                        "☼#                           ☼\n" +
                        "☼☼               ○           ☼\n" +
                        "☼☼                           ☼\n" +
                        "☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼"
                , Direction.LEFT);
    }
}