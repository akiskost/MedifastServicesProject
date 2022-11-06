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
    public void checkedLogin(UserDTO userDTO) throws SQLException {

        // Extract dto
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUserFirstName(userDTO.getUserFirstName());
        user.setUserLastName(userDTO.getUserLastName());


        try {
            userDAO.checkLogin(user.getEmail(), user.getPassword());
        } catch (SQLException e) {
            throw e;
        }


    }

}
