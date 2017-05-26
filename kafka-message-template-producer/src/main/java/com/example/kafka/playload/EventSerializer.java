package com.example.kafka.playload;

import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * Created by pkpk1234 on 2017/5/26.
 */
public class EventSerializer implements Serializer<Event> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Event data) {
        byte[] result = "".getBytes();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ObjectOutputStream serializer = new ObjectOutputStream(out);
            serializer.writeObject(data);
            result = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() {

    }
}
