package com.marcos.market_catalog.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionMessage {

    private Map<String, String> error;

    public ExceptionMessage() {
        this.error = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Error Messages:\n");
        error.forEach((field, message) -> sb.append(field).append(": ").append(message).append("\n"));
        return sb.toString();
    }

}