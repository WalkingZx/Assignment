package com.bookSystem.layout;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bookSystem.Tools.InterfaceControl;

/**
 * Main menu for showing all the functions
 */
public class mainPanel extends JFrame{
	JPanel pan[] = new JPanel[4];
	JButton jadd_u, jadd_b, jmodi_u, jmodi_b;
	
	mainPanel(){
		this.setTitle("Main menu");
		this.setSize(400, 300);
		this.setLayout(new GridLayout(2, 2));
		Container con = this.getContentPane();
		for(int i = 0; i < 4; i++){
			pan[i] = new JPanel();
			pan[i].setLayout(null);
			con.add(pan[i]);
		}
		jadd_u = new JButton("Add User");
		jadd_b = new JButton("Add Book");
		jmodi_u = new JButton("Users List");
		jmodi_b = new JButton("Books List");
		
		pan[0].add(jadd_u);  jadd_u.setBounds(55, 15, 100, 50);
		pan[1].add(jadd_b);  jadd_b.setBounds(55, 15, 100, 50);
		pan[2].add(jmodi_u); jmodi_u.setBounds(55, 15, 100, 50);
		pan[3].add(jmodi_b); jmodi_b.setBounds(55, 15, 100, 50);
		
		jadd_u.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddUser();
			}
		});
		
		jadd_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBook();
			}
		});
		
		jmodi_u.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UsersInformation();
			}
		});
		
		jmodi_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BooksInformation();
			}
		});
		
		this.setVisible(true);
		InterfaceControl.setLocationCentre(this);
	}
}


