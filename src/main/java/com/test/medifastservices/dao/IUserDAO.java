package com.test.medifastservices.dao;

import com.test.medifastservices.dto.UserDTO;
import com.test.medifastservices.model.User;

import java.sql.SQLException;

public interface IUserDAO {
    User checkLogin(String email, String password) throws SQLException;
}
