package kr.ac.kookmin.embedded.sales;

/**
 * Class for a sale of one item with discount expressed as a percent of the
 * price, but no other adjustments. Class invariant: The price is always
 * nonnegative; the name is a nonempty string; the discount is always
 * nonnegative.
 */

public class DiscountSale extends Sale {
	private double	discount;	// A percent of the price. Cannot be negative.
								
	public DiscountSale() {
		/** ���� �Ͻÿ� **/ 
		discount =0;
	}
	
	/**
	 * Precondition: theName is a nonempty string; thePrice is nonnegative;
	 * theDiscount is expressed as a percent of the price and is nonnegative.
	 */
	public DiscountSale(String theName, double thePrice, double theDiscount) {
		/** ���� �Ͻÿ� **/ 
		setName(theName);
		setPrice(thePrice);
		setDiscount(theDiscount);
	}
	
	public DiscountSale(DiscountSale originalObject) {
		/** ���� �Ͻÿ� **/
		if (originalObject == null) {
			System.out.println("Error: null Sale object.");
			System.exit(0);
		}
		// else
		discount = originalObject.discount;
	}
	
	public static void announcement() {
		System.out.println("This is the DiscountSale class.");
	}
	
	public double bill() {
		/** ���� �Ͻÿ� **/ 
		double fraction = discount/100;
        return (1 - fraction)*getPrice( );
	
	}
	
	public double getDiscount() {
		/** ���� �Ͻÿ� **/ 
		return discount;
	}
	
	/**
	 * Precondition: Discount is nonnegative.
	 */
	public void setDiscount(double newDiscount) {
		/** ���� �Ͻÿ� **/ 
		if (newDiscount >= 0)
			discount = newDiscount;
		else {
			System.out.println("Error: Negative price.");
			System.exit(0);
		}
	}
	
	public String toString() {
		return (getName() + " Price = $" + getPrice() + " Discount = " + discount + "%\n" + "   Total cost = $" + bill());
	}
	
	public boolean equals(Object otherObject) {
		/** ���� �Ͻÿ� **/ 
		if (otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		else {
			DiscountSale otherDiscountSale = (DiscountSale) otherObject;
			return (super.equals(otherDiscountSale) && discount == otherDiscountSale.discount);
		}
	}
	
	
	public DiscountSale clone() {
		/** ���� �Ͻÿ�....  �ӽû����� ��� **/ 
		return new DiscountSale(this);
	}
}