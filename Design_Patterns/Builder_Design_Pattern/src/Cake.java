public class Cake {

    private final double sugar;
    private final double butter;
    private final int eggs;
    private final int vanila;
    private final double flour;
    private final double bakingpowder;


    public static class Builder {

        private double sugar;
        private double butter;
        private int eggs;
        private int vanila;
        private double flour;
        private double bakingpowder;


        //builder methods for setting property
        public Builder sugar(double cup){this.sugar = cup; return this; }
        public Builder butter(double cup){this.butter = cup; return this; }
        public Builder eggs(int number){this.eggs = number; return this; }
        public Builder vanila(int spoon){this.vanila = spoon; return this; }
        public Builder flour(double cup){this.flour = cup; return this; }
        public Builder bakingpowder(double spoon){this.bakingpowder = spoon; return this; }



        //return  build object
        public Cake build() {
            return new Cake(this);
        }
    }


    private Cake(Builder builder) {
        this.sugar = builder.sugar;
        this.butter = builder.butter;
        this.eggs = builder.eggs;
        this.vanila = builder.vanila;
        this.flour = builder.flour;
        this.bakingpowder = builder.bakingpowder;

    }

    @Override
    public String toString() {
        return "Cake{" + "sugar=" + sugar + ", butter=" + butter + ", eggs=" + eggs + ", vanila=" + vanila + ", flour=" + flour + ", bakingpowder=" + bakingpowder + '}';

    }

}


