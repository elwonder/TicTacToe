package com.elwonder.xo.controller;

import com.elwonder.xo.model.Field;
import com.elwonder.xo.model.Figure;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CurrentMoveControllerTest {

    @Test
    void currentMove() {
        final Field field = new Field();
        assertEquals(CurrentMoveController.currentMove(field), Figure.X);
        field.setFigure(new Point(0, 0), Figure.X);
        Figure current = Figure.O;
        assertEquals(CurrentMoveController.currentMove(field), Figure.O);
        for (int i = 0; i < field.getSize(); i++) {
                for (int j = 0; j < field.getSize(); j++) {
                    current = current == Figure.O ? Figure.X : Figure.O;
                    if (i == 0 && j == 0) continue;
                    field.setFigure(new Point(i, j), CurrentMoveController.currentMove(field));
                    assertEquals(field.getFigure(new Point(i, j)), current);
                }
        }
        assertNull(CurrentMoveController.currentMove(field));
    }
}