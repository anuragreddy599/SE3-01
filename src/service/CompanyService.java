package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Client;
import com.entity.Company;
import javax.persistence.PersistenceException;

import pojo.ClientTO;
import pojo.CompanyTO;


public class CompanyService {

	private static CompanyService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private CompanyService() {
	      // Exists only to defeat instantiation.
	   }
	   public static CompanyService getInstance() {
	      if(instance == null) {
	         instance = new CompanyService();
	      }
	      return instance;
	   }
	public CompanyTO getCompany() {
		
		Query query = entitymanager.
	      createQuery("Select e from Company e");
		Company company=(Company)query.getSingleResult();
                
		//Convert from entity to TO
		CompanyTO companyTO=new CompanyTO();
		
			
			companyTO.setId(company.getId());
			companyTO.setName(company.getName());
			companyTO.setAddressLine1(company.getAddressLine1());
			companyTO.setAddressLine2(company.getAddressLine2());
			companyTO.setCity(company.getCity());
			
			companyTO.setState(company.getState());
			companyTO.setZip(company.getZip());
			
		
		return companyTO;
	}

    public boolean updateCompany(CompanyTO companyTO) {
        try{
           entitymanager.getTransaction( ).begin( ); 
          Company company=  entitymanager.find(Company.class, companyTO.getId());
       
                        company.setName(companyTO.getName());
			company.setAddressLine1(companyTO.getAddressLine1());
			company.setAddressLine2(companyTO.getAddressLine2());
			company.setCity(companyTO.getCity());
			
			company.setState(companyTO.getState());
			company.setZip(companyTO.getZip());
        
        
         entitymanager.getTransaction( ).commit( );
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
      return true;  
    }

   
}
