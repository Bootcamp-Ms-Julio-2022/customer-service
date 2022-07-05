package com.nttdata.customerservice.entity;

import com.nttdata.customerservice.entity.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
