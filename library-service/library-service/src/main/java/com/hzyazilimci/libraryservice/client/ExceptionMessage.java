package com.hzyazilimci.libraryservice.client;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionMessage{

        private String timeStamp;
        private String error;
        private String message;
        private String path;
        private int status;
}
