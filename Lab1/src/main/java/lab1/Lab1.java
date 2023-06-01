package lab1;

import java.io.File;

public class Lab1 {

    public static void main(String[] args) {
        //File f = new File("..//");
        File f = new File(".");
        System.out.println("$current folder$");
        if (f.isDirectory())
            for (File item : f.listFiles())
                if (item.isDirectory()){
                    buildTree(item, "| ");
                } else {
                    System.out.println("| " + item.getName());
                }
    }

    public static void buildTree(File f, String s) {
        System.out.println(s + f.getName());
        if (f.isDirectory()) {
            for (File item : f.listFiles()) {
                if (item.isDirectory()) {
                    buildTree(item, s + "| ");
                } else {
                    System.out.println(s + "| " + item.getName());
                }
            }
        }
    }
}
