package com.cs2114.bomberman3;

// -------------------------------------------------------------------------
/**
 * This class is the Bomb object that Bomberman drops. The bomb will explode
 * after two seconds and the explosion will destroy weak walls and enemies.
 * Although the explosion can not destroy Strongwalls or Tiles.
 *
 * @author Aska192
 * @author chrisg6
 * @author dnyang
 * @version Apr 13, 2014
 */
public class Bomb
    extends WorldActors
{
    private int      bombStrength;
    private Location current;


    // ----------------------------------------------------------
    /**
     * Create a new Bomb object that will explode after some time.
     *
     * @param map
     *            map of the bomb
     * @param s
     *            the bombstrength
     * @param loc
     *            location of the bomb
     * @param left
     *            left coordinate of the bomb
     * @param top
     *            top coordinate of the bomb
     * @param right
     *            right coordinate of the bomb
     * @param bottom
     *            bottom coordinate of the bomb
     */
    public Bomb(
        Map map,
        int s,
        Location loc,
        float left,
        float top,
        float right,
        float bottom)
    {
        super(map, loc, left, top, right, bottom);

        bombStrength = s;
        setImage("bomb");
        current = getMap().getBomberman().getLocation();

    }


    // ----------------------------------------------------------
    /**
     * Returns the strength(explosion radius) of the bomb. 1 bombStrength is
     *
     * @return the strength of the bomb
     */
    public int strength()
    {
        return bombStrength;
    }


    /**
     * Removes the bomb itself and leaves Fire depending on its strength.
     */
    public void explode()
    {
        WorldActors north = getMap().getCell(current.north());
        WorldActors east = getMap().getCell(current.east());
        WorldActors south = getMap().getCell(current.south());
        WorldActors west = getMap().getCell(current.west());
        WorldActors self = getMap().getCell(current);

        if (!(north instanceof StrongWall))
        {
            north.die();
            int x = current.north().x();
            int y = current.north().y();

            getMap().setCell(
                current.north(),
                new Tile(
                    getMap(),
                    current.north(),
                    x * cellSize,
                    y * cellSize,
                    (x + 1) * cellSize,
                    (y + 1) * cellSize));
        }

        if (!(east instanceof StrongWall))
        {
            east.die();
            int x = current.east().x();
            int y = current.east().y();

            getMap().setCell(
                current.east(),
                new Tile(
                    getMap(),
                    current.east(),
                    x * cellSize,
                    y * cellSize,
                    (x + 1) * cellSize,
                    (y + 1) * cellSize));
        }

        if (!(south instanceof StrongWall))
        {
            south.die();
            int x = current.south().x();
            int y = current.south().y();

            getMap().setCell(
                current.south(),
                new Tile(
                    getMap(),
                    current.south(),
                    x * cellSize,
                    y * cellSize,
                    (x + 1) * cellSize,
                    (y + 1) * cellSize));
        }

        if (!(west instanceof StrongWall))
        {
            west.die();
            int x = current.west().x();
            int y = current.west().y();

            getMap().setCell(
                current.west(),
                new Tile(
                    getMap(),
                    current.west(),
                    x * cellSize,
                    y * cellSize,
                    (x + 1) * cellSize,
                    (y + 1) * cellSize));
        }
        if (self instanceof Enemy || self instanceof Bomberman)
        {
            self.die();
        }

        this.remove();
    }


    public Location getLocation()
    {
        return current;
    }
}
