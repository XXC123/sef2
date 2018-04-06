package Models;

public class Message {

	
	
	private String sender;
	private String recipient;
	private String subject;
	private String message;

	public void message(String sender, String recipient, String subject, String message)
	{
		this.sender = sender;
		this.recipient = recipient;
		this.subject = subject;
		this.message = message;
	}
	
	public void newMessage()
	{
	//to-do	
	}
	
	public void replyMessage()
	{
	//to-do	
	}
	
	public void submitMessage()
	{
	//to-do	
	}
	
	public void deleteMessage()
	{
	//to-do	
	}
	
	public void checkInbox()
	{
	//to-do	
	}
}
