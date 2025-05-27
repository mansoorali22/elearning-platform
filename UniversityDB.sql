CREATE DATABASE EducationPlatform;

USE EducationPlatform;

CREATE TABLE DataTemp (
    email VARCHAR(255)
);

--------------
-- User table
CREATE TABLE Users (
    userID INT PRIMARY KEY,
    fullName VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    phoneNo VARCHAR(50),
    designation VARCHAR(50)
);

SELECT * FROM Users;

-- Admin table
CREATE TABLE Admin (
    userID INT PRIMARY KEY, FOREIGN KEY (userID) REFERENCES Users(userID)
);

SELECT * FROM Admin;

-- Student table
CREATE TABLE Student (
    userID INT PRIMARY KEY, FOREIGN KEY (userID) REFERENCES Users(userID),
    semesterNo INT,
    cGPA DOUBLE
);

SELECT * FROM Student;

-- Alumni table
CREATE TABLE Alumni (
    userID INT PRIMARY KEY, FOREIGN KEY (userID) REFERENCES Users(userID),
    yearCompletion VARCHAR(4),
    checkverify VARCHAR(50)
);

SELECT * FROM Alumni;



-- Course table
CREATE TABLE Course (
    courseID VARCHAR(50) PRIMARY KEY,
    courseType VARCHAR(255),
    courseName VARCHAR(255)
);

SELECT * FROM Course;


-- Course Material table
CREATE TABLE CourseMaterial (
    materialID INT PRIMARY KEY,
    courseID VARCHAR(50),
    materialType VARCHAR(255),
    Title VARCHAR(255),
    Description TEXT,
    FOREIGN KEY (courseID) REFERENCES Course(courseID)
);


SELECT * FROM CourseMaterial;

-- Syllabus Table
CREATE TABLE Syllabus (
    courseID VARCHAR(50),
    courseName VARCHAR(255),
    Title VARCHAR(255),
    link TEXT,
    FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

-- Recommanded Books Table
CREATE TABLE rBooks (
    courseID VARCHAR(50),
    courseName VARCHAR(255),
    Title VARCHAR(255),
    link TEXT,
    FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

-- Course Outline Table
CREATE TABLE CourseOutline (
    courseID VARCHAR(50),
    courseName VARCHAR(255),
    Title VARCHAR(255),
    link TEXT,
    FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

-- Pastpapers Table
CREATE TABLE Pastpapers (
    courseID VARCHAR(50),
    courseName VARCHAR(255),
    Title VARCHAR(255),
    link TEXT,
    FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

-- Assignments Table
CREATE TABLE Assignments (
    courseID VARCHAR(50),
    courseName VARCHAR(255),
    Title VARCHAR(255),
    link TEXT,
    FOREIGN KEY (courseID) REFERENCES Course(courseID)
);

-- Lecture Notes Table
CREATE TABLE LectureNotes (
    courseID VARCHAR(50),
    courseName VARCHAR(255),
    Title VARCHAR(255),
    link TEXT,
    FOREIGN KEY (courseID) REFERENCES Course(courseID)
);


--------------
INSERT INTO Users (userID, fullName, email, password, phoneNo, designation) VALUES
(0, 'Admin', 'admin', 'admin', '555-0101', 'Admin'),
(1, 'Mansoor Ali', 'i210001@nu.edu.pk', 'hashed_password1', '555-0101', 'Admin'),
(2, 'Sohaib Butt', 'i210002@nu.edu.pk', 'hashed_password2', '555-0102', 'Admin'),
(3, 'Albab Nawaz', 'i210003@nu.edu.pk', 'hashed_password3', '555-0103', 'Student'),
(4, 'Ali Shahzain', 'i210004@nu.edu.pk', 'hashed_password4', '555-0104', 'Student'),
(5, 'Talha Arjumand', 'i210005@nu.edu.pk', 'hashed_password5', '555-0105', 'Student'),
(6, 'Shabi ul Hassan', 'i210006@nu.edu.pk', 'hashed_password6', '555-0106', 'Student'),
(7, 'Hassan Abbas', 'i210007@nu.edu.pk', 'hashed_password7', '555-0107', 'Student'),
(8, 'Ahmed Mujtaba', 'i210008@nu.edu.pk', 'hashed_password8', '555-0108', 'Alumni'),
(9, 'Irtiqa Haider', 'i210009@nu.edu.pk', 'hashed_password9', '555-0109', 'Alumni'),
(10, 'Amir Rehman', 'i210010@nu.edu.pk', 'hashed_password10', '555-0110', 'Alumni'),
(11, 'student', 'student', 'student', '555-0110', 'Student'),
(12, 'alumni', 'alumni', 'alumni', '555-0110', 'Alumni');

-- Inserting data into Admin
INSERT INTO Admin (userID) VALUES
(0),
(1),
(2);

-- Inserting data into Student
INSERT INTO Student (userID, semesterNo, cGPA) VALUES
(3, 1, 3.8),
(4, 3, 3.6),
(5, 2, 3.9),
(6, 1, 3.4),
(7, 2, 3.1),
(11, 7, 3.9);

-- Inserting data into Alumni
INSERT INTO Alumni (userID, yearCompletion, checkVerify) VALUES
(8, '2022', 'Verified'),
(9, '2023', 'Unverified'),
(10, '2024', 'Unverified'),
(12, '2024', 'Unverified');

-- Inserting data into Course
INSERT INTO Course (courseID, courseType, courseName) VALUES
('CS101', 'Computer Science', 'Introduction to Computer Science'),
('CS102', 'Computer Science', 'Programming Fundamentals'),
('CS103', 'Computer Science', 'OOP'),
('CS104', 'Computer Science', 'Data Structures'),
('ENG101', 'Science-Humanities', 'English Literature'),
('EL101', 'Elective', 'Pakistan Studies'),
('EL102', 'Elective', 'Technopreneurship'),
('MT101', 'Science-Humanities', 'Calculus I'),
('MT102', 'Science-Humanities', 'Calculus II'),
('CS105', 'Computer Science', 'DLD');


-- Inserting data into CourseMaterial
INSERT INTO CourseMaterial (courseID, materialID, materialType, Title, Description) VALUES
('CS101', 1, 'Lecture Notes', 'Lecture 1: Introduction', 'Notes from the first lecture.'),
('CS102', 2, 'Lecture Notes', 'Lecture 1: Introduction', 'Textbook covering advanced calculus topics.'),
('CS103', 3, 'Lecture Notes', 'Lecture 1: Introduction', 'Manual for laboratory sessions.'),
('CS104', 4, 'Lab Manual', 'Lab Manual 1: Introduction', 'Detailed textbook on organic chemistry.'),
('ENG101', 5, 'Lab Manual', 'Lab Manual 1: Introduction', 'Collection of Shakespeare plays.'),
('EL101', 6, 'Past Paper', 'Spring 2022', 'Documentary series on ancient civilizations.'),
('EL102', 7, 'Past Paper', 'Spring 2022', 'A collection of recent psychology journal articles.'),
('MT101', 8, 'Past Paper', 'Spring 2022', 'A paper on the latest findings in genetics.'),
('MT102', 9, 'Past Paper', 'Fall 2022', 'A portfolio of Renaissance artwork.'),
('CS105', 10, 'Past Paper', 'Fall 2022', 'Sheet music for classical compositions.');

-- Inserting data into Syllabus
INSERT INTO Syllabus (courseID, courseName, Title, link) VALUES
('CS101', 'Introduction to Computer Science', 'Syllabus', 'http://example.com/syllabus'),
('CS102', 'Programming Fundamentals', 'Syllabus', 'http://example.com/syllabus'),
('CS103', 'OOP', 'Syllabus', 'http://example.com/syllabus'),
('CS104', 'Data Structures', 'Syllabus', 'http://example.com/syllabus'),
('ENG101', 'English Literature', 'Syllabus', 'http://example.com/syllabus'),
('EL101', 'Pakistan Studies', 'Syllabus', 'http://example.com/syllabus'),
('EL102', 'Technopreneurship', 'Syllabus', 'http://example.com/syllabus'),
('MT101', 'Calculus I', 'Syllabus', 'http://example.com/syllabus'),
('MT102', 'Calculus II', 'Syllabus', 'http://example.com/syllabus'),
('CS105', 'DLD', 'Syllabus', 'http://example.com/syllabus');

-- Inserting data into Recommended books
INSERT INTO rBooks (courseID, courseName, Title, link) VALUES
('CS101', 'Introduction to Computer Science', 'Book 7th Edition', 'http://example.com/syllabus'),
('CS102', 'Programming Fundamentals', 'Book 4th Edition', 'http://example.com/syllabus'),
('CS103', 'OOP', 'Book 5th Edition', 'http://example.com/syllabus'),
('CS104', 'Data Structures', 'Book 7th Edition', 'http://example.com/syllabus'),
('ENG101', 'English Literature', 'Book 11th Edition', 'http://example.com/syllabus'),
('EL101', 'Pakistan Studies', 'Book 7th Edition', 'http://example.com/syllabus'),
('EL102', 'Technopreneurship', 'Book 13th Edition', 'http://example.com/syllabus'),
('MT101', 'Calculus I', 'Book 7th Edition', 'http://example.com/syllabus'),
('MT102', 'Calculus II', 'Book 1st Edition', 'http://example.com/syllabus'),
('CS105', 'DLD', 'Book 2nd Edition', 'http://example.com/syllabus');

-- Inserting data into Course Outline
INSERT INTO CourseOutline (courseID, courseName, Title, link) VALUES
('CS101', 'Introduction to Computer Science', 'Course Outline', 'http://example.com/syllabus'),
('CS102', 'Programming Fundamentals', 'Course Outline', 'http://example.com/syllabus'),
('CS103', 'OOP', 'Course Outline', 'http://example.com/syllabus'),
('CS104', 'Data Structures', 'Course Outline', 'http://example.com/syllabus'),
('ENG101', 'English Literature', 'Course Outline', 'http://example.com/syllabus'),
('EL101', 'Pakistan Studies', 'Course Outline', 'http://example.com/syllabus'),
('EL102', 'Technopreneurship', 'Course Outline', 'http://example.com/syllabus'),
('MT101', 'Calculus I', 'Course Outline', 'http://example.com/syllabus'),
('MT102', 'Calculus II', 'Course Outline', 'http://example.com/syllabus'),
('CS105', 'DLD', 'Course Outline', 'http://example.com/syllabus');

-- Inserting data into Pastpapers
INSERT INTO Pastpapers (courseID, courseName, Title, link) VALUES
('CS101', 'Introduction to Computer Science', 'Final Exam Fall 2022', 'http://example.com/syllabus'),
('CS102', 'Programming Fundamentals', 'Final Exam Spring 2022', 'http://example.com/syllabus'),
('CS103', 'OOP', 'Mid 2 Spring 2022', 'http://example.com/syllabus'),
('CS104', 'Data Structures', 'Mid 1 Fall 2022', 'http://example.com/syllabus'),
('ENG101', 'English Literature', 'Final Exam Fall 2023', 'http://example.com/syllabus'),
('EL101', 'Pakistan Studies', 'Mid 1 Fall 2022', 'http://example.com/syllabus'),
('EL102', 'Technopreneurship', 'Final Exam Fall 2023', 'http://example.com/syllabus'),
('MT101', 'Calculus I', 'Mid 2 Spring 2022', 'http://example.com/syllabus'),
('MT102', 'Calculus II', 'Mid 2 Spring 2022', 'http://example.com/syllabus'),
('CS105', 'DLD', 'Final Exam Fall 2023', 'http://example.com/syllabus');

-- Inserting data into Assignments
INSERT INTO Assignments (courseID, courseName, Title, link) VALUES
('CS101', 'Introduction to Computer Science', 'Assignment 1', 'http://example.com/syllabus'),
('CS102', 'Programming Fundamentals', 'Assignment 2', 'http://example.com/syllabus'),
('CS103', 'OOP', 'Assignment 3', 'http://example.com/syllabus'),
('CS104', 'Data Structures', 'Assignment 1', 'http://example.com/syllabus'),
('ENG101', 'English Literature', 'Assignment 2', 'http://example.com/syllabus'),
('EL101', 'Pakistan Studies', 'Assignment 3', 'http://example.com/syllabus'),
('EL102', 'Technopreneurship', 'Assignment 1', 'http://example.com/syllabus'),
('MT101', 'Calculus I', 'Assignment 2', 'http://example.com/syllabus'),
('MT102', 'Calculus II', 'Assignment 3', 'http://example.com/syllabus'),
('CS105', 'DLD', 'Assignment 1', 'http://example.com/syllabus');



-- Inserting data into Lecture notes
INSERT INTO LectureNotes (courseID, courseName, Title, link) VALUES
('CS101', 'Introduction to Computer Science', 'Lecture 1 : Introduction', 'http://example.com/syllabus'),
('CS102', 'Programming Fundamentals', 'Lecture 2 : Basic Programming', 'http://example.com/syllabus'),
('CS103', 'OOP', 'Lecture 3 : OOP Principles', 'http://example.com/syllabus'),
('CS104', 'Data Structures', 'Lecture 1 : Introduction', 'http://example.com/syllabus'),
('ENG101', 'English Literature', 'Lecture 2 : Comprehension', 'http://example.com/syllabus'),
('EL101', 'Pakistan Studies', 'Lecture 3 : Democracy', 'http://example.com/syllabus'),
('EL102', 'Technopreneurship', 'Lecture 1 : Introduction', 'http://example.com/syllabus'),
('MT101', 'Calculus I', 'Lecture 2 : Domain and Range', 'http://example.com/syllabus'),
('MT102', 'Calculus II', 'Lecture 3 : Multi-Domain', 'http://example.com/syllabus'),
('CS105', 'DLD', 'Lecture 1 : Introduction', 'http://example.com/syllabus');