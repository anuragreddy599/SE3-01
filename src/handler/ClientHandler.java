package handler;

import java.util.List;

import pojo.ClientTO;
import service.ClientService;

public class ClientHandler {

	private static ClientHandler instance = null;
	   private ClientHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static ClientHandler getInstance() {
	      if(instance == null) {
	         instance = new ClientHandler();
	      }
	      return instance;
	   }
	public List<ClientTO> getAllClients() {
		// TODO Auto-generated method stub
		
		return ClientService.getInstance().getAllClients();
	}

    public void addClient(ClientTO clientObj) {
        ClientService.getInstance().addClient(clientObj);
        
    }

    public boolean updateClient(ClientTO clientObj) {
        return ClientService.getInstance().updateClient(clientObj);
        
    }

}
