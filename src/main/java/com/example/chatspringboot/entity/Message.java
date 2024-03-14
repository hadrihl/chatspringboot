package com.example.chatspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	private String content;
	
	private String sender;
	
	private String recipient;
}
