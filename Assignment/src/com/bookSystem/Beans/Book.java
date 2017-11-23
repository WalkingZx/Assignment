package com.bookSystem.Beans;
import java.io.Serializable;
import java.util.Random;

/**
 * This is a basic class for a book
 * 
 * @id (book ID)
 * @title (book's name)
 * @author (author name) 
 * @year (year)
 * @pubisher(the name of publisher)
 * @availableCopies (number of available copies)
 * @publicationDate (the date of publication)
 */
public class Book implements Serializable
{
    private int id;
    private String title;
    private String author;
    private int year;
    private String publisher;
    private int avalCopies;
    private String pubDate;

    /**
     * Create a constructor of Books class  
     *
     */
    public Book(String title,String author,int year,String publisher,int availableCopies,String pubDate)
    {
       this.title = title ; 
       this.author = author ; 
       this.year = year ; 
       this.publisher = publisher; 
       this.avalCopies = availableCopies ; 
       this.pubDate = pubDate ; 
       Random rand = new Random();
       this.id = rand.nextInt(1000000) ;
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
     * Gets the id of book    
     */
    public int getId()
    {
        return this.id; 
    }

    /**
     * Sets the id for this Books class  
     */
    public void setId(int id)
    {
        this.id = id ; 
    }

    /**
     * Returns the title of book    
     */
    public String getTitle()
    {
        return title; 
    }

    /**
     * Sets the title for this Books class  
     */
    public void setTitle(String title)
    {
        this.title = title ; 
    }
    
    /**
     * Returns the author of book    
     */
    public String getAuthor()
    {
        return author; 
    }

    /**
     * Sets the author for this Books class  
     */
    public void setAuthor(String author)
    {
        this.author = author ; 
    }
    
    /**
     * Returns the year of book    
     */
    public int getDate()
    {
        return year; 
    }

    /**
     * Sets the date for this Books class  
     */
    public void setDate(int year)
    {
        this.year = year ; 
    }
    
    /**
     * Returns the publisher's name of book    
     */
    public String getPublisher()
    {
        return publisher; 
    }

    /**
     * Sets the publisher's name for this Books class  
     */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher; 
    }
    
    /**
     * Returns the number of available copies of book    
     */
    public int getAvailableCopies()
    {
        return avalCopies; 
    }

    /**
     * Sets the number of available copies for this Books class  
     */
    public void setAvailableCopies(int availableCopies)
    {
        this.avalCopies = availableCopies ; 
    }
    
     /**
     * Returns the date of publication of book    
     */
    public String getPublicationDate()
    {
        return pubDate; 
    }

    /**
     * Sets the the date of publication for this Books class  
     */
    public void setPublicationDate(String pubDate)
    {
        this.pubDate = pubDate ; 
    }
    
}
