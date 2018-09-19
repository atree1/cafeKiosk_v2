package org.zerock.web;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.zerock.domain.OwnerVO;

@WebServlet(urlPatterns = "/owner/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/login.jsp");

        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Login post.....");
        String id = req.getParameter("owid");
        String pw = req.getParameter("owpw");
        System.out.println(id + ":" + pw);

        OwnerVO vo ;

        if(id.equals(pw) == false){

            resp.sendRedirect("/owner/login");
            return;
        }

        vo = new OwnerVO();

        HttpSession session = req.getSession();

        if(vo != null){
            session.setAttribute("owner",vo);
        }

            resp.sendRedirect("/store/main");
    }
}
