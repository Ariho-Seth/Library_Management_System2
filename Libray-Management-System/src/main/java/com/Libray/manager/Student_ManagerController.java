package com.Libray.manager;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student_ManagerController
 */
public class Student_ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/javabook")
	private DataSource dataSource;
	Student_HelperClass helperClass;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		super.init();
		helperClass = new Student_HelperClass(dataSource);
	}

	public void listAllStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> theStudents = helperClass.getStudents();

		request.setAttribute("MyStudentList", theStudents);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/List-Students.jsp");
		dispatcher.forward(request, response);
	}

	public void loadAllStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		System.out.println("Load method is Executing");
		String theDate = request.getParameter("issueIn");

		SimpleDateFormat newDate = new SimpleDateFormat("yyyy-mm-dd");

		String StudentID = request.getParameter("regNumber");
		String status = request.getParameter("status");

		System.out.println(StudentID);

		Date dateIn = newDate.parse(theDate);
		System.out.println("Load method is Executed");

		Student newStudent = new Student(StudentID, dateIn, status);
		helperClass.checkStudent(newStudent);

	}

	public void add_Student(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {

		String thedate = request.getParameter("issueOut");
		SimpleDateFormat newDate = new SimpleDateFormat("yyyy-mm-dd");

		String regNumber = request.getParameter("regNumber");
		String firstName = request.getParameter("firstName");
		String otherNames = request.getParameter("otherNames");
		String theLevel = request.getParameter("theLevel");
		String theClass = request.getParameter("theClass");
		String stream = request.getParameter("stream");
		String theGender = request.getParameter("theGender");
		String bookTitle = request.getParameter("bookTitle");
		Date issueOut = newDate.parse(thedate);

		Student theStudent = new Student(regNumber, firstName, otherNames, theLevel, theClass, stream, theGender,
				bookTitle, issueOut);
		helperClass.add_Student(theStudent);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get method is Executing");

		try {
			String theCommand = request.getParameter("command");
			if (theCommand == null)
				theCommand = "LIST";

			switch (theCommand) {
			case "LIST":
				listAllStudents(request, response);
				break;

			case "ADD":
				add_Student(request, response);

			case "LOAD":
				load_All_Students(request, response);
			break;
			case "UPDATE":
				 update_Student(request, response);
			break;
			default:
				listAllStudents(request, response);
				break;
			}

		} catch (ServletException | IOException | ParseException | SQLException exception) {

			exception.printStackTrace();
		}
	}

	private void load_All_Students(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String studentId = request.getParameter("regNumber");

		Student theStudent = helperClass.getStudent(studentId);
		request.setAttribute("THESTUDENT", theStudent);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/Update_Student_Form.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST method is Executing");
		boolean ischecked = Boolean.parseBoolean(request.getParameter("isChecked"));
		System.out.println("boolean is exected!");

		while (!ischecked) {
			try {
				System.out.println("inside  the try-catch");
				loadAllStudents(request, response);
				System.out.println("load method is Executed");

			} catch (ServletException | IOException | ParseException exception) {

				exception.printStackTrace();
			}
		}
	}
}
