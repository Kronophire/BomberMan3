package com.cs2114.bomberman3;

import sofia.util.Timer;
import java.util.Random;

// -------------------------------------------------------------------------
/**
 * The enemy in the bomberman map. Moves randomly and kills bomberman if they
 * come in contact with him. They can't move through any walls
 *
 * @author Aska192
 * @author chrisg6
 * @author dnyang
 * @version Apr 13, 2014
 */
public class Enemy
    extends WorldActors
{
    private Location current;


    // ----------------------------------------------------------
    /**
     * Create a new Enemy object.
     *
     * @param map
     *            map of the enemy
     * @param loc
     *            location of the enemy
     * @param left
     *            left coordinate of the enemy
     * @param top
     *            top coordinate of the enemy
     * @param right
     *            right coordinate of the enemy
     * @param bottom
     *            bottom coordinate of the enemy
     */
    public Enemy(
        Map map,
        Location loc,
        float left,
        float top,
        float right,
        float bottom)
    {
        super(map, loc, left, top, right, bottom);

        current = loc;
        setImage("balloon");
        Timer.callRepeatedly(this, "moveRandomly", 5000);
    }


    /**
     * The enemy moves around randomly.
     */
    public void moveRandomly()
    {
        Random numGenerator = new Random();
        int n = numGenerator.nextInt(5);

        if (n == 0)
        {
            if (getMap().getCell(current.west()) instanceof Tile)
            {
                int x = current.west().x();
                int y = current.west().y();
                getMap().setCell(
                    current,
                    new Tile(
                        getMap(),
                        current,
                        x * cellSize,
                        y * cellSize,
                        (x + 1) * cellSize,
                        (y + 1) * cellSize));
                getMap().setCell(current.west(), this);
                this.animate(500).moveBy(-1 * cellSize, 0).play();

            }
            else if (getMap().getCell(current.west()) instanceof Bomberman)
            {
                getMap().getBomberman().die();
            }
        }
        else if (n == 1)
        {
            if (getMap().getCell(current.east()) instanceof Tile)
            {

                int x = current.east().x();
                int y = current.east().y();

                getMap().setCell(
                    current,
                    new Tile(
                        getMap(),
                        current,
                        x * cellSize,
                        y * cellSize,
                        (x + 1) * cellSize,
                        (y + 1) * cellSize));

                getMap().setCell(current.east(), this);
                current = current.east();
                this.animate(500).moveBy(cellSize, 0).play();
            }
            else if (getMap().getCell(current.east()) instanceof Bomberman)
            {
                getMap().getBomberman().die();
            }
        }
        else if (n == 2)
        {
            if (getMap().getCell(current.north()) instanceof Tile)
            {

                int x = current.north().x();
                int y = current.north().y();

                getMap().setCell(
                    current,
                    new Tile(
                        getMap(),
                        current,
                        x * cellSize,
                        y * cellSize,
                        (x + 1) * cellSize,
                        (y + 1) * cellSize));

                getMap().setCell(current.north(), this);
                current = current.north();
                this.animate(500).moveBy(0, -1 * cellSize).play();
            }
            else if (getMap().getCell(current.north()) instanceof Bomberman)
            {
                getMap().getBomberman().die();
            }
        }
        else
        {
            if (getMap().getCell(current.south()) instanceof Tile)
            {

                int x = current.south().x();
                int y = current.south().y();

                getMap().setCell(
                    current,
                    new Tile(
                        getMap(),
                        current,
                        x * cellSize,
                        y * cellSize,
                        (x + 1) * cellSize,
                        (y + 1) * cellSize));

                getMap().setCell(current.south(), this);
                current = current.south();

                this.animate(500).moveBy(0, cellSize).play();
            }
            else if (getMap().getCell(current.south()) instanceof Bomberman)
            {
                getMap().getBomberman().die();
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * sets the location of the enemy
     *
     * @param curr
     *            the new location
     */
    public void setLocation(Location curr)
    {
        current = curr;
    }


    public void die()
    {
        getMap().addScore();

        int x = current.x();
        int y = current.y();

        getMap().setCell(
            current,
            new Tile(getMap(), current, x * cellSize, y * cellSize, (x + 1)
                * cellSize, (y + 1) * cellSize));

        animate(400).alpha(0).rotation(720).removeWhenComplete().play();
    }
}
