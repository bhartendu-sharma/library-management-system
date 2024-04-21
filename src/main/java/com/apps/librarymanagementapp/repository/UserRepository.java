package com.apps.librarymanagementapp.repository;

import com.apps.librarymanagementapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}
