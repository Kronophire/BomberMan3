package com.cs2114.bomberman3;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Pops up when it's game over.
 *
 * @author Dannies
 * @version Apr 30, 2014
 */
public class GameOver
    extends RectangleShape
{
    // ----------------------------------------------------------
    /**
     * Create a new GameOver object.
     *
     * @param left
     *            left coord
     * @param top
     *            top coord
     * @param right
     *            right coord
     * @param bottom
     *            bottom coord
     */
    public GameOver(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setImage("game_over");
    }
}
