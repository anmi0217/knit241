package org.knit.samples.lection25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    @Qualifier("simplDataBaseServiceImpl")
    private DataBaseService dataBaseService;
    private String name;

    public UserService(DataBaseServiceImpl dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void serve(){
        dataBaseService.runBase();
    }
}
