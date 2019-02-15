package com.codenjoy.dojo.snakebattle.model;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.PointImpl;


/**
 * Created by Tall Tamias on 07.02.2019.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class Constraint {
    Point leftDownCorner;
    Point rightUpCorner;

    public static Constraint getConstraint(List<Point> points) {
        int minX = points.stream().mapToInt(Point::getX).min().orElse(0);
        int minY = points.stream().mapToInt(Point::getY).min().orElse(0);
        int maxX = points.stream().mapToInt(Point::getX).max().orElse(0);
        int maxY = points.stream().mapToInt(Point::getY).max().orElse(0);

        return new Constraint(new PointImpl(minX, minY), new PointImpl(maxX, maxY));
    }

    public int minDeepNes(Point point) {
        int dx1 = Math.min(point.getX() - leftDownCorner.getX(), rightUpCorner.getX() - point.getX());
        int dy1 = Math.min(point.getY() - leftDownCorner.getY(), rightUpCorner.getX() - point.getX());

        return - Math.min(dx1, dy1);
    }

    public boolean inSide(Point point) {
        return leftDownCorner.getX() <= point.getX() && leftDownCorner.getY() <= point.getY() && rightUpCorner.getX() >= point.getX() && rightUpCorner.getY() >= point.getY();
    }
}