package handler;




import pojo.CompanyTO;

import service.CompanyService;

public class CompanyHandler {

	private static CompanyHandler instance = null;
	   private CompanyHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static CompanyHandler getInstance() {
	      if(instance == null) {
	         instance = new CompanyHandler();
	      }
	      return instance;
	   }
	public CompanyTO getCompany() {
		// TODO Auto-generated method stub
		
		return CompanyService.getInstance().getCompany();
	}

    

    public boolean updateCompany(CompanyTO companyTO) {
        return CompanyService.getInstance().updateCompany(companyTO);
        
    }

}
