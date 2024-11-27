import java.util.*;
import java.util.stream.Collectors;

public class ProductManager {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Integer, Product> products = new TreeMap<>();

    public static void addProduct() {
        System.out.print("Nhập ID sản phẩm: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = sc.nextDouble();
        sc.nextLine();

        products.put(id, new Product(id, name, price));
        System.out.println("Đã thêm sản phẩm: " + new Product(id, name, price));
    }

    public static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm rỗng.");
        } else {
            System.out.println("Danh sách sản phẩm:");
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }

    public static void searchProductByName(String name) {
        List<Product> result = products.values().stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào với tên: " + name);
        } else {
            System.out.println("Các sản phẩm tìm thấy:");
            result.forEach(System.out::println);
        }
    }

    public static void sortProductsByPrice(boolean ascending) {
        List<Product> sortedProducts = new ArrayList<>(products.values());

        if (ascending) {
            sortedProducts.sort(Comparator.comparingDouble(Product::getPrice));
        } else {
            sortedProducts.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        }

        System.out.println("Danh sách sản phẩm sau khi sắp xếp:");
        sortedProducts.forEach(System.out::println);
    }

    public static void main(String[] args) {

        addProduct();
        addProduct();

        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = sc.nextLine();
        searchProductByName(name);

        System.out.println("Sắp xếp sản phẩm theo giá tăng dần:");
        sortProductsByPrice(true);

        System.out.println("Sắp xếp sản phẩm theo giá giảm dần:");
        sortProductsByPrice(false);
    }
}
