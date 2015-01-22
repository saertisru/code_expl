package DAO;

import Entity.Person;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import utils.HibernateUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shushkov
 * Date: 02.12.14
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
public class PersonDAO {


    public List<Person> getAll(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Person> result = session.createQuery("from Person").list();
        session.getTransaction().commit();
        return result;
    }
}
