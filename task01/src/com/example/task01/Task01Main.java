package com.example.task01;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Task01Main {
    public static void main(String[] args) throws IOException {
        System.out.println(checkSumOfStream(new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01}))); // Должно вывести 71
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException();
        }
        //b - для считанных байтов
        //c - для хранение разультат
        int contolSum = 0;
        int b, c;

        while ((b = inputStream.read()) != -1) {
            c = Integer.rotateLeft(contolSum, 1);
            contolSum = c ^ b;
        }
        //0x37 в теории, что 71 будет
        return contolSum;
    }
}
