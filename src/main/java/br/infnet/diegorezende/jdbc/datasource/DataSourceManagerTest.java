package br.infnet.diegorezende.jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceManagerTest {
    public static void main(String[] args) {
        System.out.println("**********");
        testDataSource();
        System.out.println("**********");


    }

    private static void testDataSource() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = DataSourceManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id, nome from museus_db.MUSEUS");
            while(rs.next()){
                System.out.println("Museu ID="+rs.getInt("id")+", Nome="+rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
