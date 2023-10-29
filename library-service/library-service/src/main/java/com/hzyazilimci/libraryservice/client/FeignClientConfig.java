package com.hzyazilimci.libraryservice.client;

import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    private final ObjectFactory<HttpMessageConverters> messageConvertersObjectFactory;

    public FeignClientConfig(org.springframework.beans.factory.ObjectFactory<HttpMessageConverters> messageConvertersObjectFactory) {
        this.messageConvertersObjectFactory = messageConvertersObjectFactory;
    }

 /*   @Bean
    public ErrorDecoder getErrorDecoder(){
        return new RetrieveMessageErrorDecoder(new ResponseEntityDecoder(new SpringDecoder(messageConvertersObjectFactory)));
    }*/
}
