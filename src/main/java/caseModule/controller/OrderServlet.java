package caseModule.controller;

import caseModule.model.Customer;
import caseModule.model.Order;
import caseModule.model.Product;
import caseModule.service.classImplement.*;
import caseModule.service.interfacee.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OrderServlet", value = "/orders")
public class OrderServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    OrderService orderService=new OrderServiceImpl();
    CustomerService customerServlet=new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "order":
                try {
                    showOrder(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;}

    }

    private void showOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int idP= Integer.parseInt(request.getParameter("id"));
        int idC= Integer.parseInt(request.getParameter("idC"));
        int idOder= Integer.parseInt(request.getParameter("idO"));

        Product product=productService.findById(idP);
        Customer customer=customerServlet.findById(idC);
        Order order=orderService.findById(idOder);
         request.setAttribute("product",product);
         request.setAttribute("customer",customer);
         request.setAttribute("order",order);
         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
