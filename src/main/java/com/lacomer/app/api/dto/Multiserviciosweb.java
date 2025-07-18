package com.lacomer.app.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Multiserviciosweb {

	private boolean error;
    private String message;
    private Response response;
}
