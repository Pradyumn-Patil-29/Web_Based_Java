package dao;

import java.sql.*;
import static utils.DBUtils.*;

import pojos.User;
import static utils.Validations.validateAge;
public class UserDaoImpl implements UserDao {
	// fields
	private Connection cn;
	private PreparedStatement pst1,pst2;

	public UserDaoImpl() throws SQLException {
		
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		pst2=cn.prepareStatement("insert into users values (Default,?,?,?,?,?,?,?)");
	
		System.out.println("user dao created!");
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		// set IN params
		pst1.setString(1, email);		
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery()) {
			if(rst.next()) //=> success
				
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password, 
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
		}//rst.close()
		return null;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("user dao cleaned up!");
	}

	@Override
	public User RegisterNewVoter(String firstName, String lastName, String email, String password, String dob) throws SQLException {
		
		
		Date Dob=validateAge(dob);
		//pst2.setInt(1,id);
		pst2.setString(1,firstName);
		pst2.setString(2,lastName);
		pst2.setString(3,email);
		pst2.setString(4,password);
		pst2.setDate(5,Dob);
		//pst2.setBoolean(7,votingStatus);
		//pst2.setString(8,role);
		
		pst2.setBoolean(6, false);
		pst2.setString(7, "voter");
	    System.out.println("in register");
			int rs=pst2.executeUpdate();
			if(rs!=1)
			 throw new SQLException("wrong");
			return new User(10,firstName,lastName,email,password,Dob,false,"voter");
			
			
		
		
	}

}
