public class Originator {
    private String name;

    private String pc;

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Name :"+ name);
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
        System.out.println("PC :" + pc);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println("Price :" + price);
    }

    //push
    public Memento saveMemento(){
        System.out.println();
        System.out.println("Saving.......");
        System.out.println();
        return new Memento(name,pc,price);
    }

    //revert
    public void restoreMemento(Memento memento){
        System.out.println();
        System.out.println("Reverting.....");
        System.out.println();
        this.setName(memento.getName());
        this.setPc(memento.getPc());
        this.setPrice(memento.getPrice());
    }



}
