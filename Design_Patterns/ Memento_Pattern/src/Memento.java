public class Memento {
    private String name;

    private String pc;

    private double price;

    public Memento(String name, String pc, double price) {
        super();
        this.name = name;
        this.pc = pc;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
