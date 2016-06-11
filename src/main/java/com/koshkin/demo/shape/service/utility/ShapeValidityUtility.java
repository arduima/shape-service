package com.koshkin.demo.shape.service.utility;

import com.koshkin.demo.shape.service.model.Shape;

import java.util.logging.Logger;

import static com.koshkin.demo.shape.service.exception.ExceptionMessages.INVALID_NEGATIVE_DIMENSIONS;
import static com.koshkin.demo.shape.service.exception.ExceptionMessages.INVALID_SIZE_DIMENSIONS;

/**
 * Created by dkoshkin on 6/10/16.
 */

public class ShapeValidityUtility {

    private static Logger log = Logger.getLogger(ShapeValidityUtility.class.getName());

    private ShapeValidityUtility() {};

    public static boolean isValid(Shape shape) {
        if(shape == null) {
            return false;
        }

        return isValid(shape.location().x, shape.location().y, shape.width(), shape.height());
    }

    public static boolean isValid(double x, double y, double width, double height) {
        boolean isValid = false;
        try {
            isValid = isValidException(x, y, width, height);
        } catch (IllegalArgumentException ex) {
            isValid = false;
        }

        return isValid;
    }

    public static boolean isValidException(double x, double y, double width, double height) throws IllegalArgumentException {
        if(width <= 0 || height <= 0) {
            log.warning(INVALID_NEGATIVE_DIMENSIONS);
            throw new IllegalArgumentException(INVALID_NEGATIVE_DIMENSIONS);
        }
        // Check for overflow
        if(Double.isInfinite(x + width) || Double.isInfinite(y + height)) {
            log.warning(INVALID_SIZE_DIMENSIONS);
            throw new IllegalArgumentException(INVALID_SIZE_DIMENSIONS);
        }

        return true;
    }
}
