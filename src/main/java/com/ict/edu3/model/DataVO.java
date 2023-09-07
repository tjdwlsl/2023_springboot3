package com.ict.edu3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@NoArgsConstructor <- 인자가 없는
@AllArgsConstructor
public class DataVO {
    private boolean success;
    private String message;
    private Object data;
}
