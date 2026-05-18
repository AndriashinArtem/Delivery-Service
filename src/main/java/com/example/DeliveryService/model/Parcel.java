package com.example.DeliveryService.model;

import com.example.DeliveryService.dto.CreateParcelDTO;
import jakarta.persistence.*;

@Entity
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackingNumber;

    private String senderName;
    private String senderAddress;

    private String receiverName;
    private String receiverAddress;

    private Double weight;

    @Enumerated(EnumType.STRING)
    private ParcelStatus status;

    public Parcel(){}

    public Parcel(CreateParcelDTO newParcel){
        this.senderName = newParcel.getSenderName();
        this.senderAddress = newParcel.getSenderAddress();

        this.receiverName = newParcel.getReceiverName();
        this.receiverAddress = newParcel.getReceiverAddress();

        this.weight = newParcel.getWeight();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

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

    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }
}
