package com.example.narutoultimatequiz;

import android.app.Application;

public class MyApplication extends Application {
    public static int points=0;
    public static boolean [] answered = new boolean[21];
    public static String nickname;



    MyApplication ()
    {
        for(int i=0;i<answered.length;i++)
        {
            answered[i]=false;
        }
    }

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        MyApplication.nickname = nickname;
    }

    public static int getPoints() {
        return points;

    }

    public static void setPoints(int points) {
        MyApplication.points = points;
    }

    public static void incrementPoints()
    {
        points++;
    }
    public static void decrementPoints()
    {
        points--;
    }
}
