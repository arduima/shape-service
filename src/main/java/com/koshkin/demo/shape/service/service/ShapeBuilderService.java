package com.koshkin.demo.shape.service.service;

import com.koshkin.demo.shape.service.model.Point;
import com.koshkin.demo.shape.service.model.Rectangle;
import com.koshkin.demo.shape.service.model.Shape;
import org.springframework.stereotype.Service;

/**
 * Created by dkoshkin on 6/11/16.
 */

@Service
public class ShapeBuilderService {

    public Shape buildShape(double x, double y, double width, double height) {
        return buildShape(new Point(x, y), width, height);
    }

    public Shape buildShape(Point location, double width, double height) {
        return new Rectangle(location, width, height);
    }
}
