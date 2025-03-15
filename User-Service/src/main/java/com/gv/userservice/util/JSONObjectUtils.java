package com.gv.userservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gv.userservice.model.Post;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JSONObjectUtils {

    public static void ObjectMapperEx1() {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "{\"name\": \"Alice\", \"age\": 30, \"address\": {\"street\": \"123 Maple Street\", \"city\": \"Wonderland\"}, \"isActive\": true}";

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            String name = jsonNode.get("name").asText();
            String city = jsonNode.get("address").get("city").asText();
            String postCode = jsonNode.get("address").has("postCode") ? jsonNode.get("address").get("postCode").asText() : "50080";
            log.info("name: " + name + "; city: " + city + "; postCode:" + postCode);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void objectMapper2() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonObject = objectMapper.createObjectNode();
        jsonObject.put("name", "Alice");
        jsonObject.put("age", 30);
        jsonObject.set("address", objectMapper.createObjectNode().put("street", "Orchard street").put("city", "Singapore"));
        jsonObject.put("isActive", true);
        log.info("[objectMapper2] " + jsonObject.toString());
    }

    public static void objectMapper3() {
        Post post = new Post(1, "sample post");
        log.info("[postString] post:", post.getDesc());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String postString = objectMapper.writeValueAsString(post);
            log.info("[postString] :", postString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
