package com.test.medifastservices.dao;

import com.test.medifastservices.dto.UserDTO;
import java.sql.*;

import static com.test.medifastservices.dao.dbutil.DBUtil.openConnection;
import static com.test.medifastservices.dao.dbutil.DBUtil.closeConnection;


public class UserDAOImpl implements IUserDAO {

    @Override
    public UserDTO checkLogin(String email, String password) throws SQLException {

        PreparedStatement pst = null;
        UserDTO user = null;

        try {
            String sql = "SELECT * FROM users WHERE email = ? and password = ?";
            pst = openConnection().prepareStatement(sql);

            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());

            ResultSet rs = pst.executeQuery(sql);

            if (rs.next()) {
                user = new UserDTO();
                user.setUserFirstName(rs.getString("FNAME"));
                user.setUserLastName(rs.getString("LANME"));
                user.setEmail(email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pst != null) pst.close();
            if (openConnection() != null) closeConnection();

        } return user;
    }
}
