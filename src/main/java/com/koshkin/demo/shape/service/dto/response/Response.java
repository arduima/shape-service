package com.koshkin.demo.shape.service.dto.response;

/**
 * Created by dkoshkin on 6/11/16.
 */
public class Response {

    private Meta meta;
    private ResponseData data;

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
