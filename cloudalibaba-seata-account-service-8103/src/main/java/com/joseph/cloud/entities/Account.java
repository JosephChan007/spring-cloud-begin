package com.joseph.cloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;                    // 主键ID
    private Long userId;                // 用户ID
    private Integer total;              // 总余额
    private Integer used;               // 已用余额
    private Integer residue;            // 剩余余额

}
