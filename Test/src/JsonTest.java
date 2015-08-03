import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.simple.JSONArray;




public class JsonTest {

	public static void main(String[] args) throws Exception, IOException, SQLException {
		
		Class.forName("org.postgresql.Driver"); 
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nominas-gday", "postgres", "root"); 
		String INSERT_PICTURE = "insert into  \"Test\"(json) values (?)"; 

		FileInputStream fis = null; 
		PreparedStatement ps =conn.prepareStatement
		("insert into \"Test\"(json3) values (?)");
			try { 
			conn.setAutoCommit(false); 
			String cadena;
			 FileReader f = new FileReader("c://test//t1.txt");
		        BufferedReader b = new BufferedReader(f);
		        while((cadena = b.readLine())!=null) {
		        	cadena+=cadena;
		        	  System.out.println(cadena);
		        }
		        JSON arrayObj=new JSONArray();
		        arrayObj.add(cadena);
		        System.out.println("-"+arrayObj);
			ps.setObject(1, arrayObj.get(0));
			ps.executeUpdate(); 
			conn.commit();
			ps.close(); 


			} 
			
			catch (Exception e) {
				System.out.println(""+e.getMessage());
				e.printStackTrace();
				
			}
	}

}
