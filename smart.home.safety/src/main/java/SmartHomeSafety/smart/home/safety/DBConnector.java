package SmartHomeSafety.smart.home.safety;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

	public class DBConnector {
	    private Connection connect = null;
	    private Statement statement = null;
	    private PreparedStatement preparedStatement = null;
	    private ResultSet resultSet = null;

	    public void saveData() throws Exception {
	        try {
	            // This will load the MySQL driver, each DB has its own driver
	            Class.forName("com.mysql.jdbc.Driver");
	            // Setup the connection with the DB
	            connect = DriverManager
	                    .getConnection("jdbc:mysql://localhost/seas?"
	                            + "user=root");
	            
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            
	            // PreparedStatements can use variables and are more efficient
	            preparedStatement = connect
	                    .prepareStatement("insert into  seas.values values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");

	            // Parameters start with 1
	            preparedStatement.setFloat(1, SensorValues.kitchen_day_min_value);
	            preparedStatement.setFloat(2, SensorValues.kitchen_day_max_value);
	            preparedStatement.setFloat(3, SensorValues.kitchen_night_min_value);
	            preparedStatement.setFloat(4, SensorValues.kitchen_night_max_value);
	            preparedStatement.setFloat(5, SensorValues.livingroom_day_min_value);
	            preparedStatement.setFloat(6, SensorValues.livingroom_day_max_value);
	            preparedStatement.setFloat(7, SensorValues.livingroom_night_min_value);
	            preparedStatement.setFloat(8, SensorValues.livingroom_night_max_value);
	            preparedStatement.setFloat(9, SensorValues.bedroom_day_min_value);
	            preparedStatement.setFloat(10, SensorValues.bedroom_day_max_value);
	            preparedStatement.setFloat(11, SensorValues.bedroom_night_min_value);
	            preparedStatement.setFloat(12, SensorValues.bedroom_night_max_value);
	            preparedStatement.setFloat(13, SensorValues.bathroom_day_min_value);
	            preparedStatement.setFloat(14, SensorValues.bathroom_day_max_value);
	            preparedStatement.setFloat(15, SensorValues.bathroom_night_min_value);
	            preparedStatement.setFloat(16, SensorValues.bathroom_night_max_value);
	            preparedStatement.setFloat(17, SensorValues.kitchen_presence_min_value);
	            preparedStatement.setFloat(18, SensorValues.kitchen_presence_max_value);
	            preparedStatement.setFloat(19, SensorValues.livingroom_presence_min_value);
	            preparedStatement.setFloat(20, SensorValues.livingroom_presence_max_value);
	            preparedStatement.setFloat(21, SensorValues.bedroom_presence_min_value);
	            preparedStatement.setFloat(22, SensorValues.bedroom_presence_max_value);
	            preparedStatement.setFloat(23, SensorValues.bathroom_presence_min_value);
	            preparedStatement.setFloat(24, SensorValues.bathroom_presence_max_value);
	            preparedStatement.setString(25, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
	            preparedStatement.executeUpdate();

	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }

	    }

	    public void getData() throws Exception {
	    	try {
	    	Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/seas?"
                            + "user=root");
            
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
	    	resultSet = statement
                    .executeQuery("select * from seas.values");
	    	
	        while (resultSet.next()) {
	            SensorValues.kitchen_day_min_value = resultSet.getFloat("kdmin");
	            SensorValues.kitchen_day_max_value = resultSet.getFloat("kdmax");
	            SensorValues.kitchen_night_min_value = resultSet.getFloat("knmin");
	            SensorValues.kitchen_night_max_value = resultSet.getFloat("knmax");
	            
	            SensorValues.livingroom_day_min_value = resultSet.getFloat("ldmin");
	            SensorValues.livingroom_day_max_value = resultSet.getFloat("ldmax");
	            SensorValues.livingroom_night_min_value = resultSet.getFloat("lnmin");
	            SensorValues.livingroom_night_max_value = resultSet.getFloat("lnmax");
	            
	            SensorValues.bedroom_day_min_value = resultSet.getFloat("bdmin");
	            SensorValues.bedroom_day_max_value = resultSet.getFloat("bdmax");
	            SensorValues.bedroom_night_min_value = resultSet.getFloat("bnmin");
	            SensorValues.bedroom_night_max_value = resultSet.getFloat("bnmax");
	            
	            SensorValues.bathroom_day_min_value = resultSet.getFloat("btdmin");
	            SensorValues.bathroom_day_max_value = resultSet.getFloat("btdmax");
	            SensorValues.bathroom_night_min_value = resultSet.getFloat("btnmin");
	            SensorValues.bathroom_night_max_value = resultSet.getFloat("btnmax");
	            
	            SensorValues.kitchen_presence_min_value = resultSet.getFloat("kmin");
	            SensorValues.kitchen_presence_max_value = resultSet.getFloat("kmax");
	            
	            SensorValues.livingroom_presence_min_value = resultSet.getFloat("lmin");
	            SensorValues.livingroom_presence_max_value = resultSet.getFloat("lmax");
	            
	            SensorValues.bedroom_presence_min_value = resultSet.getFloat("bmin");
	            SensorValues.bedroom_presence_max_value = resultSet.getFloat("bmax");
	            
	            SensorValues.bathroom_presence_min_value = resultSet.getFloat("btmin");
	            SensorValues.bathroom_presence_max_value = resultSet.getFloat("btmax");
	        }
	    	} catch (Exception e) {
	            throw e;
	        } finally {
	            close();
	        }
	    }

	    // You need to close the resultSet
	    private void close() {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }

	            if (statement != null) {
	                statement.close();
	            }

	            if (connect != null) {
	                connect.close();
	            }
	        } catch (Exception e) {

	        }
	    }

}

