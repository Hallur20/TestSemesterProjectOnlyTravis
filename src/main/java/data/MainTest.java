/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Entities.User;
import java.sql.*;

/**
 *
 * @author hallur
 */
public class MainTest {

    public static void main(String args[]) throws SQLException {
  DataMapper dataMapper = new DataMapper();        
        dataMapper.setDataSource(new DataSource().getDataSource());

        User user = dataMapper.getUser(1);
        
        System.out.println("User: " + user);
    }
}
