package com.saleount.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity // модель однієї таблиці (бд)
public class Post {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO) // Автоінкремент
     private Long id;

     //private Long id_user, id_photo;

     private int phone_number, price_US;
     private String product_name, username, category, //product_photo,
             product_description, location, email_address;




}
