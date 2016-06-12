package com.koshkin.demo.shape.service.dto.response;

import java.util.Calendar;

/**
 * Created by dkoshkin on 6/11/16.
 */
public class Meta {

    private String timestamp;
    // TODO figure out how to read from props
    private String version = "0.0.1";

    public String getTimestamp() {
        return Calendar.getInstance().getTime().toString();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
