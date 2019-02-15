package com.codenjoy.dojo.snakebattle.model;

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


import java.util.Optional;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.printer.CharElements;
import static com.codenjoy.dojo.snakebattle.model.ElementType.BARRIER;
import static com.codenjoy.dojo.snakebattle.model.ElementType.BONUS;
import static com.codenjoy.dojo.snakebattle.model.ElementType.ENEMY;
import static com.codenjoy.dojo.snakebattle.model.ElementType.ME;
import static com.codenjoy.dojo.snakebattle.model.ElementType.WAY;


/**
 * Тут указана легенда всех возможных объектов на поле и их состояний.
 * Важно помнить, что для каждой енумной константы надо создать спрайт в папке \src\main\webapp\resources\sprite.
 */
public enum Elements implements CharElements {

    NONE(' ', 7, WAY) {
        @Override
        public int getWeight(Board board, Point point) {
            Optional<Integer> darkZone = darkZone(board, point);
            if (darkZone.isPresent()) {
                return darkZone.get() + (board.isBlind(point) ? -10 : weight);
            }

            return board.isBlind(point) ? -10 : weight;
        }
    },         // пустое место
    WALL('☼', -3, BARRIER) {
        @Override
        public int getWeight(Board board, Point point) {
            Optional<Integer> darkZone = darkZone(board, point);
            return darkZone.map(integer -> integer + weight).orElse(weight);
        }
    },         // а это стенка
    START_FLOOR('#', 0, BARRIER),  // место старта змей
    OTHER('?', 0, BARRIER),        // этого ты никогда не увидишь :)

    APPLE('○', 20, BONUS) {
        @Override
        public int getWeight(Board board) {
            if (board.iAmHunting() || board.enemyIsOneAndWeak()) return 7;
            if (board.getMySize() < 12) return 30;
            return super.getWeight(board);
        }
    },        // яблоки надо кушать от них становишься длинее
    STONE('●', 5, BARRIER) {
        @Override
        public int getWeight(Board board) {

            if (board.getMySize() < 6) return weight;

            return 10;
        }

        @Override
        public int getWeight(Board board, Point point) {
            return board.isBlind(point) ? -10 : getWeight(board);
        }
    },        // а это кушать не стоит - от этого укорачиваешься
    FLYING_PILL('©', 20, BONUS) {
        @Override
        public int getWeight(Board board, Point point) {
            if (board.iAmHunting() || board.enemyIsOneAndWeak()) return 7;
            if (board.amIAngry()) return 5;
            return board.isBlind(point) ? -10 : getWeight(board);
        }
    },  // таблетка полета - дает суперсилы
    FURY_PILL('®', 50, BONUS) {
        @Override
        public int getWeight(Board board, Point point) {
            return board.isBlind(point) ? -10 : getWeight(board);
        }
    },    // таблетка ярости - дает суперсилы
    GOLD('$', 40, BONUS) {
        @Override
        public int getWeight(Board board, Point point) {
            if (board.iAmHunting() || board.enemyIsOneAndWeak()) return 7;

            return board.isBlind(point) ? -10 : getWeight(board);
        }
    },         // золото - просто очки

    // голова твоей змеи в разных состояниях и напрвлениях
    HEAD_DOWN('▼', 0, ME),
    HEAD_LEFT('◄', 0, ME),
    HEAD_RIGHT('►', 0, ME),
    HEAD_UP('▲', 0, ME),
    HEAD_DEAD('☻', 0, ME),    // этот раунд ты проиграл
    HEAD_EVIL('♥', 0, ME),    // скушали таблетку ярости
    HEAD_FLY('♠', 0, ME),     // скушали таблетку полета
    HEAD_SLEEP('&', 0, ME),   // змейка ожидает начала раунда

    // хвост твоей змейки
    TAIL_END_DOWN('╙', 7, ME),
    TAIL_END_LEFT('╘', 7, ME),
    TAIL_END_UP('╓', 7, ME),
    TAIL_END_RIGHT('╕', 7, ME),
    TAIL_INACTIVE('~', 7, ME),

    // туловище твоей змейки
    BODY_HORIZONTAL('═', 0, ME) {

    },
    BODY_VERTICAL('║', 0, ME),
    BODY_LEFT_DOWN('╗', 0, ME),
    BODY_LEFT_UP('╝', 0, ME),
    BODY_RIGHT_DOWN('╔', 0, ME),
    BODY_RIGHT_UP('╚', 0, ME),

    // змейки противников
    ENEMY_HEAD_DOWN('˅', 0, ENEMY) {
        @Override
        public int getWeight(Board board) {

            return getHeadWeight(board);
        }
    },
    ENEMY_HEAD_LEFT('<', 0, ENEMY) {
        @Override
        public int getWeight(Board board) {
            return super.getHeadWeight(board);
        }
    },
    ENEMY_HEAD_RIGHT('>', 0, ENEMY) {
        @Override
        public int getWeight(Board board) {
            return super.getHeadWeight(board);
        }
    },
    ENEMY_HEAD_UP('˄', 0, ENEMY) {
        @Override
        public int getWeight(Board board) {
            return super.getHeadWeight(board);
        }
    },
    ENEMY_HEAD_DEAD('☺', 0, ENEMY),   // этот раунд противник проиграл
    ENEMY_HEAD_EVIL('♣', -10, ENEMY),   // противник скушал таблетку ярости
    ENEMY_HEAD_FLY('♦', 5, ENEMY),    // противник скушал таблетку полета
    ENEMY_HEAD_SLEEP('ø', 0, ENEMY),  // змейка ожидает начала раунда

    // хвосты змеек противников
    ENEMY_TAIL_END_DOWN('¤', 0, ENEMY),
    ENEMY_TAIL_END_LEFT('×', 0, ENEMY),
    ENEMY_TAIL_END_UP('æ', 0, ENEMY),
    ENEMY_TAIL_END_RIGHT('ö', 0, ENEMY),
    ENEMY_TAIL_INACTIVE('*', 0, ENEMY),

    // туловище змеек противников
    ENEMY_BODY_HORIZONTAL('─', -10, ENEMY) {
        @Override
        public int getWeight(Board board) {
            return getBodyWeight(board);
        }
    },
    ENEMY_BODY_VERTICAL('│', -10, ENEMY) {
        @Override
        public int getWeight(Board board) {
            return getBodyWeight(board);
        }
    },
    ENEMY_BODY_LEFT_DOWN('┐', -10, ENEMY) {
        @Override
        public int getWeight(Board board) {
            return getBodyWeight(board);
        }
    },
    ENEMY_BODY_LEFT_UP('┘', -10, ENEMY) {
        @Override
        public int getWeight(Board board) {
            return getBodyWeight(board);
        }
    },
    ENEMY_BODY_RIGHT_DOWN('┌', -10, ENEMY) {
        @Override
        public int getWeight(Board board) {
            return getBodyWeight(board);
        }
    },
    ENEMY_BODY_RIGHT_UP('└', -10, ENEMY) {
        @Override
        public int getWeight(Board board) {
            return getBodyWeight(board);
        }
    };

    final char ch;
    final int weight;
    final ElementType elementType;

    Elements(char ch, int weight, ElementType elementType) {
        this.ch = ch;
        this.weight = weight;
        this.elementType = elementType;
    }

    public static Elements valueOf(char ch) {
        for (Elements el : Elements.values()) {
            if (el.ch == ch) {
                return el;
            }
        }
        throw new IllegalArgumentException("No such element for " + ch);
    }

    @Override
    public char ch() {
        return ch;
    }

    @Override
    public String toString() {
        return String.valueOf(ch);
    }

    public final int getHeadWeight(Board board) {
        return board.iAmHunting() || board.enemyIsOneAndWeak() ? 100 : weight;
    }

    public final int getBodyWeight(Board board) {
        return board.amIAngry() ? 100 : weight;
    }

    public int getWeight(Board board) {
        return weight;
    }

    protected Optional<Integer> darkZone(Board board, Point point) {
        return board.getDarkZones().stream().filter(z -> z.inSide(point)).map(z -> z.minDeepNes(point)).findFirst();
    }

    public int getWeight(Board board, Point point) {
        Optional<Integer> darkZone = darkZone(board, point);
        int w = getWeight(board);
        return darkZone.map(integer -> integer + w).orElse(w);
    }

    public ElementType getElementType() {
        return elementType;
    }
}