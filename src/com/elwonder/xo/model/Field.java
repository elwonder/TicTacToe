package com.elwonder.xo.model;

import java.awt.*;

public class Field {
    private static final int FIELD_SIZE = 3;
    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public boolean setFigure(Point point, Figure figure) {
        if (!isCorrectPoint(point)) {
            return false;
        }
        if (getFigure(point) != null) {
            return false;
        }
        field[point.x][point.y] = figure;
        return true;
    }


    private boolean isCorrectPoint(Point point) {
        int x = point.x;
        int y = point.y;
        return x >= 0 && y >= 0 && x < FIELD_SIZE && y < FIELD_SIZE;
    }

    public Figure getFigure(Point point) {
        return field[point.x][point.y];
    }
}
