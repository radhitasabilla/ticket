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
import pojo.Login;
import pojo.NakamaUtil;

/**
 *
 * @author Acer
 */
public class DAOLogin {
     public List<Login> getBy(String uName, String uPass){
         Transaction trans  = null;
        Login us = new Login();
        List<Login> user = new ArrayList();
         Session session = NakamaUtil.getSessionFactory().openSession();
         try{
             trans = session.beginTransaction();
             Query query = session.createQuery("from Login where username=:uName AND password=:uPass ");
             query.setString("uName", uName);
             query.setString("uPass", uPass);
             us = (Login) query.uniqueResult();
             user = query.list();
             trans.commit();
         }
         catch (Exception e){
              System.err.println(e);
         } 
         return user;
    }
     }
     
