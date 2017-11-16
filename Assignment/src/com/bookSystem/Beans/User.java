package com.bookSystem.Beans;
import java.io.Serializable;

/**
 * Write a description of class Users here.
 * create a user with the following details
 * @ username
 * @ ﬁrstname 
 * @ surname 
 * @ house number
 * @ street name
 * @ postcode 
 * @ email address
 * @ and date of birth 
 */
public class User implements Serializable
{
    // instance variables - replace the example below with your own
   private String username;
   private String firstname;
   private String surname;
   private String houseNumber;
   private String streetName;
   private String postcode;
   private String email;
   private String dateOfBirth;

     /**
     * Create a constructor of Users class  
     */
    
    public User(){}
    public User(String username,String firstname,String surname,String houseNumber,String streetName,String postcode,String email,String dateOfBirth)
    {
      this.username=username;
      this.firstname=firstname;
      this.surname=surname;
      this.houseNumber=houseNumber;
      this.streetName=streetName;
      this.postcode=postcode;
      this.email=email;
      this.dateOfBirth=dateOfBirth;
    }

    /**
     * Return the username of User    
     */
    public String getUsername()
    {
        return username; 
    }

    /**
     * Set the  username for this Users class  
     */
    public void setUsername(String username)
    {
        this. username =  username ; 
    }
    
    /**
     * Return the ﬁrstname of User    
     */
    public String getFirstname()
    {
        return firstname; 
    }

    /**
     * Set the  ﬁrstname for this Users class  
     */
    public void setFirstname(String firstname)
    {
        this. firstname =  firstname ; 
    }
    
    /**
     * Return the surname of User    
     */
    public String getSurname()
    {
        return surname; 
    }

    /**
     * Set the  surname for this Users class  
     */
    public void setSurname(String surname)
    {
        this.surname = surname ; 
    }
    
    /**
     * Return the houseNumber of User    
     */
    public String getHouseNumber()
    {
        return houseNumber; 
    }

    /**
     * Set the houseNumber for this Users class  
     */
    public void setHouseNumber(String houseNumber)
    {
        this.houseNumber = houseNumber ; 
    }
    
    /**
     * Return the streetName of User    
     */
    public String getStreetName()
    {
        return streetName; 
    }

    /**
     * Set the streetName for this Users class  
     */
    public void setStreetName(String streetName)
    {
        this.streetName = streetName ; 
    }
    
    /**
     * Return the streetName of User    
     */
    public String getPostcode()
    {
        return postcode; 
    }

    /**
     * Set the postcode for this Users class  
     */
    public void setPostcode(String postcode)
    {
        this.postcode = postcode ; 
    }
    
    /**
     * Return the email of User    
     */
    public String getEmail()
    {
        return email; 
    }

    /**
     * Set the email for this Users class  
     */
    public void setEmail(String email)
    {
        this.email = email ; 
    }
    
    /**
     * Return the date of User's birth      
     */
    public String getDateOfBirth()
    {
        return dateOfBirth; 
    }

    /**
     * Set the date of birth for this Users class  
     */
    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth ; 
    }
    }

