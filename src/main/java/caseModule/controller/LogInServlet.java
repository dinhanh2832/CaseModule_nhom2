package caseModule.controller;

import caseModule.model.ClassifyProduct;
import caseModule.model.Customer;
import caseModule.model.Product;
import caseModule.model.Server;
import caseModule.service.classImplement.ClassifyProductServiceImpl;
import caseModule.service.classImplement.CustomerServiceImpl;
import caseModule.service.classImplement.ProductServiceImpl;
import caseModule.service.classImplement.ServerServiceImpl;
import caseModule.service.interfacee.ClassifyProductService;
import caseModule.service.interfacee.CustomerService;
import caseModule.service.interfacee.ProductService;
import caseModule.service.interfacee.ServerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LogInServlet", value = "/logIn")
public class LogInServlet extends HttpServlet {
    CustomerService customerServlet = new CustomerServiceImpl();
    ProductService productService = new ProductServiceImpl();
    ServerService serverService = new ServerServiceImpl();
    ClassifyProductService classifyProductService = new ClassifyProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "page":
                showLogIn(request, response);
                break;
            case "viewProduct":
                try {
                    showProductOfUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "show":
                try {
                    showListGuest(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showCustomerSide(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showProductOfUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/viewProductOfUser.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        ClassifyProduct classifyProduct = classifyProductService.findById(product.getClassifyId());
        Server server = serverService.findById(product.getServerId());
        request.setAttribute("product", product);
        request.setAttribute("server", server);
        request.setAttribute("classifyProduct", classifyProduct);
        ;
        requestDispatcher.forward(request, response);
    }

    private void showLogIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/adminSide.jsp");
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
        boolean check = false;
        for (Customer customer : list) {
            if (customer.getUserNameAcc().equals(userName) && customer.getPass().equals(pass)) {
                check = true;
                session.setAttribute("uc", userName);
                session.setAttribute("pc", pass);
                session.setAttribute("idC", customer.getId());
                session.setAttribute("mS", customer.getMoney());
                session.setAttribute("name", customer.getName());
                session.setAttribute("email", customer.getEmail());
                session.setAttribute("sdt", customer.getNumberPhone());
            }
        }
        if (check) {
            showCustomerSide(request, response);
        } else if (userName.equals("admin") && pass.equals("admin")) {
            session.setAttribute("uc", 100);
            session.setAttribute("pc", pass);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/adminSide.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("message", "Sai tai khoan hoac mat khau !");
            dispatcher.forward(request, response);
        }
    }

    private List<ClassifyProduct> findClassifyProduct(List<Product> products) throws SQLException {
        List<ClassifyProduct> list = new ArrayList<>();
        for (Product product : products) {
            ClassifyProduct classifyProduct = classifyProductService.findById(product.getClassifyId());
            list.add(classifyProduct);
        }
        return list;
    }

    private List<Server> findAllServer(List<Product> productList) throws SQLException {
        List<Server> list = new ArrayList<>();
        for (Product product : productList) {
            Server server = serverService.findById(product.getServerId());
            list.add(server);
        }
        return list;
    }

    private void showCustomerSide(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customerSide.jsp");
        List<Product> productList = productService.printAll();
        List<Product> list2 = new ArrayList<>();
        for (Product product : productList) {
            int status = product.getStatus();
            if (status == 1) {
                list2.add(product);
            }
        }
        List<ClassifyProduct> classifyProducts = findClassifyProduct(list2);
        List<Server> serverList = findAllServer(list2);
        HttpSession session = request.getSession(false);
        int id = (Integer) session.getAttribute("idC");
        Customer customer = customerServlet.findById(id);
        request.setAttribute("customer", customer);
        request.setAttribute("products", list2);
        request.setAttribute("classifyProducts", classifyProducts);
        request.setAttribute("servers", serverList);
        dispatcher.forward(request, response);
    }
    private void showListGuest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customerSide.jsp");
        List<Product> productList = productService.printAll();
        List<Customer> list = customerServlet.printAll();
        List<Product> list2 = new ArrayList<>();
        HttpSession session = request.getSession();
        for (Customer customer : list) {
            if(customer.getId() == 0){
                session.setAttribute("idC", customer.getId());
                session.setAttribute("mS", customer.getMoney());
                session.setAttribute("name", customer.getName());
                session.setAttribute("email", customer.getEmail());
                session.setAttribute("sdt", customer.getNumberPhone());
            }
        }
        for (Product product : productList) {
            int status = product.getStatus();
            if (status == 1) {
                list2.add(product);
            }
        }

        List<ClassifyProduct> classifyProducts = findClassifyProduct(list2);
        List<Server> serverList = findAllServer(list2);
        request.setAttribute("products", list2);
        request.setAttribute("classifyProducts", classifyProducts);
        request.setAttribute("servers", serverList);
        dispatcher.forward(request, response);
    }
}
