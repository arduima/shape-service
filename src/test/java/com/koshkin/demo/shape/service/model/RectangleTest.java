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

    }

    @Test
    public void intersects1() throws Exception {

    }

    @Test
    public void contains() throws Exception {
        // Completely enclosed
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Shape rect2 = new Rectangle(2.0, 2.0, 5.0, 10.0);
        Boolean intersects = rect1.contains(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Enclosed, one corner touching
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 0.0, 5.0, 10.0);
        intersects = rect1.contains(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Enclosed, 2 sides touching
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 0.0, 10.0, 10.0);
        intersects = rect1.contains(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Enclosed, all sides touching
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        intersects = rect1.contains(rect2);
        assertNotNull(intersects);
        assertTrue(intersects);

        // Enclosed, all sides touching, same rectangle
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        intersects = rect1.contains(rect1);
        assertNotNull(intersects);
        assertTrue(intersects);
    }

    @Test
    public void containsFalse() throws Exception {

        // Null shape
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Boolean intersects = rect1.contains(null);
        assertNull(intersects);

        // Left side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Shape rect2 = new Rectangle(-5.0, 0.0, 10.0, 15.0);
        intersects = rect1.contains(rect2);
        assertNotNull(intersects);
        assertFalse(intersects);

        // Bottom Side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, -5.0, 10.0, 15.0);
        intersects = rect1.contains(rect2);
        assertNotNull(intersects);
        assertFalse(intersects);

        // Top side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(0.0, 5.0, 10.0, 15.0);
        intersects = rect1.contains(rect2);
        assertNotNull(intersects);
        assertFalse(intersects);


        // Right side
        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(5.0, 0.0, 10.0, 15.0);
        intersects = rect1.contains(rect2);
        assertNotNull(intersects);
        assertFalse(intersects);

        rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        rect2 = new Rectangle(-5.0, -5.0, 20.0, 25.0);
        intersects = rect1.contains(rect2);
        assertNotNull(intersects);
        assertFalse(intersects);
    }

    @Test
    public void contains1() throws Exception {
        // Null shape
        Shape rect1 = new Rectangle(0.0, 0.0, 10.0, 15.0);
        Boolean intersects = rect1.contains(2.0, 2.0, 5.0, 10.0);
        assertNotNull(intersects);
        assertTrue(intersects);
    }

    @Test
    public void adjacent() throws Exception {

    }

    @Test
    public void adjacent1() throws Exception {

    }
}