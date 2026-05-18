package com.example.DeliveryService.service.Impl;

import com.example.DeliveryService.dto.CreateParcelDTO;
import com.example.DeliveryService.dto.ParcelStatsDTO;
import com.example.DeliveryService.dto.UpdateParcelStatusDTO;
import com.example.DeliveryService.model.Parcel;
import com.example.DeliveryService.model.ParcelStatus;
import com.example.DeliveryService.repository.InMemoryParcelDAO;
import com.example.DeliveryService.service.ParcelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryParcelServiceImpl implements ParcelService {

    private final InMemoryParcelDAO repository;

    public InMemoryParcelServiceImpl(InMemoryParcelDAO repository){
        this.repository = repository;
    }

    @Override
    public List<Parcel> findAllParcels() {
        return repository.findAllParcels();
    }

    @Override
    public Parcel findParcelById(Long id) {
        return repository.findParcelById(id);
    }

    @Override
    public ParcelStatsDTO getParcelsStats() {
        return null;
    }

    @Override
    public void changeParcelStatus(Long id, UpdateParcelStatusDTO status) {
        //TODO
    }

    @Override
    public Parcel createParcel(CreateParcelDTO newParcel) {
        Parcel parcel = new Parcel(newParcel);
        parcel.setTrackingNumber(UUID.randomUUID().toString());
        parcel.setStatus(ParcelStatus.CREATED);

        return repository.createParcel(parcel);
    }

    @Override
    public Parcel updateParcel(Parcel parcel) {
        return repository.updateParcel(parcel);
    }

    @Override
    public void deleteParcel(Long id) {
        repository.deleteParcel(id);
    }
}
