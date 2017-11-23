package com.bookSystem.Tools;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.bookSystem.Beans.*;

/**
 *  Connecting the files and the application
 */
public class connection {
	
	private static String USER_FILE_NAME = "src/users";
	private static String BOOK_FILE_NAME = "src/books";
	private static String ADMIN_FILE_NAME = "src/admin";
	
	/**
	 *  Store the users' information
	 */
	
	public static void writeUsersToFile(UserList ulist){
		File file = null;
        file = judeFileExists(new File(USER_FILE_NAME));
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            objOut.writeObject(ulist);
            objOut.flush();
            objOut.close(); 
            System.out.println("write user success!");
        } catch (IOException e) {
            System.out.println("write user failed");
            e.printStackTrace();
        }
    }
	
	/**
	 *  Store the books' information
	 */
	
	public static void writeBooksToFile(BookList blist){
		File file = null;
        file = judeFileExists(new File(BOOK_FILE_NAME));
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            objOut.writeObject(blist);
            objOut.flush();
            objOut.close();
            System.out.println("write book success!");
        } catch (IOException e) {
            System.out.println("write book failed");
            e.printStackTrace();
        }
    }
	
	/**
	 *  Gets the users' information
	 */
	public static UserList readUsersFromFile(){
		UserList temp=null;
		File file;
		file = judeFileExists(new File(USER_FILE_NAME));
		if(file.length() == 0){
			return temp;
		}
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=(UserList) objIn.readObject();
            objIn.close();
            System.out.println("read user success!");
        } catch (IOException e) {
            System.out.println("read user failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
	
	/**
	 *  Gets the books' information
	 */
	
	public static BookList readBooksFromFile(){
		BookList temp=null;
        File file;
		file = judeFileExists(new File(BOOK_FILE_NAME));
		if(file.length() == 0){
			return temp;
		}
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=(BookList) objIn.readObject();
            objIn.close();
            System.out.println("read book success!");
        } catch (IOException e) {
            System.out.println("read book failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
	
	/**
	 *  Judge if this file exists or not 
	 */
    public static File judeFileExists(File file) {
        if (file.exists()) {
            System.out.println("file exists");
            return file;
        } else {
            System.out.println("file not exists, create it ...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
    
	/**
	 *  Read the administrators' info 
	 */
    
    public static String getAdminInfo(){
    	File file = new File(ADMIN_FILE_NAME);
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while((s = br.readLine())!=null){
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            System.out.println("Error in reading ADMIN FILE");
        }
        return result.toString();
    }
}
