package service;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;





public class JavaMailService {

	private static JavaMailService instance = null;
	//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        //EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private JavaMailService() {
	      // Exists only to defeat instantiation.
	   }
	   public static JavaMailService getInstance() {
	      if(instance == null) {
	         instance = new JavaMailService();
	      }
	      return instance;
	   }
           
      public boolean sendMail(Map<String, Object> mailData)  {

		boolean sendStatus = true;
                try{  
		
                   // File file = new File("/com.util/util.properties");
                    InputStream is=this.getClass().getResourceAsStream("/com/util/util.properties");
			//FileInputStream fileInput = new FileInputStream(file);
			Properties utilProperties = new Properties();
			utilProperties.load(is);
			is.close();
                    
                    
                    String to=mailData.get("clientEmail").toString();//change accordingly  
                    final String user=utilProperties.getProperty("mail.from");
                    final String password=utilProperties.getProperty("mail.password");

                    //1) get the session object     
                    Properties properties = System.getProperties();  
//                    properties.setProperty("mail.smtp.host", "smtp.gamil.com");  
//                    properties.put("mail.smtp.auth", "true");  


                        properties.put("mail.smtp.starttls.enable", true); // added this line
                        properties.put("mail.smtp.host", "smtp.gmail.com");
                        properties.put("mail.smtp.user", user);
                        properties.put("mail.smtp.password", password);
                        properties.put("mail.smtp.port", "587");
                        properties.put("mail.smtp.auth", true);
                        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");


                    Session session = Session.getDefaultInstance(properties,  
                     new javax.mail.Authenticator() {  
                     protected PasswordAuthentication getPasswordAuthentication() {  
                     return new PasswordAuthentication(user,password);  
                     }  
                    });  

                    //2) compose message     
                    
                      MimeMessage message = new MimeMessage(session);  
                      message.setFrom(new InternetAddress(user));  
                      message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
                      message.setSubject("Your Invoice for project "+mailData.get("project"));  

                      //3) create MimeBodyPart object and set your message text     
                      BodyPart messageBodyPart1 = new MimeBodyPart();  
                      messageBodyPart1.setText("Hi ,/n Your invoice is here attached. ");  

                      //4) create new MimeBodyPart object and set DataHandler object to this object      
                      MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

                      String filename = "G:/Documents/Anurag/Project2/workspace_eclipse/generateInvoice_1003.pdf";//change accordingly  
                      DataSource source =(DataSource) mailData.get("attachment");//new FileDataSource(filename);  
                      messageBodyPart2.setDataHandler(new DataHandler(source));  
                      messageBodyPart2.setFileName("Invoice_"+mailData.get("project"));  


                      //5) create Multipart object and add MimeBodyPart objects to this object      
                      Multipart multipart = new MimeMultipart();  
                      multipart.addBodyPart(messageBodyPart1);  
                      multipart.addBodyPart(messageBodyPart2);  

                      //6) set the multiplart object to the message object  
                      message.setContent(multipart );  

                      Transport transport = session.getTransport("smtp");
                        transport.connect("smtp.gmail.com", user, password);
                        System.out.println("Transport: "+transport.toString());
                        transport.sendMessage(message, message.getAllRecipients());
                      
                      //7) send message  
                      //Transport.send(message);  

                     System.out.println("message sent...."+message);  
                     }catch (Exception ex) {ex.printStackTrace();}  
		return sendStatus;
	}

	
           
	
}
