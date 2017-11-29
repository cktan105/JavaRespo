import java.sql.*;

public class MavenDemo
{
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stat = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sa45", "root", "password");
			
			stat = conn.createStatement();
			String sql = "SELECT * FROM students";
			ResultSet rs = stat.executeQuery(sql);
			
			while (rs.next())
			{
				System.out.println(rs.getInt(1) + ":\t" + rs.getString(2));
			}
			
		}
		catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				stat.close();
				conn.close();
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage());
			}
			
		}
	}
}
