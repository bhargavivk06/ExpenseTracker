package com.bhargavi.ExpenseTracker.repo;

import com.bhargavi.ExpenseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
