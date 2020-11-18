package com.elwonder.xo.controller;

import com.elwonder.xo.model.Field;
import com.elwonder.xo.model.Figure;
import com.elwonder.xo.model.exceptions.InvalidMoveException;

import java.awt.*;

public class MoveController {
    public static void applyFigure(Field field, Point point, Figure figure) throws InvalidMoveException {
        if (!field.setFigure(point, figure)) {
            throw new InvalidMoveException();
        }
    }
}
