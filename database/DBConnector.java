package database;
import java.sql.*;
import java.util.ArrayList;
import BusinessLogic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DBConnector {

	Connection con;
		// TODO Auto-generated method stub
	public DBConnector(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EducationPlatform" , "root" ,"Idontlikefast123");
			System.out.println("Entered into the system");
		}catch(Exception e) {
			System.out.println(e);
			
		}
	}
		
	public boolean checkadminlogin(Admin A)
    {
        ArrayList<User> Users = new ArrayList<User>();
        Statement stm;
        try {
			stm = con.createStatement();

            String query = "SELECT * FROM Users WHERE email = '" + A.getEmail() + "' AND password = '" + A.getPassword() + "'"
                    + "AND Designation = 'Admin';";
            
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                System.out.println("YES");
                User U = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                Users.add(U);
            }
            
            if (!Users.isEmpty())
            {
                System.out.println("Administrator Found!");
                return true;
            }
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Administrator NOT Found!");
        return false;
    }

	public boolean checkStudentLogin(Student S)
    {
        ArrayList<User> Users = new ArrayList<User>();
        Statement stm;
        try {
			stm = con.createStatement();

            String query = "SELECT * FROM Users WHERE email = '" + S.getEmail() + "' AND password = '" + S.getPassword() + "'"
                    + "AND Designation = 'Student';";
            
            ResultSet rs = stm.executeQuery(query);
            
            String query1 = "INSERT INTO DataTemp (email) VALUES (?)";

            PreparedStatement stmt1 = con.prepareStatement(query1);
            
            stmt1.setString(1, S.getEmail());

            int rows1 = stmt1.executeUpdate() ;
            
            while (rs.next())
            {
                System.out.println("YES");
                User U = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                Users.add(U);
            }
            
            if (!Users.isEmpty() && rows1 > 0)
            {
                System.out.println("Student Found!");
                return true;
            }
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Student NOT Found!");
        return false;
    }
	public boolean checkAlumniLogin(Alumni Al)
    {
        ArrayList<User> Users = new ArrayList<User>();
        Statement stm;
        try {
			stm = con.createStatement();
			
			
            String query = "SELECT * FROM Users JOIN Alumni ON Users.userID = Alumni.userID WHERE Users.email = '" + Al.getEmail() + "' AND Users.password = '" + Al.getPassword() + "'"
                    + " AND Users.Designation = 'Alumni' AND Alumni.checkVerify = 'Verified';";
            
            ResultSet rs = stm.executeQuery(query);
            
            String query1 = "INSERT INTO DataTemp (email) VALUES (?)";

            PreparedStatement stmt1 = con.prepareStatement(query1);
            
            stmt1.setString(1, Al.getEmail());

            int rows1 = stmt1.executeUpdate() ;
            
            while (rs.next())
            {
                System.out.println("YES");
                User U = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                Users.add(U);
            }
            
            if (!Users.isEmpty() && rows1 > 0)
            {
                System.out.println("Alumni Found!");
                return true;
            }
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Alumni NOT Found!");
        return false;
    }
	public ArrayList<Course> viewCourse()
    {
        ArrayList<Course> courses = new ArrayList<Course>();
        Statement stm;
        try {
			stm = con.createStatement();
			
			
            String query = "Select * from Course";
            
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                System.out.println("YES");
                Course C = new Course(rs.getString(1), rs.getString(2), rs.getString(3));
                courses.add(C);
            }
            
            if (!courses.isEmpty())
            {
                System.out.println("Course Found!");
               // return true;
            }
            
        } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle exceptions
        }

        System.out.println("Course NOT Found!");
        return courses;
    }

	public boolean saveStudent (Student S) {
        try {

        	String query  = "INSERT INTO Users (userID, fullname, email, password, phoneno, designation) VALUES (?, ?, ?, ?, ?, ?)";
        	String query1 = "INSERT INTO Student (userID, semesterNo, cGPA) VALUES (?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(query);
            PreparedStatement stmt1 = con.prepareStatement(query1);
            
            stmt.setInt(1, S.getUserID());
            stmt.setString(2, S.getFullName());
            stmt.setString(3, S.getEmail());
            stmt.setString(4,S.getPassword());
            stmt.setString(5, S.getPhoneNo());
            stmt.setString(6, S.getDesignation());

            stmt1.setInt(1, S.getUserID());
            stmt1.setInt(2,S.getSemesterNo());
            stmt1.setDouble(3, S.getCGPA());
            
            int rows = stmt.executeUpdate();
            int rows1 = stmt1.executeUpdate() ;
            
            if (rows > 0 && rows1 > 0) {
                System.out.println("A Student was added...");
                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
	public boolean NewCourse (Course C) {
        try {

        	String query  = "INSERT INTO Course (courseID, courseType, courseName) VALUES (?, ?, ?)";
        	
            PreparedStatement stmt = con.prepareStatement(query);
           
            stmt.setString(1, C.getCourseID());
            stmt.setString(2, C.getCourseType());
            stmt.setString(3,C.getCourseName());

            int rows = stmt.executeUpdate();
            
            if (rows > 0) {
                System.out.println("A Course was added...");
                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        return false;
    }
	public boolean saveAlumni (Alumni Al) {
        try {

        	String query  = "INSERT INTO Users (userID, fullname, email, password, phoneno, designation) VALUES (?, ?, ?, ?, ?, ?)";
        	String query1 = "INSERT INTO Alumni (userID, yearCompletion, checkVerify) VALUES (?, ?, ?)";

            PreparedStatement stmt = con.prepareStatement(query);
            PreparedStatement stmt1 = con.prepareStatement(query1);
            
            stmt.setInt(1, Al.getUserID());
            stmt.setString(2, Al.getFullName());
            stmt.setString(3, Al.getEmail());
            stmt.setString(4, Al.getPassword());
            stmt.setString(5, Al.getPhoneNo());
            stmt.setString(6, Al.getDesignation());

            stmt1.setInt(1, Al.getUserID());
            stmt1.setString(2,Al.getYearCompletion());
            stmt1.setString(3,Al.getStatus());

            int rows = stmt.executeUpdate();
            int rows1 = stmt1.executeUpdate() ;
            
            if (rows > 0 && rows1 > 0) {
                System.out.println("A Alumni was added...");
                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    } 
	public ArrayList<Alumni> AlumniDatabase() {
	    ArrayList<Alumni> list = new ArrayList();

	    String query = "SELECT u.fullName, a.yearCompletion, a.checkverify FROM Users u " +
	                   "JOIN Alumni a ON u.userID = a.userID";
	   
	    try (   PreparedStatement pst = con.prepareStatement(query);
	            ResultSet rs = pst.executeQuery(query)) {

	        while (rs.next()) {
	            // Replace 'Alumni' with the actual class you are using to hold this information
	            Alumni alumni = new Alumni(
	                rs.getString("fullName"),
	                rs.getString("yearCompletion"),
	                rs.getString("checkverify")
	            );
	            list.add(alumni);
	        }
	        	if(!list.isEmpty()) {
	        		System.out.print(false);
	        	}

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Handle exceptions
	    }

	    return list;
	}
	public ArrayList<CourseMaterial> SyllabusDatabase() {
	    ArrayList<CourseMaterial> list = new ArrayList();

	    String query = "Select * from Syllabus";
	   
	    try (   PreparedStatement pst = con.prepareStatement(query);
	            ResultSet rs = pst.executeQuery(query)) {

	    	while (rs.next()) {
	        	CourseMaterial course = new CourseMaterial(
	        		1,
	        		rs.getString("CourseName"),
	        		rs.getString("Title"),
	        		rs.getString("link")	        		
	        	);

	            list.add(course);
	        }
	        	if(!list.isEmpty()) {
	        		System.out.print(false);
	        	}

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Handle exceptions
	    }

	    return list;
	}
	public ArrayList<CourseMaterial> BooksDatabase() {
	    ArrayList<CourseMaterial> list = new ArrayList();

	    String query = "Select * from rBooks";
	   
	    try (   PreparedStatement pst = con.prepareStatement(query);
	            ResultSet rs = pst.executeQuery(query)) {

	    	while (rs.next()) {
	        	CourseMaterial course = new CourseMaterial(
	        		1,
	        		rs.getString("CourseName"),
	        		rs.getString("Title"),
	        		rs.getString("link")	        		
	        	);

	            list.add(course);
	        }
	        	if(!list.isEmpty()) {
	        		System.out.print(false);
	        	}

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Handle exceptions
	    }

	    return list;
	}
	public ArrayList<CourseMaterial> CourseOutlineDatabase() {
	    ArrayList<CourseMaterial> list = new ArrayList();

	    String query = "Select * from CourseOutline";
	   
	    try (   PreparedStatement pst = con.prepareStatement(query);
	            ResultSet rs = pst.executeQuery(query)) {

	    	while (rs.next()) {
	        	CourseMaterial course = new CourseMaterial(
	        		1,
	        		rs.getString("CourseName"),
	        		rs.getString("Title"),
	        		rs.getString("link")	        		
	        	);

	            list.add(course);
	        }
	        	if(!list.isEmpty()) {
	        		System.out.print(false);
	        	}

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Handle exceptions
	    }

	    return list;
	}
	public ArrayList<CourseMaterial> AssignmentDatabase() {
	    ArrayList<CourseMaterial> list = new ArrayList();

	    String query = "Select * from Assignments";
	   
	    try (   PreparedStatement pst = con.prepareStatement(query);
	            ResultSet rs = pst.executeQuery(query)) {

	    	while (rs.next()) {
	        	CourseMaterial course = new CourseMaterial(
	        		1,
	        		rs.getString("CourseName"),
	        		rs.getString("Title"),
	        		rs.getString("link")	        		
	        	);

	            list.add(course);
	        }
	        	if(!list.isEmpty()) {
	        		System.out.print(false);
	        	}

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Handle exceptions
	    }

	    return list;
	}
	public ArrayList<CourseMaterial> NotesDatabase() {
	    ArrayList<CourseMaterial> list = new ArrayList();

	    String query = "Select * from LectureNotes";
	   
	    try (   PreparedStatement pst = con.prepareStatement(query);
	            ResultSet rs = pst.executeQuery(query)) {

	    	while (rs.next()) {
	        	CourseMaterial course = new CourseMaterial(
	        		1,
	        		rs.getString("CourseName"),
	        		rs.getString("Title"),
	        		rs.getString("link")	        		
	        	);

	            list.add(course);
	        }
	        	if(!list.isEmpty()) {
	        		System.out.print(false);
	        	}

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Handle exceptions
	    }

	    return list;
	}
	public ArrayList<CourseMaterial> PastPaperDatabase() {
	    ArrayList<CourseMaterial> list = new ArrayList();

	    String query = "Select * from Pastpapers";
	   
	    try (   PreparedStatement pst = con.prepareStatement(query);
	            ResultSet rs = pst.executeQuery(query)) {

	    	while (rs.next()) {
	        	CourseMaterial course = new CourseMaterial(
	        		1,
	        		rs.getString("CourseName"),
	        		rs.getString("Title"),
	        		rs.getString("link")	        		
	        	);

	            list.add(course);
	        }
	        	if(!list.isEmpty()) {
	        		System.out.print(false);
	        	}

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        // Handle exceptions
	    }

	    return list;
	}
	public boolean VerifyAlumni(int selectedAlumni) {
		

        //////////////////////////////////////////////
        ArrayList<Alumni> alumnis = new ArrayList<Alumni>();		
		Statement stm;
		try {
			stm = con.createStatement();
			
			String query = "Select * from Alumni";
			ResultSet rs = stm.executeQuery(query);
			
			Integer temp = 0;
			Integer alumniTempID = null;
			
			while(rs.next()) {
				
				System.out.println(selectedAlumni);
                System.out.println(temp);
				
				System.out.println("YES");
				Alumni A =  new Alumni(rs.getInt(1), rs.getString(2), rs.getString(3));
				alumnis.add(A);
				
	            if (!alumnis.isEmpty()){
	                System.out.println("Alumni Found!");
	            }			
	        	System.out.println(temp);
	        	
	            if (temp == selectedAlumni) {
	            	alumniTempID = rs.getInt(1);
	    			System.out.println(alumniTempID);
	            	
	            }

	            temp = temp + 1;
			}
			
			int userID = alumniTempID;
	        String status = "Verified";
	        
			
	        String query1 = "UPDATE Alumni SET checkVerify=? WHERE userID=?";
			
	        PreparedStatement ps = con.prepareStatement(query1);
            ps.setString(1, status);
            ps.setInt(2, userID);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("A Alumni info was updated...");
                return true;
            }
			
			
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		return false;
		
	}
	public boolean EditCourse(Course C) {
		try {			
	        String query1 = "UPDATE Course SET courseName=? , courseType=? WHERE courseID=?";
			
	        PreparedStatement ps = con.prepareStatement(query1);
            ps.setString(1, C.getCourseName());
            ps.setString(2, C.getCourseType());
            ps.setString(3, C.getCourseID());


            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("A Course info was updated...");
                return true;
            }
			
			
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		return false;
		
	}
	
	public boolean saveEmail (String email) {
        try {
        	String oldemail = null;
        	Statement stm = con.createStatement();
			
			
            String query = "Select email from datatemp";
            String query2 = "DELETE FROM DataTemp";
            
            ResultSet rs = stm.executeQuery(query);
            
            while (rs.next())
            {
                System.out.println("YES");
                oldemail = rs.getString(1);
            }
            

           String query1 = "UPDATE Users SET email=? WHERE email=?";
			
	        PreparedStatement ps = con.prepareStatement(query1);
	        PreparedStatement ps1 = con.prepareStatement(query2);            

	        ps.setString(1, email);
	        ps.setString(2, oldemail);


            int rows = ps.executeUpdate();
            int rows1 = ps1.executeUpdate();
            
            if (rows > 0 && rows1 > 0) {
                System.out.println("Email changed.");

                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
	public boolean saveName (String name) {
        try {
        	String oldemail = null;
        	Statement stm = con.createStatement();
			
			
            String query = "Select email from datatemp";
            String query2 = "DELETE FROM DataTemp";
            
            ResultSet rs = stm.executeQuery(query);
            
            while (rs.next())
            {
                System.out.println("YES");
                oldemail = rs.getString(1);
            }
            

           String query1 = "UPDATE Users SET fullName=? WHERE email=?";
			
	        PreparedStatement ps = con.prepareStatement(query1);
	        PreparedStatement ps1 = con.prepareStatement(query2);            

	        ps.setString(1, name);
	        ps.setString(2, oldemail);


            int rows = ps.executeUpdate();
            int rows1 = ps1.executeUpdate();
            
            if (rows > 0 && rows1 > 0) {
                System.out.println("Name changed.");

                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
	public boolean savePassword (String password) {
        try {
        	String oldemail = null;
        	Statement stm = con.createStatement();
			
			
            String query = "Select email from datatemp";
            String query2 = "DELETE FROM DataTemp";
            
            ResultSet rs = stm.executeQuery(query);
            
            while (rs.next())
            {
                System.out.println("YES");
                oldemail = rs.getString(1);
            }
            

           String query1 = "UPDATE Users SET password=? WHERE email=?";
			
	        PreparedStatement ps = con.prepareStatement(query1);
	        PreparedStatement ps1 = con.prepareStatement(query2);            

	        ps.setString(1, password);
	        ps.setString(2, oldemail);


            int rows = ps.executeUpdate();
            int rows1 = ps1.executeUpdate();
            
            if (rows > 0 && rows1 > 0) {
                System.out.println("Password changed.");

                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
	public boolean savePhoneNo (String phoneNo) {
        try {
        	String oldemail = null;
        	Statement stm = con.createStatement();
			
			
            String query = "Select email from datatemp";
            String query2 = "DELETE FROM DataTemp";
            
            ResultSet rs = stm.executeQuery(query);
            
            while (rs.next())
            {
                System.out.println("YES");
                oldemail = rs.getString(1);
            }
            

           String query1 = "UPDATE Users SET phoneNo=? WHERE email=?";
			
	        PreparedStatement ps = con.prepareStatement(query1);
	        PreparedStatement ps1 = con.prepareStatement(query2);            

	        ps.setString(1, phoneNo);
	        ps.setString(2, oldemail);


            int rows = ps.executeUpdate();
            int rows1 = ps1.executeUpdate();
            
            if (rows > 0 && rows1 > 0) {
                System.out.println("PhoneNo changed.");

                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
}
