package com.codenjoy.dojo.snakebattle.util;

import java.util.List;
import java.util.function.ToIntFunction;
import static java.util.Comparator.comparingInt;


/**
 * Created by Tall Tamias on 08.02.2019.
 */
public class DataHelper {

    public static <E> E findMin(List<E> list, ToIntFunction<E> weightExtractor) {
        return list.stream().min(comparingInt(weightExtractor)).orElse(null);
    }

    public static <E> E findMax(List<E> list, ToIntFunction<E> weightExtractor) {
        return list.stream().max(comparingInt(weightExtractor)).orElse(null);
    }
}