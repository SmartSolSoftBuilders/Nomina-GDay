import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;


public class JsonTest2 {

	public static void main(String[] args) throws Exception, IOException, SQLException { 
		Class.forName("org.postgresql.Driver"); 
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nominas-gday", "postgres", "root"); 

		PreparedStatement ps =conn.prepareStatement
		("select json from  \"Test\"");
			try { 
			conn.setAutoCommit(false); 
			//File file = new File("c://test//1.docx"); 
			//fis = new FileInputStream(file); 
			//System.out.println(file.length());
			 FileOutputStream fileOuputStream = 
		             new FileOutputStream("C://test//t4.txt"); 
			ResultSet rs = ps.executeQuery();
			
            while (rs.next())
             {
                String name_json=rs.getString("json");
                
                System.out.println(name_json);
                JSONArray arrayObj=new JSONArray();
                arrayObj.
                System.out.println(arrayObj);
                
             }
			ps.close(); 

			} 
			
			catch (Exception e) {
				System.out.println(""+e.getMessage());
				e.printStackTrace();
				
			} 
	}
}
