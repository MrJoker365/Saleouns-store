package com.saleount.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class Photos {

    @Id
    @GeneratedValue
    private Long id;

    private Long id_user, id_post;

    @Lob
    private byte[] image;


}
