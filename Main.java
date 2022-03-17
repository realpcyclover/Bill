
package j1.s.h201;

public class Main {
    public static void main(String[] args) {
        Item i1 = new Item("Shampoo", 10.555, 0.135);
        Item i2 = new Item("Tomatoes", 5.444, 2.111);
        Item i3 = new Item("Rice", 10.52, 5);
        
        DiscountBill dbill1 = new DiscountBill(new Employee("John"), true);
        
        dbill1.add(i1);
        dbill1.add(i2);
        dbill1.add(i3);
        
        DiscountBill dbill2 = new DiscountBill(new Employee("Bob"), false);
        
        dbill2.add(i1);
        dbill2.add(i2);
        dbill2.add(i3);
        
        dbill1.printReceipt();
        dbill2.printReceipt();
    }
}
