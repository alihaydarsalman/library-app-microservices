package com.hzyazilimci.libraryservice.client;

public record ExceptionMessage(
        String timeStamp,
        String error,
        String message,
        String path
        ) {
}
