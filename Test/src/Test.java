import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 

public class Test { 
	

public static void main(String[] args) throws Exception, IOException, SQLException { 
Class.forName("org.postgresql.Driver"); 
Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nominas-gday", "postgres", "root"); 
String INSERT_PICTURE = "insert into  \"Test\"(archivo2) values (?)"; 

FileInputStream fis = null; 
PreparedStatement ps =conn.prepareStatement
("insert into \"Test\"(archivo2) values (?)");
	try { 
	conn.setAutoCommit(false); 
	File file = new File("c://test//4.BMP"); 
	fis = new FileInputStream(file); 
	System.out.println(file.length());
	ps.setBinaryStream(1, fis, (int) file.length()); 
	ps.executeUpdate(); 
	conn.commit();
	ps.close(); 
	fis.close(); 

	} 
	
	catch (Exception e) {
		System.out.println(""+e.getMessage());
		e.printStackTrace();
		
	} 
}

}