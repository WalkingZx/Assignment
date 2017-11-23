package com.bookSystem.Beans;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * This is a basic class for BookList
 * 
 */
public class BookList implements Serializable
{
    /**
    * @ store a collection of book objects 
    */
   private static final long serialVersionUID = 200000L;
   private ArrayList<Book> bookList = new ArrayList<Book>();
   
   public BookList()
   {}
   
   /**
    *  a new constructor for inputing the booklist
    */
   public BookList(ArrayList<Book> bookList){
	   this.bookList = bookList;
   }
   
   /**
    *  add a book into the list
    */
   
   public boolean addBook(Book b)
   {
       boolean addSucc = false;
       addSucc = bookList.add(b);
       return addSucc;
   }
    
   /**
    * search through the collection 
    * ﬁnd a book by title, author, publisher or publication date
    */
   
   public static Book searchBookByItem(String type, String item, ArrayList<Book> bookList){
	   Book findBook = null;
	   for(Book b: bookList){
		   switch(type){
		   	case "title": if(b.getTitle().equals(item)) {findBook = b; break;}
		   	case "author": if (b.getAuthor().equals(item)) {findBook =b; break;}
		   	case "publisher": if(b.getTitle().equals(item)) {findBook = b; break;}
		   	case "pubDate": if(b.getTitle().equals(item)) {findBook = b; break;}
		   }
	   }
	   return findBook;
   }
    
   /**
    * remove a book from the collection by searching a book's title
    */
   public boolean removeBookByTitle(String title)
   {
	   boolean rmSucc = false;
	   for(Book b: bookList){
		   if(title.equals(b.getTitle())) {rmSucc = bookList.remove(b);}
	   }
	   return rmSucc;
   }
    
   /**
    * return the total number of books stored in the collection
    */
   public int numOfBooks()
   {
	   return bookList.size();
   }
   
   /**
    * Gets all books as a ArrayList
    */
   
   public ArrayList<Book> getAllBooks(){
	   return this.bookList;
   }

}
