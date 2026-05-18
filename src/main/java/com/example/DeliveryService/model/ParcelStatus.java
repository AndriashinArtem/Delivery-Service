package com.example.DeliveryService.model;

import java.util.Map;
import java.util.Set;

public enum ParcelStatus {
    CREATED,
    IN_TRANSIT,
    DELIVERED;

    private static final Map<ParcelStatus, Set<ParcelStatus>> map = Map.of(
            CREATED, Set.of(IN_TRANSIT),
            IN_TRANSIT, Set.of(DELIVERED),
            DELIVERED, Set.of()
    );

    public boolean canTransitionTo(ParcelStatus newStatus){
        return map.get(this).contains(newStatus);
    }
}
