import java.io.*; 
  
class StringWrite { 
    public static void main(String[] args) 
    { 
  
        try { 
  
           
            Writer writer 
                = new PrintWriter(System.out); 
  
            
            
            
            
            writer.write("I love Dogs & Cats"); 
  
            writer.flush(); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
} 