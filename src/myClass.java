public class myClass extends Thread {
    long[] inputData;

    public myClass(String threadName, long[] inputData) {
        super(threadName);
        this.inputData = inputData;
    }

    @Override
    public void run() {
        System.out.println("Message from thread " + getName() + ": thread start!");
        double sr_result = 0.0;
        for (int i = 0; i < 1000; i++) {
            double result = 0.0;
            for (int j = 0; j < inputData.length; j++)
                result += inputData[j];
            sr_result += result / inputData.length;
        }
        System.out.println("Message from thread " + getName() + ": sr_ar = " + sr_result / 1000);
    }
}
