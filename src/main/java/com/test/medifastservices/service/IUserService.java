package com.test.medifastservices.service;

import com.test.medifastservices.dto.UserDTO;
import com.test.medifastservices.model.User;

import java.sql.SQLException;

public interface IUserService {
    User checkedLogin (UserDTO userDTO) throws SQLException;
}

