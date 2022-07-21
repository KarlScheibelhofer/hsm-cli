package dev.scheibelhofer;

import io.quarkus.logging.Log;

import java.util.Collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
    static ObjectMapper mapper = new ObjectMapper();

    static String toJson(HsmApiClient.Key key) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(key);
        } catch (JsonProcessingException e) {
            Log.error("invalid key oject", e);
            return "<invalid>";
        }
    }

    static String toJson(Collection<HsmApiClient.Key> keys) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(keys);
        } catch (JsonProcessingException e) {
            Log.error("invalid key oject", e);
            return "<invalid>";
        }
    }
}
