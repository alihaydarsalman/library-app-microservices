package com.hzyazilimci.libraryservice.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzyazilimci.libraryservice.client.ExceptionMessage;
import com.hzyazilimci.libraryservice.util.exception.BookNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class RetrieveMessageErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message;
        try (InputStream bodyIs = response.body().asInputStream()){
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ExceptionMessage.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        switch (response.status()){
            case 404:
                throw new BookNotFoundException(message.message() != null ? message.message() : "NOT FOUND!");
            default:
                return errorDecoder.decode(methodKey,response);
        }
    }
}
