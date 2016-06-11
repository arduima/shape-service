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
        return null;
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
        boolean contains = true;
        // Check for what it can't be
        // All 4 corners must be inside the this.shape
        if(x < this.x || x+width > this.x+this.width || y < this.y || y+height > this.y+this.height) {
            contains =  false;
        }
        return contains;
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



