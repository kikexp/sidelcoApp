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

     public void altaReg(Object objeto) {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(objeto);
        tx.commit();
        session.close();
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
        cli = (Clientes) session.get(Clientes.class, numC);
        tx.commit();
        session.close();

        return cli;

    }

    public Usuario buscarUsuario(String nomUs) {
        Usuario usu;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        usu = (Usuario) session.get(Usuario.class, nomUs);
        tx.commit();
        session.close();

        return usu;

    }

    public Factura buscarFactura(int idfac) {
        Factura fact;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        fact = (Factura) session.get(Factura.class, idfac);
        tx.commit();
        session.close();
        return fact;
    }

    public Cadetes buscarCadete(int idCad) {
        Cadetes cad;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        cad = (Cadetes) session.get(Cadetes.class, idCad);
        tx.commit();
        session.close();

        return cad;
    }

    public Comidas buscarComida(int idCom) {
        Comidas com;
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        com = (Comidas) session.get(Comidas.class, idCom);
        tx.commit();
        session.close();
        return com;
    }

    public List listarFacturas() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Factura order by IdFactura desc");
        List<Factura> lista = q.list();
        Iterator<Factura> iter = lista.iterator();
        tx.commit();
        session.close();
        return lista;
    }
    public List listarHistorial() {
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Historial order by fechayHora desc");
        List<Historial> lista = q.list();
        Iterator<Historial> iter = lista.iterator();
        tx.commit();
        session.close();
        return lista;
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
        while (iter.hasNext()) {
            Clientes c = (Clientes) iter.next();
            dlm.addElement(c);
        }

        return dlm;
    }
}
