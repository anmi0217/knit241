package org.knit.samples.lection25;

import org.springframework.stereotype.Component;

@Component
public class DataBaseServiceImpl implements DataBaseService {
    void run(){
        System.out.println("database Service");
    };

    @Override
    public void runBase() {
        System.out.println("runBase runBase");
    }
}
