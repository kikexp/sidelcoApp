/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.*;
import javax.swing.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Modelos.*;

/**
 *
 * @author Pc-desarrollo
 */
public class Operaciones {
    
    public void alta(Object objeto) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(objeto);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Agregado correctamente");
    }
   
    public void modificacion(Object objeto) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.update(objeto);
        tx.commit();
        session.close();
        JOptionPane.showMessageDialog(null, "Modificado correctamente");
    }
    
    
    public Clientes buscarCliente(int numC) {
        Clientes cli;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        cli  = (Clientes) session.get(Clientes.class,  numC);
        tx.commit();
        session.close();
        
        return cli;
        
    }
    public DefaultListModel listarClientes() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();        
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Clientes");
        List<Clientes> lista = q.list();
        Iterator<Clientes> iter = lista.iterator();
        tx.commit();
        session.close();
        DefaultListModel dlm = new DefaultListModel();
        while(iter.hasNext()){
            Clientes c = (Clientes) iter.next();
            dlm.addElement(c);
        }
        
        return dlm;
    }
}
