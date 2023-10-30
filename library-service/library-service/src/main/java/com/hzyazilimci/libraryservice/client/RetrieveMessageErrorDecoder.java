package com.hzyazilimci.libraryservice.client;

import com.hzyazilimci.libraryservice.util.exception.BookNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RetrieveMessageErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message;
        try (InputStream body = response.body().asInputStream()){

            // create a new exceptionMessage from feign client response
            message = new ExceptionMessage();

            message.setTimeStamp(response.headers().get("date").toString());
            message.setStatus(response.status());
            message.setError(HttpStatus.resolve(message.getStatus()).getReasonPhrase());
            message.setPath(response.request().url());
            message.setMessage(IOUtils.toString(body, StandardCharsets.UTF_8));

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        switch (response.status()){
            case 404:
                throw new BookNotFoundException(message);
            default:
                return errorDecoder.decode(methodKey,response);
        }
    }
}
