package org.example.dao.impl;

import org.example.dao.AbstractDAO;
import org.example.model.User;
import org.example.util.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class UsersDAO extends AbstractDAO<User> {
    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User getById(User user) {
        return null;
    }

    @Override
    public Set<User> getAll(User user) {
        return null;
    }

    public User getByEmail(String email) {
        Connection conn = DBUtils.getConnection();
        final String sql = "SELECT * FROM `users` WHERE email = '" + email + "'";

        try {
            Statement stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        DBUtils.release(conn, null, null, null);

        return null;
    }
}
