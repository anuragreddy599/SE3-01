package service;

import com.entity.Invoice;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.entity.User;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import pojo.UserTO;


public class InvoiceGenerateService {

	private static InvoiceGenerateService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private InvoiceGenerateService() {
	      // Exists only to defeat instantiation.
	   }
	   public static InvoiceGenerateService getInstance() {
	      if(instance == null) {
	         instance = new InvoiceGenerateService();
	      }
	      return instance;
	   }
	
    //Find last invoice Date
    public Invoice getInvoice(Long client){
        Invoice invoiceObj=null;
        try{
        List<Long> projList=ClientProjectService.getInstance().findAllProjectsOfClient(client);
       
         Query query = entitymanager.createQuery(
            "SELECT e FROM Invoice e " 
            + "WHERE e.projectNumber IN :projectList ORDER BY e.invoiceDate desc");

            query.setParameter("projectList", projList);
            query.setMaxResults(1);
            invoiceObj=(Invoice)query.getSingleResult();
        } catch(NoResultException ex){
            System.out.println(ex.getMessage());
    }
            return invoiceObj;
    }
    
}
