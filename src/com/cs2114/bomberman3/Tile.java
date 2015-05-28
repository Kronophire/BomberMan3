package com.cs2114.bomberman3;

// -------------------------------------------------------------------------
/**
 * A blank Tile space. Bomberman and enemies can walk on these.
 *
 * @author Aska192
 * @author chrisg6
 * @author dnyang
 * @version Apr 13, 2014
 */
public class Tile
    extends WorldActors
{
// ----------------------------------------------------------
    /**
     * Create a new Tile object.
     *
     * @param map
     *            the map of this object
     * @param loc
     *            the location
     * @param left
     *            left coordinate
     * @param top
     *            top coordinate
     * @param right
     *            right coordinate
     * @param bottom
     *            bottom coordinate
     */
    public Tile(
        Map map,
        Location loc,
        float left,
        float top,
        float right,
        float bottom)
    {
        super(map, loc, left, top, right, bottom);
    }
}
