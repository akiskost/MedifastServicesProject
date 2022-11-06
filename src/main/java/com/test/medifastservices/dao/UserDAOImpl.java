package com.test.medifastservices.dao;

import com.test.medifastservices.dto.UserDTO;
import com.test.medifastservices.model.User;

import java.sql.*;

import static com.test.medifastservices.dao.dbutil.DBUtil.openConnection;
import static com.test.medifastservices.dao.dbutil.DBUtil.closeConnection;


public class UserDAOImpl implements IUserDAO {

    @Override
    public User checkLogin(String email, String password) throws SQLException, NullPointerException {

        PreparedStatement pst = null;
        User user = null;

        try {
            String sql = "SELECT * FROM users WHERE email = ? AND password =?";
            pst = openConnection().prepareStatement(sql);

            pst.setString(1, email);
            pst.setString(2, password);

            //ws edo pernane

            ResultSet rs = pst.executeQuery(sql);
            System.out.println(rs);
            if (rs.next()) {
                user = new User();
                user.setUserFirstName(rs.getString("FNAME"));
                user.setUserLastName(rs.getString("LANME"));
                user.setEmail(email);
            }

            return user;

        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pst != null) pst.close();
            if (openConnection() != null) closeConnection();

        }
    }
}
