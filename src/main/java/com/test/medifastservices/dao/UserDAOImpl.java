package com.test.medifastservices.dao;

import com.test.medifastservices.dto.UserDTO;
import com.test.medifastservices.model.User;

import javax.servlet.http.HttpSession;
import java.sql.*;

import static com.test.medifastservices.dao.dbutil.DBUtil.openConnection;
import static com.test.medifastservices.dao.dbutil.DBUtil.closeConnection;


public class UserDAOImpl implements IUserDAO {

    @Override
    public User checkLogin(String email, String password) throws SQLException, NullPointerException {

        PreparedStatement pst = null;
        User user = null;

        try {
            //String sql = "SELECT * FROM users WHERE fname = 'Admin'";

            String sql = "SELECT * from users WHERE email = '" + email + "' AND password = '" + password + "'";

            pst = openConnection().prepareStatement(sql);

            ResultSet rs = pst.executeQuery(sql);

            if (rs.next()) {
                user = new User();
                user.setUserFirstName(rs.getString("FNAME"));
                user.setUserLastName(rs.getString("LNAME"));
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
