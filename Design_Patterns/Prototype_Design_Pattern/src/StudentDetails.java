public class StudentDetails implements Prototype{
    private int id;
    private String name;
    private int grade;
    private String address;

    public StudentDetails(int id,String name,int grade,String address){
        this.id = id;
        this.name=name;
        this.grade = grade;
        this.address = address;

    }

    public void showDetails(){

        System.out.println(id+"\t"+name+"\t"+address+"\t"+grade);
    }

    @Override
    public Prototype getClone() {

        return new StudentDetails(id,name,grade,address);
    }


}
