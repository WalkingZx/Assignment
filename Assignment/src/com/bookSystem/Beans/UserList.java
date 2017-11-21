package com.bookSystem.Beans;
import java.io.Serializable;
import java.util.*;
/**
 * Write a description of class UserList here.
 */
public class UserList implements Serializable
{
/**
* @ store a collection of user objects 
*/
   private static final long serialVersionUID = 1L;
   private ArrayList<User> userList = new ArrayList<User>();
   
   public UserList(){
   }
   
   public UserList(ArrayList<User> userList){
	   this.userList = userList;
   }
   public boolean addUser(User u){
	   boolean addSucc = false;
	   addSucc = userList.add(u);
	   return addSucc;
   }

/**
* @ return the count the number of users in the system
*/
   public int numOfUsers(){
	   return userList.size();
   }
    
/**
* @ remove a user from the collection by giving the user's firstname.
*/
   public boolean remove(String firstname){
	   boolean rmSucc = false;
	   ArrayList<User> deleteList = new ArrayList<User>();
	   for(User u : userList){
		   if(u.getFirstname().equals(firstname)) deleteList.add(u);
	   }
	   if(deleteList.size() == 0){
		   System.out.println("Can not find the person");
	   }else if(deleteList.size() > 1){
		   System.out.println("There are some people who has the same firstname");
	   }else if(deleteList.size() == 1){
		   rmSucc = true;
		   userList.remove(deleteList.get(0));
	   }else{
		   System.out.println("Error in deleting user"); 
	   }
	   return rmSucc;
   }
    
    /**
    * @ return a users detail by the username
    */
   public User searchUserByUsername(String username){
	   User uDetail = null;
	   for( User u : userList){
		   if(u.getUsername().equals(username)) uDetail = u;
	   }
	   return uDetail;
   }
   
   public ArrayList<User> getAllUsers(){
	   return this.userList;
   }
   
   public String toString(){
	   String output = "";
	   for(User u : userList){
		   output += u.getUsername();
	   }
	   return output;
   }
}
