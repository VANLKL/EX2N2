package cn.edu.cqust.ex2n2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigInteger;

@WebServlet(name = "1" , value = "/first")
public class FirstServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= 7; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        ServletContext context = getServletContext();
        context.setAttribute("factorial7", result);

        response.getWriter().println("7! = " + result);
    }
}
