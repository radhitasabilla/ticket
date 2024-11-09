/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Acer
 */
public class LoginTest {
    
    public LoginTest() {
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
    Testing method login_user that used to amin for login. First step is to
    set all the data needed. After that, make expResult. If the result and
    expResult are equals, means test pased.
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
}
