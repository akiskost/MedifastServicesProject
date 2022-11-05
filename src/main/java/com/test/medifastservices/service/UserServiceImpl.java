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
        user.setUid(userDTO.getUid());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        user.setUserFirstName(user.getUserFirstName());
        user.setUserLastName(user.getUserLastName());


        try {
            userDAO.checkLogin(user.getEmail(), user.getPassword());
        } catch (SQLException e) {
            throw e;
        }

        return user;
    }

}
