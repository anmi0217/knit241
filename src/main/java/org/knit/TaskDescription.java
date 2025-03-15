package org.knit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TaskDescription {
    int taskNumber();
    String taskDescription() default "No Description provided";
    String href() default "No reference provided";// link to source (file, site, ..etc)
}
