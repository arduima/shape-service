package com.koshkin.demo.shape.service.controller;

import com.koshkin.demo.shape.service.dto.request.ShapeRequest;
import com.koshkin.demo.shape.service.dto.response.Meta;
import com.koshkin.demo.shape.service.dto.response.Response;
import com.koshkin.demo.shape.service.exception.UnknownStateException;
import com.koshkin.demo.shape.service.service.ShapeHttpService;
import com.koshkin.demo.shape.service.service.ShapeService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
import static com.koshkin.demo.shape.service.logging.LogMessages.*;

/**
 * Created by dkoshkin on 6/11/16.
 */

@RestController
public class ShapeController {

    private static Logger log = Logger.getLogger(ShapeController.class.getName());

    @Autowired
    private ShapeHttpService service;

    @RequestMapping(value="/relationship", method = RequestMethod.POST)
    public ResponseEntity<Response> greeting(@RequestBody ShapeRequest request) {
        Response response = new Response();
        try {
            response.setMeta(new Meta());
            response.setData(service.getResponseData(request));
            return ResponseEntity.ok(response);
        } catch(IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        } catch (UnknownStateException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
