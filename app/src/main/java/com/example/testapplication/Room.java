package com.example.testapplication;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Room implements Serializable
{
    private int id;
    private String name;
    private ArrayList<User> users;
    private User creator;
    private ArrayList<Message> messages;

    public Room(int id, String name, ArrayList<User> users, User creator, ArrayList<Message> messages) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.creator = creator;
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public Message getLastMessage()
    {
        return new Message(new User("Arfeen", 20, 'M', "123", true),
                this, new Timestamp(System.currentTimeMillis()), false, "This is text message");
    }
}
