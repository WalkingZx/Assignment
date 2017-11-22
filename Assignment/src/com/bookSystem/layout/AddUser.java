package com.bookSystem.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.bookSystem.Beans.*;
import com.bookSystem.Tools.InterfaceControl;
import com.bookSystem.Tools.connection;

public class AddUser extends JFrame{
	JPanel pan[] = new JPanel[9];
	JLabel label_username = new JLabel("Username"); JTextField text_username = new JTextField();
	JLabel label_firstname = new JLabel("firstname"); JTextField text_firstname = new JTextField();
	JLabel label_surname = new JLabel("surname"); JTextField text_surname = new JTextField();
	JLabel label_houseNumber = new JLabel("houseNumber"); JTextField text_houseNumber = new JTextField();
	JLabel label_streetName = new JLabel("streetName"); JTextField text_streetName = new JTextField();
	JLabel label_postcode = new JLabel("postcode"); JTextField text_postcode = new JTextField();
	JLabel label_email = new JLabel("email"); JTextField text_email = new JTextField();
	JLabel label_dateOfBirth = new JLabel("dateOfBirth"); JTextField text_dateOfBirth = new JTextField();
	
	JButton submit = new JButton("Submit");
	JButton Reset = new JButton("Reset");
	
	AddUser(){
		this.setTitle("Add one user information");
		this.setSize(500, 800);
		this.setLayout(new GridLayout(9, 1));
		Container con = this.getContentPane();
		for(int i = 0; i < 9; i++){
			pan[i] = new JPanel();
			pan[i].setLayout(null);
			con.add(pan[i]);
		}
		
		this.setVisible(true);
		   InterfaceControl.setLocationCentre(this);
		   
		pan[0].add(label_username); label_username.setBounds(10, 15, 100, 20);
		pan[0].add(text_username); text_username.setBounds(200, 15, 200, 20);

		pan[1].add(label_firstname); label_firstname.setBounds(15, 15, 100, 20);
		pan[1].add(text_firstname); text_firstname.setBounds(200, 15, 200, 20);
		
		pan[2].add(label_surname); label_surname.setBounds(15, 15, 100, 20);
		pan[2].add(text_surname); text_surname.setBounds(200, 15, 200, 20);
		
		pan[3].add(label_houseNumber); label_houseNumber.setBounds(15, 15, 100, 20);
		pan[3].add(text_houseNumber); text_houseNumber.setBounds(200, 15, 200, 20);
		
		pan[4].add(label_streetName); label_streetName.setBounds(15, 15, 100, 20);
		pan[4].add(text_streetName); text_streetName.setBounds(200, 15, 200, 20);
		
		pan[5].add(label_postcode); label_postcode.setBounds(15, 15, 100, 20);
		pan[5].add(text_postcode); text_postcode.setBounds(200, 15, 200, 20);
		
		pan[6].add(label_email); label_email.setBounds(15, 15, 100, 20);
		pan[6].add(text_email); text_email.setBounds(200, 15, 200, 20);
		
		pan[7].add(label_dateOfBirth); label_dateOfBirth.setBounds(15, 15, 100, 20);
		pan[7].add(text_dateOfBirth); text_dateOfBirth.setBounds(200, 15, 200, 20);
		
		pan[8].add(submit); submit.setBounds(85, 15, 80, 50);
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				   String username = "";
				   String firstname = "";
				   String surname = "";
				   String houseNumber = "";
				   String streetName = "";
				   String postcode = "";
				   String email = "";
				   String dateOfBirth = "";
				   
				   username = text_username.getText();
				   firstname = text_firstname.getText();
				   surname = text_surname.getText();
				   houseNumber = text_houseNumber.getText();
				   streetName = text_streetName.getText();
				   postcode = text_postcode.getText();
				   email = text_email.getText();
				   dateOfBirth = text_dateOfBirth.getText();
				   
				   User u = new User(username, firstname, surname, houseNumber, streetName, postcode, email, dateOfBirth);
				   UserList ulist = null;
				   Object obj = connection.readUsersFromFile();
				   if(obj == null){
					   ulist = new UserList();
					   ulist.addUser(u);
					   JOptionPane.showMessageDialog(null, "Add successfully!");
					   connection.writeUsersToFile(ulist);
				   }else if(obj instanceof UserList){
					   ulist = (UserList) obj;
					   ulist.addUser(u);
					   JOptionPane.showMessageDialog(null, "Add successfully!");
					   connection.writeUsersToFile(ulist);
				   }else{
					   System.out.println("Error in adding User");
				   }				
				   dispose();
			}
		});
	}
}
