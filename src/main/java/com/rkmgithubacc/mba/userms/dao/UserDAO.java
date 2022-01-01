package com.rkmgithubacc.mba.userms.dao;

import com.rkmgithubacc.mba.userms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
}
