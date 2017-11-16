package com.bookSystem.Beans;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class LoanList {
	
	private HashMap<Book, Loan> loanlist = new HashMap<Book, Loan>();
	private int BORROW_DATE = 60;
	
	public LoanList(HashMap<Book, Loan> loanlist){
		this.loanlist = loanlist;
	}
	
	public void borrowBook(User u, Book b, int date){
		if(!loanlist.containsKey(b)){
			HashMap<User, Integer> ulist = new HashMap<User, Integer>();
			ulist.put(u, date);
			Loan loan = new Loan(b, ulist);
			loanlist.put(b, loan);
			System.out.println("Borrow Succssful");
		}else if(loanlist.containsKey(b)){
			Loan loan = loanlist.get(b);
			loanlist.remove(b);
			loan.getUlist().put(u, date);
			loanlist.put(b, loan);
			System.out.println("Borrow Succssful");
		}
	}
	
	public void returnBook(User u, Book b){
		if(loanlist.containsKey(b)){
			Loan loan = loanlist.get(b);
			if(loan.getUlist().containsKey(u)){
				loan.getUlist().remove(u);
				System.out.println("Return Book Succssful");
			}
		}else{
			System.out.println("ReturnBook Fail!");
		}
	}
	
	public int sumOfBorrowing(User u){
		int numOfBooks = 0;
		for(Entry<Book, Loan> entry : loanlist.entrySet()){
			if(entry.getValue().getUlist().containsKey(u)){
				numOfBooks++;
			}
		}
		return numOfBooks; 
	}
	
	public HashMap<Book, HashMap<String, String>> findOverdueBooks(){
		HashMap<Book, HashMap<String, String>> overdueBooks = new HashMap<Book, HashMap<String, String>>();
		Date date = new Date();
		long times = date.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(date);
		int today = Integer.parseInt(dateString);
		
		for(Entry<Book, Loan> entry : loanlist.entrySet()){
			HashMap<User, Integer> oneBookBorrows = (HashMap<User, Integer>)entry.getValue().getUlist();
			for (Entry<User, Integer> entry_borrowers : oneBookBorrows.entrySet()) {
				if(today - entry_borrowers.getValue() > BORROW_DATE){
					HashMap<String, String> userInfo = new HashMap<String, String>();
					userInfo.put("firstname", entry_borrowers.getKey().getFirstname());
					userInfo.put("surname", entry_borrowers.getKey().getSurname());
					overdueBooks.put(entry.getKey(), userInfo);
				}
			}
		}		
		return overdueBooks;
	}
	
	public ArrayList<Book> multiBorrow(){
		ArrayList<Book> books = new ArrayList<Book>();
		for(Entry<Book, Loan> entry : loanlist.entrySet()){
			if(entry.getValue().getUlist().size()>1){
					books.add(entry.getKey());
				}
			}		
		return books;
	}
	
	public ArrayList<HashMap> getUsersByBookname(Book b){
		ArrayList<HashMap> ulist = new ArrayList<HashMap>();
		for(Entry<Book, Loan> entry : loanlist.entrySet()){
			if(b.equals(entry.getKey())){
				HashMap<String, String> userInfo = new HashMap<String, String>();
				HashMap<User, Integer> oneBookBorrows = (HashMap<User, Integer>)entry.getValue().getUlist();
				for (Entry<User, Integer> entry_borrowers :oneBookBorrows.entrySet()) {
						String firstname = entry_borrowers.getKey().getFirstname();
						String surname = entry_borrowers.getKey().getSurname();
						String addr = entry_borrowers.getKey().getEmail();
						userInfo.put("firstname", firstname);
						userInfo.put("surname", surname);
						userInfo.put("email_address", addr);
					}
				}				
			}	
		return ulist;	
	}
}
