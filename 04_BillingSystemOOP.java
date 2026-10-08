import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name; this.price = price; this.quantity = quantity;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getAmount() { return price * quantity; }
}

class Bill {
    private List<Product> products = new ArrayList<>();
    private double taxRate;

    public Bill(double taxRate) { this.taxRate = taxRate; }
    public void addProduct(Product product) { products.add(product); }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Product p : products) subtotal += p.getAmount();
        return subtotal;
    }

    public double calculateTax() { return calculateSubtotal() * taxRate; }
    public double calculateTotal() { return calculateSubtotal() + calculateTax(); }

    public void displayBill() {
        System.out.println("\n============================== BILL ==============================");
        System.out.printf("%-20s %10s %8s %12s%n", "Product", "Price", "Qty", "Amount");
        System.out.println("------------------------------------------------------------------");
        for (Product p : products)
            System.out.printf("%-20s ₹%9.2f %8d ₹%11.2f%n",
                    p.getName(), p.getPrice(), p.getQuantity(), p.getAmount());
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-40s ₹%11.2f%n", "Subtotal:", calculateSubtotal());
        System.out.printf("%-40s ₹%11.2f%n", "Tax (18%):", calculateTax());
        System.out.printf("%-40s ₹%11.2f%n", "Final Total:", calculateTotal());
        System.out.println("==================================================================");
    }
}

public class BillingSystemOOP {
    public static void main(String[] args) {
        System.out.println("===== OOP BILLING SYSTEM =====");
        Bill bill = new Bill(0.18);
        bill.addProduct(new Product("Laptop Bag", 1200, 2));
        bill.addProduct(new Product("Wireless Mouse", 750, 1));
        bill.addProduct(new Product("Keyboard", 1500, 1));
        bill.addProduct(new Product("USB Cable", 300, 3));
        bill.displayBill();
    }
}
