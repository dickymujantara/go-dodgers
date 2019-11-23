package com.example.godogders;

import java.util.ArrayList;

public class PlayersData {
    private static String[] name = {"Joc Pederson","Max Muncy","Justin Turner","Cody Bellinger","Corey Seager",
            "A.J Pollock","Will Smith","Enrique Hernandez","Clayton Kershaw","Walker Buehler"};
    private static String[] nickname = {"King","Funky Muncy","Redturn2","Belli","Seags","Pollo","Smitty","Kike","Kersh","Buetane"};
    private static String[] position = {"LF","1B","3B","RF","SS","CF","C","2B","P","P"};
    private static char[] bat = {'L','L','R','L','R','R','R','R','L','R'};
    private static char[] throwing = {'L','R','R','L','R','R','R','R','L','R'};
    private static int[] noJersey = {31,13,10,35,5,11,16,14,22,21};
    private static String[] height = {"6'1","6'0","5'11","6'4","6'4","6'1","5'10","5'11","6'4","6'2"};
    private static int[] weight = {220,218,202,203,215,212,195,192,226,185};
    private static int[] age = {27,29,34,24,25,31,24,28,31,25};
    private static int[] photo ={
            R.drawable.joc_pederson, R.drawable.max_muncy, R.drawable.justin_turner,  R.drawable.cody_bellinger, R.drawable.corey_seager,
            R.drawable.a_j_pollock, R.drawable.will_smith, R.drawable.kike_hernandez, R.drawable.kershaw, R.drawable.walker_buehler
    };

    static ArrayList<Player> getListData(){
        ArrayList<Player> listData = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {

            Player player = new Player();
            player.setName(name[i]);
            player.setNickname(nickname[i]);
            player.setPosition(position[i]);
            player.setBat(bat[i]);
            player.setThrowing(throwing[i]);
            player.setNoJersey(noJersey[i]);
            player.setHeight(height[i]);
            player.setWeight(weight[i]);
            player.setAge(age[i]);
            player.setPhoto(photo[i]);

            listData.add(player);
        }

        return listData;
    }
}
