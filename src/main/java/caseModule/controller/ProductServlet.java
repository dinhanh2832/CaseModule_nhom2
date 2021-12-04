package caseModule.controller;

import caseModule.model.Product;
import caseModule.service.classImplement.OrderServiceImpl;
import caseModule.service.classImplement.ProductServiceImpl;
import caseModule.service.classImplement.ServerServiceImpl;
import caseModule.service.interfacee.OrderService;
import caseModule.service.interfacee.ProductService;
import caseModule.service.interfacee.ServerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    ServerService serverService = new ServerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(request,response);
                break;
            default:
                try {
                    showListProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }


    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("theme/createProduct.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> productList = productService.printAll();
        request.setAttribute("products", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("theme/listProduct.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        int price = Integer.parseInt(request.getParameter("price"));
       int classifyId= Integer.parseInt(request.getParameter("classifyId"));
       String description=request.getParameter("description");
       String userProduct=request.getParameter("userProduct");
       String pass=request.getParameter("pass");
       int status= Integer.parseInt(request.getParameter("status"));
       int serverId= Integer.parseInt(request.getParameter("serverId"));
        Product product = new Product(id, price,classifyId,description,userProduct,pass,status,serverId);
        productService.add(product);
        response.sendRedirect("/products");

    }
}
