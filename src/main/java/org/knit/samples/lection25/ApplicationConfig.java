package org.knit.samples.lection25;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.knit.samples.lection25")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

}
