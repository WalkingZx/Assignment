package com.bookSystem.layout;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import com.bookSystem.Beans.User;
import com.bookSystem.Beans.UserList;
import com.bookSystem.Tools.connection;

public class UsersInformation extends JFrame {
	JList list = null;
	JLabel label = new JLabel("List of users");
	JPanel pan[] = new JPanel[2];
	
	UsersInformation(){
		this.setTitle("List all users information");
		this.setSize(500, 800);
		this.setLayout(new GridLayout(2, 1));
		Container con = this.getContentPane();
		for(int i = 0; i < 2; i++){
			pan[i] = new JPanel();
			pan[i].setLayout(null);
			con.add(pan[i]);
		}
		
		pan[0].add(label); label.setBounds(15, 15, 100, 20);
		this.setVisible(true);
		
		UserList ulist = connection.readUsersFromFile();
//		ArrayList<String> s = new ArrayList<String>();
		Vector<String> s = new Vector<String>();
		for(User u : ulist.getAllUsers()){
			s.add(u.getFirstname() + " " + u.getSurname());
		}
		
		list = new JList(s);
		list.setVisibleRowCount(s.size());
		list.setBorder(BorderFactory
				.createTitledBorder("Select one user to modify"));
		list.addListSelectionListener((ListSelectionListener) this);
		pan[1].add(list);
		
//		this.addWindowListener(new WindowAdapter(){
//			public void windowClosing(WindowEvent e){
//				System.exit(0);
//			}
//		});
	}
	
	public static void main(String[] args){
		new UserList();
	}
}
