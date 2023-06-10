package dao;

import java.sql.Date;
import java.sql.SQLException;

import pojos.User;

public interface UserDao {
	User authenticateUser(String email, String password) throws SQLException;
	User RegisterNewVoter( String firstName, String lastName, String email, String password, String dob) throws SQLException;
}
