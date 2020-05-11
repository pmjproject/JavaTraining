public class Discount {

    private static Discount discount;

    private Discount(){

    }

    public static Discount getInstance(){
        if (discount==null){
            synchronized (Discount.class){
                if (discount==null)
                    discount = new Discount();
            }

        }
        return discount;
    }
    public Double getDiscount(double i){
        double discountValue;

       if(i>100) {
           if (i < 500) {
               discountValue = 50.00;
           } else {
               discountValue = 150.00;
           }
       }else {
           discountValue = 0.00;
       }
        return discountValue;
    }


}
