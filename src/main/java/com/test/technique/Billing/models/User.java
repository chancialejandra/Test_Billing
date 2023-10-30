package com.test.technique.Billing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id_user")
    private Long idUser;
    private String dni;
    private String name;
    private Integer age;
    private String email;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<Bill> bills;
}
