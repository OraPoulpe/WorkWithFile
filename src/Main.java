import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;
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
        rowStartPosition = matrixWriter.getRowStartPosition();

        System.out.println("SrAr line 101 = " +
                getSrAr(
                        convertStringToArrayOfLong(
                                getLineFromFileByLinePointer(
                                        fileName,
                                        rowStartPosition.get(100)
                                )
                        )
                )
        );


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

    public static String getLineFromFileByLinePointer(String fileName, long linePointer) {
        String result = null;
        File file = new File(fileName);
        if (file.exists() && file.length() > 0) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                randomAccessFile.seek(linePointer);
                result = randomAccessFile.readLine();
                randomAccessFile.close();
            } catch (Exception e) {
                return null;
            }
        }
        return result;
    }

    public static long[] convertStringToArrayOfLong(String input) {
        Scanner scanner = new Scanner(input);
        String[] cols = scanner.useDelimiter("\n").next().split(";");
        long[] result = new long[cols.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = Long.parseLong(cols[i + 1]);

        }
        return result;
    }

    public static double getSrAr(long[] data) {
        double result = 0.0;
        for (int i = 0; i < data.length; i++)
            result += (1.0 * data[i] / data.length);
        return result;
    }


}
