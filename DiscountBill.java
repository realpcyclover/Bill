package j1.s.h201;

public class DiscountBill extends GroceryBill {

    private boolean isPreferredCustomer =false;

    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        isPreferredCustomer = preferred;
    }

    public int getDiscountCount() {
        int countDiscount = 0;
        if (isPreferredCustomer) {
            for (int i = 0; i < itemList.size(); i++) {
                if (itemList.get(i).getDiscount() > 0) {
                    countDiscount++;
                }
            }
        } 
        return countDiscount;
    }

    public double getDiscountAmount() {
        double retAmount = 0;
        if (isPreferredCustomer) {
            for (int i = 0; i < itemList.size(); i++) {
                retAmount += itemList.get(i).getDiscount();
            }
        }
        return retAmount;
    }

    public double getDiscountPercent() {
        double grossTotal = super.getTotal();
        return (getDiscountAmount() / grossTotal) * 100;
    }

    @Override
    public double getTotal() {
        if (!isPreferredCustomer) {
            return super.getTotal();
        }
        return super.getTotal() - getDiscountAmount();
    }

    @Override
    public void printReceipt() {
        System.out.println("\nBill for " + clerk.getName());
        System.out.printf("%12s %11s %13s\n", "Item Name", "Price", "Discount");
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            System.out.printf("%d) %-15s %-10.2f %-10.2f\n", (i + 1), item.getName(), item.getPrice(), item.getDiscount());

        }
        System.out.printf("No.Discounted Items: %d \n", getDiscountCount());
        System.out.printf("Total Amount: %.2f \n", super.getTotal());
        System.out.printf("Discount: %.2f (%.2f%%)\n", getDiscountAmount(), getDiscountPercent());
        System.out.printf("Bill after Discount: %.2f - %.2f = %.2f \n", super.getTotal(), getDiscountAmount(), super.getTotal() - getDiscountAmount());
    }
}
