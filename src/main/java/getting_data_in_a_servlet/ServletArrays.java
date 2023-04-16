package getting_data_in_a_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//передача массивов
@WebServlet("/hello")
public class ServletArrays extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String[] nums = req.getParameterValues("nums");
        try {
            writer.print("<h2>Numbers: ");
            for(String n: nums)
                writer.print(n + " ");
            writer.println("</h2>");
        } finally {
            writer.close();
        }
    }
}
