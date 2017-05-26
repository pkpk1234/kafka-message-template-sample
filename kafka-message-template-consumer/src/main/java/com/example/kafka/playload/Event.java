package com.example.kafka.playload;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by pkpk1234 on 2017/5/25.
 */
public class Event implements Serializable {

    private String id = UUID.randomUUID().toString();
    private LocalDateTime createTime = LocalDateTime.now();
    private String message;

    public Event() {
    }

    public Event(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", createTime=" + createTime +
                ", message='" + message + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
