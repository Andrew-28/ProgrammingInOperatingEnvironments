package lab3;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3 {

    public static void main(String[] args) {
        int num;
        
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Какое по счёту число Фибоначчи вы хотите получить?\nn=");
            num = in.nextInt();
        }
        
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Вычислительный поток запущен");
                Thread.sleep(5000);
                int res = getFib(num);
                System.out.println("Вычислительный поток завершен");
                return res;
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        
        System.out.println("Основной поток ждёт");
        
        try {
            System.out.println("Число Фибоначчи под номером " + num + " равно " + future.get());
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static int getFib(int n) {
        if (n < 2) {
            return 0;
        }
        int n1 = 0, n2 = 1, result = 1;
        for (int i = 2; i < n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
