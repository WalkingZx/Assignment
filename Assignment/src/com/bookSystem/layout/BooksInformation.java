package com.bookSystem.layout;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import com.bookSystem.Beans.Book;
import com.bookSystem.Beans.BookList;
import com.bookSystem.Beans.User;
import com.bookSystem.Beans.UserList;
import com.bookSystem.Tools.connection;

public class BooksInformation extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	JList<String> list = new JList<String>();
//	JLabel label = new JLabel("List of users");
	JPanel pan[] = new JPanel[1];
	
	BooksInformation(){
		this.setTitle("List all books information");
		this.setSize(300, 600);
		this.setLayout(new GridLayout(1, 1));
		Container con = this.getContentPane();
		for(int i = 0; i < 1; i++){
			pan[i] = new JPanel();
			pan[i].setLayout(null);
			con.add(pan[i]);
		}
		
		BookList blist = connection.readBooksFromFile();
//		ArrayList<String> s = new ArrayList<String>();
		Vector<String> s = new Vector<String>();
		if(blist != null){
			int count = 0;
			for(Book u : blist.getAllBooks()){
				count++;
				s.add(count + ". " + u.getId() + " " + u.getTitle() + " " + u.getAuthor());
			}		
		}else{
			s.add("No books!");
		}
		list.setListData(s);
		list.setVisibleRowCount(s.size());
		list.setBorder(BorderFactory
				.createTitledBorder("Double click to select one book to modify"));
//		list.addListSelectionListener((ListSelectionListener) this);
		pan[0].add(list);
		list.setBounds(15, 15, 400, 700);
		
		list.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 2){
					JList myList = (JList)e.getSource();
					int index = myList.getSelectedIndex();
					String fullname = (String) myList.getModel().getElementAt(index);
					String id = getIdOfBook(fullname);
					BookList ulist = connection.readBooksFromFile();
					ArrayList<Book> barray = ulist.getAllBooks();
					Book u = null;
					for(Book bb : barray){
						if(id.equals(bb.getId() + "")){
							u = bb;
						}
					}
					barray.remove(u);
					connection.writeBooksToFile(new BookList(barray));
					modifyBook(u);
					dispose();
				} 
			}

			private void modifyBook(Book u) {
				new changeBookInfo(u);
			}

			private String getIdOfBook(String fullname) {
				String[] s = fullname.split(" ");
				return s[1];
			}
		});
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		new BooksInformation();
	}
}
