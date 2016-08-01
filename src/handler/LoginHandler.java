/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import pojo.UserTO;
import service.LoginService;

/**
 *
 * @author Mantu
 */
public class LoginHandler {
    private static LoginHandler instance = null;
    private static UserTO userTo=null;
	   private LoginHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static LoginHandler getInstance() {
	      if(instance == null) {
	         instance = new LoginHandler();
	      }
	      return instance;
	   }
           public static UserTO getUser() {
	      
	      return userTo;
	   }

            public static void setUser(UserTO user) {
	      userTo=user;
	      
	   }
    public UserTO login(UserTO userObj) {
        
        return LoginService.getInstance().login(userObj);
    }
}
