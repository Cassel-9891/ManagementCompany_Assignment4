/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Class to create plot objects
 * Due: 04/03/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/
public class Plot 
{
    // Attributes
    private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors
    public Plot()
    {
        width = 1;
        depth = 1;
    }

    public Plot(int x, int y, int width, int depth)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot)
    {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    // Setter methods
    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }
    
    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setDepth(int depth)
    {
        this.depth = depth;
    }

    // Getter methods
    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getDepth()
    {
        return depth;
    }

    // Other methods
    public boolean overlaps(Plot otherPlot)
    {
        int x2 = this.x + this.width;
        int y2 = this.y + this.depth;
        int otherPlotX2 = otherPlot.x + otherPlot.width;
        int otherPlotY2 = otherPlot.y + otherPlot.depth;

        // If one plot is above otherPlot or vicevesa they don't overlap
        if(otherPlot.y >= y2 || this.y >= otherPlotY2)
        {
            return false;
        }

        // If one plot is one the left of otherPlot or viceversa they don't overlap
        if(otherPlot.x >= x2 || this.x >= otherPlotX2)
        {
            return false;
        }

        return true; 
    }

    public boolean encompasses(Plot otherPlot) 
    {
        int x2 = this.x + width;
        int y2 = this.y + depth;
        int otherPlotX2 = otherPlot.x + otherPlot.width;
        int otherPlotY2 = otherPlot.y + otherPlot.depth;

        return (otherPlot.x >= this.x) && (otherPlot.y >= this.y) && (otherPlotX2 <= x2) && (otherPlotY2 <= y2);
    }

    public String toString()
    {
        return x + "," +  y + "," + width + ","  + depth;
    }


}
