package com.karmakoin.kts;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class KtsObjectMapper extends ObjectMapper {
    public KtsObjectMapper() {
        super();
        SimpleModule module = new SimpleModule("BigDecimalMoneySerializer", new Version(1, 0, 0, null))
                                .addSerializer(BigDecimal.class, new BigDecimalMoneySerializer());
        this.registerModule(module);

    }
}

class BigDecimalMoneySerializer extends JsonSerializer<BigDecimal> {
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers)throws IOException, JsonProcessingException {
        gen.writeString(value.setScale(2, BigDecimal.ROUND_HALF_UP).toString());

    }
}