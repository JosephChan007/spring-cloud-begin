package com.joseph.cloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id;                    // 主键ID
    private Long productId;             // 商品ID
    private Integer total;              // 总库存
    private Integer used;               // 已用库存
    private Integer residue;            // 剩余库存

}
