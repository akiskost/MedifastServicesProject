package com.test.medifastservices.service;

import com.test.medifastservices.dao.IUserDAO;
import com.test.medifastservices.dto.UserDTO;
import com.test.medifastservices.model.User;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {

    private final IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User checkedLogin(UserDTO userDTO) throws SQLException {

        // Extract dto
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUserFirstName(userDTO.getUserFirstName());
        user.setUserLastName(userDTO.getUserLastName());


        try {
            User newUser = userDAO.checkLogin(user.getEmail(), user.getPassword());
            return newUser;

        } catch (SQLException e) {
            throw e;
        }


    }

}
