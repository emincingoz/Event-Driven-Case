package com.emincingoz.ProductService.command.api.events;

import com.emincingoz.ProductService.command.api.data.Product;
import com.emincingoz.ProductService.command.api.data.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product")
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = new Product();

        BeanUtils.copyProperties(event, product);

        productRepository.save(product);
    }

    // When an error occurs in the event handle, this method is triggered and the database process becomes a rollback
    @ExceptionHandler
    public void handle(Exception e) throws Exception {
        throw e;
    }
}
