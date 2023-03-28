package hu.nye.webprojekt.movies.response;

import java.util.List;

public class ErrorResponse {
    private final List<String> messages;

    public ErrorResponse(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
