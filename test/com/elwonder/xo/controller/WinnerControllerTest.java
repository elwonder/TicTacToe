package com.elwonder.xo.controller;

import com.elwonder.xo.model.Field;
import com.elwonder.xo.model.Figure;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    @Test
    void getWinner() {
        final Field field = new Field();
        assertNull(WinnerController.getWinner(field));
    }

    @Test
    void checkDiagonal() {
        Field field = new Field();
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(i, i), Figure.X);
        }
        assertEquals(WinnerController.getWinner(field), Figure.X);
        field = new Field();
        for (int i = 2, j = 0; j < field.getSize(); i--, j++) {
            field.setFigure(new Point(i, j), Figure.X);
        }
        assertEquals(WinnerController.getWinner(field), Figure.X);
    }

    @Test
    void checkStraight() {
        checkRows();
        checkColumns();
    }

    private void checkRows() {
        Field field = new Field();
        for (int i = 0; i < field.getSize(); i++) {
            field = new Field();
            fillRow(field, i);
            assertEquals(WinnerController.getWinner(field), Figure.X);
        }
    }

    private void checkColumns() {
        Field field = new Field();
        for (int i = 0; i < field.getSize(); i++) {
            field = new Field();
            fillColumn(field, i);
            assertEquals(WinnerController.getWinner(field), Figure.X);
        }
    }

    private void fillRow(Field field, int row) {
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(row, i), Figure.X);
        }
    }

    private void fillColumn(Field field, int column) {
        for (int i = 0; i < field.getSize(); i++) {
            field.setFigure(new Point(i, column), Figure.X);
        }
    }
}