package com.koshkin.demo.shape.service.dto.request;

import java.util.List;

/**
 * Created by dkoshkin on 6/11/16.
 */
public class ShapeRelationshipRequest {

    private List<RectangleDto> rectangles;

    public List<RectangleDto> getRectangles() {
        return rectangles;
    }

    public void setRectangles(List<RectangleDto> rectangles) {
        this.rectangles = rectangles;
    }
}
