package com.example.DeliveryService.dto;

public class ParcelStatsDTO {
    private long total;
    private long created;
    private long inTransit;
    private long delivered;

    public ParcelStatsDTO(long total, long created, long inTransit, long delivered){
        this.total = total;
        this.created = created;
        this.inTransit = inTransit;
        this.delivered = delivered;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getInTransit() {
        return inTransit;
    }

    public void setInTransit(long inTransit) {
        this.inTransit = inTransit;
    }

    public long getDelivered() {
        return delivered;
    }

    public void setDelivered(long delivered) {
        this.delivered = delivered;
    }
}
