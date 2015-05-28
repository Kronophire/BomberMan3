package com.cs2114.bomberman3;

// -------------------------------------------------------------------------
/**
 * A weak wall is destroyable by a bomb explosion.
 *
 * @author Aska192
 * @author chrisg6
 * @author dnyang
 * @version Apr 13, 2014
 */
public class WeakWall
    extends WorldActors
{

    private Location current;


    // ----------------------------------------------------------
    /**
     * Create a new WeakWall object.
     *
     * @param map
     *            the map of this object
     * @param loc
     *            location of the object
     * @param left
     *            left coordinate
     * @param top
     *            top coordinate
     * @param right
     *            right coordinate
     * @param bottom
     *            bottom coordinate
     */
    public WeakWall(
        Map map,
        Location loc,
        float left,
        float top,
        float right,
        float bottom)
    {
        super(map, loc, left, top, right, bottom);
        setImage("brick");
        current = loc;
    }


    /**
     * Called when bomb breaks it
     */
    public void die()
    {
        int x = current.x();
        int y = current.y();
        Tile tile =
            new Tile(getMap(), current, x * cellSize, y * cellSize, (x + 1)
                * cellSize, (y + 1) * cellSize);
        getMap().setCell(current, tile);

        animate(400).alpha(0).rotation(720).removeWhenComplete().play();

    }
}
