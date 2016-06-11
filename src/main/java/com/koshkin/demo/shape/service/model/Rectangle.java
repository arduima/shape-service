package com.koshkin.demo.shape.service.model;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.logging.Logger;

import static com.koshkin.demo.shape.service.exception.ExceptionMessages.*;
import static com.koshkin.demo.shape.service.utility.ShapeValidityUtility.*;

/**
 * Created by dkoshkin on 6/10/16.
 */
public class Rectangle implements Shape {

    private double x;
    private double y;
    private double width;
    private double height;

    private Rectangle() {
    }

    public Rectangle(double x, double y, double width, double height) {
        isValidException(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point location, double width, double height) {
        if(location == null) {
            throw new IllegalArgumentException();
        }
        isValidException(location.x, location.y, width, height);
        this.x = location.x;
        this.y = location.y;
        this.width = width;
        this.height = height;
    }

    @Override
    public Point location() {
        return new Point(x, y);
    }

    @Override
    public double width() {
        return width;
    }

    @Override
    public double height() {
        return height;
    }


    @Override
    public boolean intersects(Shape shape) throws IllegalArgumentException {
        if(!isValid(shape)) {
            throw new IllegalArgumentException();
        }
        return intersects(shape.location().x, shape.location().y, shape.width(), shape.height());
    }

    @Override
    public boolean intersects(double x, double y, double width, double height) throws IllegalArgumentException {
        if(!isValid(x, y, width, height)) {
            throw new IllegalArgumentException();
        }
        // Can't be fully enclosed
        // Check if either of the shapes are enclosing the other
        boolean enclosed = this.contains(x, y, width, height);
        boolean enclosedReverse = new Rectangle(x, y, width, height).contains(this);
        if(enclosed || enclosedReverse) {
            return Boolean.FALSE;
        }

        // Any of the 4 sides must be inside the this.shape ie.
        // All of the 4 sides can't be outside of the this.shape
        // R is L of this.shape.L  || this.shape.R is L of R || T is B of this.B   || this.shape.T is B of T
        return !(x+width <= this.x || this.x+this.width <= x || y+height <= this.y || this.y+this.height <= y);
    }

    @Override
    public boolean contains(Shape shape) throws IllegalArgumentException {
        if(!isValid(shape)) {
            throw new IllegalArgumentException();
        }

        return contains(shape.location().x, shape.location().y, shape.width(), shape.height());
    }

    @Override
    public boolean contains(double x, double y, double width, double height) throws IllegalArgumentException {
        if(!isValid(x, y, width, height)) {
            throw new IllegalArgumentException();
        }

        // Check for what it can't be
        // All 4 corners must be inside the this.shape
        return !(x < this.x || x+width > this.x+this.width || y < this.y || y+height > this.y+this.height);
    }

    @Override
    public boolean adjacent(Shape shape) throws IllegalArgumentException {
        if(!isValid(shape)) {
            throw new IllegalArgumentException();
        }

        return adjacent(shape.location().x, shape.location().y, shape.width(), shape.height());
    }

    @Override
    public boolean adjacent(double x, double y, double width, double height) throws IllegalArgumentException {
        if(!isValid(x, y, width, height)) {
            throw new IllegalArgumentException();
        }

        // Can't be fully enclosed
        // Check if either of the shapes are enclosing the other
        boolean enclosed = this.contains(x, y, width, height);
        boolean enclosedReverse = new Rectangle(x, y, width, height).contains(this);
        if(enclosed || enclosedReverse) {
            return Boolean.FALSE;
        }

        // Can't be fully enclosed
        // Check if either of the shapes are enclosing the other
        boolean intersects = this.intersects(x, y, width, height);
        boolean intersectsReverse = new Rectangle(x, y, width, height).intersects(this);
        if(intersects || intersectsReverse) {
            return Boolean.FALSE;
        }

        // Not enclosed or intersecting
        // Adjacent or not touching
        return !(x+width < this.x || this.x+this.width < x || y+height < this.y || this.y+this.height < y);
    }

    public boolean distant(Shape shape) throws IllegalArgumentException {
        if(!isValid(shape)) {
            throw new IllegalArgumentException();
        }

        return distant(shape.location().x, shape.location().y, shape.width(), shape.height());
    }

    public boolean distant(double x, double y, double width, double height) throws IllegalArgumentException {
        if(!isValid(x, y, width, height)) {
            throw new IllegalArgumentException();
        }

        boolean adjacent = this.adjacent(x, y, width, height);
        boolean contains = this.contains(x, y, width, height);
        boolean containsReverse = new Rectangle(x, y, width, height).contains(this);
        boolean intersects = this.intersects(x, y, width, height);

        return !(adjacent || contains || containsReverse || intersects);
    }

}



