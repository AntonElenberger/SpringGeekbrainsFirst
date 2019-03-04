package com.geekbrains.springthymeleafeboot.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Title cannot be null")
    @Size(min= 6, message = "Title length must be greater than 5 letters")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Cost cannot be null")
    @Min(value = 1, message = "Min cost error")
    @Column(name = "cost")
    private double cost;
}
