package com.cs2114.bomberman3;

import android.widget.Button;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import android.widget.TextView;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Dannies
 * @version Apr 29, 2014
 */
public class BomberScreen
    extends ShapeScreen
{
    private int      cellSize;
    private Map      map;
    private TextView score;

    private Button   moveLeft;
    private Button   moveRight;
    private Button   moveUp;
    private Button   moveDown;
    private Button   dropBomb;


    public void initialize()
    {
        int size =
            Math.min(getShapeView().getWidth(), getShapeView().getHeight());

        RectangleShape background = new RectangleShape(0, 0, size, size);
        background.setFillColor(Color.green);

        add(background);

        cellSize = size / 15;

        map = new Map(15, cellSize, this);

        map.addObserver(this);

        score.setText("Score: " + map.getScore());

        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                add(map.getCell(new Location(i, j)));
            }
        }
        enableButtons(true);
    }


    // ----------------------------------------------------------
    /**
     * Called when the drop button is pressed.
     */
    public void dropBombClicked()
    {
        map.getBomberman().dropBomb();
        add(map.getBomberman().getBomb());
    }


    // ----------------------------------------------------------
    /**
     * Called when the left button is pressed.
     */
    public void moveLeftClicked()
    {
        map.getBomberman().left();
    }


    // ----------------------------------------------------------
    /**
     * Called when the right button is pressed.
     */
    public void moveRightClicked()
    {
        map.getBomberman().right();
    }


    // ----------------------------------------------------------
    /**
     * Called when the up button is pressed.
     */
    public void moveUpClicked()
    {

        map.getBomberman().up();
    }


    // ----------------------------------------------------------
    /**
     * Called when the down button is pressed.
     */
    public void moveDownClicked()
    {
        map.getBomberman().down();
    }


    // ----------------------------------------------------------
    /**
     * Restarts the game.
     */
    public void resetClicked()
    {
        initialize();
    }


    // ----------------------------------------------------------
    /**
     * Updates if change was observed
     */
    public void changeWasObserved()
    {
        score.setText(map.getScore());
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param yes
     *            if enabled or not
     */
    public void enableButtons(boolean yes)
    {
        moveLeft.setEnabled(yes);
        moveRight.setEnabled(yes);
        moveUp.setEnabled(yes);
        moveDown.setEnabled(yes);
        dropBomb.setEnabled(yes);
    }
}
