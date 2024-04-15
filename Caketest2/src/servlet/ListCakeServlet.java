package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cake;
import entity.CakeDB;

@WebServlet("/ListCakeServlet")
public class ListCakeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListCakeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Collection<Cake> cakes = CakeDB.getAll();
        out.write("本站提供的蛋糕有：<br>");
        for (Cake cake : cakes) {
            String url = "PurchaseServlet?id=" + cake.getId();
            out.write(cake.getName() + "<a href='" + url
                    + "'>点击购买</a><br>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


