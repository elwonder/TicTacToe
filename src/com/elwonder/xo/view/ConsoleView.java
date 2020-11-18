package com.elwonder.xo.view;

import com.elwonder.xo.model.Field;
import com.elwonder.xo.model.Figure;

import java.awt.*;
import java.io.Console;

public class ConsoleView {
    private static final String SEPARATOR = "~~~~~~~~~~~";

    public static void showBoard(Field field) {
        StringBuilder[] initialStrings = new StringBuilder[field.getSize()];
        for (int i = 0; i < field.getSize(); i++) {
            initialStrings[i] = new StringBuilder("   |   |   ");
        }
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (field.getFigure(new Point(i, j)) != null) {
                    initialStrings[i].replace(1 + 4*j, 2 + 4*j, field.getFigure(new Point(i, j)).getValue());
                }
            }
        }
        System.out.println(initialStrings[0].toString());
        System.out.println(SEPARATOR);
        System.out.println(initialStrings[1].toString());
        System.out.println(SEPARATOR);
        System.out.println(initialStrings[2].toString());
    }

    public static void main(String[] args) {
        Field field = new Field();
        ConsoleView.showBoard(field);
        field.setFigure(new Point(1, 1), Figure.X);
        System.out.println();
        System.out.println();
        ConsoleView.showBoard(field);
    }
}
