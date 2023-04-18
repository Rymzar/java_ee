package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Person tom = (Person) session.getAttribute("person");

        PrintWriter out = response.getWriter();
        try {
            if(tom == null) {

                tom = new Person("Tom", 34);
                session.setAttribute("person", tom);
                out.println("Session data are set");
            }
            else {
                out.println("Name: " + tom.getName() + " Age: " + tom.getAge());
                session.removeAttribute("person");
            }
        }
        finally {
            out.close();
        }
    }
}
/*
// получение всех ключей
Enumeration keys = session.getAttributeNames();
while(keys.hasMoreElements()){
    System.out.println((String) keys.nextElement());
}

// установка интервала неактивности
session.setMaxInactiveInterval(60*60*24);   // 1 день
session.setMaxInactiveInterval(-1); // до закрытия браузера

// удаление всех данных из сессии
session.invalidate();*/