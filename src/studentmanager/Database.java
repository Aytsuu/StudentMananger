// This file performs all databasee connections and queries (actions)

package studentmanager;
import java.sql.*;

public class Database{
   
   // Declaring and Initializing variables
   public Connection connect; 
   public ResultSet rs;
   public Statement st;
   public PreparedStatement ps;
   
   public String user = "root";
   public String pass = "";
   public String url = "jdbc:mysql://localhost:3306/students";
   
   // This method performs adding of data to the database
   public void add(String ID, String Name, String Age, String Email){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connect = DriverManager.getConnection(url,user,pass);
           String sql = "insert ignore into list(ID, Name, Age, Email) values(?, ?, ?, ?)";
           ps = connect.prepareStatement(sql);
           
           ps.setString(1, ID);
           ps.setString(2,Name);
           ps.setString(3,Age);
           ps.setString(4,Email);
           
           ps.executeUpdate();

       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   // This method returns the last id in the database or the missing id in the sequence
   public String validID(){
       String lastVal="";
       int x = 0;
       int startNum = 1000;
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connect = DriverManager.getConnection(url,user,pass);
           st = connect.createStatement();
           rs = st.executeQuery("Select * From list Order by ID");
           
           while(rs.next()){
               if((startNum + x) == Integer.parseInt(rs.getString("ID"))){
                   lastVal = rs.getString("ID");
               }
               else{
                   return String.valueOf(startNum + x - 1);
               }
               x++;
           }
     
       }catch(Exception e){  
           e.printStackTrace();
       }
    return lastVal;
   }
   
   // This method performs the removal of data in the database
   public void remove(String id){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connect = DriverManager.getConnection(url,user,pass);
           ps = connect.prepareStatement("Delete From list Where ID = '" + id + "'");
           ps.executeUpdate();
	   
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   // This method performs updating of a specified data in the database
   public void update(String id, String Name, String Age, String Email){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connect = DriverManager.getConnection(url,user,pass);
           ps = connect.prepareStatement("UPDATE list SET Name = '" + Name + "', Age = '" + Age + "', Email = '" + Email + "' WHERE ID = '" + id + "'");
           ps.executeUpdate();
           
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   // This method clears all the data in the database
   public void clear(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           connect = DriverManager.getConnection(url,user,pass);
           ps = connect.prepareStatement("Delete From list");
           ps.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }
   }
}
