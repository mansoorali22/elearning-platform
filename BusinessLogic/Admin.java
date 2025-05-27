package BusinessLogic;

import database.DBConnector;

//Inherits from User, no additional fields
public class Admin extends User {
// Constructor

	public Admin (String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
	}
	
	public Admin(Integer userID, String fullName, String email, String password, String phoneNo, String designation) {
		super(userID, fullName, email, password, phoneNo, designation);

	}
	
	@Override
    public void signIn(String email, String password) {
    	DBConnector C = new DBConnector();
    	C.checkadminlogin(this);
    }

	
}
