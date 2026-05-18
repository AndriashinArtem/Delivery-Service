package com.example.DeliveryService.service;

import com.example.DeliveryService.dto.CreateParcelDTO;
import com.example.DeliveryService.dto.ParcelStatsDTO;
import com.example.DeliveryService.dto.UpdateParcelStatusDTO;
import com.example.DeliveryService.model.Parcel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParcelService {
    List<Parcel> findAllParcels();
    Parcel findParcelById(Long id);
    ParcelStatsDTO getParcelsStats();
    void changeParcelStatus(Long id, UpdateParcelStatusDTO status);
    Parcel createParcel(CreateParcelDTO newParcel);
    Parcel updateParcel(Parcel parcel);
    void deleteParcel(Long id);
}
