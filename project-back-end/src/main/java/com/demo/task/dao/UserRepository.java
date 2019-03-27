package com.demo.task.dao;

import com.demo.task.entity.User;

public interface UserRepository {
    User findByUsername(String username);
}
