package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Cake;
import entity.CakeDB;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PurchaseServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 获得用户购买的商品
        String id = req.getParameter("id");
        if (id == null) {
            // 如果id为null，重定向到ListBookServlet页面
            String url = "ListBookServlet";
            resp.sendRedirect(url);
            return;
        }
        Cake book = CakeDB.getCake(id);
        // 创建或者获得用户的Session对象
        HttpSession session = req.getSession();
        // 从Session对象中获得用户的购物车
        List<Cake> cart = (List) session.getAttribute("cart");
        if (cart == null) {
            // 首次购买，为用户创建一个购物车(List集合模拟购物车)
            cart = new ArrayList<Cake>();
            // 将购物城存入Session对象
            session.setAttribute("cart", cart);
        }
        // 将商品放入购物车
        cart.add(book);
        // 创建Cookie存放Session的标识号
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60 * 30);
        cookie.setPath("/Servlet");
        resp.addCookie(cookie);
        // 重定向到购物车页面
        String url = "CartServlet";
        resp.sendRedirect(url);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}


