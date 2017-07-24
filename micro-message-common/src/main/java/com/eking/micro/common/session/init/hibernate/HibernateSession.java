package com.eking.micro.common.session.init.hibernate;

import com.eking.micro.common.port.adapter.persistence.hibernate.HibernateEventStore;
import com.eking.micro.common.spring.SpringHibernateSessionProvider;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by liuxingjia on 2017/7/3.
 */
@Component
public class HibernateSession {
    @Bean(name = "sessionProvider", value = "sessionProvider", autowire = Autowire.BY_NAME)
    public SpringHibernateSessionProvider sessionProvider() {


        SpringHibernateSessionProvider springHibernateSessionProvider = new SpringHibernateSessionProvider();
        return springHibernateSessionProvider;
    }
    @Bean(name = "sessionFactory", value = "sessionFactory", autowire = Autowire.BY_NAME)
    public SessionFactory sessionFactory() {
        //默认读取hibernate.cfg.xml文件
        Configuration config = new Configuration().configure();

        //在Hibernate 3中
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        return sessionFactory;
    }

    @Bean
    public HibernateEventStore eventStore() {
        return new HibernateEventStore();
    }
}
