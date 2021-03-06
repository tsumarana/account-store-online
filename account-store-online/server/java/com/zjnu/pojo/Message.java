package com.zjnu.pojo;

public class Message {
    private int id;
    private String fromName;
    private String toName;
    private String message;
    private String time;

    public Message(int id, String fromName, String toName, String message, String time) {
        this.id = id;
        this.fromName = fromName;
        this.toName = toName;
        this.message = message;
        this.time = time;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", fromName='" + fromName + '\'' +
                ", toName='" + toName + '\'' +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
