package com.bookSystem.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.bookSystem.Beans.*;
import com.bookSystem.Tools.connection;

public class AddBook extends JFrame{
	JPanel pan[] = new JPanel[7];
	JLabel label_title = new JLabel("title"); JTextField text_title = new JTextField();
	JLabel label_author = new JLabel("Author"); JTextField text_author = new JTextField();
	JLabel label_year = new JLabel("Punish Year"); JTextField text_year = new JTextField();
	JLabel label_publisher = new JLabel("Publisher"); JTextField text_publisher = new JTextField();
	JLabel label_avalCopies = new JLabel("Avaliable Copies"); JTextField text_avalCopies = new JTextField();
	JLabel label_pubDate = new JLabel("Pubnish Date"); JTextField text_pubDate = new JTextField();
	
	JButton submit = new JButton("Submit");
	JButton Reset = new JButton("Reset");
	
	AddBook(){
		this.setTitle("Add one book information");
		this.setSize(500, 800);
		this.setLayout(new GridLayout(8, 1));
		Container con = this.getContentPane();
		for(int i = 0; i < 7; i++){
			pan[i] = new JPanel();
			pan[i].setLayout(null);
			con.add(pan[i]);
		}
		
		this.setVisible(true);

		pan[0].add(label_title); label_title.setBounds(15, 15, 100, 20);
		pan[0].add(text_title); text_title.setBounds(200, 15, 200, 20);
		
		pan[1].add(label_author); label_author.setBounds(15, 15, 100, 20);
		pan[1].add(text_author); text_author.setBounds(200, 15, 200, 20);
		
		pan[2].add(label_year); label_year.setBounds(15, 15, 100, 20);
		pan[2].add(text_year); text_year.setBounds(200, 15, 200, 20);
		
		pan[3].add(label_publisher); label_publisher.setBounds(15, 15, 100, 20);
		pan[3].add(text_publisher); text_publisher.setBounds(200, 15, 200, 20);
		
		pan[4].add(label_avalCopies); label_avalCopies.setBounds(15, 15, 100, 20);
		pan[4].add(text_avalCopies); text_avalCopies.setBounds(200, 15, 200, 20);
		
		pan[5].add(label_pubDate); label_pubDate.setBounds(15, 15, 100, 20);
		pan[5].add(text_pubDate); text_pubDate.setBounds(200, 15, 200, 20);
		
		pan[6].add(submit); submit.setBounds(85, 15, 80, 50);
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			    String title = "";
			    String author = "";
			    int year = 0;
			    String publisher = "";
			    int avalCopies = 0;
			    String pubDate = "";
				
			    
			    title = text_title.getText();
			    author = text_author.getText();
			    publisher = text_publisher.getText();
			    pubDate = text_publisher.getText();
			    if(!text_year.getText().isEmpty()) year = Integer.parseInt(text_year.getText());
			    if(!text_avalCopies.getText().isEmpty())avalCopies = Integer.parseInt(text_avalCopies.getText());
			    
			    Book b = new Book(title, author, year, publisher, avalCopies, pubDate);
			    BookList blist= null;
			    Object obj = connection.readBooksFromFile();
			   if(obj == null){
				   blist = new BookList();
				   blist.addBook(b);
				   connection.writeBooksToFile(blist);
			   }else if(obj instanceof BookList){
				   blist = (BookList) obj;
				   blist.addBook(b);
				   connection.writeBooksToFile(blist);
			   }else{
				   System.out.println("Error in adding Book");
			   }		   
			}
		});
		
		
	}
	
	public static void main(String[] args){
//		new AddBook();
		BookList blist = connection.readBooksFromFile();
		System.out.println(blist.toString());
	}
}