/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Class to create property objects, it also contains plot objects
 * Due: 04/03/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

public class Property 
{
    // Attributes
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;
    
    // Constructors
    public Property()
    {
        propertyName = "";
        city = "";
        owner = "";
        plot = new Plot();
    }

    public Property(String propertyName, String city, double  rentAmount, String owner)
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double  rentAmount, String owner, int x, int y, int width, int depth)
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot  = new Plot (x, y, width, depth);
    }

    public Property(Property otherProperty)
    {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot  = new Plot (otherProperty.plot);
    }

    // Setter methods
    public void setPropertyName(String propertyName)
    {
        this.propertyName = propertyName;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setRentAmount(double rentAmount)
    {
        this.rentAmount = rentAmount;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public void setPlot(Plot plot)
    {
        this.plot = new Plot(); // review
    }

    // Getter methods
    public String getPropertyName()
    {
        return propertyName;
    }

    public String getCity()
    {
        return city;
    }

    public double getRentAmount()
    {
        return rentAmount;
    }

    public String getOwner()
    {
        return owner;
    }

    public Plot getPlot()
    {
        return plot;
    }
    
    // Other methods
    public String toString()
    {
        return propertyName + "," + city + "," + owner + "," + String.format("%.1f", rentAmount);
    }
}
