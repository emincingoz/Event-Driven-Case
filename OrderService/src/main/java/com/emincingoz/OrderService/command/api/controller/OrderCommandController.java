package com.emincingoz.OrderService.command.api.controller;

import com.emincingoz.OrderService.command.api.command.CreateOrderCommand;
import com.emincingoz.OrderService.command.api.model.OrderRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderCommandController {

    private CommandGateway commandGateway;

    public OrderCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderRestModel orderRestModel) {

        String orderId = UUID.randomUUID().toString();

        CreateOrderCommand createOrderCommand =
                CreateOrderCommand
                        .builder()
                        .orderId(orderId)
                        .userId(orderRestModel.getUserId())
                        .productId(orderRestModel.getProductId())
                        .addressId(orderRestModel.getAddressId())
                        .quantity(orderRestModel.getQuantity())
                        .orderStatus("CREATED")
                        .build();

        String result = commandGateway.sendAndWait(createOrderCommand);
        return result;
    }
}
