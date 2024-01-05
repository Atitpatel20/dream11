package com.dream11.dream11.repository;

import com.dream11.dream11.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
