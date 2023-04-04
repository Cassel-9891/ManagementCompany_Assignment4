/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Junit Tests for the Management Company Class
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

public class ManagementCompanyTestStudent 
{
    @Test
    public void Default_Constructor()
    {
        // Arrange
        String expectedName = "";
        String expectedTaxId = "";
        double expectedManagementFee = 0;

        // Act
        ManagementCompany result = new ManagementCompany();

        // Assert
        assertEquals(expectedName, result.getName());
        assertEquals(expectedTaxId, result.getTaxID());
        assertEquals(expectedManagementFee, result.getMgmFeePer());

        assertNotNull(result.getPlot());

        Plot resultPlot = result.getPlot();
        assertEquals(0, resultPlot.getX());
        assertEquals(0, resultPlot.getY());
        assertEquals(ManagementCompany.MGMT_WIDTH, resultPlot.getWidth());
        assertEquals(ManagementCompany.MGMT_DEPTH, resultPlot.getDepth());

        assertNotNull(result.getProperties());
        assertEquals(ManagementCompany.MAX_PROPERTY, result.getProperties().length);
    }

    @Test
    public void Constructor1()
    {
        // Arrange
        String expectedName = "Me";
        String expectedTaxId = "**Secret information**";
        double expectedManagementFee = .15;

        // Act
        ManagementCompany result = new ManagementCompany(expectedName, expectedTaxId, expectedManagementFee);

        // Assert
        assertEquals(expectedName, result.getName());
        assertEquals(expectedTaxId, result.getTaxID());
        assertEquals(expectedManagementFee, result.getMgmFeePer());

        assertNotNull(result.getPlot());

        Plot resultPlot = result.getPlot();
        assertEquals(0, resultPlot.getX());
        assertEquals(0, resultPlot.getY());
        assertEquals(ManagementCompany.MGMT_WIDTH, resultPlot.getWidth());
        assertEquals(ManagementCompany.MGMT_DEPTH, resultPlot.getDepth());

        assertNotNull(result.getProperties());
        assertEquals(ManagementCompany.MAX_PROPERTY, result.getProperties().length);
    }

    @Test
    public void Constructor2()
    {
        // Arrange
        String expectedName = "Me";
        String expectedTaxId = "**Secret information**";
        double expectedManagementFee = .15;
        int expectedX = 2;
        int expectedY = 3;
        int expectedWidth = 4;
        int expectedDepth = 5;

        // Act
        ManagementCompany result = new ManagementCompany(expectedName, expectedTaxId, expectedManagementFee,
            expectedX, expectedY, expectedWidth, expectedDepth);

        // Assert
        assertEquals(expectedName, result.getName());
        assertEquals(expectedTaxId, result.getTaxID());
        assertEquals(expectedManagementFee, result.getMgmFeePer());

        assertNotNull(result.getPlot());

        Plot resultPlot = result.getPlot();
        assertEquals(expectedX, resultPlot.getX());
        assertEquals(expectedY, resultPlot.getY());
        assertEquals(expectedWidth, resultPlot.getWidth());
        assertEquals(expectedDepth, resultPlot.getDepth());

        assertNotNull(result.getProperties());
        assertEquals(ManagementCompany.MAX_PROPERTY, result.getProperties().length);
    }

    @Test
    public void Copy_Constructor()
    {
        // Arrange
        String expectedName = "Me";
        String expectedTaxId = "**Secret information**";
        double expectedManagementFee = .15;
        int expectedX = 2;
        int expectedY = 3;
        int expectedWidth = 4;
        int expectedDepth = 5;
        ManagementCompany originalManagementCompany = new ManagementCompany(expectedName, expectedTaxId, expectedManagementFee,
            expectedX, expectedY, expectedWidth, expectedDepth);

        // Act
        ManagementCompany copiedManagementCompany = new ManagementCompany(originalManagementCompany);

        // Assert
        assertEquals(expectedName, copiedManagementCompany.getName());
        assertEquals(expectedTaxId, copiedManagementCompany.getTaxID());
        assertEquals(expectedManagementFee, copiedManagementCompany.getMgmFeePer());

        assertNotNull(copiedManagementCompany.getPlot());

        Plot resultPlot = copiedManagementCompany.getPlot();
        assertEquals(expectedX, resultPlot.getX());
        assertEquals(expectedY, resultPlot.getY());
        assertEquals(expectedWidth, resultPlot.getWidth());
        assertEquals(expectedDepth, resultPlot.getDepth());

        assertNotNull(copiedManagementCompany.getProperties());
        assertEquals(ManagementCompany.MAX_PROPERTY, copiedManagementCompany.getProperties().length);
    }

    @Test
    public void getTotalRent()
    {
        // Arrange
        double rent1 = 1234;
        double rent2 = 2345;
        double expectedTotalRent = rent1 + rent2;

        ManagementCompany mgmtCompany = new ManagementCompany();
        Property property1 = new Property();
        property1.setRentAmount(rent1);
        mgmtCompany.addProperty(property1);

        // Using non-default constructor to avoid overlapping plots
        Property property2 = new Property("", "", rent2, "", 1, 1, 1, 1);
        mgmtCompany.addProperty(property2);
                
        // Act
        double result = mgmtCompany.getTotalRent();

        // Assert
        assertEquals(expectedTotalRent, result);
    }

    @Test
    public void getHighestRentProperty()
    {
        // Arrange
        double rent1 = 1234;
        double rent2 = 2345;

        ManagementCompany mgmtCompany = new ManagementCompany();
        Property property1 = new Property();
        property1.setRentAmount(rent1);
        mgmtCompany.addProperty(property1);

        // Using non-default constructor to avoid overlapping plots
        Property property2 = new Property("", "", rent2, "", 1, 1, 1, 1);
        mgmtCompany.addProperty(property2);
                
        // Act
        Property result = mgmtCompany.getHighestRentProperty();

        // Assert
        assertEquals(property2, result);
    }

    @Test
    public void isMangementFeeValid_returns_false_when_below_0()
    {
        // Arrange
        String name = "Me";
        String taxId = "**Secret information**";
        double managementFee = -1;
        ManagementCompany company = new ManagementCompany(name, taxId, managementFee);

        // Act
        boolean result = company.isMangementFeeValid();

        // Assert
        assertFalse(result);
    }

    @Test
    public void isMangementFeeValid_returns_false_when_above_100()
    {
        // Arrange
        String name = "Me";
        String taxId = "**Secret information**";
        double managementFee = 101;
        ManagementCompany company = new ManagementCompany(name, taxId, managementFee);

        // Act
        boolean result = company.isMangementFeeValid();

        // Assert
        assertFalse(result);
    }

    @Test
    public void isMangementFeeValid_returns_false_when_between_0_and_100()
    {
        // Arrange
        String name = "Me";
        String taxId = "**Secret information**";
        double managementFee = 37;
        ManagementCompany company = new ManagementCompany(name, taxId, managementFee);

        // Act
        boolean result = company.isMangementFeeValid();

        // Assert
        assertTrue(result);
    }

    @Test
    public void isPropertiesFull_returns_false_when_not_full()
    {
        // Arrange
        ManagementCompany mgmtCompany = new ManagementCompany();
        Property property1 = new Property();
        mgmtCompany.addProperty(property1);

        // Using non-default constructor to avoid overlapping plots
        Property property2 = new Property("", "", 2345, "", 1, 1, 1, 1);
        mgmtCompany.addProperty(property2);
                
        // Act
        boolean result = mgmtCompany.isPropertiesFull();

        // Assert
        assertFalse(result);
    }

    @Test
    public void isPropertiesFull_returns_true_when_full()
    {
        // Arrange
        ManagementCompany mgmtCompany = new ManagementCompany();
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) 
        {
            Property property = new Property("", "", 2345, "", i, 0, 1, 1);
            mgmtCompany.addProperty(property);            
        }
                
        // Act
        boolean result = mgmtCompany.isPropertiesFull();

        // Assert
        assertTrue(result);
    }

    @Test
    public void addProperty_properties_full_returns_negative_1()
    {
        // Arrange
        ManagementCompany mgmtCompany = new ManagementCompany();
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) 
        {
            Property property = new Property("", "", 2345, "", i, 0, 1, 1);
            mgmtCompany.addProperty(property);            
        }

        Property propertyToAdd = new Property("", "", 2345, "", 5, 0, 1, 1);

        // Act
        int result = mgmtCompany.addProperty(propertyToAdd);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void addProperty_property_null_returns_negative_2()
    {
        // Arrange
        ManagementCompany mgmtCompany = new ManagementCompany();
        Property propertyToAdd = null;

        // Act
        int result = mgmtCompany.addProperty(propertyToAdd);

        // Assert
        assertEquals(-2, result);
    }

    @Test
    public void addProperty_property_outside_of_management_plot_returns_negative_3()
    {
        // Arrange
        ManagementCompany mgmtCompany = new ManagementCompany();
        Property propertyToAdd = new Property();
        propertyToAdd.getPlot().setX(11);
        propertyToAdd.getPlot().setY(11);

        // Act
        int result = mgmtCompany.addProperty(propertyToAdd);

        // Assert
        assertEquals(-3, result);
    }

    @Test
    public void addProperty_property_overlapping_returns_negative_4()
    {
        // Arrange
        ManagementCompany mgmtCompany = new ManagementCompany();
        Property property1 = new Property("", "", 1234, "", 0, 0, 2, 2);
        mgmtCompany.addProperty(property1);

        Property overlappingProperty = new Property("", "", 1234, "", 1, 1, 2, 2);

        // Act
        int result = mgmtCompany.addProperty(overlappingProperty);

        // Assert
        assertEquals(-4, result);
    }

    @Test
    public void addProperty_successful_returns_property_index()
    {
        // Arrange
        ManagementCompany mgmtCompany = new ManagementCompany();
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY - 1; i++) 
        {
            Property property = new Property("", "", 1234, "", i, 0, 1, 1);
            mgmtCompany.addProperty(property);            
        }

        int lastIndex = ManagementCompany.MAX_PROPERTY - 1;
        Property lastProperty = new Property("", "", 1234, "", lastIndex, 0, 1, 1);

        // Act
        int result = mgmtCompany.addProperty(lastProperty);

        // Assert
        assertEquals(lastIndex, result);
    }

    @Test
    public void removeLastProperty_properties_empty_does_nothing()
    {
        // Arrange
        int expectedPropertyCount = 0;
        ManagementCompany company = new ManagementCompany();

        // Act
        company.removeLastProperty();

        // Assert
        assertEquals(expectedPropertyCount, company.getPropertiesCount());
    }

    @Test
    public void removeLastProperty_properties_removes_property()
    {
        // Arrange
        int expectedPropertyCount = ManagementCompany.MAX_PROPERTY - 1;
        ManagementCompany company = new ManagementCompany();        
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) 
        {
            Property property = new Property("", "", 2345, "", i, 0, 1, 1);
            company.addProperty(property);            
        }

        // Act
        company.removeLastProperty();

        // Assert
        assertEquals(expectedPropertyCount, company.getPropertiesCount());
        int lastIndex = ManagementCompany.MAX_PROPERTY - 1;
        assertNull(company.getProperties()[lastIndex]);
    }

    @Test
    public void ToString_Test()
    {
        // Arrange
        String expectedString = "List of the properties for Management, taxID: 12345\n" +
        "______________________________________________________\n" +
        "0,0,0,0.0\n" +
        "1,1,1,1.0\n" +
        "2,2,2,2.0\n" +
        "3,3,3,3.0\n" +
        "4,4,4,4.0\n" +
        "______________________________________________________\n\n\n" +        
        "Total management Fee: 10.00";

        ManagementCompany company = new ManagementCompany("Management", "12345", 100);        
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) 
        {
            String random = String.valueOf(i); 
            Property property = new Property(random, random, i, random, i, 0, 1, 1);
            company.addProperty(property);            
        }

        // Act
        String result = company.toString();
        System.out.print(result);

        // Assert
        assertEquals(expectedString, result);
    }    
}
