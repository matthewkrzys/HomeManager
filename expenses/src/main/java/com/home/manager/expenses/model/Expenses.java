package com.home.manager.expenses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "expenses")
@Builder
@AllArgsConstructor
@Getter
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

//    @Convert(converter = TypeConverter.class)
    @Enumerated(EnumType.STRING)
    private Type typeOfElement;

    public Expenses() {
    }
}
