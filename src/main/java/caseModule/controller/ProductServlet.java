package caseModule.controller;

import caseModule.model.*;
import caseModule.service.classImplement.*;
import caseModule.service.interfacee.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    CartService cartService = new CartServiceImpl();
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
            case "create":
                showCreateProduct(request, response);
                break;
            case "edit":
                try {
                    showEdit(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "view":
                try {
                    viewProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "sort":
                try {
                    sortByUp(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "sortProduct":
                try {
                    sortProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "showBuy":
                try {
                    showBuy(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteCart":
                try {
                    deleteCart(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showListProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }


    }

    private void sortProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/listProduct.jsp");
        List<Product> productList = productService.printAllOrderByPrice();
        request.setAttribute("products", productList);
        requestDispatcher.forward(request, response);

    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id= Integer.parseInt(request.getParameter("id"));
        cartService.delete(id);
        int total = 0;
        List<Cart> list1 = cartService.printAll();
        int idC = Integer.parseInt(request.getParameter("idC"));
        List<Cart> list2 = new ArrayList<>();
        List<Product> list = new ArrayList<>();
        for (Cart value : list1) {
            if (value.getIdCustomer() == idC) {
                list2.add(value);
                list = findAllProduct(list2);

            }
        }
        for (Product product : list) {
            total += product.getPrice();
        }
//        List<Cart> list3 = new ArrayList<>();
//        for (Cart cart: list2) {
//            if (cart.getIdProduct() != 1) {
//                list3.add(cart);
//                list = findAllProduct(list3);
//            }
//        }

        request.setAttribute("idC",idC);
        request.setAttribute("total", total);
        request.setAttribute("products", list);
        request.setAttribute("carts",list2);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/showBuy.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Cart> list1 = cartService.printAll();
        int idP = Integer.parseInt(request.getParameter("idP"));
        int idC = Integer.parseInt(request.getParameter("idC"));

        List<Cart> list2 = new ArrayList<>();
        List<Product> list = new ArrayList<>();
        boolean check = true;
        for (Cart value : list1) {
            if (value.getIdCustomer() == idC) {
                list2.add(value);
                list = findAllProduct(list2);

            }
        }
        if (list2.size() == 0) {
            Cart cart = new Cart(idP, idC);
            cartService.add(cart);
            list2.add(cart);
            list = findAllProduct(list2);
        } else {
            for (Cart cart : list2) {
                if (cart.getIdProduct() == idP) {
                    check = false;
                    break;
                }
            }
            if (check) {
                Cart cart = new Cart(idP, idC);
                cartService.add(cart);
                list2.add(cart);
                list = findAllProduct(list2);
            }
        }
//        List<Cart> list3 = new ArrayList<>();
//        for (Cart cart: list2) {
//            if (cart.getIdProduct() != 1) {
//                list3.add(cart);
//                list = findAllProduct(list3);
//            }
//        }
        int total = 0;
        for (Product product : list) {
            total += product.getPrice();
        }

        request.setAttribute("products", list);
        request.setAttribute("idP", idP);
        request.setAttribute("idC", idC);
        request.setAttribute("total", total);
        request.setAttribute("carts", list2);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/showBuy.jsp");
        requestDispatcher.forward(request, response);

    }


    private void buyProduct1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int total = 0;
        List<Cart> list1 = cartService.printAll();
        List<Product> listProduct = productService.printAll();
        int idC = Integer.parseInt(request.getParameter("idC"));
        List<Cart> listCart = new ArrayList<>();
        List<Product> listProduct2 = new ArrayList<>();

        for (Cart value : list1) {
            if (value.getIdCustomer() == idC) {
                listCart.add(value);
                listProduct2 = findAllProduct(listCart);
            }
        }

        for (Product product : listProduct2) {
            total += product.getPrice();
        }

        for (Product product : listProduct2) {
            for (Product value : listProduct) {
                if(product.getId() !=1 ){
                    if (product.getId() == value.getId()) {
                        productService.delete(value.getId());
                        cartService.delete(value.getId());
                    }
                }
            }
        }
        String time = String.valueOf(LocalDateTime.now());
        request.setAttribute("total", total);
        request.setAttribute("products", listProduct2);
        request.setAttribute("time", time);
        request.setAttribute("idC", idC);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/showOrder.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("customer/showBuy.jsp");
        requestDispatcher.forward(request,response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        int price = Integer.parseInt(request.getParameter("price"));
        int classifyId = Integer.parseInt(request.getParameter("classifyId"));
        String description = request.getParameter("description");
        String userProduct = request.getParameter("userProduct");
        String pass = request.getParameter("pass");
        int status = Integer.parseInt(request.getParameter("status"));
        int serverId = Integer.parseInt(request.getParameter("serverId"));
        Product product = new Product(price, classifyId, description, userProduct, pass, status, serverId);
        productService.edit(id, product);
        response.sendRedirect("/products");
    }


    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int max = 1;
        List<Product> list = productService.printAll();
        for (Product value : list) {
            if (max < value.getId()) {
                max = value.getId();
            }
        }
        int price = Integer.parseInt(request.getParameter("price"));
        int classifyId = Integer.parseInt(request.getParameter("classifyId"));
        String description = request.getParameter("description");
        String userProduct = request.getParameter("userProduct");
        String pass = request.getParameter("pass");
        int status = Integer.parseInt(request.getParameter("status"));
        int serverId = Integer.parseInt(request.getParameter("serverId"));
        Product product = new Product(max + 1, price, classifyId, description, userProduct, pass, status, serverId);
        productService.add(product);
        response.sendRedirect("/products");

    }


    private void sortByUp(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customerSide.jsp");
        List<Product> productList = productService.printAllOrderByPrice();
        request.setAttribute("products", productList);
        requestDispatcher.forward(request, response);

    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/viewProduct.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        requestDispatcher.forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/editProduct.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        requestDispatcher.forward(request, response);

    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/createProduct.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> productList = productService.printAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/listProduct.jsp");
        List<Product> list = new ArrayList<>();
        for (Product product : productList) {
            int status = product.getStatus();
            if (status == 1) {
                list.add(product);
            }
        }
        List<ClassifyProduct> classifyProducts = findClassifyProduct(list);
        List<Server> serverList = findAllServer(list);
        request.setAttribute("products", list);
        request.setAttribute("classifyProducts", classifyProducts);
        request.setAttribute("servers", serverList);
        requestDispatcher.forward(request, response);

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

    private List<Product> findAllProduct(List<Cart> cartList) throws SQLException {
        List<Product> list = new ArrayList<>();
        for (Cart cart : cartList) {
            Product product1 = productService.findById(cart.getIdProduct());
            list.add(product1);
        }
        return list;
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
                    createProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "showBuy":
                try {
                    buyProduct1(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deleteCart":
                try {
                    buyProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    private void buyProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int total = 0;
        List<Cart> list1 = cartService.printAll();
        List<Product> listProduct = productService.printAll();
        int idC = Integer.parseInt(request.getParameter("idC"));
        List<Cart> listCart = new ArrayList<>();
        List<Product> listProduct2 = new ArrayList<>();

        for (Cart value : list1) {
            if (value.getIdCustomer() == idC) {
                listCart.add(value);
                listProduct2 = findAllProduct(listCart);

            }
        }

        for (Product product : listProduct2) {
            total += product.getPrice();
        }

        for (Product product : listProduct2) {
            for (Product value : listProduct) {
                if(product.getId() !=1 ){
                    if (product.getId() == value.getId()) {
                        productService.delete(value.getId());
                        cartService.delete(value.getId());
                    }
                }
            }
        }
        String time = String.valueOf(LocalDateTime.now());
        request.setAttribute("total", total);
        request.setAttribute("products", listProduct2);
        request.setAttribute("time", time);
        request.setAttribute("idC", idC);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/showOrder.jsp");
        requestDispatcher.forward(request, response);
    }
}
