package com.cs2114.bomberman3;

import android.widget.Button;
import sofia.util.Random;
import student.TestCase;

// -------------------------------------------------------------------------

/**
 * The test class for the map.
 *
 * @author Aska192
 * @author chrisg6
 * @author dnyang
 * @version Apr 13, 2014
 */

public class MapTest

    extends TestCase

{
    // ~ Instance/static fields ...............................................
    private Map    map;
    private Enemy  balloon;
    private Button moveUp;


    /**
     * Runs before every test method.
     */

    public void setUp()

    {

// BomberScreen screen = new BomberScreen();

        Random.setNextInts(

        0,

        0,

        0,

        30,

        30,

        30,

        0,

        0,

        0,

        0,

        30,

        30,

        30,

        0,

        30,

        30,

        0);

        map = new Map(15, 50, null);
    }


    /**
     * Check objects to be properly placed.
     */

    public void testCheckObjects()

    {

        assertTrue(map.getCell(new Location(0, 0)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(2, 2)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(2, 4)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(2, 6)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(2, 8)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(2, 10)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(2, 12)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(4, 2)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(4, 4)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(4, 6)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(4, 8)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(4, 10)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(4, 12)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(6, 2)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(6, 4)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(6, 6)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(6, 8)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(6, 10)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(6, 12)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(8, 2)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(8, 4)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(8, 6)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(8, 8)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(8, 10)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(8, 12)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(10, 2)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(10, 4)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(10, 6)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(10, 8)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(10, 10)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(10, 12)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(12, 2)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(12, 4)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(12, 6)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(12, 8)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(12, 10)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(12, 12)) instanceof StrongWall);

        assertTrue(map.getCell(new Location(3, 1)) instanceof WeakWall);

        assertFalse(map.getCell(new Location(4, 1)) instanceof WeakWall);

        assertTrue(map.getCell(new Location(5, 1)) instanceof WeakWall);

        assertFalse(map.getCell(new Location(6, 1)) instanceof WeakWall);

        assertFalse(map.getCell(new Location(7, 1)) instanceof WeakWall);

        assertFalse(map.getCell(new Location(8, 1)) instanceof WeakWall);

        assertFalse(map.getCell(new Location(10, 1)) instanceof WeakWall);

        assertFalse(map.getCell(new Location(12, 1)) instanceof WeakWall);
    }


    /**
     * Testing the enemy class.
     */
    public void testMoveRandomly()
    {

        Location loc = new Location(7, 1);
        // The last parameters are for the image.
        balloon = new Enemy(map, loc, 0, 0, 0, 0);
        // 0 is west, 1 is east, 2 is north, 3 is south.
        Random.setNextInts(0, 1, 2, 3);
        assertTrue(balloon.getLocation().equals(loc));
        balloon.moveRandomly();
        assertTrue(map.getCell(new Location(6, 1)) instanceof Enemy);
        balloon.moveRandomly();
        assertTrue(map.getCell(new Location(7, 1)) instanceof Enemy);
        balloon.moveRandomly();
        assertTrue(map.getCell(new Location(7, 2)) instanceof Enemy);
        balloon.moveRandomly();
        assertTrue(map.getCell(new Location(7, 1)) instanceof Enemy);
    }


    // ----------------------------------------------------------
    /**
     * Testing the BomberMan class, bomb, and enemy methods.
     */
    public void testBomberman()
    {
        map.getBomberman().down();
        assertTrue(map.getCell(new Location(1, 2)) instanceof Bomberman);
        map.getBomberman().up();
        assertTrue(map.getCell(new Location(1, 1)) instanceof Bomberman);
        map.getBomberman().right();
        assertTrue(map.getCell(new Location(2, 1)) instanceof Bomberman);
        map.getBomberman().left();
        assertTrue(map.getCell(new Location(1, 1)) instanceof Bomberman);

        map.getBomberman().dropBomb();
        map.setCell(new Location(2, 1), new WeakWall(
            map,
            new Location(2, 1),
            0,
            0,
            0,
            0));
        assertTrue(map.getCell(new Location(2, 1)) instanceof WeakWall);
        map.getBomberman().getBomb().explode();
        assertTrue(map.getCell(new Location(2, 1)) instanceof Tile);

        map.getBomberman().die();
        assertFalse(moveUp.isEnabled());
    }
}
