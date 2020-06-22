package cast.cruise.service;

import java.util.ArrayList;
import java.util.List;

import cast.cruise.contacts.EmailMessage;

public class EmailProviderTest implements EmailProvider{
	
	List<EmailMessage> allMessages = new ArrayList<EmailMessage>();
	
	
	public List<EmailMessage> getallEmails(){
		return allMessages;
	}
	
	
	public void sendEmail(EmailMessage message){
		allMessages.add(message);
	
	}
}