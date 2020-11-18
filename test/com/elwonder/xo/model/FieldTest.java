package com.elwonder.xo.model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSize() {
        final int expectedSize = 3;
        Field field = new Field();
        final int acutalSize = field.getSize();
        assertEquals(expectedSize, acutalSize);
    }

    @Test
    void setFigure() {
        final Field field = new Field();
        final Point lessThanZeroPoint = new Point(-1, -1);
        final Point moreThanSizePoint = new Point(field.getSize() + 1, 0);
        final Point regularPoint = new Point(0, 0);
        assertFalse(field.setFigure(lessThanZeroPoint, Figure.X));
        assertFalse(field.setFigure(moreThanSizePoint, Figure.X));
        assertTrue(field.setFigure(regularPoint, Figure.X));
        assertFalse(field.setFigure(regularPoint, Figure.X));
    }

    @Test
    void getFigure() {
        final Field field = new Field();
        final Point point = new Point(0, 0);
        assertNull(field.getFigure(point));
        field.setFigure(point, Figure.X);
        assertEquals(field.getFigure(point), Figure.X);
    }
}