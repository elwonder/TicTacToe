package com.elwonder.xo.controller;

import com.elwonder.xo.model.Field;
import com.elwonder.xo.model.Figure;

import java.awt.*;

public class CurrentMoveController {
    public static Figure currentMove(Field field) {
        int xCounter = 0;
        int oCounter = 0;

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                Figure current = field.getFigure(new Point(i, j));
                if (current == Figure.X) {
                    xCounter++;
                } else if (current == Figure.O) {
                    oCounter++;
                }
            }
        }
        if (xCounter + oCounter == 9) {
            return null;
        }
        if (xCounter == 0 || xCounter == oCounter) {
            return Figure.X;
        } else {
            return Figure.O;
        }
    }
}
