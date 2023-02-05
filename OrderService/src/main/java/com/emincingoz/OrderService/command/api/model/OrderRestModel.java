package com.emincingoz.OrderService.command.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRestModel {

    private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
}
