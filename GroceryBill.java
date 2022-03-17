
package j1.s.h201;

import java.util.ArrayList;
import java.util.List;

public class GroceryBill {
    
    List<Item> itemList = new ArrayList<>();
    
    Employee clerk;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
    }
    
    public void add(Item i){
        itemList.add(i);
    }
    
    public double getTotal(){
        double retTotal = 0;
        for(int i = 0; i < itemList.size();i++){
            retTotal += itemList.get(i).getPrice();
        }
        return retTotal;
    }
    
    public void printReceipt(){
        System.out.println("\nBill for " + clerk.getName());
        System.out.printf("%12s %11s %13s\n", "Item Name", "Price", "Discount");
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            System.out.printf("%d) %-15s %-10.2f %-10.2f\n", (i+1), item.getName(), item.getPrice(), item.getDiscount());
        }
    }
}
