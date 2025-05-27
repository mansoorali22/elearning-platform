package BusinessLogic;

import database.DBConnector;

public class Alumni extends User {
    // Fields
    private String yearCompletion;
    private String status;

    // Constructor
    public Alumni() {}
    
    public Alumni(String email, String password) {
    	this.setEmail(email);
    	this.setPassword(password);
    }
    
    public Alumni(Integer id, String yearCompletion, String status) {
    	this.setUserID(id);
    	this.setYearCompletion(yearCompletion);
    	this.setStatus(status);
    }
    
    public Alumni(String fullName, String yearCompletion, String status) {
    	this.setFullName(fullName);
    	this.setYearCompletion(yearCompletion);
    	this.setStatus(status);
    }
    public Alumni(Integer userID, String fullName, String email, String password, String phoneNo,
                  String yearCompletion, String designation, String status) {
        super(userID, fullName, email, password, phoneNo, designation);
        this.yearCompletion = yearCompletion;
        this.status = status;
    }

    // Getters
    public String getYearCompletion() { return yearCompletion; }
    public String getStatus() { return status; }

    // Setters
    public void setYearCompletion(String yearCompletion) { this.yearCompletion = yearCompletion; }
    public void setStatus(String status) { this.status = status; }
    
    @Override
    public String toString() {
        return "Alumni{" +
               "name='" + getFullName() + '\'' +
               ", yearCompletion='" + yearCompletion + '\'' +
               ", status='" + status + '\'' +
               '}';
    }
    // Method to verify alumni
    public void verifyAlumni(Integer userID, String name) {
    	DBConnector C = new DBConnector();
    	C.saveAlumni(this);
    }
    
    @Override
    public void signUp() {
    	DBConnector C = new DBConnector();
    	C.saveAlumni(this);
    }
    
    @Override
    public void signIn(String email, String password) {
    	DBConnector C = new DBConnector();
    	C.checkAlumniLogin(this);
    }
}

