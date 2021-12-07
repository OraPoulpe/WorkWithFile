import java.io.IOException;
import java.util.Vector;

public class Main {

    static private final String fileName;
    static private final int row_count;
    static private final Long seed;
    static private Vector<Long> rowStartPosition;

    static {
        rowStartPosition = new Vector<>();
        fileName = "work.txt";
        row_count = 120;
        seed = 1000L;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MatrixWriter matrixWriter = new MatrixWriter(fileName);
        matrixWriter.setting(row_count);
        matrixWriter.dataGenerate(seed);
        System.out.println("Generate file done");


//        long[][] data = new long[row_count][seed];
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data[i].length; j++) {
//                data[i][j] = (long) (Math.random() * seed * 100);
//            }
//        }
//        myClass[] threads = new myClass[row_count];
//        for (int i = 0; i < threads.length; i++) {
//            threads[i] = new myClass("MyThread_" + (i + 1), data[i]);
//            threads[i].start();
//        }
//        for (int i = 0; i < threads.length; i++) {
//            threads[i].join();
//        }
//        System.out.println("Work is done!!!!");
    }
}
