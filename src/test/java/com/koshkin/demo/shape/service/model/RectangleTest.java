package com.koshkin.demo.shape.service.model;

import com.koshkin.demo.shape.service.ShapeServiceApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by dkoshkin on 6/10/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ShapeServiceApplication.class)
public class RectangleTest {

    private Shape shape1;

    @Before
    public void setUp() throws Exception {
        shape1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
    }

    @Test
    public void newInstance() throws Exception {
        Shape rectangle1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        assertNotNull(rectangle1);
        Shape rectangle2 = new Rectangle(0.0, 0.0, Double.MAX_VALUE, 15.0);
        assertNotNull(rectangle2);
        Shape rectangle3 = new Rectangle(0.0, 0.0, 10.0, Double.MAX_VALUE);
        assertNotNull(rectangle3);
        Shape rectangle4 = new Rectangle(0.0, 0.0, Double.MAX_VALUE, Double.MAX_VALUE);
        assertNotNull(rectangle4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInstanceZeroException1() throws Exception {
        new Rectangle(0.0, 0.0, 0.0, 15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInstanceZeroException2() throws Exception {
        new Rectangle(0.0, 0.0, 10.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInstanceZeroException3() throws Exception {
        new Rectangle(0.0, 0.0, 0.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInstanceNegativeException1() throws Exception {
        new Rectangle(0.0, 0.0, -10.0, 15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInstanceNegativeException2() throws Exception {
        new Rectangle(0.0, 0.0, 10.0, -15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInstanceNegativeException3() throws Exception {
        new Rectangle(0.0, 0.0, -10.0, -15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInstanceOverflowException1() throws Exception {
        new Rectangle(Double.MAX_VALUE, 0.0, Double.MAX_VALUE, 15.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInstanceOverflowException2() throws Exception {
        new Rectangle(0.0, Double.MAX_VALUE, 10, Double.MAX_VALUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newInstanceOverflowException3() throws Exception {
        new Rectangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Test
    public void location() throws Exception {
        Point point = new Point(0.0, 0.0);
        assertEquals(point, shape1.location());
    }

    @Test
    public void width() throws Exception {
        assertTrue(10.0 == shape1.width());
        assertTrue(10 == shape1.width());
        assertFalse(15.0 == shape1.width());
    }

    @Test
    public void height() throws Exception {
        assertTrue(15.0 == shape1.height());
        assertTrue(15 == shape1.height());
        assertFalse(10.0 == shape1.height());
    }

    @Test
    public void intersects() throws Exception {
        // Intersects, bottom left corner
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Shape rect2 = new Rectangle(5.0, 5.0, 10.0, 10.0);
        Boolean intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, bottom right corner
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, 5.0, 10.0, 10.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, top left corner
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(5.0, -5.0, 10.0, 10.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, top right corner
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, -5.0, 10.0, 10.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, top side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(2.0, -2.0, 4.0, 10.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, top side, all corners outside
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, -10.0, 20.0, 15.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);
        intersects = rect2.intersects(rect1);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, top side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, -5.0, 20.0, 15.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, top side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, -2.0, 4.0, 10.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, top side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, -2.0, 10.0, 10.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, bottom side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(2.0, 8.0, 4.0, 10.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, bottom side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, 10.0, 20.0, 15.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, bottom side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 8.0, 4.0, 10.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, bottom side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 8.0, 10.0, 10.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, left side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-2.0, 2.0, 4.0, 4.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, left side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-2.0, -2.0, 10.0, 19.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, left side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-2.0, 0.0, 10.0, 19.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, left side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-2.0, 0.0, 10.0, 15.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, right side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(8.0, 2.0, 4.0, 4.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);
        intersects = rect2.intersects(rect1);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, right side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(8.0, -2.0, 10.0, 19.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);
        intersects = rect2.intersects(rect1);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, right side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(8.0, 0.0, 10.0, 19.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);
        intersects = rect2.intersects(rect1);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Intersects, right side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(8.0, 0.0, 10.0, 15.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);
        intersects = rect2.intersects(rect1);
        assertNotNull(intersects);
        assertTrue(intersects);
    }

    @Test
    public void intersectsFalse() throws Exception {
        // Enclosed
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Shape rect2 = new Rectangle(2.0, 2.0, 5.0, 10.0);
        Boolean intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertFalse(intersects);

        // Reverse enclosed
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(2.0, 2.0, 5.0, 10.0);
        intersects = rect2.intersects(rect1);
        assertNotNull(intersects);
        assertFalse(intersects);

        // Null
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        intersects = rect2.intersects(null);
        assertNull(intersects);

        // Touching top, not intersects
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, -2.0, 10.0, 2.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertFalse(intersects);

        // Touching bottom, not intersects
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 15.0, 10.0, 2.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertFalse(intersects);

        // Touching right, not intersects
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(10.0, 0.0, 10.0, 2.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertFalse(intersects);

        // Touching left, not intersects
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-10.0, 0.0, 10.0, 2.0);
        intersects = rect1.intersects(rect2);
        assertNotNull(intersects);
        assertFalse(intersects);
    }

    @Test
    public void intersects1() throws Exception {
        // Intersects, bottom left corner
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Boolean intersects = rect1.intersects(5.0, 5.0, 10.0, 10.0);
        assertNotNull(intersects);
        assertTrue(intersects);
    }

    @Test
    public void contains() throws Exception {
        // Completely enclosed
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Shape rect2 = new Rectangle(2.0, 2.0, 5.0, 10.0);
        Boolean contains = rect1.contains(rect2);
        assertNotNull(contains);
        assertTrue(contains);
        // Must check containment in both directions
        contains = rect2.contains(rect1);
        assertNotNull(contains);
        assertFalse(contains);

        // Enclosed, one corner touching
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 0.0, 5.0, 10.0);
        contains = rect1.contains(rect2);
        assertNotNull(contains);
        assertTrue(contains);

        // Enclosed, 2 sides touching
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 0.0, 10.0, 10.0);
        contains = rect1.contains(rect2);
        assertNotNull(contains);
        assertTrue(contains);

        // Enclosed, all sides touching
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        contains = rect1.contains(rect2);
        assertNotNull(contains);
        assertTrue(contains);

        // Enclosed, all sides touching, same rectangle
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        contains = rect1.contains(rect1);
        assertNotNull(contains);
        assertTrue(contains);
    }

    @Test
    public void containsFalse() throws Exception {
        // Null shape
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Boolean contains = rect1.contains(null);
        assertNull(contains);

        // Left side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Shape rect2 = new Rectangle(-5.0, 0.0, 10.0, 15.0);
        contains = rect1.contains(rect2);
        assertNotNull(contains);
        assertFalse(contains);

        // Bottom Side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, -5.0, 10.0, 15.0);
        contains = rect1.contains(rect2);
        assertNotNull(contains);
        assertFalse(contains);

        // Top side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 5.0, 10.0, 15.0);
        contains = rect1.contains(rect2);
        assertNotNull(contains);
        assertFalse(contains);

        // Right side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(5.0, 0.0, 10.0, 15.0);
        contains = rect1.contains(rect2);
        assertNotNull(contains);
        assertFalse(contains);

        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, -5.0, 20.0, 25.0);
        contains = rect1.contains(rect2);
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test
    public void contains1() throws Exception {
        // Null shape
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Boolean contains = rect1.contains(2.0, 2.0, 5.0, 10.0);
        assertNotNull(contains);
        assertTrue(contains);
    }

    @Test
    public void adjacent() throws Exception {
        // Adjacent, top to this.shape.bottom
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Shape rect2 = new Rectangle(-5.0, -10.0, 20.0, 10.0);
        Boolean adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, top to this.shape.bottom
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, -10.0, 10.0, 10.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, top to this.shape.bottom
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(5.0, -10.0, 10.0, 10.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, top to this.shape.bottom
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(4.0, -10.0, 2.0, 10.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, bottom to this.shape.top
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, 15.0, 20.0, 10.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, bottom to this.shape.top
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, 15.0, 10.0, 10.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, bottom to this.shape.top
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(4.0, 15.0, 2.0, 10.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, bottom to this.shape.top
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(5.0, 15.0, 10.0, 10.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, left to this.shape.right
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(10.0, -5.0, 20.0, 20.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, left to this.shape.right
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(10.0, -5.0, 20.0, 10.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, left to this.shape.right
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(10.0, 5.0, 20.0, 5.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, left to this.shape.right
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(10.0, 5.0, 20.0, 15.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, right to this.shape.left
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-10.0, -5.0, 10.0, 20.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, right to this.shape.left
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-10.0, 5.0, 10.0, 20.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, right to this.shape.left
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-10.0, -5.0, 10.0, 10.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);

        // Adjacent, right to this.shape.left
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-10.0, 5.0, 10.0, 5.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertTrue(adjacent);
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertTrue(adjacent);
    }

    @Test
    public void adjacentFalse() throws Exception {
        // Intersects, bottom left corner
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Shape rect2 = new Rectangle(5.0, 5.0, 10.0, 10.0);
        Boolean adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertFalse(adjacent);

        // Completely enclosed
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(2.0, 2.0, 5.0, 10.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertFalse(adjacent);
        // Must check containment in both directions
        adjacent = rect2.adjacent(rect1);
        assertNotNull(adjacent);
        assertFalse(adjacent);

        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, 0.0, 10.0, 15.0);
        adjacent = rect1.adjacent(rect2);
        assertNotNull(adjacent);
        assertFalse(adjacent);
    }

    @Test
    public void adjacent1() throws Exception {

    }
}