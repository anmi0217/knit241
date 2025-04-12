package org.knit.solutions.task20.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "org.knit.solutions.Task20.repository",
        "org.knit.solutions.Task20.crypto",
        "org.knit.solutions.Task20.security",
        "org.knit.solutions.Task20.clipboard",
        "org.knit.solutions.Task20.service"
})
public class AppConfig {
}
