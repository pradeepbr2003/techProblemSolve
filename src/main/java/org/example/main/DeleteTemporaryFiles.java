package org.example.main;

import java.io.File;
import java.util.Objects;

import static org.example.util.TempEnum.*;

public class DeleteTemporaryFiles {
    public static void main(String[] args) {
        File tempFile = new File(TEMP.value());
        File recentFile = new File(RECENT.value());
        File windowTempFile = new File(WINDOWS_TEMP.value());
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