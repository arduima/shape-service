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

        // Any of the 4 corners must be inside the this.shape ie.
        // All of the 4 corners can't be outside of the this.shape
        Boolean intersects = Boolean.FALSE;
        if(x >= this.x && x < this.x+this.width && y+height>this.y && y+height <= this.y+height) {
            // Top left corner inside this.shape, must be inside not on the line
            intersects = Boolean.TRUE;
        } else if(x+width > this.x && x+width <= this.x+width && y+height>this.y && y+height <= this.y+height) {
            // Top right corner inside this.shape
            intersects = Boolean.TRUE;
        } else if(x >= this.x && x < this.x+this.width && y > this.y && y < this.y+height) {
            // Bottom left corner inside this.shape
            intersects = Boolean.TRUE;
        } else if(x+width > this.x && x+width <= this.x+width && y > this.y && y < this.y+height) {
            // Bottom right corner inside this.shape
            intersects = Boolean.TRUE;
        }

        return intersects;
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
        return null;
    }

}



