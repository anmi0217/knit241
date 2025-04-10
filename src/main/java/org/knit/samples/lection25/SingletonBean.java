package org.knit.samples.lection25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    @Value("${knit.bean.name}")
    private String name;

    @Autowired
    private PrototypeBean bean;

    public String getName() {
        return name;
    }

    public void printSomth(){
        System.out.println(bean);
    }
}
