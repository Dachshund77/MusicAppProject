package Database;

//Step 1 import libs
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DB {

    private static String port;
    private static String databaseName;
    private static String userName;
    private static String password;

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    /*
      Static initializer
      This will be called whenever we use the DB class to setup the class fields.
     */
    private DB(){

    }
    static {
        Properties props = new Properties();
        String fileName = "src/db.properties";
        InputStream input;
        try {
            input = new FileInputStream(fileName);
            props.load(input);
            port = props.getProperty("port", "1433");
            databaseName = props.getProperty("databaseName");
            userName = props.getProperty("userName", "sa");
            password = props.getProperty("password");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Step 2
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public static boolean execute(String statement){
        conn = null;
        ps = null;
        try {
            //Step 3 open connection
            connect();
            //Step 4 Execute query
            ps = conn.prepareStatement(statement);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            cleanUp();
        }
        return true;
    }

    public static ArrayList<Object[]> select(String statement) {
        conn = null;
        ps = null;
        ArrayList<Object[]> returnArrayList = new ArrayList<>();
        try {
            //Step 3 open connection
            connect();
            //Step 4 Execute query
            ps = conn.prepareStatement(statement);
            rs = ps.executeQuery();
            Integer noOfColumns = rs.getMetaData().getColumnCount();
            //Structuring return data
            while (rs.next()){
                Object[] tempArray = new Object[noOfColumns];
                for (int i = 0; i < tempArray.length; i++) {
                    tempArray[i] = rs.getObject(i+1);
                }
                returnArrayList.add(tempArray);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp();
        }
        return returnArrayList;
    }

    public static boolean executeWithFile(String statement, File file){
        conn = null;
        ps = null;
        try {
            //Step 3 open connection
            connect();
            //Step 4 Execute query
            ps = conn.prepareStatement(statement);
            ps.setBinaryStream(1, new FileInputStream(file),(int)file.length());
            ps.executeUpdate();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }finally {
            cleanUp();
        }
        return true;
    }


    private static void connect(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:" + port, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void cleanUp(){
        try{
            if (ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
            if (rs != null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
