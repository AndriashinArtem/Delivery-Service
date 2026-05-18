package com.example.DeliveryService.repository;

import com.example.DeliveryService.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}
