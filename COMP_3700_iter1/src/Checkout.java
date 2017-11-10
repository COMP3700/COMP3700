import java.util.*;

public class Checkout {
    private int id;
    private double totalPrice;
    private ArrayList<Product> productList = new ArrayList<Product>();
    private String customerName;

//    public void addItemToCheckout(Product product) {
//        //Add an item at the end of the list
//        productList.add(product);
//    }
//
//    public double calculateTotalPrice() {
//        double total = 0;
//
//        for(int i = 0; i < productList.size() - 1; i++) {
//            Product prod = productList.get(i);
//            total = total + prod.getPrice();
//        }
//
//        return total;
//    }

    public int getId(){
        return id;
    }
    public void setId(int newId){
        this.id = newId;
    }
    public double getTotalPrice(){
        return  totalPrice;
    }
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }
    public void addToTotalPrice(double toAdd){
        this.totalPrice += toAdd;
    }
    public void addToProductList(Product productIn){

//        for (int i = 0; i < quantity; i++) {
            productList.add(productIn);
//        }
    }
    public ArrayList<Product> getProductList(){
        return productList;
    }

}
