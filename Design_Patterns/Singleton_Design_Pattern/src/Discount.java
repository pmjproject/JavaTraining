public class Discount {

    private static Double discount;
    private Discount(){

    }

    public static Double getDiscount(){
        if (discount==null){
            synchronized (Discount.class){
                if (discount==null)
                    discount = new Double(12);
            }

        }
        return discount;
    }
}
