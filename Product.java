public class Product {
    private String productID;
    private String name;
    private double price;
    private int stock;
    public Product(String productID, String name, double price, int stock) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String getProductID() {
        return productID;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public void reduceStock(int quantity) {
        stock -= quantity;
    }
    @Override
    public String toString() {
        return productID + "," + name + "," + price + "," + stock;
    }
    public static Product fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            System.out.println("Invalid data format for Product");
            return null;
        }
        String priceString = parts[2];
        String stockString = parts[3];
        if (!isDouble(priceString) || !isInteger(stockString)) {
            System.out.println("Price or stock not valid");
            return null;
        }
        double price = Double.parseDouble(priceString);
        int stock = Integer.parseInt(stockString);

        return new Product(parts[0], parts[1], price, stock);
    }
    private static boolean isInteger(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private static boolean isDouble(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        boolean hasDecimalPoint = false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (s.charAt(i) == '.') {
                if (hasDecimalPoint) return false;
                hasDecimalPoint = true;
                continue;
            }
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}