package org.knit.samples.lection7;

public class Lection7Samples {
    public static void main(String[] args) {

    }

    public abstract class PatternClass{
        public final void printMessage(String message){

                beforeMessage(message);
                mainMessageOperation(message);
                completeMessageOperation();
        }
        public abstract void beforeMessage(String message);
        public abstract void mainMessageOperation(String message);
        public abstract void completeMessageOperation();
    }
}
