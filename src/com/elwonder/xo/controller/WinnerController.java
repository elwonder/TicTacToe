package com.elwonder.xo.controller;

import com.elwonder.xo.model.Field;
import com.elwonder.xo.model.Figure;

import java.awt.*;

public class WinnerController {
    public static Figure getWinner(Field field) {
        if (checkDiagonal(field) != null) return checkDiagonal(field);
        if (checkStraight(field) != null) return checkStraight(field);
        return null;
    }

    private static Figure checkString(String row) {
        if (row.equals("XXX")) {
            return Figure.X;
        } else if (row.equals("OOO")) {
            return Figure.O;
        }
        return null;
    }

    private static Figure checkStraight(Field field) {
        for (int i = 0; i < field.getSize(); i++) {
            String row = "";
            String column = "";
            for (int j = 0; j < field.getSize(); j++) {
                Figure rowFigure = field.getFigure(new Point(i, j));
                Figure columnFigure = field.getFigure(new Point(j, i));
                if (rowFigure != null) row += rowFigure.getValue();
                if (columnFigure != null) column += columnFigure.getValue();
            }
            if (checkString(row) != null) return checkString(row);
            if (checkString(column) != null) return checkString(column);
        }
        return null;
    }

    private static Figure checkDiagonal(Field field) {
        String diagonal = "";
        for (int i = 0; i < field.getSize(); i++) {
            Figure figure = field.getFigure(new Point(i, i));
            if (figure != null) diagonal += figure.getValue();
        }
        if (checkString(diagonal) != null) return checkString(diagonal);
        diagonal = "";
        for (int i = field.getSize() - 1, j = 0; j < field.getSize(); i--, j++) {
            Figure figure = field.getFigure(new Point(i, j));
            if (figure  != null) diagonal += figure.getValue();
        }
        if (checkString(diagonal) != null) return checkString(diagonal);
        return null;
    }
}
