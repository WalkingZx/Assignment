package com.bookSystem.Beans;
import java.io.Serializable;
import java.util.Random;

/**
 * Write a description of class Books here.
 * 
 * @id (book ID)
 * @title (book's name)
 * @author (your name) 
 * @year 
 * @pubisher(the name of publisher)
 * @availableCopies (number of available copies)
 * @publicationDate (the date of publication)
 */
public class Book implements Serializable
{
    // instance variables - replace the example below with your own
    private int id;
    private String title;
    private String author;
    private int year;
    private String publisher;
    private int avalCopies;
    private String pubDate;

    /**
     * Create a constructor of Books class  
     * @param id 
     */
    public Book(String title,String author,int year,String publisher,int availableCopies,String pubDate, int id)
    {
       this.id = id ; 
       this.title = title ; 
       this.author = author ; 
       this.year = year ; 
       this.publisher = publisher; 
       this.avalCopies = availableCopies ; 
       this.pubDate = pubDate ; 
    }
    
    /**
     * Generate the book ID randomly     
     */
    public Book()
    {
      Random rand = new Random();
      this.id = rand.nextInt() ; 
    }
    
    /**
     * Return the id of book    
     */
    public int getId()
    {
        return id; 
    }

    /**
     * Set the id for this Books class  
     */
    public void setId(int id)
    {
        this.id = id ; 
    }

    /**
     * Return the title of book    
     */
    public String getTitle()
    {
        return title; 
    }

    /**
     * Set the title for this Books class  
     */
    public void setTitle(String title)
    {
        this.title = title ; 
    }
    
    /**
     * Return the author of book    
     */
    public String getAuthor()
    {
        return author; 
    }

    /**
     * Set the author for this Books class  
     */
    public void setAuthor(String author)
    {
        this.author = author ; 
    }
    
    /**
     * Return the year of book    
     */
    public int getDate()
    {
        return year; 
    }

    /**
     * Set the date for this Books class  
     */
    public void setDate(int year)
    {
        this.year = year ; 
    }
    
    /**
     * Return the publisher's name of book    
     */
    public String getPublisher()
    {
        return publisher; 
    }

    /**
     * Set the publisher's name for this Books class  
     */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher; 
    }
    
    /**
     * Return the number of available copies of book    
     */
    public int getAvailableCopies()
    {
        return avalCopies; 
    }

    /**
     * Set the number of available copies for this Books class  
     */
    public void setAvailableCopies(int availableCopies)
    {
        this.avalCopies = availableCopies ; 
    }
    
     /**
     * Return the date of publication of book    
     */
    public String getPublicationDate()
    {
        return pubDate; 
    }

    /**
     * Set the the date of publication for this Books class  
     */
    public void setPublicationDate(String pubDate)
    {
        this.pubDate = pubDate ; 
    }
    
}
