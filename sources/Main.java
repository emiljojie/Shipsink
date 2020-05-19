package com.Shipsink;

import java.security.SecureRandom;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int shipcoordinatesfinal[][]=new int[3][6];
	Gamestart one = new Gamestart();
	one.createship();

	//copying coordinates
        for(int i=0;i<3;i++)
            for(int j=0;j<6;j++)
                shipcoordinatesfinal[i][j]=one.shipcoordinates[i][j];

    UserInput two = new UserInput();
    two.shipnames(shipcoordinatesfinal);
        System.out.println("" );
        System.out.println("-------------------------------------------" );
        System.out.println(" Location of the enemy ships marked in 'x'" );
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                System.out.print(" "+ one.Matrix1[i][j]);}
            System.out.println("");
        }

    }}






