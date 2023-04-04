/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Junit Tests for the Property Class
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

public class PropertyTestStudent 
{
    @Test
    public void Default_Constructor()
    {
        // Arrange
        String expectedName = "";
        String expectedCity = "";
        String expectedOwner = "";

        // Act 
        Property result = new Property();

        // Assert
        assertEquals(expectedName, result.getPropertyName());
        assertEquals(expectedCity, result.getCity());
        assertEquals(expectedOwner, result.getOwner());
        assertNotNull(result.getPlot());
    }

    @Test
    public void Constructor1()
    {
        // Arrange
        String expectedName = "property";
        String expectedCity = "Raleigh";
        double expectedRentAmount = 12345;
        String expectedOwner = "Me";

        // Act 
        Property result = new Property(expectedName, expectedCity, expectedRentAmount, expectedOwner);

        // Assert
        assertEquals(expectedName, result.getPropertyName());
        assertEquals(expectedCity, result.getCity());
        assertEquals(expectedRentAmount, result.getRentAmount());
        assertEquals(expectedOwner, result.getOwner());
        assertNotNull(result.getPlot());
    }

    @Test
    public void Constructor2()
    {
        // Arrange
        String expectedName = "property";
        String expectedCity = "Raleigh";
        double expectedRentAmount = 12345;
        String expectedOwner = "Me";
        int plotX = 1;
        int plotY = 2;
        int plotWidth = 3;
        int plotDepth = 4;

        // Act 
        Property result = new Property(expectedName, expectedCity, expectedRentAmount, expectedOwner,
            plotX, plotY, plotWidth, plotDepth);

        // Assert
        assertEquals(expectedName, result.getPropertyName());
        assertEquals(expectedCity, result.getCity());
        assertEquals(expectedRentAmount, result.getRentAmount());
        assertEquals(expectedOwner, result.getOwner());
        
        assertNotNull(result.getPlot());
        assertEquals(plotX, result.getPlot().getX());
        assertEquals(plotY, result.getPlot().getY());
        assertEquals(plotWidth, result.getPlot().getWidth());
        assertEquals(plotDepth, result.getPlot().getDepth());
    }

    @Test
    public void Copy_Constructor()
    {
        // Arrange
        String expectedName = "property";
        String expectedCity = "Raleigh";
        double expectedRentAmount = 12345;
        String expectedOwner = "Me";
        int plotX = 1;
        int plotY = 2;
        int plotWidth = 3;
        int plotDepth = 4;
        Property originalProperty = new Property(expectedName, expectedCity, expectedRentAmount, expectedOwner,
            plotX, plotY, plotWidth, plotDepth);

        // Act 
        Property copiedProperty = new Property(originalProperty);

        // Assert
        assertEquals(expectedName, copiedProperty.getPropertyName());
        assertEquals(expectedCity, copiedProperty.getCity());
        assertEquals(expectedRentAmount, copiedProperty.getRentAmount());
        assertEquals(expectedOwner, copiedProperty.getOwner());
        
        assertNotNull(copiedProperty.getPlot());
        assertEquals(plotX, copiedProperty.getPlot().getX());
        assertEquals(plotY, copiedProperty.getPlot().getY());
        assertEquals(plotWidth, copiedProperty.getPlot().getWidth());
        assertEquals(plotDepth, copiedProperty.getPlot().getDepth());
    }

    @Test
    public void ToString_Test()
    {
        // Arrange
        String propertyName = "property";
        String city = "Raleigh";
        double rentAmount = 12345;
        String owner = "Me";
        String expectedResult = propertyName + "," + city + "," + owner + "," + String.format("%.1f", rentAmount);
        Property property = new Property(propertyName, city, rentAmount, owner);

        // Act
        String result = property.toString();

        // Assert
        assertEquals(expectedResult, result);
    }
}
