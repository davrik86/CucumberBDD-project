package DBtest;

import org.testng.annotations.Test;
import utilities.DBUtils;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dbTestDemo {
    String query="select *from CraterDBS.invoices order by invoice_number desc;";
    @Test
    public void testDB(){
        String dbURL="jdbc:mysql://stack-overflow.cfse9bqqndon.us-east-1.rds.amazonaws.com/CraterDBS";
        String userName="craterdbuser";
        String password="ptschool2023";

//        1.Step one create connection
        try {
            Connection connection = DriverManager.getConnection(dbURL,userName,password);

//            2.Create a stetement
            Statement statement= connection.createStatement();


//            3. Execute query
            ResultSet resultSet=statement.executeQuery(query);
            ResultSetMetaData rsmd= resultSet.getMetaData();
            int coulmCount = rsmd.getColumnCount();

            for (int i = 1; i <coulmCount ; i++) {
//                System.out.println("Column count is  "+ rsmd.getColumnName(i));
//                System.out.println("Coulmn type is "+rsmd.getColumnType(i));
//                System.out.println("Column display size is "+rsmd.getColumnDisplaySize(i));
            }
            List<String> data= new ArrayList<>();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("invoice_number"));

                List<String> row = new ArrayList<>();
                for (int i = 1; i < coulmCount; i++) {
                    row.add(resultSet.getString(i));

                }
//                data.add
            }

        } catch (SQLException e) {
            System.out.println("Connection not successful");
            e.printStackTrace();
        }


    }
    @Test
    public void testDemowithUtils(){
        DBUtils.executeQuery(query);
    }

}
