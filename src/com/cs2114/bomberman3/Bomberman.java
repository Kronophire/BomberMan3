package com.cs2114.bomberman3;

import sofia.util.Timer;

// -------------------------------------------------------------------------
/**
 * The main character controlled by the user. He can drop bombs to destroy
 * enemies and weak walls. He can't walk through walls or his own bombs.
 *
 * @author Aska192
 * @author chrisg6
 * @author dnyang
 * @version Apr 13, 2014
 */
public class Bomberman
    extends WorldActors
{
    private int      bombStrength;
    private Location current;
    private Bomb     bomb;


    // ----------------------------------------------------------
    /**
     * Create a new Bomberman object.
     *
     * @param map
     *            the map bomberman is in
     * @param loc
     *            the location of this object
     * @param left
     *            left coordinate
     * @param top
     *            top coordinate
     * @param right
     *            right coordinate
     * @param bottom
     *            bottom coordinate
     */
    public Bomberman(
        Map map,
        Location loc,
        float left,
        float top,
        float right,
        float bottom)
    {
        super(map, loc, left, top, right, bottom);

        bombStrength = 1;
        current = new Location(1, 1);
        setImage("bomberman");
    }


    // ~ Methods .........................................................

    // ----------------------------------------------------------
    /**
     * Moves Bomberman to the left.
     */
    public void left()
    {
        if (getMap().getCell(current.west()) instanceof Tile)
        {

            int x = current.west().x();
            int y = current.west().y();
            getMap().setCell(
                current,
                new Tile(getMap(), current, x * cellSize, y * cellSize, (x + 1)
                    * cellSize, (y + 1) * cellSize));

            getMap().setCell(current.west(), this);
            current = current.west();
            this.animate(250).moveBy(-1 * cellSize, 0).play();
        }
        else if (getMap().getCell(current.west()) instanceof Enemy)
        {
            this.die();
        }
    }


    /**
     * Moves Bomberman to the right.
     */
    public void right()
    {
        int x = current.east().x();
        int y = current.east().y();
        if (getMap().getCell(current.east()) instanceof Tile)
        {
            getMap().setCell(
                current,
                new Tile(getMap(), current, x * cellSize, y * cellSize, (x + 1)
                    * cellSize, (y + 1) * cellSize));

            getMap().setCell(current.east(), this);
            current = current.east();
            this.animate(250).moveBy(cellSize, 0).play();
        }
        else if (getMap().getCell(current.east()) instanceof Enemy)
        {
            this.die();
        }
    }


    /**
     * Moves Bomberman up.
     */
    public void up()
    {
        if (bomb != null)
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
                this.animate(250).moveBy(0, -1 * cellSize).play();

            }
            else if (getMap().getCell(current.north()) instanceof Enemy)
            {
                this.die();
            }
    }


    /**
     * Moves Bomberman down.
     */
    public void down()
    {
        if (getMap().getCell(current.south()) instanceof Tile)
        {

            int x = current.south().x();
            int y = current.south().y();
            getMap().setCell(
                current,
                new Tile(getMap(), current, x * cellSize, y * cellSize, (x + 1)
                    * cellSize, (y + 1) * cellSize));

            getMap().setCell(current.south(), this);
            current = current.south();
            this.animate(250).moveBy(0, cellSize).play();

        }
        else if (getMap().getCell(current.south()) instanceof Enemy)
        {
            this.die();
        }
    }


    /**
     * Plants a bomb at the bomberman's current location.
     */
    public void dropBomb()
    {
        int x = current.x();
        int y = current.y();
        bomb =
            new Bomb(getMap(), bombStrength(), current, x * cellSize, y
                * cellSize, (x + 1) * cellSize, (y + 1) * cellSize);

        Timer.callOnce(bomb, "explode", 6000);
    }


    /**
     * Return the bomb strength.
     *
     * @return strength the bomb strength
     */
    public int bombStrength()
    {
        return bombStrength;
    }


    // ----------------------------------------------------------
    /**
     * Returns the location of bomberman
     *
     * @return the location
     */
    public Location getLocation()
    {
        return current;
    }


    // ----------------------------------------------------------
    /**
     * Called when bomberman dies.
     */
    public void die()
    {
        animate(400).alpha(0).rotation(720).removeWhenComplete().play();

        int size =
            Math.min(getMap().getScreen().getShapeView().getHeight(), getMap()
                .getScreen().getShapeView().getWidth());
        getMap().getScreen().add(new GameOver(0, 0, size, size));

        getMap().getScreen().enableButtons(false);
    }


    // ----------------------------------------------------------
    /**
     * Returns the bomb object placed by bomberman
     *
     * @return the bomb
     */
    public Bomb getBomb()
    {
        return bomb;
    }
}
