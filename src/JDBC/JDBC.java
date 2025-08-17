package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:C:/sqlite/UniversityStudents.db";
        String uname = "richard_simplilearn";
        String password = "mypassword";
        String query = "select * from EngineeringStudents";


        try {
            Connection con = DriverManager.getConnection(url, uname, password);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String UniversityData = "";
                for (int i = 1; i <= 6; i++) {
                    UniversityData += result.getString(i) + ":";
                }
                System.out.println(UniversityData);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }
