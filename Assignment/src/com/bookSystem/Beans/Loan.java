package com.bookSystem.Beans;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *  This class is for a load relationship
 *  In this class I connect a Book Class and a HashMap and the Hashmap is storing a user and a date when the user borrowed
 *
 */
public class Loan {
	private Book book;
	private User u;
	private HashMap<User, Integer> ulist;
	
	/**
	 *  constructor for inputing the Book and the HashMap
	 *
	 */
	public Loan(Book book, HashMap<User, Integer> ulist){
		this.book = book;
		this.ulist = ulist;
	}
	
	/**
	 *  Gets the HashMap so that gets the relationship between the user and the date
	 *
	 */
	
	public HashMap<User, Integer> getUlist(){
		return this.ulist;
	}
}
