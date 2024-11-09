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
public class TiketTest {
    
    public TiketTest() {
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
    Tiket instance = new Tiket();
    int expResult = 20;
    List<Tiket> result = instance.getAllRecords();
    assertEquals(expResult, result.toArray().length);
  }
  
   /*
    Testing getById method managed to show data by ID. First step is set ID Ticket.
    Make variable expResult. If expResult and result are equals, means test passed.
   */
    
    @Test
    public void testGetById() {
        System.out.println("Method Testing Search Ticket by Id");

        Tiket instance = new Tiket();
        instance.setIdTiket(1);

        String expResult = "AdminEdit";
        String result = instance.getById();

        System.out.println("expResult : " + expResult);
        System.out.println("result : " + result);

        assertEquals(expResult, result);
      }
  
   /*
    Testing save_user method that used to add new content in AdminMainMenu.xhtml.
    First step is to set all the data needed. Then, make variable expResult. 
    If expResult is equal to outcomes from save_user method, means test pssed.
   */
    
    @Test
    public void testAddTicket() {
        System.out.println("Method Testing Payment");

        Tiket instance = new Tiket();
        instance.setJudul("Maxident Stray Kids");
        instance.setTempat("ICE BSD");
        instance.setTanggal("01 Desember 2022");
        instance.setHarga("IDR 2.350.000");
        instance.setDeskripsi("Maxident Stray Kids");
        instance.setThumbnail("../thumbnail/Thumbnail6.jpg^");

        String expResult = "AdminMainMenu";
        String result = instance.save_user();

        System.out.println("expResult : " + expResult);
        System.out.println("result : " + result);

        assertEquals(expResult, result);
    }

   /*
    Testing edit() method that used to update data ticket in database.
    First step is to set all the data needed. And then, make variable expResult.
    If expResult and result are equal, means test passed.
   */
    
    @Test
    public void testEditCustomer() {
        System.out.println("Method Testing Edit Ticket");

        Tiket instance = new Tiket();
        instance.setIdTiket(29);
        instance.setJudul("Maxident Stray Kids");
        instance.setTempat("Ancol");
        instance.setTanggal("01 Desember 2022");
        instance.setHarga("IDR 2.350.000");
        instance.setDeskripsi("Maxident Stray Kids");
        instance.setThumbnail("../thumbnail/Thumbnail6.jpg^");

        String expResult = "AdminEdit";
        String result = instance.edit();

        System.out.println("expResult : " + expResult);
        System.out.println("result : " + result);

        assertEquals(expResult, result);
    }
    
   /*
    Testing delete() method that used to delete ticket by ID. First step is
    set ID ticket that needed to be deleted. Next is make variable expResult.
    If expResult and result are equals, means test passed.
  */

    @Test
    public void testDeleteTicket() {
        System.out.println("Method Testing Delete Ticket");

        Tiket instance = new Tiket();
        instance.setIdTiket(30);

        String expResult = "AdminEdit";
        String result = instance.delete();

        assertEquals(expResult, result);
      }
}
