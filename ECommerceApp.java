import java.io.*;
import java.util.*;
public class ECommerceApp {
static BufferedReader reading = new BufferedReader(new InputStreamReader(System.in));
public static void main(String[] args) throws IOException {
 UserManager userManager = new UserManager();
    ProductManager productManager = new ProductManager();
    OrderManager orderManager = new OrderManager(userManager.getUsers(), productManager.getProducts());
    while (true) {
        System.out.println("\nJ Cart E-Commerce Menu");
        System.out.println("1.add user");
         System.out.println("2.add product");
        System.out.println("3.place order");
        System.out.println("4.view orders");
         System.out.println("5.exit");
        System.out.print("choose option:");
        String choice = reading.readLine();
        switch (choice) {
            case "1":
            System.out.print("useriD: ");
         String uid = reading.readLine();
        System.out.print("name: ");
         String uname = reading.readLine();
         System.out.print("email: ");
        String email = reading.readLine();
        userManager.saveUser(new User(uid, uname, email));
        break;
    case "2":
        System.out.print("productId: ");
        String pid = reading.readLine();
        System.out.print("name: ");
         String pname = reading.readLine();
        System.out.print("price: ");
        double price = Double.parseDouble(reading.readLine());
        System.out.print("stock: ");
        int stock = Integer.parseInt(reading.readLine());
        productManager.saveProduct(new Product(pid, pname, price, stock));
        break;
    case "3":
         List<User> users = userManager.getUsers();
        List<Product> products = productManager.getProducts();
        if (users.isEmpty() || products.isEmpty()) {
        System.out.println("add users & products.");
         break;
         }
         System.out.print("orderId: ");
        String oid = reading.readLine();
         for (int i = 0; i < users.size(); i++) {
         System.out.println((i + 1) + ". " + users.get(i));
        }
        System.out.print("user choose: ");
        User user = users.get(Integer.parseInt(reading.readLine()) - 1);
         Order order = new Order(oid, user);
         while (true) {
         for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));}
            System.out.print("product choose exit->enter'0': ");
            int pchoice = Integer.parseInt(reading.readLine());
          if (pchoice == 0) break;
            Product p = products.get(pchoice - 1);
            System.out.print("quantity: ");
            int qty = Integer.parseInt(reading.readLine());
         if (qty <= p.getStock()) {
            p.reduceStock(qty);
            order.addItem(p, qty);
            } else {
         System.out.println("no stock");
            }
            }
            orderManager.saveOrder(order);
        break;
    case "4":
        orderManager.printAllOrders();
         break;
    case "5":
         System.out.println("exiting");
    return;
    default:
     System.out.println("wrong option");
     }
     }
 }
}
