package com.example.websocketdemo.domain;

import java.time.LocalDateTime;

public class Message {
	private long id; // primary key
	private User user; 
	private String contents;
	private Chatroom chatroom;
	private LocalDateTime chatTime;
	
	public Message()  {}
	public Message(User user, String contents, Chatroom chatroom) {
		super();
		this.user = user;
		this.contents = contents;
		this.chatroom = chatroom;
		this.chatTime = LocalDateTime.now();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public Chatroom getChatroom() {
		return chatroom;
	}
	public void setChatroom(Chatroom chatroom) {
		this.chatroom = chatroom;
	}
	public LocalDateTime getChatTime() {
		return chatTime;
	}
	public void setChatTime(LocalDateTime chatTime) {
		this.chatTime = chatTime;
	}

	
	
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
		Message other = (Message) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	*/

}
