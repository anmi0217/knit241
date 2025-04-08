package org.knit.solutions.Task10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class Race {
    public static int Const = 5;
    public static final CyclicBarrier BARRIER = new CyclicBarrier(Const, new StartRace());
    public static final CyclicBarrier FinishBARRIER = new CyclicBarrier(Const, new FinishRace());

    public static Integer finishOrder = 0;

    public static synchronized void registerFinish() {
        if (finishOrder!=0) {
            System.out.println("Бегун номер " + finishOrder + " пришел первым!");

        }
    }
}
