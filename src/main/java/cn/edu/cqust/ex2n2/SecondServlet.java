package cn.edu.cqust.ex2n2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigInteger;

@WebServlet(name = "2" , value = "/second")
public class SecondServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        BigInteger factorial7 = (BigInteger) context.getAttribute("factorial7");

        if (factorial7 == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "请先访问/first");
            return;
        }

        BigInteger factorial9 = BigInteger.ONE;
        for (int i = 1; i <= 9; i++) {
            factorial9 = factorial9.multiply(BigInteger.valueOf(i));
        }

        BigInteger total = factorial7.add(factorial9);

        response.getWriter().println(
                "7! = " + factorial7 +"\n"  +
                        "9! = " + factorial9 + "\n" +
                        "total = " + total
        );
    }
}
