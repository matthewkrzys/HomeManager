package com.home.manager.expenses.controller;

import com.home.manager.expenses.model.Expenses;
import com.home.manager.expenses.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    ExpensesRepository expensesRepository;

    @GetMapping
    public ResponseEntity<List<Expenses>> getAllExpenses() {
        List<Expenses> expensesList = expensesRepository.findAll();
        return expensesList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(expensesList);
    }

    @PostMapping()
    public ResponseEntity<Expenses> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        Expenses newExpenses = Expenses.builder()
                .name(expenseDTO.getName())
                .price(expenseDTO.getPrice())
                .typeOfElement(expenseDTO.getTypeOfElement())
                .build();
        Expenses savedExpenses = expensesRepository.save(newExpenses);
        return ResponseEntity.ok(savedExpenses);
    }
}
