package org.knit.samples.lection25;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {
    public void printConfig(){
        System.out.println("prototype bean hash "+hashCode());
    }
}
