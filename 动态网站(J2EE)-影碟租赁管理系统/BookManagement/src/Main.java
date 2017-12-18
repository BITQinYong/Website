import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Main {
	public static void main(String[] args) throws SQLException{
		PreparedStatement ps=SQLMan.getConnection().prepareStatement("select * from BookInfo");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("bookType"));
		}
		
	}
}
