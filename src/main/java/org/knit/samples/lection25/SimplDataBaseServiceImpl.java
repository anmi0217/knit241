package org.knit.samples.lection25;

import org.springframework.stereotype.Component;

@Component
public class SimplDataBaseServiceImpl implements DataBaseService{
    @Override
    public void runBase() {
        System.out.println("simpleService");
    }
}
