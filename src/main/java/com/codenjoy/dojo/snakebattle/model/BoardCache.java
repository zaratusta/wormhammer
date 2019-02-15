package com.codenjoy.dojo.snakebattle.model;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


/**
 * Created by Tall Tamias on 08.02.2019.
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardCache {
    List<Constraint> darkZones;
}