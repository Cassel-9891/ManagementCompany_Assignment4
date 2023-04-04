/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Junit Tests for the Plot Class
 * Due: 04/03/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class PlotTestStudent 
{
    @Test
    public void Default_Constructor()
    {
        // Arrange
        int expectedX = 0;
        int expectedY = 0;
        int expectedWidth = 1;
        int expectedDepth = 1;

        // Act
        Plot result = new Plot();

        // Assert
        assertEquals(expectedX, result.getX());
        assertEquals(expectedY, result.getY());
        assertEquals(expectedWidth, result.getWidth());
        assertEquals(expectedDepth, result.getDepth());
    }

    @Test
    public void Constructor()
    {
        // Arrange
        int expectedX = 2;
        int expectedY = 3;
        int expectedWidth = 4;
        int expectedDepth = 5;

        // Act
        Plot result = new Plot(expectedX, expectedY, expectedWidth, expectedDepth);

        // Assert
        assertEquals(expectedX, result.getX());
        assertEquals(expectedY, result.getY());
        assertEquals(expectedWidth, result.getWidth());
        assertEquals(expectedDepth, result.getDepth());
    }

    @Test
    public void Copy_Constructor()
    {
        // Arrange
        int expectedX = 2;
        int expectedY = 3;
        int expectedWidth = 4;
        int expectedDepth = 5;
        Plot originalPlot = new Plot(expectedX, expectedY, expectedWidth, expectedDepth);

        // Act
        Plot copiedPlot = new Plot(originalPlot);

        // Assert
        assertEquals(expectedX, copiedPlot.getX());
        assertEquals(expectedY, copiedPlot.getY());
        assertEquals(expectedWidth, copiedPlot.getWidth());
        assertEquals(expectedDepth, copiedPlot.getDepth());
    }

    @Test
    public void Overlaps_returns_true_when_plots_overlap()
    {
        // Arrange
        Plot plot1 = new Plot(0, 0, 2, 2);
        Plot plot2 = new Plot(1, 1, 2, 2);

        // Act
        boolean result = plot1.overlaps(plot2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void Overlaps_returns_false_when_plots_do_not_overlap()
    {
        // Arrange
        Plot plot1 = new Plot(0, 0, 1, 1);
        Plot plot2 = new Plot(1, 1, 1, 1);

        // Act
        boolean result = plot1.overlaps(plot2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void Encompasses_returns_true_when_plot1_encompasses_plot2()
    {
        // Arrange
        Plot plot1 = new Plot(0, 0, 2, 2);
        Plot plot2 = new Plot(0, 0, 1, 1);

        // Act
        boolean result = plot1.encompasses(plot2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void Encompasses_returns_false_when_plot1_does_not_encompass_plot2()
    {
        // Arrange
        Plot plot1 = new Plot(0, 0, 2, 2);
        Plot plot2 = new Plot(1, 1, 2, 2);

        // Act
        boolean result = plot1.encompasses(plot2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void ToString()
    {
        // Arrange
        int x = 2;
        int y = 3;
        int width = 4;
        int depth = 5;
        String expectedString = x + "," +  y + "," + width + ","  + depth;

        // Act
        Plot result = new Plot(x, y, width, depth);

        // Assert
        assertEquals(expectedString, result.toString());
    }
}
