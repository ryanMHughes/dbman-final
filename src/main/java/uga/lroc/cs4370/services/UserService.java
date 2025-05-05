package uga.lroc.cs4370.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;


import uga.lroc.cs4370.models.User;

@Service
@SessionScope
public class UserService {

    private final DataSource dataSource;
    private final SCryptPasswordEncoder passwordEncoder;
    private User loggedInUser = null;

    @Autowired
    public UserService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.passwordEncoder = SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    
    public boolean authenticate(String username, String password) throws SQLException {
        final String sql = "select * from user where username = ?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String storedPasswordHash = rs.getString("password");
                    boolean isPassMatch = passwordEncoder.matches(password, storedPasswordHash);
                    if (isPassMatch) {
                        String userId = rs.getString("userId");
                        String firstName = rs.getString("firstName");
                        String lastName = rs.getString("lastName");

                        loggedInUser = new User(userId, firstName, lastName);
                    }
                    return isPassMatch;
                }
            }
        }
        return false;
    }

    public void unAuthenticate() {
        loggedInUser = null;
    }

    public boolean isAuthenticated() {
        return loggedInUser != null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public boolean registerUser(String username, String password, String firstName, String lastName)
            throws SQLException {
        final String registerSql = "insert into user (username, password, firstName, lastName) values (?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement registerStmt = conn.prepareStatement(registerSql)) {
            registerStmt.setString(1, username);
            registerStmt.setString(2, passwordEncoder.encode(password));
            registerStmt.setString(3, firstName);
            registerStmt.setString(4, lastName);

            int rowsAffected = registerStmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

}
