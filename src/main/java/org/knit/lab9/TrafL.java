package org.knit.lab9;

public class TrafL {
    enum TrafficLight {
        RED("YELLOW"),
        YELLOW("GREEN"),
        GREEN("RED");

        private final String nextLight;

        TrafficLight(String nl) {
            nextLight = nl;
        }
        public static String getNextLight(String old_light) {
            return TrafficLight.valueOf(old_light).nextLight;
        }
    }
}
