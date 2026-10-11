package com.bhargavi.ExpenseTracker.controller;

import com.bhargavi.ExpenseTracker.model.Expense;
import com.bhargavi.ExpenseTracker.service.ExpenseService;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService)
    {
        this.expenseService=expenseService;
    }

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense)
    {
      return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.addExpense(expense));
    }
    @GetMapping
    public List<Expense> getAllExpenses()
    {
        return expenseService.getAllExpenses();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id)
    {
        return expenseService.getExpenseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id,@RequestBody Expense expense)
    {
        return expenseService.updateExpense(id,expense)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id)
        {
            if(expenseService.deleteExpense(id))
            {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        }


}
