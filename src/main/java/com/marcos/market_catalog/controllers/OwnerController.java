package com.marcos.market_catalog.controllers;

import com.marcos.market_catalog.dtos.ownerDTO.UpdateOwnerDTO;
import com.marcos.market_catalog.entities.owner.Owner;
import com.marcos.market_catalog.dtos.ownerDTO.OwnerDTO;
import com.marcos.market_catalog.services.OwnerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public ResponseEntity<Owner> create(
            @Valid
            @RequestBody
            OwnerDTO ownerData) {

        System.out.println("ownerData: " + ownerData);
        Owner newOwner = ownerService.create(ownerData);
        return ResponseEntity.ok().body(newOwner);
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getAll() {
        List<Owner> owners = ownerService.getAll();
        return ResponseEntity.ok().body(owners);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> update(
            @Valid
            @PathVariable("id")
            String id,
            @RequestBody
            UpdateOwnerDTO ownerData) {
        Owner updatedOwner = ownerService.update(id, ownerData);
        return ResponseEntity.ok().body(updatedOwner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @Valid
            @PathVariable("id")
            String id) {
        this.ownerService.delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("success", "owner deleted successfully");

        return ResponseEntity.ok().body(response);
    }


}
