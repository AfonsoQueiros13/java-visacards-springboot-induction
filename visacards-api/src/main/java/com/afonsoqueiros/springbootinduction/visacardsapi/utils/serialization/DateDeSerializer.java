package com.afonsoqueiros.springbootinduction.visacardsapi.utils.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeSerializer extends StdDeserializer<Date> {

    public DateDeSerializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String value = p.readValueAs(String.class);
        try {
            System.out.println("hello");
            return new SimpleDateFormat("MM/YYYY").parse(value);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
