/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Customer;
import pojo.NakamaUtil;

/**
 *
 * @author Acer
 */

//menampilkan data ke table 
public class DAOCustomer {
    public List<Customer> retrieveCustomer(){
        List stud = new ArrayList();
        Customer stud1 = new Customer();
        Transaction trans = null;
        Session session = NakamaUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Customer");
            stud = query.list();
            stud.add(stud1.getIdCustomer());
            stud.add(stud1.getNama());
            stud.add(stud1.getEmail());
            stud.add(stud1.getTelp());
            stud.add(stud1.getKtp());

            trans.commit();;
        }
        catch(Exception e){
            System.out.println(e);}
        return stud;
    }
    
    
 //mencari data untuk bisa edit delete insert data   
    public List<Customer> getbyID(String idU){
        Customer usr = new Customer();
        List<Customer> iUsr = new ArrayList();
        Transaction trans = null;
        Session session = NakamaUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Customer where id_customer = :id");
            query.setString("id", idU);
            usr = (Customer) query.uniqueResult();
            iUsr = query.list();
            trans.commit();
        }catch(Exception e){
            System.out.println(e);
        }
        return iUsr;
    }
    
    public void deleteCustomer(int idU)
    {
        Transaction trans = null;
        Session session = NakamaUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Customer usr = (Customer) session.load(Customer.class, new Integer(idU));
            session.delete(usr);
            trans.commit();
        }catch(Exception e){
            System.out.println(e);}
    }
    
    public void editCustomer(Customer usr){
        Transaction trans = null;
        Session session = NakamaUtil.getSessionFactory().openSession();
        try 
        {
            trans = session.beginTransaction();
            session.update(usr);
            trans.commit();
        }
        catch (Exception e) {
            System.out.println(e);
    }
    }

     public String addCustomer(Customer user){
     Transaction trans = null;
     Session session = NakamaUtil.getSessionFactory().openSession();
     try
     {
         trans = session.beginTransaction();
         session.save(user);
         trans.commit();
     }catch(Exception e){
         System.out.println(e);
     }
        return "PaymentMessage";
     }

}


    



