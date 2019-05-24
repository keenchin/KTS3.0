package com.karmakoin.kts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import org.springframework.boot.json.JsonParser;

import javax.ws.rs.ext.ContextResolver;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;

public class Formatter implements ContextResolver<ObjectMapper> {
    final KtsObjectMapper mapper;

    public Formatter() {
        mapper = new KtsObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.LOWER_CAMEL_CASE);
    }

    @Override
    public ObjectMapper getContext(Class<?> cls) {
        return mapper;
    }
}


//class BigDecimalMoneyDeserializer extends JsonDeserializer<BigDecimal> {
//    private NumberDeserializers.BigDecimalDeserializer delegate = NumberDeserializers.BigDecimalDeserializer.instance;
//
//    @Override
//    public BigDecimal deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//         return delegate.deserialize(jp, ctxt).setScale(2, RoundingMode.HALF_UP);
//    }
//}