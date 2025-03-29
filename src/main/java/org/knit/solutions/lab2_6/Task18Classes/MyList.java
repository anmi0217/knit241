package org.knit.solutions.lab2_6.Task18Classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyList {
    private LinkedList<Integer> list;

    public MyList(List<Integer> list) throws Exception {
        if ((list.size() > Math.pow(10, 4)) || (list.isEmpty())) {
            throw new IllegalArgumentException("Размер массива не в промежутке [1, 10^4]");
        }
        if (!list.stream().allMatch(x -> (x >= 0) && (x < 10))) {
            throw new Exception("Не все элементы в промежутке [0, 9]");
        }

        this.list = new LinkedList<Integer>(list);
    }

    public void duplicateZeros() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(0)) {
                list.remove(list.size() - 1);
                list.add(i, 0);
                i++;
            }
        }
    }

    public LinkedList<Integer> getList() {
        return list;
    }

    public MyList() {
    }
}
