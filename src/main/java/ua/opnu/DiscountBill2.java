package ua.opnu;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountBill2 {

    private GroceryBill innerBill;
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.innerBill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    public void add(Item item) {
        innerBill.add(item);
        if (regularCustomer && item.getDiscount() > 0.0) {
            this.discountCount++;
            this.discountAmount += item.getDiscount();
        }
    }

    public double getTotal() {
        double originalTotal = innerBill.getTotal();
        double total = originalTotal - this.discountAmount;
        return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public int getDiscountCount() {
        return this.discountCount;
    }

    public double getDiscountAmount() {
          return BigDecimal.valueOf(this.discountAmount).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getDiscountPercent() {
        double originalTotal = innerBill.getTotal();
        if (originalTotal == 0) {
            return 0.0;
        }

        double percent = (this.discountAmount * 100) / originalTotal;
        return BigDecimal.valueOf(percent).setScale(13, RoundingMode.HALF_UP).doubleValue();
    }

    public Employee getClerk() {
        return innerBill.getClerk();
    }
}
