package com.marcos.market_catalog.entities.owner;

import com.marcos.market_catalog.dtos.ownerDTO.OwnerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    private String id;

    private String name;


    @Indexed(name="email_index", unique=true, background=true)
    private String email;


    public Owner(OwnerDTO owner) {
        this.name = owner.getName();
        this.email = owner.getEmail();
    }

}
