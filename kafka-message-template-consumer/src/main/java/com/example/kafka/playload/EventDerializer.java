package com.example.kafka.playload;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * Created by pkpk1234 on 2017/5/26.
 */
public class EventDerializer<Event> implements Deserializer<Event> {
    @Override
    public void configure(Map configs, boolean isKey) {
        
    }

    @Override
    public Event deserialize(String topic, byte[] data) {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream deserializer = null;
        Event event = null;
        try {
            deserializer = new ObjectInputStream(in);
            event = (Event)deserializer.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return event;
    }

    @Override
    public void close() {

    }
}
