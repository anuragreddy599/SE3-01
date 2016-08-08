package handler;

import java.util.List;

import pojo.ClientTO;
import pojo.PersonProjectTO;
import service.ClientService;
import service.PersonProjectService;

public class PersonProjectHandler {

	private static PersonProjectHandler instance = null;
	   private PersonProjectHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static PersonProjectHandler getInstance() {
	      if(instance == null) {
	         instance = new PersonProjectHandler();
	      }
	      return instance;
	   }
	public List<String> getAllProjects() {
		
		
		return PersonProjectService.getInstance().getAllProjects();
	}
        public List<String> getAllDevelopers() {
		
		
		return PersonProjectService.getInstance().getAllDevelopers();
	}

    public void addRecord(PersonProjectTO clientObj) {
        PersonProjectService.getInstance().addRecord(clientObj);
        
    }

    public boolean updateClient(ClientTO clientObj) {
        return ClientService.getInstance().updateClient(clientObj);
        
    }

    public List<PersonProjectTO> getAllAssignedData() {
        
        return PersonProjectService.getInstance().getAllAssignedData();
    }

}
