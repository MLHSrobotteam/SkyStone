package org.firstinspires.ftc.teamcode.math;

/**
 * Creates a Coordinate class. This class stores the x and y position as double and allows for continuous numbers
 * @version 1
 * @since 2/16/2020
 * @author Jeffrey
 */
public class Coordinate
{
    /**
     * variables to store the x and y position of the coordinate
     */
    public double x,y;

    /**
     * Creates a Coordinate Class with the given x and y coordinates
     * @param x x value
     * @param y y value
     */
    public Coordinate(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a Coordinate class with the coordinate (0,0);
     */
    public Coordinate()
    {
        x = 0;
        y = 0;
    }

    /**
     * Sets the x value of the coordinate to the given value
     * @param x x value
     */
    public void setX(double x)
    {
        this.x = x;
    }

    /**
     * Sets the y value of the coordinate to the given value;
     * @param y y value
     */
    public void setY(double y)
    {
        this.y = y;
    }

    /**
     * returns the x value of the coordinate
     * @return x value
     */
    public double getX()
    {
        return x;
    }

    /**
     * returns the y value of the coordinate
     * @return y value
     */
    public double getY()
    {
        return y;
    }

    /**
     * converts the continuous coordinate to a Discrete coordinate
     * @return DiscreteCoordinate
     */
    public DiscreteCoordinate toDiscreteCoordinate()
    {
        return new DiscreteCoordinate((int)x,(int)y);
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
    public Coordinate midPoint(Coordinate o)
    {
        return new Coordinate((o.x + x)/2, (o.y + y)/2 );
    }

    /**
     * checks if another Object is equal to this object by comparing x and y values. A coordinate is equals if
     * the x is equal to the other x and y is equals to the other y.
     * @param o Coordinate
     * @return if o is equivalent or not
     */
    public boolean equals(Object o)
    {
        if(o instanceof Coordinate)
            if(((Coordinate) o).x == x && ((Coordinate) o).y == y)
                return true;
        return false;
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }




}
