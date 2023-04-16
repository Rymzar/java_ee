package getting_data_in_a_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/*Передавать значения в сервлет можно различными способами.
При отправке GET-запроса значения передаются через строку запроса.
Стандартный get-запрос принимает примерно следующую форму: название_ресурса?параметр1=значение1&параметр2=значение2.*/
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        // получаем парамер id
        /* мы получаем значение этого параметра и затем отправляем его в ответ пользователю */
        String id = req.getParameter("id");

        try {
            writer.println("<h2>Id:" + id + "</h2>");
        } finally {
            writer.close();
        }
    }

}
