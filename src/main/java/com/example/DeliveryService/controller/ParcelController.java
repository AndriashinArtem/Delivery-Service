package com.example.DeliveryService.controller;

import com.example.DeliveryService.dto.CreateParcelDTO;
import com.example.DeliveryService.dto.ParcelStatsDTO;
import com.example.DeliveryService.dto.UpdateParcelStatusDTO;
import com.example.DeliveryService.model.Parcel;
import com.example.DeliveryService.service.ParcelService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parcels")
public class ParcelController {
    private final ParcelService service;

    public ParcelController(ParcelService service){
        this.service = service;
    }

    @GetMapping()
    List<Parcel> findAllParcels(){
        return service.findAllParcels();
    }

    @GetMapping("/{id}")
    Parcel findParcelById(@PathVariable Long id){
        return service.findParcelById(id);
    }

    @GetMapping("/stats")
    ParcelStatsDTO getParcelsStats(){
        return service.getParcelsStats();
    }

    @PatchMapping("/{id}")
    void updateParcelStatus(@PathVariable Long id, @Valid @RequestBody UpdateParcelStatusDTO status){
        service.changeParcelStatus(id, status);
    }

    @PostMapping("/createParcel")
    Parcel createParcel(@Valid @RequestBody CreateParcelDTO newParcel){
        return service.createParcel(newParcel);
    }

    @PutMapping("/updateParcel")
    Parcel updateParcel(@RequestBody Parcel parcel){
        return service.updateParcel(parcel);
    }

    @DeleteMapping("/deleteParcel/{id}")
    void deleteParcel(@PathVariable Long id){
        service.deleteParcel(id);
    }
}
