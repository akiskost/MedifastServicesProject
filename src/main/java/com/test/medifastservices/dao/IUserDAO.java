package com.test.medifastservices.dao;

import com.test.medifastservices.dto.UserDTO;

import java.sql.SQLException;

public interface IUserDAO {
    UserDTO checkLogin(String email, String password) throws SQLException;
}
