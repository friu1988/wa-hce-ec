package com.capa.presentacion;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author FREDDY
 */
public class Test {

    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("wa-hce-v2PU");
        EntityManager entitymanager = emfactory.createEntityManager();

//        //Scalar function
//        Query query = entitymanager.createQuery("Select UPPER(e.ename) from Employee e");
//        List<String> list = query.getResultList();
//
//        for (String e : list) {
//            System.out.println("Employee NAME :" + e);
//        }
        //Aggregate function
        Query sql = entitymanager.createQuery("Select MAX(e.hcl_serial) from THistoriaClinicaUnica e");
        String result = (String) sql.getSingleResult();
        System.out.println("Max Employee Salary :" + result);
    }
}
