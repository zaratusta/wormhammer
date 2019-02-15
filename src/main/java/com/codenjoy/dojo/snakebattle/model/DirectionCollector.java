package com.codenjoy.dojo.snakebattle.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import com.codenjoy.dojo.services.Direction;


/**
 * Created by Tall Tamias on 07.02.2019.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DirectionCollector {
    Map<Integer, List<Direction>> map = new HashMap<>();

    public DirectionCollector addDirection(Direction direction, int weight) {
        if (map.containsKey(weight)) {
            map.get(weight).add(direction);
        } else {
            LinkedList<Direction> dir = new LinkedList<>();
            dir.add(direction);
            map.put(weight, dir);
        }
        return this;
    }

    public List<Direction> getMax() {
        return map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getKey)).map(Map.Entry::getValue).orElse(Direction.onlyDirections());
    }
}