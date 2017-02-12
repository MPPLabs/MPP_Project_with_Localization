package dataClass;

import java.sql.Timestamp;

public class Message {
	private int id;
	private String text;
	private Timestamp publicateDate;
	private int recipientStatus;
	private int senderStatus;
	private int senderId;
	private int recipientId;
	public Message(int id,String text,Timestamp publicateDate,int recipientStatus,int senderStatus,int senderId,int recipientId)
	{
		this.id=id;
		this.text=text;
		this.publicateDate=publicateDate;
		this.recipientStatus=recipientStatus;
		this.senderId=senderId;
		this.recipientId=recipientId;
	}
	public int getId()
	{
		return this.id;
	}
	public String getText()
	{
		return this.text;
	}
	public Timestamp getPublicateDate()
	{
		return this.publicateDate;
	}
	public int getRecipientStatus()
	{
		return this.recipientStatus;
	}
	public int getSenderStatus()
	{
		return this.senderStatus;
	}
	public int getSenderId()
	{
		return this.senderId;
	}
	public int getRecipientId()
	{
		return this.recipientId;
	}
}
