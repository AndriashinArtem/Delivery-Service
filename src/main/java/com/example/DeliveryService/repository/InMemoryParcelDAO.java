package com.example.DeliveryService.repository;

import com.example.DeliveryService.model.Parcel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryParcelDAO {
    private final List<Parcel> PARCELS = new ArrayList<>();

    public List<Parcel> findAllParcels() {
        return PARCELS;
    }

    public Parcel findParcelById(Long id) {
        return PARCELS.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Parcel createParcel(Parcel parcel) {
        PARCELS.add(parcel);
        return parcel;
    }

    public Parcel updateParcel(Parcel parcel) {
        int parcelIndex = IntStream.range(0, PARCELS.size())
                .filter(index -> PARCELS.get(index).getId().equals(parcel.getId()))
                .findFirst()
                .orElse(-1);

        if(parcelIndex > -1) {
            PARCELS.set(parcelIndex, parcel);
            return parcel;
        }

        return null;
    }

    public void deleteParcel(Long id) {
        var parcel = findParcelById(id);
        if(parcel != null)
            PARCELS.remove(parcel);
    }
}
