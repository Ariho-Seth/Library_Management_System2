package com.Libray.manager;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;

public class Student_HelperClass {
	@Resource(name = "jdbc/javabook")
	private DataSource dataSource;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Student studentInfo;

	public Student_HelperClass(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> getStudents() {
		List<Student> studentList = new ArrayList<>();
		String queryString = "SELECT * FROM libraysystem";
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(queryString);) {

			while (resultSet.next()) {
				String regNum = resultSet.getString(1);
				String firstName = resultSet.getString(2);
				String otherNames = resultSet.getString(3);
				String levelofStudy = resultSet.getString(4);
				String StudyClass = resultSet.getString(5);
				String stream = resultSet.getString(6);
				String gender = resultSet.getString(7);
				String bookTitle = resultSet.getString(8);
				Date issueOut = (Date) resultSet.getObject(9);
				Date issueIn = (Date) resultSet.getObject(10);
				String status = resultSet.getString(11);

				studentInfo = new Student(regNum, firstName, otherNames, levelofStudy, StudyClass, stream, gender,
						bookTitle, issueOut, issueIn, status);
				studentList.add(studentInfo);
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return studentList;

	}

	public void checkStudent(Student theStudent) {

		String queryString = "UPDATE libraysystem SET status= ?, issueIn=? WHERE regNumber= ?";
		LocalDate currentDate = LocalDate.now();
		String statusString = "CLEARED";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(queryString);) {
			preparedStatement.setString(1, statusString);
			preparedStatement.setObject(2, currentDate);
			preparedStatement.setString(3, studentInfo.getRegNumber());
			preparedStatement.executeUpdate();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	public void add_Student(Student theStudent) throws ParseException {
		String queryString = "INSERT INTO libraysystem (regNumber, firstName, lastName, level, class, stream, sex, bookTitle, issueOut) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(queryString);) {

			// converting util Date to SQL Date.
			java.util.Date utilDate = theStudent.getIssueOut();
			long timeInMillSec = utilDate.getTime();
			java.sql.Date sqlDate = new java.sql.Date(timeInMillSec);

			preparedStatement.setString(1, theStudent.getRegNumber());
			preparedStatement.setString(2, theStudent.getFirstName());
			preparedStatement.setString(3, theStudent.getOtherNames());
			preparedStatement.setString(4, theStudent.getLevel());
			preparedStatement.setString(5, theStudent.getStudyClass());
			preparedStatement.setString(6, theStudent.getStream());
			preparedStatement.setString(7, theStudent.getGender());
			preparedStatement.setString(8, theStudent.getBookTitle());
			preparedStatement.setDate(9, sqlDate);

			preparedStatement.execute();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

	}

	public Student getStudent(String studentId) throws SQLException {
		String queryString = "SELECT regNumber, firstName, lastName, level, class, stream, sex, bookTitle, issueOut "
				+ "FROM libraysystem WHERE regNumber= ?";

		System.out.println("into the getStudent Method");
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, studentId);

			resultSet = preparedStatement.executeQuery();


			while (resultSet.next()) {
				String firstName = resultSet.getString("firstName");
				String otherNames = resultSet.getString("lastName");
				String level = resultSet.getString("level");
				String studyClass = resultSet.getString("class");
				String stream = resultSet.getString("stream");
				String gender = resultSet.getString("sex");
				String bookTitle = resultSet.getString("bookTitle");
				Date issueOut = resultSet.getDate("issueOut");

				studentInfo = new Student(studentId, firstName, otherNames, level, studyClass, stream, gender,
						bookTitle, issueOut);
			
			}
			return studentInfo;
		} finally {
			close(resultSet, preparedStatement, connection);
		}
	}

	private void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection)
			throws SQLException {
		if (resultSet != null)
			resultSet.close();
		if (preparedStatement != null)
			preparedStatement.close();
		if (connection != null)
			connection.close();

	}

}
