package org.knit.solutions;

import lombok.extern.slf4j.Slf4j;
import org.knit.TaskDescription;

import java.io.Console;
import java.util.Arrays;

@Slf4j
@TaskDescription(taskNumber = 2, taskDescription = "Краткое описание задачи 2")
public class TaskExample2 implements Solution {

    public void execute() {
        System.out.println("Задача 2 запущена");

        Console console = System.console();
        log.info("console {}", console);
        if (console!=null){
            char[] chars = console.readPassword();
            log.info("password readed");
            if (Arrays.equals(chars, new char[]{'a','b','c'})){
                log.info("login ");
            } else {
                log.warn("not login");
            }
        }

    }
}
