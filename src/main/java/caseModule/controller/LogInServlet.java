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
    ClassifyProductService classifyProductService=new ClassifyProductServiceImpl();

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
        }
    }

    private void showLogIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("theme/adminSide.jsp");
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
        if (userName.equals("admin") && pass.equals("admin")) {
            session.setAttribute("uc", userName);
            session.setAttribute("pc", pass);
            RequestDispatcher dispatcher = request.getRequestDispatcher("theme/adminSide.jsp");
            dispatcher.forward(request, response);
        } else {
            for (Customer customer : list) {
                if (customer.getUserNameAcc().equals(userName) && customer.getPass().equals(pass)) {
                    check = true;
                }
            }
            if(check){
                session.setAttribute("us", userName);
                session.setAttribute("ps", pass);

                RequestDispatcher dispatcher = request.getRequestDispatcher("theme/customerSide.jsp");

                List<Product> productList = productService.printAll();

                List<Product> list2 = new ArrayList<>();

                for(Product product: productList){
                    int status = product.getStatus();
                    if(status == 1){
                        list2.add(product);
                    }
                }

                List<ClassifyProduct> classifyProducts = findClassifyProduct(list2);
                List<Server> serverList = findAllServer(list2);
                request.setAttribute("products", list2);
                request.setAttribute("classifyProducts",classifyProducts);
                request.setAttribute("servers",serverList);
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                request.setAttribute("message", "Sai tai khoan hoac mat khau !");
                dispatcher.forward(request, response);
            }
        }
    }
    private List<ClassifyProduct> findClassifyProduct(List<Product> products)throws SQLException, ServletException, IOException{
        List<ClassifyProduct> list = new ArrayList<>();
        for (Product product : products) {
            ClassifyProduct classifyProduct = classifyProductService.findById(product.getClassifyId());
            list.add(classifyProduct);
        }
        return list;
    }
    private List<Server> findAllServer(List<Product> productList) throws SQLException {
        List<Server> list=new ArrayList<>();
        for (Product product : productList) {
            Server server = serverService.findById(product.getServerId());
            list.add(server);
        }
        return list;
    }
}
