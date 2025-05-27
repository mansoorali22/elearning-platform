package BusinessLogic;

public class User {
    // Fields
    private Integer userID;
    private String fullName;
    private String email;
    private String password;
    private String phoneNo;
    private String designation;

    // Constructor
    public User() {}
    
    
    public User(Integer userID, String fullName, String email, String password, String phoneNo, String designation) {
        this.userID = userID;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.designation = designation;
    }

    // Getters
    public Integer getUserID() { return userID; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhoneNo() { return phoneNo; }
    public String getDesignation() { return designation; }

    // Setters
    public void setUserID(Integer userID) { this.userID = userID; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public void setDesignation(String designation) {this.designation = designation;}

    // Methods for signIn and signUp
    public void signIn(String email, String password) {
        // Authentication logic here
    }

    public void signUp() {
        // Sign up logic here
    }


}