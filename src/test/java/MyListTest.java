import org.junit.*;
import org.knit.solutions.lab2_6.Task18Classes.MyList;

import java.util.*;

import static org.junit.Assert.*;

public class MyListTest {
    private MyList myList;

    @Test(expected = Exception.class)
    public void testSize() throws Exception {
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            arrayList.add(1);
        }
        myList = new MyList(arrayList);
    }

    @Test(expected = Exception.class)
    public void testValuesInterval() throws Exception {
        myList = new MyList(Arrays.asList(0, 1, 10));
    }

    @Test
    public void testWithoutZeros() throws Exception {
        myList = new MyList(Arrays.asList(2, 4, 1, 9));

        myList.duplicateZeros();
        assertEquals(myList.getList(), new LinkedList<Integer>(Arrays.asList(2, 4, 1, 9)));
    }

    @Test
    public void ordinaryTest() throws Exception {
        myList = new MyList(Arrays.asList(0, 0, 3, 5, 0));

        myList.duplicateZeros();
        assertEquals(myList.getList(), new LinkedList<Integer>(Arrays.asList(0, 0, 0, 0, 3)));
    }

    @Test
    public void testBorder() throws Exception {
        myList = new MyList(Arrays.asList(1, 4, 0));

        myList.duplicateZeros();
        assertEquals(myList.getList(), new LinkedList<Integer>(Arrays.asList(1, 4, 0)));
    }

    @Test
    public void testAllZeros() throws Exception {
        myList = new MyList(Arrays.asList(0, 0, 0));

        myList.duplicateZeros();
        assertEquals(myList.getList(), new LinkedList<Integer>(Arrays.asList(0, 0, 0)));
    }

    @Test(expected = Exception.class)
    public void testEmpty() throws Exception {
        myList = new MyList(new ArrayList<>());

        myList.duplicateZeros();
        assertEquals(myList.getList(), new LinkedList<Integer>());
    }

    @Test
    public void testPerformance() throws Exception {
        ArrayList<Integer> bigList = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < Math.pow(10, 4); i++) {
            bigList.add(random.nextInt(10));
        }

        myList = new MyList(bigList);
        long startTime = System.currentTimeMillis();
        myList.duplicateZeros();
        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;
        System.out.println("Метод duplicateZeros() в худшем случае выполняется " + duration + " мс");

    }
    @After
    public void tearDown() {
        myList = null;
    }
}
