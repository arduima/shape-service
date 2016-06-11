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
    public Boolean intersects(Shape shape) {
        if(!isValid(shape)) {
            return null;
        }
        return intersects(shape.location().x, shape.location().y, shape.width(), shape.height());
    }

    @Override
    public Boolean intersects(double x, double y, double width, double height) {
        if(!isValid(x, y, width, height)) {
            return null;
        }
        // Can't be fully enclosed
        // Check if either of the shapes are enclosing the other
        Boolean enclosed = this.contains(x, y, width, height);
        Boolean enclosedReverse = new Rectangle(x, y, width, height).contains(this);
        if(enclosed == null || enclosedReverse == null) {
            return null;
        } else if(enclosed || enclosedReverse) {
            return Boolean.FALSE;
        }

        // Any of the 4 sides must be inside the this.shape ie.
        // All of the 4 sides can't be outside of the this.shape
        // R is L of this.shape.L  || this.shape.R is L of R || T is B of this.B   || this.shape.T is B of T
        return !(x+width <= this.x || this.x+this.width <= x || y+height <= this.y || this.y+this.height <= y);
    }

    @Override
    public Boolean contains(Shape shape) {
        if(!isValid(shape)) {
            return null;
        }

        return contains(shape.location().x, shape.location().y, shape.width(), shape.height());
    }

    @Override
    public Boolean contains(double x, double y, double width, double height) {
        if(!isValid(x, y, width, height)) {
            return null;
        }

        // Check for what it can't be
        // All 4 corners must be inside the this.shape
        return !(x < this.x || x+width > this.x+this.width || y < this.y || y+height > this.y+this.height);
    }

    @Override
    public Boolean adjacent(Shape shape) {
        if(!isValid(shape)) {
            return null;
        }

        return adjacent(shape.location().x, shape.location().y, shape.width(), shape.height());
    }

    @Override
    public Boolean adjacent(double x, double y, double width, double height) {
        if(!isValid(x, y, width, height)) {
            return null;
        }

        // Can't be fully enclosed
        // Check if either of the shapes are enclosing the other
        Boolean enclosed = this.contains(x, y, width, height);
        Boolean enclosedReverse = new Rectangle(x, y, width, height).contains(this);
        if(enclosed == null || enclosedReverse == null) {
            return null;
        } else if(enclosed || enclosedReverse) {
            return Boolean.FALSE;
        }

        // Can't be fully enclosed
        // Check if either of the shapes are enclosing the other
        Boolean intersects = this.intersects(x, y, width, height);
        Boolean intersectsReverse = new Rectangle(x, y, width, height).intersects(this);
        if(intersects == null || intersectsReverse == null) {
            return null;
        } else if(intersects || intersectsReverse) {
            return Boolean.FALSE;
        }

        // Not enclosed or intersecting
        // Adjacent or not touching
        return !(x+width < this.x || this.x+this.width < x || y+height < this.y || this.y+this.height < y);
    }

}



