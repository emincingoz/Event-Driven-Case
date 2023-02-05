package com.emincingoz.CommonService.commands;


import com.emincingoz.CommonService.model.CardDetails;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ValidatePaymentCommand {

    private String paymentId;
    private String orderId;
    private CardDetails cardDetails;
}
