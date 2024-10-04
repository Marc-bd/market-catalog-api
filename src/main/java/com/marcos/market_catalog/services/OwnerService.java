package com.marcos.market_catalog.services;

import com.marcos.market_catalog.dtos.ownerDTO.UpdateOwnerDTO;
import com.marcos.market_catalog.entities.owner.Owner;
import com.marcos.market_catalog.dtos.ownerDTO.OwnerDTO;
import com.marcos.market_catalog.exceptions.ObjectNotFoundException;
import com.marcos.market_catalog.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private OwnerRepository repository;

    public OwnerService(OwnerRepository repository) {
        this.repository = repository;
    }

    public Owner create(OwnerDTO owner) {
        Owner newOwner = new Owner(owner);
        return repository.save(newOwner);
    }

    public List<Owner> getAll() {
        return repository.findAll();
    }

    public Owner getById(String id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Owner not found with id: " + id));
    }


    public Owner update(String id, UpdateOwnerDTO ownerData) {
        Owner onwer = this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Owner not found with id: " + id));
        if(ownerData.name() != null && !ownerData.name().isEmpty()){
            onwer.setName(ownerData.name());
        }
        this.repository.save(onwer);
        return onwer;
    }

    public void delete(String id) {
        Owner onwer = this.repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Owner not found with id: " + id));
        this.repository.delete(onwer);

    }

}
