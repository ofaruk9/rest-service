package com.example.restservice;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CustomSerializer extends StdSerializer<Customer> {

    public CustomSerializer() {
        this(null);
    }

    public CustomSerializer(Class<Customer> t) {
        super(t);
    }

    @Override
    public void serialize(Customer value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        for (Customer c : value.getCustomers()) {
            gen.writeStringField("Customer Name", c.getName());
            Iterator it = c.getPurchases().entrySet().iterator();
            gen.writeFieldName("points");
            gen.writeStartArray();
            while (it.hasNext()) {
                gen.writeStartObject();
                Map.Entry e = (Map.Entry) it.next();
                List<Integer> point = (List<Integer>) e.getValue();
                gen.writeStringField("month", (String) e.getKey());
                gen.writeStringField("point", String.valueOf(point.get(0)));
                gen.writeEndObject();
            }

            gen.writeEndArray();
        }
        gen.writeEndObject();
    }


}
