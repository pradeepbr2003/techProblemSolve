package org.example;

import java.io.File;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DeleteTemporaryFiles {
    public static void main(String[] args) {
        File tempFile = new File("C:\\Users\\pradeep.a.ramaiah\\AppData\\Local\\Temp");
        File recentFile = new File("C:\\Users\\pradeep.a.ramaiah\\Recent");
        File windowTempFile = new File("C:\\Windows\\Temp");
        File files[] = {tempFile, recentFile};
        for (File file : files) {
            deleteTempFiles(file);
        }
    }

    static void deleteTempFiles(File file) {
        if (file.isDirectory()) {
            File[] files = Objects.requireNonNull(file.listFiles());
            for (File f : files) {
                deleteTempFiles(f);
            }
            System.out.printf("%n %s directory is deleted %b", file.getName(), file.delete());
        } else {
            System.out.printf("%n %s is deleted %b %n", file.getName(), file.delete());
        }
    }


    static void printAllFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printAllFiles(f);
                }
            }
        } else {
            System.out.printf("%n File name : %s", file.getName());
        }
    }
}