package org.knit.tasks.task26;

public class Task26 {
    public static void main(String[] args) {
        Handler junior = new JuniorManager();
        Handler senior = new SeniorManager();
        Handler director = new Director();

        junior.setNextHandler(senior);
        senior.setNextHandler(director);

        junior.acceptProblem(new Problem(
                1, "Подсказать, как пройти."
        ));
        junior.acceptProblem(new Problem(
                15, "Оформление дебетовой карты."
        ));
        junior.acceptProblem(new Problem(
                45, "Потерян доступ к счету юридического лица."
        ));
        junior.acceptProblem(new Problem(
                100, "Покупка машины клиенту."
        ));
    }
}
