package org.knit.solutions.ClassesSem1.lab3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class CharacterChart extends JFrame {
    private XYSeries series1;
    private XYSeries series2;

    public CharacterChart(Player[] players1, Player[] players2) {
        setTitle("График персонажей");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        XYSeriesCollection dataset = new XYSeriesCollection();

        // Инициализация серий для команд
        series1 = new XYSeries("Команда 1");
        series2 = new XYSeries("Команда 2");

        // Добавление данных в серии
        updateSeries(players1, series1);
        updateSeries(players2, series2);

        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createScatterPlot(
                "Координаты персонажей",
                "Координата X",
                "Координата Y",
                dataset
        );

        // Установка фиксированных границ для осей
        XYPlot plot = chart.getXYPlot();
        plot.getDomainAxis().setRange(-40, 40); // Устанавливаем диапазон оси X
        plot.getRangeAxis().setRange(-40, 40);  // Устанавливаем диапазон оси Y

        // Установка цвета для серий
        plot.getRenderer().setSeriesPaint(0, Color.RED);  // Первая команда - красный
        plot.getRenderer().setSeriesPaint(1, Color.BLUE); // Вторая команда - синий

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 400));
        setContentPane(chartPanel);
    }

    // Метод для обновления данных в серии
    public void updateChart(Player[] players1, Player[] players2) {
        series1.clear(); // Очищаем старые данные
        series2.clear(); // Очищаем старые данные

        // Обновляем данные в сериях
        updateSeries(players1, series1);
        updateSeries(players2, series2);

        // Перерисовываем график
        revalidate();
        repaint();
    }

    private void updateSeries(Player[] players, XYSeries series) {
        for (Player player : players) {
            series.add(player.axis_X, player.axis_Y); // Предполагается, что у класса Player есть поля axis_X и axis_Y
        }
    }

    public void display() {
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
        });
    }
}
