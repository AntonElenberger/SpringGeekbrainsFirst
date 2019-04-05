package com.geekbrains.springthymeleafeboot.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductErrorResponce {
    private int status;
    private String message;
    private long timestamp;
}
