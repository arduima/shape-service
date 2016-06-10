package com.koshkin.demo.shape.service.model;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.logging.Logger;

import static com.koshkin.demo.shape.service.exception.ExceptionMessages.*;

/**
 * Created by dkoshkin on 6/10/16.
 */
public class Rectangle implements Shape {

    static Logger log = Logger.getLogger(Rectangle.class.getName());

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

    // TODO implement

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
        return null;
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

    private boolean isValid(Shape shape) {
        if(shape == null) {
            return false;
        }

        return isValid(shape.location().x, shape.location().y, shape.width(), shape.height());
    }

    private boolean isValid(double x, double y, double width, double height) {
        boolean isValid = false;
        try {
            isValid = isValidException(x, y, width, height);
        } catch (IllegalArgumentException ex) {
            isValid = false;
        }

        return isValid;
    }

    private boolean isValidException(double x, double y, double width, double height) throws IllegalArgumentException {
        if(width <= 0 || height <= 0) {
            log.warning(INVALID_NEGATIVE_DIMENSIONS);
            throw new IllegalArgumentException(INVALID_NEGATIVE_DIMENSIONS);
        }
        // Check for overflow
        if(x + width <= 0 || y + height <= 0) {
            log.warning(INVALID_SIZE_DIMENSIONS);
            throw new IllegalArgumentException(INVALID_SIZE_DIMENSIONS);
        }

        return true;
    }
}
