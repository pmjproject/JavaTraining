package factory;

public class PhoneFactory {
    public Phone getPhone(String type){
        if(type == null){
            return null;
        }else if(type.equalsIgnoreCase("Expencive Price")){
            return new Iphone();

        }else if(type.equalsIgnoreCase("Middle Price")){
            return new SamsungPhone();
        }else if(type.equalsIgnoreCase("Low Price")){
            return new HuwaviPhone();
        }
        return null;
    }
}
