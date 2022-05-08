package com.code.DoanJAVA.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class product_Img {
    @Id
    @Column(
            name = "id",
            nullable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id ;
    private String img ;
    @ManyToOne
    @JoinColumn(
            name = "product_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private product product;
}
