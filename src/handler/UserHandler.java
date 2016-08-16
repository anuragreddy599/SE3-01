package handler;

import java.util.List;


import pojo.UserTO;
import service.UserService;


public class UserHandler {

	private static UserHandler instance = null;
	   private UserHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static UserHandler getInstance() {
	      if(instance == null) {
	         instance = new UserHandler();
	      }
	      return instance;
	   }
	public List<UserTO> getAllUsers() {
		// TODO Auto-generated method stub
		
		return UserService.getInstance().getAllUsers();
	}

    public void addUser(UserTO userTO) {
        UserService.getInstance().addUser(userTO);
        
    }

    public boolean updateUser(UserTO userTO) {
        return UserService.getInstance().updateUser(userTO);
        
    }

}
