public class BuilderPattern {
    public static void main(String args[]) {

        //Creating object using Builder pattern
        Cake vanilaCake = new Cake.Builder().sugar(1).butter(0.5).  eggs(2).vanila(2).flour(1.5). bakingpowder(0.75) .build();


        System.out.println(vanilaCake);
    }


}
