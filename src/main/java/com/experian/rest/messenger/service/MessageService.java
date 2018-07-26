package com.experian.rest.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.experian.rest.messenger.database.Database;
import com.experian.rest.messenger.exception.DataNotFoundException;
import com.experian.rest.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = Database.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "How are you?", new Date(), "Jeejo"));
		messages.put(2L, new Message(2, "I'm fine", new Date(), "Jeejo"));
	}

	public List<Message> getMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		Message msg = messages.get(id);
		if(msg == null)
			throw new DataNotFoundException("Message with id " + id + " not found");
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0)
			return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
