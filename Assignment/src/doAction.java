import java.util.ArrayList;

import com.bookSystem.Beans.*;
import com.bookSystem.Tools.connection;


public class doAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   String username = "xiaozhou";
	   String firstname = "xiao";
	   String surname = "zhou";
	   String houseNumber = "22";
	   String streetName = "Trinity Hall";
	   String postcode = "DH13PT";
	   String email = "xiao.zhou@durham.ac.uk";
	   String dateOfBirth = "19940328";
	   User u = new User(username, firstname, surname, houseNumber, streetName, postcode, email, dateOfBirth);
	   ArrayList<User> array_ulist = new ArrayList<User>();
	   array_ulist.add(u);
//	   UserList ulist_input = new UserList(array_ulist);
//	   connection.writeUsersToFile(ulist_input);
	   
	   UserList ulist_output = connection.readUsersFromFile();
	   System.out.println(ulist_output.toString());
	   
	   if(ulist_output.remove(firstname)) System.out.print("Remove successful");
	   
	}

}
