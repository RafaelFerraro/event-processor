package com.eventProcessor.web.request;

public class Message {
    private final long id;
    private final String content;

    public Message(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public String getContent() {
        return this.content;
    }
}
