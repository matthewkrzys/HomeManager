package com.home.manager.expenses.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Type typeOfElement;
}
