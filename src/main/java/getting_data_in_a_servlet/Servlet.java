package getting_data_in_a_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//передача несколько параметров
@WebServlet("/hello")
public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        try {
            writer.println("<h2>Name: " + name + "; Age: " + age + "</h2>");
        } finally {
            writer.close();
        }
    }
}
