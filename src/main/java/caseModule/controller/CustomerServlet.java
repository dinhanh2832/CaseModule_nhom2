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

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
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
            case "watch":
                try {
                    watchOfCustomer(request,response);
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

    private void watchOfCustomer(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/viewCustomerOfUser.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerServlet.findById(id);
        request.setAttribute("customer", customer);
        requestDispatcher.forward(request, response);
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
            case "edit2":
                try {
                    updateCustomerA(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int age = Integer.parseInt(request.getParameter("age"));
        String numberPhone = request.getParameter("numberPhone");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Customer customer = new Customer(age, numberPhone, email, pass);
        customerServlet.edit(id, customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customerSide.jsp");
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
        HttpSession session = request.getSession(false);
        int id1 =(Integer) session.getAttribute("idC");
        Customer customer1 = customerServlet.findById(id1);
        request.setAttribute("customer",customer1);
        request.setAttribute("products", list2);
        request.setAttribute("classifyProducts",classifyProducts);
        request.setAttribute("servers",serverList);
        dispatcher.forward(request, response);
    }
    private void updateCustomerA(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int age = Integer.parseInt(request.getParameter("age"));
        String numberPhone = request.getParameter("numberPhone");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        double money = Double.parseDouble(request.getParameter("money"));
        Customer customer = new Customer(age, numberPhone, email,money ,pass);
        customerServlet.editA(id, customer);
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
        Customer customer1 = customerServlet.findById(id);
        request.setAttribute("customer",customer1);
        request.setAttribute("products", list2);
        request.setAttribute("classifyProducts",classifyProducts);
        request.setAttribute("servers",serverList);
        response.sendRedirect("/customers");
    }
    private void AddForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String numberPhone = request.getParameter("numberPhone");
        String email = request.getParameter("email");
        String userNameAcc = request.getParameter("userNameAcc");
        String pass = request.getParameter("pass");
        try {
            customerServlet.add(new Customer(name, age, numberPhone, email, userNameAcc, pass));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);
    }
    private List<ClassifyProduct> findClassifyProduct(List<Product> products)throws SQLException{
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
