/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Login;

/**
 *
 * @author Acer
 */
public class DAOLoginTest {
    
    public DAOLoginTest() {
    }
    
  @BeforeClass
  public static void setUpClass() {
    System.out.println("--- START TESTING ---");
  }
  
  @AfterClass
  public static void tearDownClass() {
    System.out.println("--- END TESTING ---");
  }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        System.out.println("\n");
    }
    
     /* 
        Testing method login user in DAO.DAOLogin. This method is used to login admin. 
        First step is to set all the data needed. Fill the data with valid username and password. 
        And then, make expResult. If expResult and result are equal, means test passed.
     */
    
    @Test
    public void testLogin() {
        System.out.println("Method Testing Login");

        Login instance = new Login();
        instance.setUsername("rahma");
        instance.setPassword("rahma"); 

        String expResult = "AdminMainMenu";
        String result = instance.login_user();
        System.out.println("expResult : " + expResult);
        System.out.println("result : " + result);
        assertEquals(expResult, result);
      }

    
     /*  
        Testing to search admin's data in database. First step is to set variable uName and uPass 
        and fill them with valid uername and password. Then turn variable result into array. 
        If array length is equal to 0, means the admin is unavailable and test not passed.
    */  
    
    @Test
    public void testSearchLogin() {
        System.out.println("Method Testing Search Data Login");
        String uName = "rahma";
        String uPass = "rahma";   
        int empty = 0;
        DAOLogin instance = new DAOLogin();
        List<Login> result = instance.getBy(uName, uPass);
        System.out.println(result.toArray().length);
        assertThat(result.toArray().length, is(not(equalTo(empty))));
      } 
  

}
