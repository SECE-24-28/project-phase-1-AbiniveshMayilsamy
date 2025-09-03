import java.util.*;
import java.io.*;
public class ProductManager {
    private List<Product> products = new ArrayList<>();
    private final String File= "products.txt";
    public ProductManager() throws IOException {
        loadProducts();
    }
    public void loadProducts() throws IOException {
        File file = new File(File);
        if (!file.exists()) file.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(File));
        String line;
        while ((line = br.readLine()) != null) {
            products.add(Product.fromString(line));
        }
        br.close();
    }
    public void saveProduct(Product product) throws IOException {
        products.add(product);
        BufferedWriter bw = new BufferedWriter(new FileWriter(File, true));
        bw.write(product.toString());
        bw.newLine();
        bw.close();
    }
    public List<Product> getProducts() {
        return products;
    }
}
