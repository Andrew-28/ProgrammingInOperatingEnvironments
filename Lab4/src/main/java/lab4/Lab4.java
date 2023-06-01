package lab4;

import java.util.stream.IntStream;

public class Lab4 {

    public static void main(String[] args) {
        int size = 10000;
        int sleep = 1;
        int[] input1 = new int[size];
        int[] input2 = new int[size];
        int[] result1 = new int[size];
        int[] result2 = new int[size];

        for (int i = 0; i < size; i++) {
            input1[i] = (int) (Math.random() * 101);
            input2[i] = (int) (Math.random() * 101);
        }

        long time = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            result1[i] = input1[i] * input2[i];
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
        long time1 = System.currentTimeMillis() - time;
        System.out.printf("sync: %s\n", time1);
        
        time = System.currentTimeMillis();

        IntStream.iterate(0, i -> i+1).limit(size).parallel().forEach(x->{
            result2[x] = input1[x] * input2[x];
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        
        long time2 = System.currentTimeMillis() - time;
        System.out.printf("parallel: %s\n", time2);

        System.out.printf("sync-parallel=%s\n", time1 - time2);
        
        for (int i = 0; i < size; i++) {
            if (result1[i] != result2[i]) {
                System.out.println("ERROR" + i + " " + result1[i] + " " + result2[i] + "\n" + input1[i] + " " + input2[i]);
                return;
            }
        }
    }
}
