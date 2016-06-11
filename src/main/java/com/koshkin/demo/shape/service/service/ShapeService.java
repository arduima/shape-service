package com.koshkin.demo.shape.service.service;

import com.koshkin.demo.shape.service.model.Point;
import com.koshkin.demo.shape.service.model.Rectangle;
import com.koshkin.demo.shape.service.model.Relationship;
import com.koshkin.demo.shape.service.model.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import static com.koshkin.demo.shape.service.logging.LogMessages.*;

/**
 * Created by dkoshkin on 6/11/16.
 */
@Service
public class ShapeService {

    private static Logger log = Logger.getLogger(ShapeService.class.getName());

    public Set<Relationship> getRelationship(Shape shape1, Shape shape2) throws IllegalArgumentException {
        Set relationshipSet = new HashSet<>();

        try {
            // Check if either shape contains the other
            if (shape1.contains(shape2) || shape2.contains(shape1)) {
                relationshipSet.add(Relationship.CONTAINS);
            }
            // Check if shapes intersect
            if (shape1.intersects(shape2)) {
                relationshipSet.add(Relationship.INTERCEPTS);
            }
            // Check if shapes are adjacent
            if (shape1.adjacent(shape2)) {
                relationshipSet.add(Relationship.ADJACENT);
            }

            // Check if distant only if no other conditions
            if (relationshipSet.isEmpty()) {
                if (shape1.distant(shape2)) {
                    relationshipSet.add(Relationship.DISTANT);
                } else {
                    // Program error, should not happen
                    log.warning(UNKNOWN_RELATIONSHIP);
                    relationshipSet.add(Relationship.UNDEFINED);
                }
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException();
        }

        return relationshipSet;
    }

}
