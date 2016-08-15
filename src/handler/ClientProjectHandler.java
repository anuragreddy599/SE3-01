package handler;

import java.util.List;
import pojo.ClientProjectTO;

import pojo.ClientTO;
import service.ClientProjectService;
import service.ClientService;

public class ClientProjectHandler {

	private static ClientProjectHandler instance = null;
	   private ClientProjectHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static ClientProjectHandler getInstance() {
	      if(instance == null) {
	         instance = new ClientProjectHandler();
	      }
	      return instance;
	   }
	public List<ClientProjectTO> getAllClientProjects() {
		// TODO Auto-generated method stub
		
		return ClientProjectService.getInstance().getAllClientProjects();
	}

    public void addClientProject(ClientProjectTO clientObj) {
        ClientProjectService.getInstance().addClientProject(clientObj);
        
    }

    public boolean updateClientProject(ClientProjectTO clientObj) {
        return ClientProjectService.getInstance().updateClientProject(clientObj);
        
    }

}
