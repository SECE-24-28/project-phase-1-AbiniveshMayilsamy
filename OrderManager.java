import java.util.*;
import java.io.*;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();
    private final String File = "orders.txt";
    private List<User> users;
    private List<Product> products;
    public OrderManager(List<User> users, List<Product> products) throws IOException {
        this.users = users;
        this.products = products;
        loadOrders();
    }
    public void loadOrders() throws IOException {
        File file = new File(File);
        if (!file.exists()) file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(File));
        String line;
        while ((line = br.readLine()) != null) {
            Order order = Order.fromString(line, users, products);
            if (order != null) orders.add(order);
        }
        br.close();
    }
    public void saveOrder(Order order) throws IOException {
        orders.add(order);
        BufferedWriter bw = new BufferedWriter(new FileWriter(File, true));
        bw.write(order.toString());
        bw.newLine();
        bw.close();
    }
    public void printAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders");
            return;
        }
        for (Order order : orders) {
            order.printSummary();
        }
    }
}
