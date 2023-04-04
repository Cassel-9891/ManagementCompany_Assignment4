/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Class to create a Management Company that include property objects and plot objects.
 * Due: 04/03/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/
public class ManagementCompany 
{
    // Attributes
    private String name;
    private String taxID;
    private double mgmFee;
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    private static final int MIN_MGMT_FEE = 0;
    private static final int MAX_MGMT_FEE = 100;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;


    // Constructors
    public ManagementCompany()
    {
        name = "";
        taxID = "";

        plot = new Plot();
        plot.setWidth(MGMT_WIDTH);
        plot.setDepth(MGMT_DEPTH);

        properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(String name, String taxID, double mgmFee)
    {
        this.name = name;
        this.taxID = taxID; 
        this.mgmFee = mgmFee;

        plot = new Plot();
        plot.setWidth(MGMT_WIDTH);
        plot.setDepth(MGMT_DEPTH);

        properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
    {
        this.name = name;
        this.taxID = taxID; 
        this.mgmFee = mgmFee;

        plot = new Plot(x, y, width, depth);

        properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(ManagementCompany otherCompany)
    {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFee = otherCompany.mgmFee;
        this.plot = new Plot(otherCompany.plot);

        // copying array from otherCompany to this company
        this.properties = new Property[otherCompany.properties.length];
        for(int i = 0; i < otherCompany.properties.length; i++)
        {
            if (this.properties[i] != null) 
            {
                this.properties[i] = new Property(otherCompany.properties[i]);
            }            
        }
    }
  
    // Getters
    public String getName()
    {
        return name;
    }

    public String getTaxID()
    {
        return taxID;
    }

    public double getMgmFeePer()
    {
        return mgmFee;
    }

    public int getPropertiesCount() 
    {
        return numberOfProperties; 
    }

    public double getTotalRent()
    {
        double totalRent = 0;
        for(int i = 0; i < numberOfProperties; i++)
        {
            Property currentProperty = this.properties[i];
            totalRent += currentProperty.getRentAmount(); 
        }

        return totalRent;
    }

    public Property getHighestRentProperty()
    {
        Property highestRentPriceProperty = properties[0];
        
        for(int i = 1; i < numberOfProperties; i++)
        {
            if(highestRentPriceProperty.getRentAmount() < properties[i].getRentAmount())
            {
                highestRentPriceProperty =  properties[i];
            }
        }

        return highestRentPriceProperty; 
    }

    // Gets Management company plot
    public Plot getPlot()
    {
        return plot; 
    }

    // returns Property[]
    //method called getProperties()
    // Gets the properties.
    public Property[] getProperties()
    {
        return properties;
    }

    // Other methods
    // the addProperty method is an overloaded method with multiple versions
    public int addProperty(String name, String city, double rentAmount, String owner)
    {
        // Using the property constructor that matches the parameters of the function to build a Property object 
        // Then using the Property object to call the last overloaded function which accepts a Property object
        Property propertyToAdd = new Property(name, city, rentAmount, owner);
        
        return addProperty(propertyToAdd);
    }

    public int addProperty(String name, String city, double rentAmount, String owner, int x, int y, int width, int depth)
    {
        // Using the property constructor that matches the parameters of the function to build a Property object 
        // Then using the Property object to call the last overloaded function which accepts a Property object
        Property propertyToAdd = new Property(name, city, rentAmount, owner, x, y, width, depth);
        
        return addProperty(propertyToAdd);
    }

    public int addProperty(Property property)
    {
        // If there is a problem adding the property because the array is full, it will return -1
        if(isPropertiesFull())
        {
            return -1;
        }

        // If there is a problem adding the property because the property is null, it will return -2
        if(property == null)
        {
            return -2;
        }

        // If there is a problem adding the property because the property we are adding 
        // is not inside the bounds of the Management company plot, it will return -3
        if(!this.plot.encompasses(property.getPlot()))
        {
            return -3;
        }

        // If there is a problem adding the property because the property we are adding overlaps other properties,
        // it will return -4

        for(int i = 0; i < numberOfProperties; i++)
        {
            boolean isOverlapping = properties[i].getPlot().overlaps(property.getPlot());
            if(isOverlapping)
            {
                return -4;
            }
        }

        // Making a copy of the index that the new property was added on
        int newPropertyAddedIndex = numberOfProperties;

        // Adding new property
        properties[newPropertyAddedIndex] = property;

        // Increasing number of properties to new amount
        numberOfProperties++;

        // Returning the index of the last property added
        return newPropertyAddedIndex; 
    }

    public boolean isMangementFeeValid()
    {
        return mgmFee >= MIN_MGMT_FEE && mgmFee <= MAX_MGMT_FEE;
    }

    public boolean isPropertiesFull()
    {
        return this.getPropertiesCount() == MAX_PROPERTY;
    }

    public void removeLastProperty()
    {
        if(numberOfProperties > 0)
        {
            int lastPropertyIndex = this.getPropertiesCount() - 1;
            properties[lastPropertyIndex] = null;

            numberOfProperties--;
        }
    }

    /*  
        Example :

        List of the properties for Railey, taxID: 555555555
        ______________________________________________________
        Almost Aspen,Glendale,Sammy Smith,4844.0
        Ambiance,Lakewood,Tammy Taylor,4114.0
        Bear Creek Lodge,Peninsula,Bubba Burley,4905.0
        Sunsational,Beckman,BillyBob Wilson,2613.0
        Mystic Cove,Lakepointe,Joey BagODonuts,5327.0
        ______________________________________________________
        
        total management Fee: 1308.18
    */
    public String toString() 
    {
        String propertiesData = "";
        int actualAmountOfProperties = this.getPropertiesCount();
        double totalMgmFee = 0;

        for(int i = 0; i < actualAmountOfProperties; i++)
        {
            Property currentProperty = properties[i];

            totalMgmFee+= (currentProperty.getRentAmount()) * (this.getMgmFeePer() / 100);

            propertiesData += currentProperty.toString() + "\n";
        }

        return "List of the properties for " + this.name + ", taxID: " + this.taxID + "\n" +
        "______________________________________________________" + "\n" + 
        propertiesData + 
        "______________________________________________________" + "\n\n\n" +
        String.format("Total management Fee: %.2f", totalMgmFee);
    }

}
