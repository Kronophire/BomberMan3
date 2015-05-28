package com.cs2114.bomberman3;

// -------------------------------------------------------------------------
/**
 * An indestructable wall that can't be passed through.
 *
 * @author Aska192
 * @author chrisg6
 * @author dnyang
 * @version Apr 13, 2014
 */
public class StrongWall
    extends WorldActors
{
    // ----------------------------------------------------------
    /**
     * Create a new StrongWall object.
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
    public StrongWall(
        Map map,
        Location loc,
        float left,
        float top,
        float right,
        float bottom)
    {
        super(map, loc, left, top, right, bottom);
        setImage("wall");
    }
}
