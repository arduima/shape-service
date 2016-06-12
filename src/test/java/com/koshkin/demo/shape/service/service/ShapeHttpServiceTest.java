package com.koshkin.demo.shape.service.service;

import com.koshkin.demo.shape.service.ShapeServiceApplication;
import com.koshkin.demo.shape.service.dto.request.RectangleDto;
import com.koshkin.demo.shape.service.dto.request.ShapeRelationshipRequest;
import com.koshkin.demo.shape.service.dto.request.ShapeValidRequest;
import com.koshkin.demo.shape.service.dto.response.ResponseData;
import com.koshkin.demo.shape.service.dto.response.ShapeResponseData;
import com.koshkin.demo.shape.service.dto.response.ValidResponseData;
import com.koshkin.demo.shape.service.model.Relationship;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dkoshkin on 6/11/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ShapeServiceApplication.class)
@WebAppConfiguration
public class ShapeHttpServiceTest {

    @Autowired
    private ShapeHttpService service;

    @Test
    public void getRelationshipResponseData0() throws Exception {
        // INTERCEPTS
        ShapeRelationshipRequest request = new ShapeRelationshipRequest();
        List<RectangleDto> rectangleList = new ArrayList<>();
        RectangleDto rectangle1 = new RectangleDto();
        rectangle1.setX(0.0);
        rectangle1.setY(0.0);
        rectangle1.setWidth(10.0);
        rectangle1.setHeight(10.0);
        rectangleList.add(rectangle1);

        RectangleDto rectangle2 = new RectangleDto();
        rectangle2.setX(-5.0);
        rectangle2.setY(-5.0);
        rectangle2.setWidth(10.0);
        rectangle2.setHeight(10.0);
        rectangleList.add(rectangle2);

        request.setRectangles(rectangleList);
        ResponseData data = service.getRelationshipResponseData(request);
        assertNotNull(data);
        assertNotNull(((ShapeResponseData)data).getRelationship());
        assertTrue(((ShapeResponseData)data).getRelationship().compareTo(Relationship.INTERCEPTS.name()) == 0);
    }

    @Test
    public void getRelationshipResponseData1() throws Exception {
        // CONTAINS
        ShapeRelationshipRequest request = new ShapeRelationshipRequest();
        List<RectangleDto> rectangleList = new ArrayList<>();
        RectangleDto rectangle1 = new RectangleDto();
        rectangle1.setX(0.0);
        rectangle1.setY(0.0);
        rectangle1.setWidth(10.0);
        rectangle1.setHeight(10.0);
        rectangleList.add(rectangle1);

        RectangleDto rectangle2 = new RectangleDto();
        rectangle2.setX(2.0);
        rectangle2.setY(2.0);
        rectangle2.setWidth(6.0);
        rectangle2.setHeight(6.0);
        rectangleList.add(rectangle2);

        request.setRectangles(rectangleList);
        ResponseData data = service.getRelationshipResponseData(request);
        assertNotNull(data);
        assertNotNull(((ShapeResponseData)data).getRelationship());
        assertTrue(((ShapeResponseData)data).getRelationship().compareTo(Relationship.CONTAINS.name()) == 0);
    }

    @Test
    public void getRelationshipResponseData2() throws Exception {
        // ADJACENT
        ShapeRelationshipRequest request = new ShapeRelationshipRequest();
        List<RectangleDto> rectangleList = new ArrayList<>();
        RectangleDto rectangle1 = new RectangleDto();
        rectangle1.setX(0.0);
        rectangle1.setY(0.0);
        rectangle1.setWidth(10.0);
        rectangle1.setHeight(10.0);
        rectangleList.add(rectangle1);

        RectangleDto rectangle2 = new RectangleDto();
        rectangle2.setX(0.0);
        rectangle2.setY(10.0);
        rectangle2.setWidth(6.0);
        rectangle2.setHeight(6.0);
        rectangleList.add(rectangle2);

        request.setRectangles(rectangleList);
        ResponseData data = service.getRelationshipResponseData(request);
        assertNotNull(data);
        assertNotNull(((ShapeResponseData)data).getRelationship());
        assertTrue(((ShapeResponseData)data).getRelationship().compareTo(Relationship.ADJACENT.name()) == 0);
    }

    @Test
    public void getRelationshipResponseData3() throws Exception {
        // DISTANT
        ShapeRelationshipRequest request = new ShapeRelationshipRequest();
        List<RectangleDto> rectangleList = new ArrayList<>();
        RectangleDto rectangle1 = new RectangleDto();
        rectangle1.setX(0.0);
        rectangle1.setY(0.0);
        rectangle1.setWidth(10.0);
        rectangle1.setHeight(10.0);
        rectangleList.add(rectangle1);

        RectangleDto rectangle2 = new RectangleDto();
        rectangle2.setX(15.0);
        rectangle2.setY(15.0);
        rectangle2.setWidth(6.0);
        rectangle2.setHeight(6.0);
        rectangleList.add(rectangle2);

        request.setRectangles(rectangleList);
        ResponseData data = service.getRelationshipResponseData(request);
        assertNotNull(data);
        assertNotNull(((ShapeResponseData)data).getRelationship());
        assertTrue(((ShapeResponseData)data).getRelationship().compareTo(Relationship.DISTANT.name()) == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRelationshipResponseDataInvalid() throws Exception {
        ShapeRelationshipRequest request = new ShapeRelationshipRequest();
        List<RectangleDto> rectangleList = new ArrayList<>();
        RectangleDto rectangle1 = new RectangleDto();
        rectangle1.setX(0.0);
        rectangle1.setY(0.0);
        rectangle1.setWidth(10.0);
        rectangle1.setHeight(10.0);
        rectangleList.add(rectangle1);

        request.setRectangles(rectangleList);
        service.getRelationshipResponseData(request);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRelationshipResponseDataInvalid1() throws Exception {
        ShapeRelationshipRequest request = new ShapeRelationshipRequest();
        List<RectangleDto> rectangleList = new ArrayList<>();

        request.setRectangles(rectangleList);
        service.getRelationshipResponseData(request);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRelationshipResponseDataInvalid2() throws Exception {
        service.getRelationshipResponseData(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRelationshipResponseDataInvalid3() throws Exception {
        ShapeRelationshipRequest request = new ShapeRelationshipRequest();
        service.getRelationshipResponseData(request);
    }

    @Test
    public void getValidResponseData0() throws Exception {
        ShapeValidRequest request = new ShapeValidRequest();
        RectangleDto rectangle = new RectangleDto();
        rectangle.setX(0.0);
        rectangle.setY(0.0);
        rectangle.setWidth(10.0);
        rectangle.setHeight(10.0);
        request.setRectangle(rectangle);
        ResponseData data = service.getValidResponseData(request);
        assertNotNull(data);
        assertTrue(((ValidResponseData)data).isValid());

        // Null
        data = service.getValidResponseData(null);
        assertNotNull(data);
        assertFalse(((ValidResponseData)data).isValid());

        // Zero size
        rectangle = new RectangleDto();
        rectangle.setX(0.0);
        rectangle.setY(0.0);
        rectangle.setWidth(0.0);
        rectangle.setHeight(0.0);
        request.setRectangle(rectangle);
        data = service.getValidResponseData(null);
        assertNotNull(data);
        assertFalse(((ValidResponseData)data).isValid());

    }


}