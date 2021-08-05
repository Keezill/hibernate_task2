package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                /*Map<String,String> jdbcUrlSettings = new HashMap<>();
                String jdbcDbUrl = System.getenv("postgresql://putjsocerlotgn:1c5177b1935894a15341b640381be303e158aa216bbb9a8352f934fe72af29b4@ec2-54-236-137-173.compute-1.amazonaws.com:5432/d8hg33f6032gns");
                if (null != jdbcDbUrl) {
                    jdbcUrlSettings.put("hibernate.connection.url", System.getenv("postgres://putjsocerlotgn:1c5177b1935894a15341b640381be303e158aa216bbb9a8352f934fe72af29b4@ec2-54-236-137-173.compute-1.amazonaws.com:5432/d8hg33f6032gns"));
                }

                registry = new StandardServiceRegistryBuilder().
                        configure("hibernate.cfg.xml").
                        applySettings(jdbcUrlSettings).
                        build();*/
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
