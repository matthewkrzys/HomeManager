package com.home.manager.expenses.controller;

import com.home.manager.expenses.model.Type;
import lombok.Data;

@Data
public class ExpenseDTO {
    private String name;
    private Double price;
    private Type typeOfElement;
}
