import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Vector;

public class MatrixWriter {
    static private final int DEFAULT_ROW;

    static {
        DEFAULT_ROW = 0;
    }

    private final String fileName;
    private final Vector<Long> rowStartPosition;
    private int num_row;

    public Vector<Long> getRowStartPosition() {
        return rowStartPosition;
    }

    public MatrixWriter(String fileName) {
        this.fileName = fileName;
        this.num_row = DEFAULT_ROW;
        this.rowStartPosition = new Vector<>();
    }

    public void setting(int row_count) {
        this.num_row = row_count;
    }

    public void dataGenerate(long seed) {
        if (num_row == DEFAULT_ROW) {
            System.err.println("row is zero!!!");
        } else {
            try {
                File file = new File(fileName);
                if (file.length() == 0) {
                    PrintWriter writer = new PrintWriter(file, "UTF-8");
                    for (int i = 0; i < num_row; i++) {
                        writer.print("Line: " + (i + 1) + ";");
                        int num_col = (int) (Math.random() * num_row + 1);
                        for (int j = 0; j < num_col; j++)
                            writer.print((long) (Math.random() * seed * 900 + seed * 100) + ";");
                        if (i != num_row - 1) writer.println();
                    }
                    writer.close();
                }
                if (file.length() > 0) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                    rowStartPosition.add(0L);
                    while (randomAccessFile.readLine() != null && randomAccessFile.getFilePointer() != file.length()) {
                        rowStartPosition.add(randomAccessFile.getFilePointer());
                    }
                    randomAccessFile.close();
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        }
    }
}
