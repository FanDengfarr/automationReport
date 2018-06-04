package com.itsma.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.swap;

/**
 * Created by dengfan on 2017/11/1.
 */
@Service
public class FileOperatorService {
    public static String[] readfile(String filepath) throws FileNotFoundException, IOException {

        File file = new File(filepath);
        if (file.isDirectory()) {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File readfile = new File(filepath + "\\" + filelist[i]);
                if (readfile.isDirectory()) {
                    System.out.println("path=" + filelist[i]);
                    //System.out.println("absolutepath="
                    // + readfile.getAbsolutePath());
                    //System.out.println("name=" + readfile.getName());
                }
            }
            return filelist;
        }

        return null;
    }

    public static long[] sort(String[] a) {
        if(a != null) {
            long[] inte = new long[a.length];
            for (int i = 0; i < a.length; i++) {
                inte[i] = Long.parseLong(a[i]);
            }
            for (int i = 0; i < inte.length; i++) {
                for (int j = 0; j < inte.length; j++) {
                    if (inte[i] > inte[j]) {
                        swap(inte, i, j);
                    }
                }
            }

            return inte;
        } else return null;
    }

}
