package com.ocp17.java7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JdbcEnhancements {
    public static void main(String[] args) throws Exception {
      viewResults();
      createJdbcRowset();
    }
    private static void viewResults() throws Exception {
      try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/organization", "root", "root");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee");
      ) {
        while (rs.next()) {
          System.out.println(rs.getString("NAME") + " " + rs.getInt("AGE") + " " + rs.getString("DEPARTMENT"));
        }
      } catch (Exception ex) {
        throw ex;
      }
    }
    private static void createJdbcRowset() throws Exception {
      try (JdbcRowSet jrs = RowSetProvider.newFactory().createJdbcRowSet();) {
        jrs.setUrl("jdbc:mysql//localhost:3306/organization");
        jrs.setUsername("root");
        jrs.setPassword("root");
        jrs.setCommand("select * from employee");
        jrs.execute();
        while (jrs.next()) {
          System.out.println(jrs.getString("NAME") + "" + jrs.getInt("AGE") + "" + jrs.getString("DEPARTMENT"));
        }
      } catch (Exception ex) {
        throw ex;
      }
    }
}