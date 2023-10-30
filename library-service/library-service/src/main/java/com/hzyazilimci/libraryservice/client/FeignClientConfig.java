package com.hzyazilimci.libraryservice.client;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    private final ObjectFactory<HttpMessageConverters> messageConvertersObjectFactory;

    public FeignClientConfig(org.springframework.beans.factory.ObjectFactory<HttpMessageConverters> messageConvertersObjectFactory) {
        this.messageConvertersObjectFactory = messageConvertersObjectFactory;
    }
}
