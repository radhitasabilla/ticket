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
import pojo.Tiket;
import pojo.NakamaUtil;

/**
 *
 * @author Acer
 */

//menampilkan data ke table 
public class DAOTiket {
    public List<Tiket> retrieveTiket(){
        List stud = new ArrayList();
        Tiket stud1 = new Tiket();
        Transaction trans = null;
        Session session = NakamaUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Tiket");
            stud = query.list();
            stud.add(stud1.getIdTiket());
            stud.add(stud1.getJudul());
            stud.add(stud1.getTempat());
            stud.add(stud1.getTanggal());
            stud.add(stud1.getHarga());
            stud.add(stud1.getDeskripsi());
            trans.commit();;
        }
        catch(Exception e){
            System.out.println(e);}
        return stud;
    }
    
    
 //mencari data untuk bisa edit delete insert data   
    public List<Tiket> getbyID(String idU){
        Tiket usr = new Tiket();
        List<Tiket> iUsr = new ArrayList();
        Transaction trans = null;
        Session session = NakamaUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Tiket where id_tiket = :id");
            query.setString("id", idU);
            usr = (Tiket) query.uniqueResult();
            iUsr = query.list();
            trans.commit();
        }catch(Exception e){
            System.out.println(e);
        }
        return iUsr;
    }
    
    public void deleteTiket(int idU)
    {
        Transaction trans = null;
        Session session = NakamaUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Tiket usr = (Tiket) session.load(Tiket.class, new Integer(idU));
            session.delete(usr);
            trans.commit();
        }catch(Exception e){
            System.out.println(e);}
    }
    
    public void editTiket(Tiket usr){
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

     public void addTiket(Tiket user){
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
     }

  
}


    



