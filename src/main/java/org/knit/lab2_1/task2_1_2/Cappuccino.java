package org.knit.lab2_1.task2_1_2;

public class Cappuccino implements Coffee {
        @Override
        public int getCost() {
            return 150;
        }

        @Override
        public String getDescription() {
            return "Капучино — итальянский кофейный напиток на основе эспрессо. Он состоит из равных частей кофе, молока и пены. 1\n" +
                    "Главная особенность капучино заключается в балансе насыщенного аромата и вкуса кофейных зёрен и чуть сладковатых, нежных, сливочных нот молока.";
        }
}
