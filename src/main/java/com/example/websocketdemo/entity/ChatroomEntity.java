package com.example.websocketdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.example.websocketdemo.domain.Chatroom;


@Entity
@Table(name = "chatroom")
public class ChatroomEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@OrderBy
	private Long id; // database에서 sequence number, primary key 역할
	
	@Column(nullable=false, unique=true)
	private String name;

	/*
	@OneToMany(mappedBy="chatroom")
	private List<MessageEntity> messages = new ArrayList<MessageEntity>();
	*/
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	public List<MessageEntity> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageEntity> messages) {
		this.messages = messages;
	}
	*/
	
	public Chatroom buildDomain() {
		Chatroom chatroom = new Chatroom();
		chatroom.setId(id);
		chatroom.setName(name);
		//chatroom.setMessages(messages);
		return chatroom;
	}	
	public void buildEntity(Chatroom chatroom) {
		id = chatroom.getId();
		name = chatroom.getName();
	}
}