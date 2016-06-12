package com.koshkin.demo.shape.service.controller;

import com.koshkin.demo.shape.service.dto.request.ShapeRelationshipRequest;
import com.koshkin.demo.shape.service.dto.request.ShapeValidRequest;
import com.koshkin.demo.shape.service.dto.response.Meta;
import com.koshkin.demo.shape.service.dto.response.Response;
import com.koshkin.demo.shape.service.exception.UnknownStateException;
import com.koshkin.demo.shape.service.service.ShapeHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Created by dkoshkin on 6/11/16.
 */

@RestController
@CrossOrigin
public class ShapeController {

    private static Logger log = Logger.getLogger(ShapeController.class.getName());

    @Autowired
    private ShapeHttpService service;

    @RequestMapping(value="/relationship", method = RequestMethod.POST)
    public ResponseEntity<Response> relationship(@RequestBody ShapeRelationshipRequest request) {
        Response response = new Response();
        try {
            response.setMeta(new Meta());
            response.setData(service.getRelationshipResponseData(request));
            return ResponseEntity.ok(response);
        } catch(IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        } catch (UnknownStateException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @RequestMapping(value="/valid", method = RequestMethod.POST)
    public ResponseEntity<Response> valid(@RequestBody ShapeValidRequest request) {
        Response response = new Response();
        try {
            response.setMeta(new Meta());
            response.setData(service.getValidResponseData(request));
            return ResponseEntity.ok(response);
        } catch(IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
