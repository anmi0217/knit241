package org.knit.samples.lection25;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private SingletonBean bean;

    @Autowired
    private ObjectFactory<PrototypeBean> prototypeBeanObjectFactory;

    @Autowired
    private UserService userService;

    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Приложение стартовало");
        bean.printSomth();
        userService.serve();
        prototypeBeanObjectFactory.getObject().printConfig();
        prototypeBeanObjectFactory.getObject().printConfig();
        prototypeBeanObjectFactory.getObject().printConfig();
        prototypeBeanObjectFactory.getObject().printConfig();
        prototypeBeanObjectFactory.getObject().printConfig();
    }

}
