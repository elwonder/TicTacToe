package com.elwonder.xo.controller;

import com.elwonder.xo.model.Field;
import com.elwonder.xo.model.Figure;
import com.elwonder.xo.model.exceptions.InvalidMoveException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MoveControllerTest {

    @Test
    void applyFigure() {
        final Field field = new Field();
        final Point invalidPoint = new Point(-1, -1);
        final Figure figure = Figure.X;
        final Point point = new Point(0, 0);
        try {
            MoveController.applyFigure(field, invalidPoint, figure);
            fail();
        } catch (InvalidMoveException e) { /* ignore */}

        try {
            MoveController.applyFigure(field, point, figure);
        } catch (InvalidMoveException e) {
            fail();
        }
        assertEquals(field.getFigure(point), figure);
    }
}