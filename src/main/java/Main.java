import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        //один раз мы эту процедуру делаем, лучше б в отдельном классе, но можно и вот так:
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata  metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        // теперь получаем сессию
        Session session = sessionFactory.openSession();

        // одной такой строчкой теперь мы просто можем получить строчку из бд
        Course course = session.get(Course.class, 1);
        System.out.println(course.getName());

        // закрываем
        sessionFactory.close();

    }
}