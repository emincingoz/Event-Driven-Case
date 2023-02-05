package com.emincingoz.ProductService.query.api.queries;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetProductsQuery {

    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
