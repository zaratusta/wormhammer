package com.codenjoy.dojo.snakebattle.util;

import lombok.Value;
import lombok.experimental.Accessors;


/**
 * Created by Tall Tamias on 07.02.2019.
 */
@Value(staticConstructor = "of")
@Accessors(fluent = true)
public class Pair<F, S> {
	F fst;
	S snd;
}