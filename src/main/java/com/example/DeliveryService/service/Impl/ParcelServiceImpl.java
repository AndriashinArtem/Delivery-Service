package com.example.DeliveryService.service.Impl;

import com.example.DeliveryService.dto.CreateParcelDTO;
import com.example.DeliveryService.dto.ParcelStatsDTO;
import com.example.DeliveryService.dto.UpdateParcelStatusDTO;
import com.example.DeliveryService.model.Parcel;
import com.example.DeliveryService.model.ParcelStatus;
import com.example.DeliveryService.repository.ParcelRepository;
import com.example.DeliveryService.service.ParcelService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Primary

public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository repository;

    public ParcelServiceImpl(ParcelRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Parcel> findAllParcels() {
        return repository.findAll();
    }

    @Override
    public Parcel findParcelById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ParcelStatsDTO getParcelsStats() {
        List<Parcel> parcels = repository.findAll();
        long total = parcels.size();
        long created = parcels.stream().filter(p -> p.getStatus() == ParcelStatus.CREATED).count();
        long inTransit = parcels.stream().filter(p -> p.getStatus() == ParcelStatus.IN_TRANSIT).count();
        long delivered = parcels.stream().filter(p -> p.getStatus() == ParcelStatus.DELIVERED).count();

        return new ParcelStatsDTO(total, created, inTransit, delivered);
    }

    @Transactional
    @Override
    public void changeParcelStatus(Long id, UpdateParcelStatusDTO status){
        Parcel parcel = findParcelById(id);
        ParcelStatus currentStatus = parcel.getStatus();
        ParcelStatus newStatus = status.getStatus();
        if(!currentStatus.canTransitionTo(newStatus))
            throw new IllegalArgumentException("Invalid status transition");
        parcel.setStatus(newStatus);
    }

    @Override
    public Parcel createParcel(CreateParcelDTO newParcel) {
        Parcel parcel = new Parcel(newParcel);
        parcel.setTrackingNumber(UUID.randomUUID().toString());
        parcel.setStatus(ParcelStatus.CREATED);
        return repository.save(parcel);
    }

    @Override
    public Parcel updateParcel(Parcel parcel) {
        return repository.save(parcel);
    }

    @Override
    public void deleteParcel(Long id) {
        repository.deleteById(id);
    }
}
