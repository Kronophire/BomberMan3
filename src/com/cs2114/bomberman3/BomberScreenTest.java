package com.cs2114.bomberman3;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Dannies
 * @version Apr 30, 2014
 */
public class BomberScreenTest
    extends student.AndroidTestCase<BomberScreen>
{
    private TextView score;

    private Button   moveLeft;
    private Button   moveRight;
    private Button   moveUp;
    private Button   moveDown;
    private Button   dropBomb;

    private Button   reset;


    // ----------------------------------------------------------
    /**
     * Create a new BomberScreenTest object.
     */
    public BomberScreenTest()
    {
        super(BomberScreen.class);
    }


    public void setUp()
    {
        // left blank
    }


    // ----------------------------------------------------------
    /**
     * Tests the moveLeft button.
     */
    public void testMoveLeft()
    {
        click(moveLeft);
        assertEquals(score.getText().toString(), "0");
    }
}
