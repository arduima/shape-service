package com.koshkin.demo.shape.service.model;

/**
 * Created by dkoshkin on 6/10/16.
 */
public interface Shape {

    // Location of bottom left corner
    Point location();
    double width();
    double height();

    boolean intersects(Shape shape) throws IllegalArgumentException;
    boolean intersects(double x, double y, double width, double height) throws IllegalArgumentException;
    boolean contains(Shape shape) throws IllegalArgumentException;
    boolean contains(double x, double y, double width, double height) throws IllegalArgumentException;
    boolean adjacent(Shape shape) throws IllegalArgumentException;
    boolean adjacent(double x, double y, double width, double height) throws IllegalArgumentException;
    boolean distant(Shape shape) throws IllegalArgumentException;
    boolean distant(double x, double y, double width, double height) throws IllegalArgumentException;

}
