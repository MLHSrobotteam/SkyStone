package org.firstinspires.ftc.teamcode.math;

/**
 * Creates a Coordinate class. This class stores the x and y position as double and allows for discrete numbers
 * This means only integers can be stores
 * @version 1
 * @since 2/16/2020
 * @author Jeffrey
 */
public class DiscreteCoordinate
{
    /**
     * variables to store the x and y position of the coordinate
     */
    public int x,y;

    /**
     * Creates a Coordinate Class with the given x and y coordinates
     * @param x x value
     * @param y y value
     */
    public DiscreteCoordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a Coordinate class with the coordinate (0,0);
     */
    public DiscreteCoordinate()
    {
        x = 0;
        y = 0;
    }

    /**
     * Sets the x value of the coordinate to the given value
     * @param x x value
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Sets the y value of the coordinate to the given value;
     * @param y y value
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * returns the x value of the coordinate
     * @return x value
     */
    public int getX()
    {
        return x;
    }

    /**
     * returns the y value of the coordinate
     * @return y value
     */
    public int getY()
    {
        return y;
    }

    /**
     * converts the discrete coordinate to a continuous coordinate
     * @return Coordinate
     */
    public Coordinate toCoordinate()
    {
        return new Coordinate((double)x,(double)y);
    }

    /**
     * calculates the distance between two coordinates using distance formula
     * @param o Coordinate
     * @return distance between coordinates
     */
    public double distance(Coordinate o)
    {
        return Math.hypot(o.x - x,o.y - y);
    }

    /**
     * finds the coordinate of the midpoint between the current coordinate and another coordinate
     * @param o Coordinate
     * @return midpoint as a coordinate
     */
    public Coordinate midPoint(DiscreteCoordinate o)
    {
        return new Coordinate((o.x + x)/2.0, (o.y + y)/2.0);
    }

    /**
     * checks if another Object is equal to this object by comparing x and y values. A coordinate is equals if
     * the x is equal to the other x and y is equals to the other y.
     * @param o Object
     * @return if o is equivalent or not
     */
    public boolean equals(Object o)
    {
        if(o instanceof DiscreteCoordinate)
            if(((DiscreteCoordinate) o).x == this.x && ((DiscreteCoordinate) o).y == y)
                return true;
        return false;
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}
