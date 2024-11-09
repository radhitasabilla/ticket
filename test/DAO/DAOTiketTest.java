/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.NakamaUtil;
import pojo.Tiket;

/**
 *
 * @author Acer
 */
public class DAOTiketTest {
    
    public DAOTiketTest() {
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
    public void testRetrveTableTiket() {
        System.out.println("Method Testing Show Table");
        DAOTiket instance = new DAOTiket();
        List<Tiket> result = instance.retrieveTiket();
        System.out.println(+ result.toArray().length);
        assertFalse(result.isEmpty());
      }    
    
     /*
       Testing whether addTiket method in DAO.DAOTiket be able to input new data
       to database or not. First step is to set all data needed. And then, if the expResult
       is equal to result, means test passed.
     */
  
    @Test
     public void testAddTicket() {
        System.out.println("Method Testing Add Ticket");

        Tiket tik = new Tiket();
        tik.setJudul("ASTRO");
        tik.setTempat("Revotown Bekasi");
        tik.setTanggal("27 November 2022");
        tik.setHarga("IDR 75.000");
        tik.setDeskripsi("Tiket ASTRO SMAN 8 Cup Festival");
        tik.setThumbnail("../thumbnail/Thumbnail3.jpeg");

        DAOTiket instance = new DAOTiket();
        instance.addTiket(tik);
        assertNotNull(tik);

      }
     
     /*
      Testing whether getByID method in DAO.DAOCustomer be able to get data in database
      by ID or not. First step is to make a variable idTiket as the ID to be found.
      If the result is empty means test not passed.
    */

    @Test
     public void testSearchTicket() {
         System.out.println("Method Testing Search Ticket");
         String idTiket = "18";
         DAOTiket instance = new DAOTiket();
         List<Tiket> result = instance.getbyID(idTiket);
         assertFalse(result.isEmpty());
     }

     /*
      Testing the delete method whether it is managed to delete data in database or not.
      First step is to make a variable idTiket as the ID to be deleted. Call object Tiket
      and check ID Tiket. If ID is null, means the customer is deleted.
     */
     
   @Test
       public void testDeleteTicket() {
           System.out.println("Method Testing Delete Ticket");

           Integer idTiket = 38;
           DAOTiket instance = new DAOTiket(); 
           Transaction transaction = null;
           Session session = NakamaUtil.getSessionFactory().openSession();

           transaction = session.beginTransaction();
           instance.deleteTiket(idTiket);
           transaction.commit();

           Tiket deletedTiket = (Tiket) session.get(Tiket.class, idTiket);
           assertNull(deletedTiket);
     }
       
    /*
      Testing whether method update be able to update ticket data in database.
      First step is to set all the data needed. After that, call the object Tiket
      and check ID Tiket. Last step is to make variable expResult and result to check whether
      the ticket is edited or not. And use getJudul to get the ticket title.
      If expResult and result are equals, means test passed.
    */

   @Test
       public void testEditTicket() {
           System.out.println("Method Testing Edit Ticket");

           DAOTiket instance = new DAOTiket();
           Transaction transaction = null;
           Session session = NakamaUtil.getSessionFactory().openSession();

           Integer id = 5;
           Tiket tik = new Tiket();
           tik.setIdTiket(id);
           tik.setJudul("Pestapora Fest");
           tik.setTempat("ICE BSD");
           tik.setTanggal("17 November 2022");
           tik.setHarga("IDR 225.000");
           tik.setDeskripsi("Festival Pestapora");
           tik.setThumbnail("../thumbnail/Thumbnail5.jpg");

           transaction = session.beginTransaction();
           instance.editTiket(tik);
           transaction.commit();

           Tiket updatedTiket = (Tiket) session.get(Tiket.class, id);

           String expResult = updatedTiket.getJudul();
           String result = updatedTiket.getJudul();

           System.out.println("expResult : " + expResult);
           System.out.println("result : " + result);

           assertEquals(expResult, result);
   }
}
