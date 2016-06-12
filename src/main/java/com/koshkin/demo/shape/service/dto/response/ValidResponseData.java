package com.koshkin.demo.shape.service.dto.response;

/**
 * Created by dkoshkin on 6/11/16.
 */
public class ValidResponseData implements ResponseData {

    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
