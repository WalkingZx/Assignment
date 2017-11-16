package com.bookSystem.Beans;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;



public class Loan {
	private Book book;
	private User u;
	private HashMap<User, Integer> ulist;

	public Loan(Book book, HashMap<User, Integer> ulist){
		this.book = book;
		this.ulist = ulist;
	}
	
	public HashMap<User, Integer> getUlist(){
		return this.ulist;
	}
}
