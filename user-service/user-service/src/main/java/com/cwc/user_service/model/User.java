package com.cwc.user_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Annotate the Address, Company, and Geo classes with @Entity because they represent complex types that need
     to be stored in the database.
     Additionally, we need to handle the relationships between the User entity and these other entities
     (Address, Company, and Geo).

     Since a user has one address, company, and geo-location, we can use @OneToOne or @Embedded (for Address and Geo),
     but @Entity is recommended if we want to store these as separate tables.

     Key Points:
    @Entity:
        Address, Company, and Geo are now entities, meaning they will each have their own table in the database.
    Relationships:
        User has a @OneToOne relationship with Address and Company. Address also has a @OneToOne relationship with Geo.
    CascadeType.ALL:
        This ensures that when a User is saved, its associated Address, Company, and Geo are also saved.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;

    @OneToOne(cascade = CascadeType.ALL) // This ensures that when a User is saved, its associated Address, Company, and Geo are also saved
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    private String phone;
    private String website;

    @OneToOne(cascade = CascadeType.ALL) //This ensures that when a User is saved, its associated Address, Company, and Geo are also saved
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
}
