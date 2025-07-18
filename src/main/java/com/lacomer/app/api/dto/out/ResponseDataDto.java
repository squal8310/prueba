package com.lacomer.app.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDataDto {

    private Integer code;
    private String message;
    private Object data;
}
