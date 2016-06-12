package com.koshkin.demo.shape.service.service;

import com.koshkin.demo.shape.service.ShapeServiceApplication;
import com.koshkin.demo.shape.service.model.Relationship;
import com.koshkin.demo.shape.service.model.Shape;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by dkoshkin on 6/11/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ShapeServiceApplication.class)
@WebAppConfiguration
public class ShapeServiceTest {

    @Autowired
    private ShapeService service;
    @Autowired
    private ShapeBuilderService builder;

    @Test
    public void getRelationship() throws Exception {
        // Contains
        Shape shape1 = builder.buildShape(0.0, 0.0, 10.0, 10.0);
        Shape shape2 = builder.buildShape(2.0, 2.0, 6.0, 6.0);
        Relationship relationship = service.getRelationship(shape1, shape2);
        assertNotNull(relationship);
        assertTrue(relationship.compareTo(Relationship.CONTAINS) == 0);

        // Intersects
        shape1 = builder.buildShape(0.0, 0.0, 10.0, 10.0);
        shape2 = builder.buildShape(-2.0, -2.0, 6.0, 6.0);
        relationship = service.getRelationship(shape1, shape2);
        assertNotNull(relationship);
        assertTrue(relationship.compareTo(Relationship.INTERCEPTS) == 0);

        // Adjacent
        shape1 = builder.buildShape(0.0, 0.0, 10.0, 10.0);
        shape2 = builder.buildShape(-2.0, -2.0, 10.0, 2.0);
        relationship = service.getRelationship(shape1, shape2);
        assertNotNull(relationship);
        assertTrue(relationship.compareTo(Relationship.ADJACENT) == 0);

        // Distant
        shape1 = builder.buildShape(0.0, 0.0, 10.0, 10.0);
        shape2 = builder.buildShape(-10.0, -10.0, 5.0, 5.0);
        relationship = service.getRelationship(shape1, shape2);
        assertNotNull(relationship);
        assertTrue(relationship.compareTo(Relationship.DISTANT) == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRelationshipNull() throws Exception {
        Shape shape1 = builder.buildShape(0.0, 0.0, 10.0, 10.0);
        service.getRelationship(shape1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRelationshipIllegal() throws Exception {
        Shape shape1 = builder.buildShape(0.0, 0.0, 10.0, 10.0);
        Shape shape2 = builder.buildShape(0.0, 0.0, 0.0, 0.0);
        service.getRelationship(shape1, shape2);
    }
}