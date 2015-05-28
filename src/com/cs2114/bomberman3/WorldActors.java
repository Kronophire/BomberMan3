package com.cs2114.bomberman3;

import sofia.graphics.RectangleShape;

/**
 * It encompasses the objects that interact in the Bomber Man world.
 *
 * @author Aska192
 * @author chrisg6
 * @author dnyang
 * @version Apr 12, 2014
 */
public class WorldActors
    extends RectangleShape
{

    // ~ Fields ..........................................................
    private Map      map;
    private Location current;
    /**
     * Used by the subclasses for graphics
     */
    protected int    cellSize;


    // ----------------------------------------------------------
    // Constructor

    /**
     * Create a new WorldActors object.
     *
     * @param map
     *            the map of this object
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
    public WorldActors(
        Map map,
        Location loc,
        float left,
        float top,
        float right,
        float bottom)
    {
        super(left, top, right, bottom);
        this.map = map;
        cellSize = map.getCellSize();
        this.current = loc;
    }


    /**
     * Returns the map the actor is in.
     *
     * @return the map it's in
     */
    public Map getMap()
    {
        return map;
    }


    // ----------------------------------------------------------
    /**
     * Sets the world for the actor.
     *
     * @param world
     */
    public void setMap(Map world)
    {
        map = world;
    }


    // ----------------------------------------------------------
    /**
     * Returns the Location of this object
     *
     * @return the location
     */
    public Location getLocation()
    {
        return current;
    }


    // ----------------------------------------------------------
    /**
     * Overridden.
     */
    public void die()
    {
        // nothing, should be overridden for specific classes

    }
}
