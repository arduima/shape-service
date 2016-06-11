package com.koshkin.demo.shape.service.model;

/**
 * Created by dkoshkin on 6/10/16.
 */
public interface Shape {

    // Location of bottom left corner
    Point location();
    double width();
    double height();

    Boolean intersects(Shape shape);
    Boolean intersects(double x, double y, double width, double height);
    Boolean contains(Shape shape);
    Boolean contains(double x, double y, double width, double height);
    Boolean adjacent(Shape shape);
    Boolean adjacent(double x, double y, double width, double height);

}
