package com.study.demo.test.err;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        File file = new File("Z:\\Text.txt");
        File newFile = new File(file.getAbsolutePath().replaceAll("\\.txt$",".sql"));
        String line = "";
        //在try中声明资源
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));) {
            //一些业务操作
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line+System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
