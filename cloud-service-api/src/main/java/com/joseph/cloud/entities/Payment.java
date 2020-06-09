package com.joseph.cloud.entities;


import com.joseph.cloud.common.MistObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends MistObject {

    private Long id;
    private String serial;

}
