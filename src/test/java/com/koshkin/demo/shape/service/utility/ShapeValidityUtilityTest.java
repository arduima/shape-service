package com.koshkin.demo.shape.service.utility;

import com.koshkin.demo.shape.service.ShapeServiceApplication;
import com.koshkin.demo.shape.service.model.Rectangle;
import com.sun.javafx.binding.DoubleConstant;
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
public class ShapeValidityUtilityTest {

    @Test
    public void isValid() throws Exception {
        assertFalse(ShapeValidityUtility.isValid(null));
        assertTrue(ShapeValidityUtility.isValid(0.0, 0.0, 10.0, 15.0));
    }

    @Test
    public void isValid1() throws Exception {
        assertFalse(ShapeValidityUtility.isValid(0.0, 0.0, 0.0, 0.0));
    }

    @Test
    public void isValidException0() throws Exception {
        assertTrue(ShapeValidityUtility.isValidException(0.0, 0.0, 10.0, 10.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValidException1() throws Exception {
         ShapeValidityUtility.isValidException(0.0, 0.0, 0.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValidException2() throws Exception {
        ShapeValidityUtility.isValidException(Double.MAX_VALUE, 0.0, Double.MAX_VALUE, 0.0);
    }


}