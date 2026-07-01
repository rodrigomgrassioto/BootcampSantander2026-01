package com.devrodrigo.phone;

public record PhoneResponse(
        String formattedNumber,
        String type,
        boolean success,
        String message
) {

    public String toJson() {
        return """
        {
          "success": %b,
          "type": "%s",
          "formattedNumber": "%s",
          "message": "%s"
        }
        """.formatted(success, type, formattedNumber, message).trim();
    }
}
