/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Customer;
import DAO.DAOCustomer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NakamaUtil;

/**
 *
 * @author Acer
 */
public class DAOCustomerTest {
    
    public DAOCustomerTest() {
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
        Testing whether the method can retrieve data in database. 
        First step is to turn result into array.
        If the array in result is not empty, means test pssed.
    */
    
    @Test
    public void testRetrieveTableCustomer() {
        System.out.println("Method Testing Show Table");
        DAOCustomer instance = new DAOCustomer();
        List<Customer> result = instance.retrieveCustomer();
        System.out.println(+ result.toArray().length);
        assertFalse(result.isEmpty());
    }
  
     /*
       Testing whether addCustomer method in DAO.DAOCustomer be able to input new data
       to database or not. First step is to set all data needed. And then, if the expResult
       is equal to result, means test passed.
     */
    
    @Test
    public void testPayment() {
        System.out.println("Method Testing Payment");

        Customer user = new Customer();
        user.setNama("Zoa");
        user.setEmail("z0a@gmail.com");
        user.setTelp("085786973734");
        user.setKtp("1282928748498");
        user.setPembayaran("ShopeePay");

        DAOCustomer instance = new DAOCustomer();
        String expResult = "PaymentMessage";
        String result = instance.addCustomer(user);
        System.out.println("expResult : " + expResult);
        System.out.println("result : " + result);
        assertEquals(expResult, result);
    }
    
    /*
      Testing whether getByID method in DAO.DAOCustomer be able to get data in database
      by ID or not. First step is to make a variable idCustomer as the ID to be found.
      If the result is empty means test not passed.
    */
    
    @Test
    public void testGetById() {
        System.out.println("Method Testing Search Customer by Id");
        String idCustomer = "31";
        DAOCustomer instance = new DAOCustomer();
        List<Customer> result = instance.getbyID(idCustomer);
        assertFalse(result.isEmpty());
    }
    
    /*
      Testing the delete method whether it is managed to delete data in database or not.
      First step is to make a variable idCustomer as the ID to be deleted. Call object Customer
      and check ID customer. If ID is null, means the customer is deleted.
    */
    
    
    @Test
    public void testDeleteCustomer() {
        System.out.println("Method Testing Delete Customer");

        Integer idCustomer = 31;
        DAOCustomer instance = new DAOCustomer(); 
        Transaction transaction = null;
        Session session = NakamaUtil.getSessionFactory().openSession();

        transaction = session.beginTransaction();
        instance.deleteCustomer(idCustomer);
        transaction.commit();

        Customer deletedCustomer = (Customer) session.get(Customer.class, idCustomer);
        assertNull(deletedCustomer);
  }
    
    /*
      Testing whether method update be able to update customer data in database.
      First step is to set all the data needed. After that, call the object Customer
      and check ID customer. Last step is to make variable expResult and result to check whether
      the customer is edited or not. And use getNama to get the customer's name.
      If expResult and result are equals, means test passed.
    */
    
    @Test
    public void testEditCustomer() {
        System.out.println("Method Testing Edit Customer");

        DAOCustomer instance = new DAOCustomer();
        Transaction transaction = null;
        Session session = NakamaUtil.getSessionFactory().openSession();

        Integer id = 31;
        Customer customer = new Customer();
        customer.setIdCustomer(id);
        customer.setNama("Ayen");
        customer.setEmail("jeongin@gmail.com");
        customer.setTelp("0858897685647");
        customer.setKtp("11122993884558");
        customer.setPembayaran("BCA");

        transaction = session.beginTransaction();
        instance.editCustomer(customer);
        transaction.commit();

        Customer updatedCustomer = (Customer) session.get(Customer.class, id);

        String expResult = updatedCustomer.getNama();
        String result = updatedCustomer.getNama();
        
        System.out.println("expResult : " + expResult);
        System.out.println("result : " + result);

        assertEquals(expResult, result);
  }

}
