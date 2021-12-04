package caseModule.controller;

import caseModule.model.Customer;
import caseModule.service.classImplement.CustomerServiceImpl;
import caseModule.service.interfacee.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LogInServlet", value = "/logIn")
public class LogInServlet extends HttpServlet {
    CustomerService customerServlet = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "page":
                showLogIn(request,response);
                break;
        }
    }

    private void showLogIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("theme/logIn.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                try {
                    logIn(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    private void logIn(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Customer> list = customerServlet.printAll();
        String userName = request.getParameter("username");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession();
        for (Customer customer : list) {
            if (customer.getUserNameAcc().equals(userName) && customer.getPass().equals(pass)) {
                session.setAttribute("us", userName);
                session.setAttribute("ps", pass);
                RequestDispatcher dispatcher = request.getRequestDispatcher("theme/logIn.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                request.setAttribute("message", "Sai tai khoan hoac mat khau !");
                dispatcher.forward(request, response);
            }
        }
    }
}
