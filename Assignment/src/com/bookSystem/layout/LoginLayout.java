package com.bookSystem.layout;
import java.awt.*;   //导入必要的包
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InterfaceAddress;

import javax.swing.*;
import javax.swing.JTextField;

import com.bookSystem.Tools.InterfaceControl;
import com.bookSystem.Tools.connection;

/**
 * Creating a interface for a administrator to log in 
 */
public class LoginLayout extends JFrame{
    JTextField jTextField ;
    JPasswordField jPasswordField;
    JLabel jLabel1,jLabel2;
    JPanel jp1,jp2,jp3;
    JButton jb1,jb2; 
    public LoginLayout(){
        jTextField = new JTextField(12);
        jPasswordField = new JPasswordField(13);
        jLabel1 = new JLabel("Username");
        jLabel2 = new JLabel("Password");
        jb1 = new JButton("Login");
        jb2 = new JButton("Close");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        
        this.setLayout(new GridLayout(3,1));
        
        jp1.add(jLabel1); 
        jp1.add(jTextField); 
        
        jp2.add(jLabel2);
        jp2.add(jPasswordField);
        
        jp3.add(jb1);
        jp3.add(jb2); 
        
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        
        jb1.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String adminInfo = "";
				try {
					adminInfo = connection.getAdminInfo();
					// delete some words that is unuseful
					if(adminInfo.contains("\r\n")){
						adminInfo = adminInfo.replace("\r\n", "");
					}
					//to get username and password
					String[] info = adminInfo.split("####");
					String username = info[0];
					String password = info[1];
					
					String input_un = jTextField.getText();
					String input_pw = String.valueOf(jPasswordField.getPassword());
					
					//compare the information that is inputed and the information that has been stored
					if(input_un.equals(username) && input_pw.equals(password)){
						JOptionPane.showMessageDialog(null, "Success!");
						new mainPanel();
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Incorrect");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});
        
        jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Welcome to login in");
        
        InterfaceControl.setLocationCentre(this);
    }
}