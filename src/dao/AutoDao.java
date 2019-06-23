package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

import beans.Automobile;

@Component
@PropertySource(value = "classpath:message.property")
//@Repository - I am using component annotation for demo purpose only. Specifically Repository annotation should be used for Dao classes.
//Here I am not using Spring Dao. Rather using JDBC to show @value and environment property of Spring.
public class AutoDao {
	@Autowired
	private Environment environment;
	
	public Connection getMYSQLConnection() throws ClassNotFoundException, SQLException {
		Class.forName(environment.getProperty("driver"));
		return DriverManager.getConnection(environment.getProperty("url"),environment.getProperty("user"),environment.getProperty("password"));
	}
	
	public List<Automobile> getAuto() throws ClassNotFoundException, SQLException{
		List<Automobile> automobiles=new ArrayList();
		Connection connection=getMYSQLConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from automobile");
		while(resultSet.next()) {
			Automobile automobile=new Automobile();
			automobile.setAutoId(resultSet.getInt(1));
			automobile.setAutoName(resultSet.getString(2));
			automobile.setParent(resultSet.getString(3));
			automobile.setCountry(resultSet.getString(4));
			automobile.setSales(resultSet.getInt(5));
			automobile.setContinent(resultSet.getString(6));
			automobiles.add(automobile);
		}
		
		
		return automobiles;
	}
}
