package com.demo.task.helpers;

import com.demo.task.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomUserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUsername(rs.getString("user_name"));
        user.setEncodedPassword(rs.getString("password"));
        user.setRole(rs.getString("role_name"));
        return user;
    }

}
