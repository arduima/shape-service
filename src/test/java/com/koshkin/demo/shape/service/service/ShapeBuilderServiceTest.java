package com.koshkin.demo.shape.service.service;

import com.koshkin.demo.shape.service.ShapeServiceApplication;
import com.koshkin.demo.shape.service.model.Point;
import com.koshkin.demo.shape.service.model.Shape;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by dkoshkin on 6/11/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ShapeServiceApplication.class)
public class ShapeBuilderServiceTest {

    @Autowired
    private ShapeBuilderService builder;

    @Test
    public void buildShape() throws Exception {
        Shape shape1 = builder.buildShape(0.0, 0.0, 10.0, 10.0);
        assertNotNull(shape1);
    }

    @Test
    public void buildShape1() throws Exception {
        Shape shape1 = builder.buildShape(new Point(0.0, 0.0), 10.0, 10.0);
        assertNotNull(shape1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void buildShapeError() throws Exception {
        Shape shape1 = builder.buildShape(new Point(0.0, 0.0), 0.0, 0.0);
        assertNotNull(shape1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void buildShapeNull() throws Exception {
        Shape shape1 = builder.buildShape(null, 0.0, 0.0);
        assertNotNull(shape1);
    }
}