package servlet;


import entity.Cake;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CartServlet")

public class CartServlet extends HttpServlet {



    protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        List<Cake> cart = null;
        boolean purFlag = true;
        HttpSession session = req.getSession(false);
        if (session == null)
        {
            purFlag =false;
        }
        else {
            cart = (List) session.getAttribute("cart");

            if (cart == null){
                purFlag=false;
            }
        }

        if(!purFlag){
            out.write("抱歉，您还没有购买任何商品！<br>");
        }
        else {
            out.write("您购买的蛋糕有：<br>");
            double price = 0;
            for (Cake cake:cart){
                out.write(cake.getName() +"<br>");
            }
        }

    }


}

