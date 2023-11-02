package com.test.technique.Billing.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "`bill`")
public class BillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bill")
    private Long idBill;
    @Column(name = "total_amount")
    private double totalAmount;
    private String desc;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idUser")
    private UserModel user;
}
