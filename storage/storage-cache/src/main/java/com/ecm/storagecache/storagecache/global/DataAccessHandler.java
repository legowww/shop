package com.ecm.storagecache.storagecache.global;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataAccessHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String serialize(
            T source
    ) {
        try {
            return objectMapper.writeValueAsString(source);
        } catch (IOException exception) {
            throw new IllegalStateException();
        }
    }

    public static <T> T deserialize(
            String source,
            Class<T> clazz
    ) {
        try {
            return objectMapper.readValue(source, clazz);
        } catch (IOException exception) {
            throw new IllegalStateException();
        }
    }
}
