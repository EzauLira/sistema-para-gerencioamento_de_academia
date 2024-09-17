package com.SistemaDeGerenciamentodeAcademia.SGA.config;

import java.util.concurrent.TimeUnit;

public class Timer {
    public static void timer(){
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void tempoCorrido(){
        timer();
        System.out.println(".");
        timer();
        System.out.println(".");
        timer();
        System.out.println(".");
        timer();
        System.out.println(".");
    }
}
