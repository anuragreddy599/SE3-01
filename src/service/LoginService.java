/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import com.entity.User;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import pojo.UserTO;

/**
 *
 * @author Mantu
 */
public class LoginService {
    private static LoginService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private LoginService() {
	      // Exists only to defeat instantiation.
	   }
	   public static LoginService getInstance() {
	      if(instance == null) {
	         instance = new LoginService();
	      }
	      return instance;
	   }
           
           public UserTO login(UserTO userObj) {
		UserTO obj=null;
//		Query query = entitymanager.
//	      createQuery("Select e from User e ");
            try{
                CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<User> cq=cb.createQuery(User.class);
                Root<User> root = cq.from(User.class);
                Predicate andClause =  cb.and(cb.equal(root.get("status"),"Active"));     
                
                cq.where(cb.equal(root.get("userId"),userObj.getUserId()),andClause);
              
               TypedQuery<User> query = entitymanager.createQuery(cq);

                User user=(User) query.getSingleResult();
		
			 obj= new UserTO();
                        if(user!=null){
                            obj.setId(user.getId());
                            obj.setUserId(user.getUserId());
                            obj.setPassword(user.getPassword());
                            obj.setRole(user.getRole());
                            obj.setStatus(user.getStatus());
                        }
            }catch(NoResultException e){
                e.getMessage();
            }	
		
		return obj;
	}
}
