package com.example.websocketdemo.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.websocketdemo.entity.MessageEntity;

public class Chatroom {
	private long id; // primary key
	private String name;
	//private List<Message> messages = new ArrayList<Message>();
	
	public Chatroom()  {}
	public Chatroom(String userId, String name, List<Message> messages) {
		super();
		this.name = name;
		//this.messages = messages;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	*/
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chatroom other = (Chatroom) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	*/
}
