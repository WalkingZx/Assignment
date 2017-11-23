package com.bookSystem.layout;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import com.bookSystem.Beans.User;
import com.bookSystem.Beans.UserList;
import com.bookSystem.Tools.InterfaceControl;
import com.bookSystem.Tools.connection;

public class UsersInformation extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	JList<String> list = new JList<String>();
//	JLabel label = new JLabel("List of users");
	JPanel pan[] = new JPanel[1];
	
	UsersInformation(){
		this.setTitle("List all users information");
		this.setSize(300, 600);
		this.setLayout(new GridLayout(1, 1));
		Container con = this.getContentPane();
		for(int i = 0; i < 1; i++){
			pan[i] = new JPanel();
			pan[i].setLayout(null);
			con.add(pan[i]);
		}
		
		UserList ulist = connection.readUsersFromFile();
//		ArrayList<String> s = new ArrayList<String>();
		Vector<String> s = new Vector<String>();
		if(ulist != null && ulist.numOfUsers() !=0){
			int count = 0;
			for(User u : ulist.getAllUsers()){
				count++;
				s.add(count + ". " + u.getUsername() + " " + u.getFirstname() + " " + u.getSurname());
			}		
		}else{
			s.add("No users!");
		}
		list.setListData(s);
		list.setVisibleRowCount(s.size());
		list.setBorder(BorderFactory
				.createTitledBorder("Double click to select one user to modify"));
//		list.addListSelectionListener((ListSelectionListener) this);
		pan[0].add(list);
		list.setBounds(15, 15, 400, 700);
		
		list.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 2){
					JList myList = (JList)e.getSource();
					int index = myList.getSelectedIndex();
					String fullname = (String) myList.getModel().getElementAt(index);
					String username = getUsername(fullname);
					UserList ulist = connection.readUsersFromFile();
					User u = ulist.searchUserByUsername(username);
					ArrayList<User> uarray = ulist.getAllUsers();
					uarray.remove(u);
					connection.writeUsersToFile(new UserList(uarray));
					modifyUser(u);
					dispose();
				}
			}

			private void modifyUser(User u) {
				new changeUserInfo(u);
			}

			private String getUsername(String fullname) {
				String[] s = fullname.split(" ");
				return s[1];
			}
			
			private String getFirstname(String fullname) {
				String[] s = fullname.split(" ");
				return s[2];
			}		
			
			
		});
		
		this.setVisible(true);
		InterfaceControl.setLocationCentre(this);
	}
}
