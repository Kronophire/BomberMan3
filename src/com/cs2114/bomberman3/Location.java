package com.cs2114.bomberman3;

/**
 * // -------------------------------------------------------------------------
 * This is the Location class where the coordination and location is
 * implemented.
 *
 * @author Aska192
 * @author chrisg6
 * @author dnyang
 * @version April 15, 2014
 */
public class Location
{
    // Field(s)
    private int xCoord;
    private int yCoord;


    // ----------------------------------------------------------
    // Constructor

    /**
     * Create a new Location object.
     *
     * @param x
     *            The x coordinate for the maze.
     * @param y
     *            The y coordinate for the maze.
     */
    public Location(int x, int y)
    {
        this.xCoord = x;
        this.yCoord = y;
    }


    // ----------------------------------------------------------
    // Methods

    /**
     * The equals method is declaring the x and y axis of the maze.
     *
     * @return The x and y axis of the maze.
     * @param obj
     *            An object to compare with.
     */
    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Location && ((Location)obj).x() == xCoord
            && ((Location)obj).y() == yCoord;
    }

    /**
     * The east method is moving towards the right.
     *
     * @return The new location by moving right one unit.
     */
    public Location east()
    {
        return new Location(x() + 1, y());
    }


    /**
     * The north method is moving towards the top.
     *
     * @return The new location by moving top one unit.
     */
    public Location north()
    {
        return new Location(x(), y() - 1);
    }


    /**
     * The south method is moving towards the bottom.
     *
     * @return The new location by moving bottom one unit.
     */
    public Location south()
    {
        return new Location(x(), y() + 1);
    }


    /**
     * The west method is moving towards the left.
     *
     * @return The new location by moving left one unit.
     */
    public Location west()
    {
        return new Location(x() - 1, y());
    }


    /**
     * The x() method is the x-axis of the maze.
     *
     * @return The x axis of the maze.
     */
    public int x()
    {
        return xCoord;
    }


    /**
     * The y() method is the y-axis of the maze.
     *
     * @return The y axis of the maze.
     */
    public int y()
    {
        return yCoord;
    }
}