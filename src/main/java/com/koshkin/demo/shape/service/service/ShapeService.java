package com.koshkin.demo.shape.service.service;

import com.koshkin.demo.shape.service.model.Relationship;
import com.koshkin.demo.shape.service.model.Shape;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static com.koshkin.demo.shape.service.logging.LogMessages.UNKNOWN_RELATIONSHIP;

/**
 * Created by dkoshkin on 6/11/16.
 */
@Service
public class ShapeService {

    private static Logger log = Logger.getLogger(ShapeService.class.getName());

    public Relationship getRelationship(Shape shape1, Shape shape2) throws IllegalArgumentException {
        Relationship relationship = null;

        try {
            if (shape1.contains(shape2) || shape2.contains(shape1)) {
                // Check if either shape contains the other
                relationship = Relationship.CONTAINS;
            } else if (shape1.intersects(shape2)) {
                // Check if shapes intersect
                relationship = Relationship.INTERCEPTS;
            } else if (shape1.adjacent(shape2)) {
                // Check if shapes are adjacent
                relationship = Relationship.ADJACENT;
            }

            // Check if distant only if no other conditions
            if (relationship == null) {
                if (shape1.distant(shape2)) {
                    relationship = Relationship.DISTANT;
                } else {
                    // Program error, should not happen
                    log.warning(UNKNOWN_RELATIONSHIP);
                    relationship = Relationship.UNDEFINED;
                }
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException();
        }

        return relationship;
    }

}
