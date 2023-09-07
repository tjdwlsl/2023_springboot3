package com.ict.edu3.model.members;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataVO {
    private boolean success;
    private String message;
    private Object data;
}
