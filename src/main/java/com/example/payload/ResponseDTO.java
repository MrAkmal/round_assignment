package com.example.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ResponseDTO<T> {

    private T data;

    private String message;

    private int code;
}
