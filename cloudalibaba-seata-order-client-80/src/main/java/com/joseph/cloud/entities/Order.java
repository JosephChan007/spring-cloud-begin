package com.joseph.cloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;                    // 主键ID
    private Long userId;                // 用户ID
    private Long productId;             // 商品ID
    private Integer count;              // 数量
    private BigDecimal money;           // 金额
    private Integer status;             // 订单状态：0-未支付，1-已支付

}
