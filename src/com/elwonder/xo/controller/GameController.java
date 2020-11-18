package com.elwonder.xo.controller;

import com.elwonder.xo.model.Field;
import com.elwonder.xo.model.Figure;
import com.elwonder.xo.model.Game;
import com.elwonder.xo.model.Player;
import com.elwonder.xo.model.exceptions.InvalidMoveException;
import com.elwonder.xo.view.ConsoleView;

import java.awt.*;
import java.util.Scanner;

public class GameController {

    public static void main(String[] args) {
        Player firstPlayer = new Player("Bob", Figure.X);
        Player secondPlayer = new Player("Max", Figure.O);
        Game game = new Game("XO", new Field(), firstPlayer, secondPlayer);
        init(game);
        gameRoutine(game);
    }

    private static void init(Game game) {
        System.out.println("Welcome to XO game!");
        System.out.println("Bob is playing for X, Max is playing for O");
        ConsoleView.showBoard(game.getField());
    }

    private static void gameRoutine(Game game) {
        Scanner in = new Scanner(System.in);
        final Field field = game.getField();
        while (CurrentMoveController.currentMove(field) != null) {
            System.out.println("Now is " + CurrentMoveController.currentMove(field).getValue() + " move!");
            System.out.println("Enter coordintes in X Y format: ");
            try {
                MoveController.applyFigure(
                        field,
                        new Point(in.nextInt(),
                        in.nextInt()),
                        CurrentMoveController.currentMove(field));
                System.out.println("Nice move!");
                ConsoleView.showBoard(field);
            } catch (InvalidMoveException e) {
                System.out.println("Bad move! Try again");
                continue;
            }
            if (WinnerController.getWinner(field) != null) {
                System.out.println("Winner is " + WinnerController.getWinner(field).getValue() + "!");
                System.out.println("Good bye!");
                return;
            }
        }
        System.out.println("It's a draw! Well played!");
        System.out.println("Good bye!");
    }
}
