package com.demo.task.service;

import com.demo.task.entity.User;

public interface GenericService {
    User findByUsername(String username);
}
