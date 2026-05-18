package com.example.DeliveryService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateParcelDTO {
    @NotBlank(message = "Sender name can not be empty")
    @NotNull
    private String senderName;
    @NotBlank(message = "Sender address can not be empty")
    @NotNull
    private String senderAddress;

    @NotBlank(message = "Receiver name can not be empty")
    @NotNull
    private String receiverName;
    @NotBlank(message = "Receiver address can not be empty")
    @NotNull
    private String receiverAddress;

    @Positive
    @NotNull
    private Double weight;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
