package com.elwonder.xo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getFigure() {
        final Figure testValue = Figure.X;
        final Player player = new Player(null, testValue);
        final Figure actualValue = player.getFigure();
        assertEquals(testValue, actualValue);
    }

    @Test
    void getName() {
        final String testValue = "Bob";
        final Player player = new Player(testValue, null);
        final String actualValue = player.getName();
        assertEquals(testValue, actualValue);
    }
}