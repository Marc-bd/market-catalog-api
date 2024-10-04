package com.marcos.market_catalog.repositories;

import com.marcos.market_catalog.entities.owner.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OwnerRepository extends MongoRepository<Owner, String> {
}
