package com.bhargavi.ExpenseTracker.service;

import com.bhargavi.ExpenseTracker.model.Expense;
import com.bhargavi.ExpenseTracker.repo.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepo expenserepo;

    public ExpenseService(ExpenseRepo expenserepo)
    {
        this.expenserepo=expenserepo;
    }
    public Expense addExpense(Expense expense)
    {
        return expenserepo.save(expense);
    }
    public List<Expense> getAllExpenses()
    {
        return expenserepo.findAll();
    }
    public Optional<Expense> getExpenseById(Long id)
    {
        return expenserepo.findById(id);
    }
    public Optional<Expense> updateExpense(Long id,Expense expense)
    {
        Optional<Expense> existing=expenserepo.findById(id);

        if(existing.isPresent())
        {
            Expense e=existing.get();
            e.setDate(expense.getDate());
            e.setReason(expense.getReason());
            e.setAmount(expense.getAmount());
            return Optional.of(expenserepo.save(e));
        }
        else {
            return Optional.empty();
        }
    }
    public boolean deleteExpense(Long id)
    {
        if(expenserepo.existsById(id))
        {
            expenserepo.deleteById(id);
            return true;
        }
            return false;


    }

}
