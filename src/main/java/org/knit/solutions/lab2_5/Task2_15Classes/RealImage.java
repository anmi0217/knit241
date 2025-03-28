package org.knit.solutions.lab2_5.Task2_15Classes;

import static java.lang.Thread.sleep;

public class RealImage implements ImageSubject {

    private String asciiImage;
    @Override
    public void request() {
        System.out.println(asciiImage);
        System.out.println("Изображение отобразилось");
    }

    public RealImage() throws InterruptedException {
        sleep(2000);
        asciiImage = "                      (\n" +
                "                        )     (\n" +
                "                 ___...(-------)-....___\n" +
                "             .-\"\"       )    (          \"\"-.\n" +
                "       .-'``'|-._             )         _.-|\n" +
                "      /  .--.|   `\"\"---...........---\"\"`   |\n" +
                "     /  /    |                             |\n" +
                "     |  |    |                             |\n" +
                "      \\  \\   |                             |\n" +
                "       `\\ `\\ |                             |\n" +
                "         `\\ `|                             |\n" +
                "         _/ /\\                             /\n" +
                "        (__/  \\                           /\n" +
                "     _..---\"\"` \\                         /`\"\"---.._\n" +
                "  .-'           \\                       /          '-.\n" +
                " :               `-.__             __.-'              :\n" +
                " :                  ) \"\"---...---\"\" (                 :\n" +
                "  '._               `\"--...___...--\"`              _.'\n" +
                "jgs \\\"\"--..__                              __..--\"\"/\n" +
                "     '._     \"\"\"----.....______.....----\"\"\"     _.'\n" +
                "        `\"\"--..,,_____            _____,,..--\"\"`\n" +
                "                      `\"\"\"----\"\"\"`";
        System.out.println("Изображение получено");
    }
}
