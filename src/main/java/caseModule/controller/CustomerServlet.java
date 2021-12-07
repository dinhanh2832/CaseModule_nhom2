package caseModule.controller;

import caseModule.model.Customer;
import caseModule.service.classImplement.CustomerServiceImpl;
import caseModule.service.interfacee.CustomerService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerService customerServlet = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteCus":
                try {
                    deleteCustomer(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "viewCustomer":
                try {
                    showViewCustomer(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    ListCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showViewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/viewCustomer.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerServlet.findById(id);
        request.setAttribute("customer", customer);
        requestDispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerServlet.delete(id);
        response.sendRedirect("/customers");
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/createCustomer.jsp");
        requestDispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerServlet.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/editCustomer.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);

    }

    private void ListCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = customerServlet.printAll();

        List<Customer> list = new ArrayList<>();
        for(Customer customer: listCustomer){
            int status = customer.getStatus();
            if(status == 1){
                list.add(customer);
            }
        }
        request.setAttribute("customers", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/listCustomer.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                AddForm(request, response);
                break;
            case "edit":
                try {
                    updateCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String numberPhone = request.getParameter("numberPhone");
        String email = request.getParameter("email");
        String userNameAcc = request.getParameter("userNameAcc");
        double money = Double.parseDouble(request.getParameter("money"));
        String pass = request.getParameter("pass");
        Customer customer = new Customer(name, age, numberPhone, email, money, userNameAcc, pass);
        customerServlet.edit(id, customer);
        response.sendRedirect("/customers");

    }

    private void AddForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String numberPhone = request.getParameter("numberPhone");
        String email = request.getParameter("email");
        double money = Double.parseDouble(request.getParameter("money"));
        String userNameAcc = request.getParameter("userNameAcc");
        String pass = request.getParameter("pass");
        try {
            customerServlet.add(new Customer(name, age, numberPhone, email, money, userNameAcc, pass));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/customers");
    }
}
