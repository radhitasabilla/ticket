/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.List;
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
public class CustomerTest {
    
    public CustomerTest() {
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
    mengetes method getAllRecord apakah berhasil menampilkan semua produk pada
    table. Untuk mengujinya, saya menggunakan variabel test yaitu expResult yang 
    berupa jumlah seluruh produk yang ada. Setelah itu, saya mengubah variabel
    result menjadi array. Selajutnya, bandingkan panjang array tersebut dengan 
    expresult. Jika hasilnya sama, maka test berhasil.
  */
  /*@Test
  public void testGetAllRecords() {
    System.out.println("Method Testing Get All Records");
    Customer instance = new Customer();
    int expResult = 46;
    List<Customer> result = instance.getAllRecords();
    assertEquals(expResult, result.toArray().length);
  }
    
   /*
    Testing getById method managed to show data by ID. First step is set ID Customer.
    Make variable expResult. If expResult and result are equals, means test passed.
   */
    
  @Test
  public void testGetById() {
    System.out.println("Method Testing Search Customer by Id");
      
    Customer instance = new Customer();
    instance.setIdCustomer(1);
    
    String expResult = "PaymentHistory";
    String result = instance.getById();
    
    System.out.println("expResult : " + expResult);
    System.out.println("result : " + result);

    assertEquals(expResult, result);
  }
  
  /*
    Testing save_user method that used to add customer's data in PaymentForm.xhtml.
    First step is to set all the data needed. Then, make variable expResult. 
    If expResult is equal to outcomes from save_user method, means test pssed.
  */
  
  @Test
  public void testPayment() {
    System.out.println("Method Testing Payment");
    
    Customer instance = new Customer();
    instance.setNama("Felix");
    instance.setEmail("felixlee@gmail.com");
    instance.setTelp("085899873638");
    instance.setKtp("1223323553444");
    instance.setPembayaran("Gopay");
    
    String expResult = "PaymentMessage";
    String result = instance.save_user();
    
    System.out.println("expResult : " + expResult);
    System.out.println("result : " + result);

    assertEquals(expResult, result);
  }

  /*
    Testing edit() method that used to update data customer in database.
    First step is to set all the data needed. And then, make variable expResult.
    If expResult and result are equal, means test passed.
  */
  
  @Test
  public void testEditCustomer() {
    System.out.println("Method Testing Edit Customer");
    
    Customer instance = new Customer();
    instance.setIdCustomer(48);
    instance.setNama("Felix");
    instance.setEmail("felixlee00@gmail.com");
    instance.setTelp("085899873638");
    instance.setKtp("1223323553444");
    instance.setPembayaran("Gopay");
    
    String expResult = "PaymentHistory";
    String result = instance.edit();
    
    System.out.println("expResult : " + expResult);
    System.out.println("result : " + result);

    assertEquals(expResult, result);
  }

  /*
    Testing delete() method that used to delete customer by ID. First step is
    set ID customer that needed to be deleted. Next is make variable expResult.
    If expResult and result are equals, means test passed.
  */
  
  @Test
  public void testDeleteCustomer() {
    System.out.println("Method Testing Delete Customer");
    
    Customer instance = new Customer();
    instance.setIdCustomer(43);
    
    String expResult = "PaymentHistory";
    String result = instance.delete();
    
    assertEquals(expResult, result);
  }

}
