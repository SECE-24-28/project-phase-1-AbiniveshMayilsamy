import java.util.*;
public class Order {
private String orderID;
private User user;
private List<OrderItem> items = new ArrayList<>();
    public Order(String orderID, User user) {
      this.orderID = orderID;
        this.user = user;
    }
    public void addItem(Product product, int quantity) {
     items.add(new OrderItem(product, quantity));
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(orderID);
        sb.append(".");
        sb.append(user.getUserID());
        sb.append(".");
        for (int i = 0; i < items.size(); i++) {
          sb.append(items.get(i));
        if (i < items.size() - 1) {
         sb.append(",");
        }
        }
    return sb.toString();
    }
    public static Order fromString(String line, List<User> users, List<Product> products) {
        String[] parts = line.split("\\|");
         User user = null;
        for (User u : users) {
        String userId = u.getUserID();
         String idToCompare = parts[1];
            if (userId.equals(idToCompare)) {
                user = u;
             break;
         }
     }
        if (user == null) return null;
        Order order = new Order(parts[0], user);
        String[] itemParts = parts[2].split(",");
        for (String item : itemParts) {
            String[] splt = item.split(":");
       Product product = null;
          for (Product p : products) {
        String productID = p.getProductID();
    String targetID = splt[0];
    if (productID.equals(targetID)) {
         product = p;
         break;
        }
    }
    if (product != null) {
        order.addItem(product, Integer.parseInt(splt[1]));
    }
        }
        return order;
    }
    public void printSummary() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + user.getUserID());
        double total = 0;
        for (OrderItem item : items) {
            System.out.println(" - " + item.getProduct().getProductID() + " x " + item.getQuantity() + " = ₹" + item.getSubtotal());
            total += item.getSubtotal();
        }
        System.out.println("Total: ₹" + total + "\n"+" Order placed");
    }
}
