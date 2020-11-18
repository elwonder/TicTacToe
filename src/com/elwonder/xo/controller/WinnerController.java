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
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < field.getSize(); j++) {
                if (field.getFigure(new Point(i, j))  != null) row.append(field.getFigure(new Point(i, j)).getValue());
            }
            if (checkString(row.toString()) != null) return checkString(row.toString());
        }
        for (int i = 0; i < field.getSize(); i++) {
            StringBuilder column = new StringBuilder();
            for (int j = 0; j < field.getSize(); j++) {
                if (field.getFigure(new Point(j, i))  != null) column.append(field.getFigure(new Point(j, i)).getValue());
            }
            if (checkString(column.toString()) != null) return checkString(column.toString());
        }
        return null;
    }

    private static Figure checkDiagonal(Field field) {
        StringBuilder diagonal = new StringBuilder();
        for (int i = 0; i < field.getSize(); i++) {
            if (field.getFigure(new Point(i, i))  != null) diagonal.append(field.getFigure(new Point(i, i)).getValue());
        }
        if (checkString(diagonal.toString()) != null) return checkString(diagonal.toString());
        diagonal = new StringBuilder();
        for (int i = field.getSize() - 1, j = 0; j < field.getSize(); i--, j++) {
            if (field.getFigure(new Point(i, j))  != null) diagonal.append(field.getFigure(new Point(i, j)).getValue());
        }
        if (checkString(diagonal.toString()) != null) return checkString(diagonal.toString());
        return null;
    }
}
