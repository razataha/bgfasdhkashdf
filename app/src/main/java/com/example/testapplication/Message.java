package com.example.testapplication;

import java.sql.Time;
import java.sql.Timestamp;

public class Message
{
    private User sender;
    private Room room;
    private Timestamp time;
    private boolean deleted;
    private String text;

    public Message(User sender, Room room, Timestamp time, boolean deleted, String text) {
        this.sender = sender;
        this.room = room;
        this.time = time;
        this.deleted = deleted;
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Timestamp getTimestamp() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
