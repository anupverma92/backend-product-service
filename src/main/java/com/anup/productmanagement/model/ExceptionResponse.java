package com.anup.productmanagement.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExceptionResponse {
    private String detail;
    private List<String> messages;
    private String instance;
    private String type;
    private String error;
    private String errorCode;
}
