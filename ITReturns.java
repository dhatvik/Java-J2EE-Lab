//Frontend.html

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="testtt">
	Enter Name:<input type="Text" name="name">
	Select Gender:<select>
	<option>Male</option>
	<option>Female</option>
	</select>
	Enter Salary:<input type="Text" name="salary">
	Enter Tax:<input type="Text" name="tax">
	<input type="submit">
	<input type="Reset">
	</form>
</body>
</html>

//Backend.java



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testt
 */
@WebServlet("/testt")
public class testt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public testt() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name=request.getParameter("name");
		String Gender=request.getParameter("gender");
		String Salary=request.getParameter("salary");
		String Tax=request.getParameter("tax");
		
		PrintWriter out=response.getWriter();
		out.println("<h1>HI ,"+Name);
		out.println("<h1> Your salary is "+Salary);
		out.println("<h1> Tax to be paid is "+Tax);
		
		File fd=new File("C:\\Users\\LENOVO\\OneDrive\\Desktop\\java.txt");
		FileOutputStream fos=new FileOutputStream(fd);
		fos.write(("Hello"+Name+Gender+Salary+Tax).getBytes());
		
		fos.close();
		out.close();
	}

	
}
