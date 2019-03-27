package com.demo.task.dao;

import com.demo.task.entity.User;
import com.demo.task.helpers.CustomUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository (value = "userRepository")
public class UserRepositoryImpl implements UserRepository {
    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate jdbcTemaplate) {
        this.template = jdbcTemaplate;
    }

    @Override
    public User findByUsername(String username) {
        try {
            final String sql = "select u.user_name user_name, u.password password, ur.role_name role_name from user u, user_role ur where u.user_name = ? and u.user_name = ur.user_name";
            User user = template.queryForObject(sql, new Object[] { username }, new CustomUserMapper());
            return user;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

}
