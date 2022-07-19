package com.nttdata.customer.entity;

import com.nttdata.customer.entity.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;

    private CustomerType customerType;

    private String name;

    private String docType;

    private String docNumber;

    private Date createdAt;

    private String address;

    private String phoneNumber;

    private String state;

    private String email;

    private String imeiMobilePhoneNumber;

    private Date lastModifiedAt;

    private Integer ownedPasiveProductsQty = 0;

    private Integer ownedActiveProductsQty = 0;

}
