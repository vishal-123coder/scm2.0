package com.scm.helpers;

public class Message {

    private String content;
    private MessageType type;

    // No-arg constructor
    public Message() {
        // Default constructor
        this.type = MessageType.blue;  // Default value
    }

    // All-args constructor
    public Message(String content, MessageType type) {
        this.content = content;
        this.type = type;
    }

    // Getter and Setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and Setter for type
    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    // Optional: toString method
    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", type=" + type +
                '}';
    }
}
