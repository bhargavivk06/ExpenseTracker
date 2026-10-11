package com.bhargavi.ExpenseTracker.repo;

import com.bhargavi.ExpenseTracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense,Long>
{

}
