package com.example.DeliveryService.dto;

import com.example.DeliveryService.model.ParcelStatus;
import jakarta.validation.constraints.NotNull;

public class UpdateParcelStatusDTO {
    @NotNull(message = "Status can not be null")
    private ParcelStatus status;

    public UpdateParcelStatusDTO(ParcelStatus status) {
        this.status = status;
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }
}
