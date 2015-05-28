package com.cs2114.bomberman3;

import sofia.util.Random;

/**
 * // -------------------------------------------------------------------------
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Aska192
 * @author chrisg6
 * @author dnyang
 * @version Apr 12, 2014
 */
public class Map
    extends sofia.util.Observable
{

    // ~ Fields ..........................................................
    private WorldActors[][] map;
    private int             score;
    private int             size;
    private Bomberman       bman;
    private int             cellSize;
    private BomberScreen    screen;


    // ~ Constructor ....................................................

    /**
     * Initializes the map with walls and bomberman. And enemy?
     *
     * @param s
     *            the size of the map
     * @param cellSize
     *            the size of each square cell
     * @param screen
     *            the screen of this map.
     */
    public Map(int s, int cellSize, BomberScreen screen)
    {
        this.screen = screen;
        size = s;
        score = 0;
        map = new WorldActors[size][size];
        this.cellSize = cellSize;

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                float left = i * cellSize;
                float top = j * cellSize;
                float right = (i + 1) * cellSize;
                float bot = (j + 1) * cellSize;

                map[i][j] =
                    new Tile(this, new Location(i, j), left, top, right, bot);

            }
        }

        bman =
            new Bomberman(
                this,
                new Location(1, 1),
                cellSize,
                cellSize,
                2 * cellSize,
                2 * cellSize);
        map[1][1] = bman;
        setWalls();
        setBricks();
        setEnemies();

    }


    // ~ Methods .........................................................

    /**
     * Sets the specified cell to be a specific actor.
     *
     * @param loc
     *            the cell to be set
     * @param actor
     *            what we want to place in the cell
     */
    public void setCell(Location loc, WorldActors actor)
    {
        map[loc.x()][loc.y()] = actor;
    }


    /**
     * Returns the actor in the cell.
     *
     * @param loc
     *            the location of the cell
     * @return the cell actor type
     */
    public WorldActors getCell(Location loc)
    {
        return map[loc.x()][loc.y()];
    }


    // ----------------------------------------------------------
    /**
     * Returns the score.
     *
     * @return the score
     */
    public int getScore()
    {
        return score;
    }


    // ----------------------------------------------------------
    /**
     * Returns the bomberman object so we can move it around later.
     *
     * @return the bomberman
     */
    public Bomberman getBomberman()
    {
        return bman;
    }


    // ----------------------------------------------------------
    /**
     * Returns the cellSize
     *
     * @return the cell size
     */
    public int getCellSize()
    {
        return cellSize;
    }


    // ----------------------------------------------------------
    /**
     * Increments the score when an enemy dies.
     */
    public void addScore()
    {
        score++;
        notifyObservers();
    }


    // ----------------------------------------------------------
    /**
     * Set score to whatever you want
     *
     * @param n
     *            the score to set it to.
     */
    public void setScore(int n)
    {
        score = n;
        notifyObservers();
    }


    // ----------------------------------------------------------
    /**
     * Returns the screen
     *
     * @return the screen.
     */
    public BomberScreen getScreen()
    {
        return screen;
    }


// ----------------------------------------------------------

    /**
     * Helper method to set the Bricks.
     */

    private void setBricks()
    {

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {

                float left = i * cellSize;
                float top = j * cellSize;
                float right = (i + 1) * cellSize;
                float bot = (j + 1) * cellSize;

                if (i % 2 != 0 && j % 2 != 0)
                {
                    if ((i != 1 && j != 1) || (i != 2 && j != 1)
                        || (i != 1 && j != 2))
                    {
                        Random numGenerator = new Random();
                        if (numGenerator.nextInt(100) < 70)
                        {
                            map[i][j] =
                                new WeakWall(
                                    this,
                                    new Location(i, j),
                                    left,
                                    top,
                                    right,
                                    bot);
                        }

                    }
                }
            }
        }
    }


    /**
     * Helper method to set the indestructable walls
     */
    private void setWalls()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {

                float left = i * cellSize;
                float top = j * cellSize;
                float right = (i + 1) * cellSize;
                float bot = (j + 1) * cellSize;

                if ((j == 0 || j == size - 1) || (i % 2 == 0 && j % 2 == 0)
                    || (i == 0 || i == size - 1))
                {
                    map[i][j] =
                        new StrongWall(
                            this,
                            new Location(i, j),
                            left,
                            top,
                            right,
                            bot);
                }
            }
        }

    }


    /**
     * Helper method to set the enemies.
     */
    private void setEnemies()
    {
        Random random = Random.generator();

        int x = random.nextInt(5, 10);
        int y = 0;
        while (y < x)
        {

            int a = random.nextInt(size - 1);
            int b = random.nextInt(size - 1);
            if (map[a][b] instanceof Tile && a > 5 && b > 5)
            {
                map[a][b] =
                    new Enemy(this, new Location(a, b), a * cellSize, b
                        * cellSize, (a + 1) * cellSize, (b + 1) * cellSize);
                y++;
            }

        }
    }
}
