public class Application {

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setName("Mangalya Jayakody");
        originator.setPc("4482-133-111");
        originator.setPrice(25000.0);

        // Save
        CareTaker  careTaker = new CareTaker ();
        careTaker.setMemento(originator.saveMemento());

        // change
        originator.setName("Kamal");
        originator.setPc("6682-122-111");
        originator.setPrice(1000000.0);
        System.out.println("------------");

        originator.setName("Nimasha");
        originator.setPc("6682-122-111");
        originator.setPrice(1000000.0);

        // revert
        originator.restoreMemento(careTaker.getMemento());
    }
}
