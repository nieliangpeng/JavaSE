package Modal;

import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class createDataBase {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String URL_new = "jdbc:mysql://localhost:3306/chater";
	private static final String USER="root";
	private static final String PSW="";
	private static String table="chater";
	private Connection conn=null;
	
	public void preparationInAdvance() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL,USER,PSW);
		
	}
	public void last() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL_new,USER,PSW);
		
	}
    public void createDatabaseAndTable() throws SQLException{
    	Statement statement = conn.createStatement();
    	try{
		statement.execute("create database chater");
    	}catch(Exception e){
    		System.out.println("数据库已经存在");
    	}
    	
		conn=DriverManager.getConnection(URL_new,USER,PSW);
		statement = conn.createStatement();
		DatabaseMetaData metaData = (DatabaseMetaData) conn.getMetaData();
		
		String[] type = {"table"};
		ResultSet rs = metaData.getTables(null, null, "user", type);//表类别（数据库），表模式，表名称，表类型
		//System.out.println("成功");
		if(rs.next()){
			System.out.println("数据库表存在");
		} else {
			statement.execute("create table user(name varchar(10)primary key ,password varchar(10) )");
		}
		//System.out.println("成功");
    }
    public void closeConnection() throws SQLException{
    	conn.close();
    }
    public int  insertTable(String name,String password) throws ClassNotFoundException, SQLException{
    	 last();
    	 PreparedStatement prestatment=conn.prepareStatement("insert into user(name,password) values(?,?)");
    	 prestatment.setString(1, name);
    	 prestatment.setString(2, password);
    	 int n=prestatment.executeUpdate();
    	 closeConnection();
    	 return n;
    }
    public int isExistUser(String name,String password) throws ClassNotFoundException, SQLException{
    	 int n=0;
    	 last();
    	 PreparedStatement prestatment=conn.prepareStatement("select* from user where name=? and password=?");
    	 prestatment.setString(1, name);
    	 prestatment.setString(2, password);
    	 ResultSet set=prestatment.executeQuery();
    	 if(set.next()){
    		 n=1;
    		
    	 }
    	 closeConnection();
    	 return n;
    }
}
