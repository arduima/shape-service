package com.koshkin.demo.shape.service.dto.request;

/**
 * Created by dkoshkin on 6/11/16.
 */
public class ShapeValidRequest {

    private RectangleDto rectangle;

    public RectangleDto getRectangle() {
        return rectangle;
    }

    public void setRectangle(RectangleDto rectangle) {
        this.rectangle = rectangle;
    }
}
