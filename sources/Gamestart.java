package com.Shipsink;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class Gamestart {
    int shipcoordinates[][]=new int[3][6];
    String [][] Matrix1 = new String[7][7];
    //int randomfinal[]=new int[6];

// Method 1- CreateShip
    public void createship(){
         int randomfinal[]=samplegenerator();

//intialise ship
        for(int w=0;w<7;w++)
            for(int e=0;e<7;e++)
                Matrix1[w][e]="0";

//Check availale positions
        int lrtb,a,q ;
        for(int i=0;i<3;i++){
            //inserting first position
            a=randomfinal[i];
            q=randomfinal[i+3];
            shipcoordinates[i][0]=q;shipcoordinates[i][1]=a;
            Matrix1 [a][q]="x";
            //System.out.println("Position of ship"+i+": x-"+q+ " y-"+a+" ");
//Inserting 2 & 3 positions
            lrtb= check(a,q,Matrix1);
            //System.out.println("Position of LRTB :"+lrtb);

            switch (lrtb){
                case 0:
                    Matrix1 [a+2][q] ="x" ;Matrix1 [a+1][q] ="x";
                    shipcoordinates[i][2]=q;shipcoordinates[i][3]=a+1;
                    shipcoordinates[i][4]=q;shipcoordinates[i][5]=a+2;
                    break;
                case 1:
                    Matrix1 [a-2][q]="x" ;Matrix1 [a-1][q] ="x";
                    shipcoordinates[i][2]=q;shipcoordinates[i][3]=a-1;
                    shipcoordinates[i][4]=q;shipcoordinates[i][5]=a-2;
                    break;
                case 2:
                    Matrix1 [a][q+2] ="x" ;Matrix1 [a][q+1] ="x";
                    shipcoordinates[i][2]=q+1;shipcoordinates[i][3]=a;
                    shipcoordinates[i][4]=q+2;shipcoordinates[i][5]=a;
                    break;
                case 3:
                    Matrix1 [a][q-2]="x" ;Matrix1 [a][q-1] ="x";
                    shipcoordinates[i][2]=q-1;shipcoordinates[i][3]=a;
                    shipcoordinates[i][4]=q-2;shipcoordinates[i][5]=a;
                    break;

            }


        }
        //Location of the ship
        /*for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                System.out.print(" "+ Matrix1[i][j]);}
            System.out.println("");
        }
        //Coordinates of ship
        for(int i=0;i<3;i++){
            for(int j=0;j<6;j++){
                System.out.print(" "+ shipcoordinates[i][j]);}
            System.out.println("");
        }*/
}
//Checking the availale location for placing the ship
    public int check(int x,int y,String Matrix2[][]){
        int returncheck=0;
        int [] checkvalue = new int[4];
        Arrays.fill(checkvalue,0);
        int randomreturn;

        //Outoundcheck
        if(0<= (x+2) && (x+2) <=6 &&Matrix2 [x+2] [y] .equals("0") && Matrix2 [x+1] [y].equals("0"))
            checkvalue[0]=1;
        if((0<= (x-2) && (x-2) <=6) && (Matrix2 [x-2] [y].equals("0"))&& (Matrix2 [x-1] [y].equals("0")))
            checkvalue[1]=1;
        if((0<=(y+2) && (y+2)<=6) && (Matrix2 [x] [y+2].equals("0"))&& (Matrix2 [x] [y+1].equals("0")))
            checkvalue[2]=1;
        if((0<=(y-2) && (y-2)<=6) && (Matrix2 [x] [y-2].equals("0"))&& (Matrix2 [x] [y-1].equals("0")))
            checkvalue[3]=1;

        //return
        do {
            randomreturn =new Random().nextInt(4);
            if (checkvalue[randomreturn]==1){
                returncheck= randomreturn;
                break;
            }
        } while (checkvalue[randomreturn]==1||checkvalue[randomreturn]==0);

        return returncheck;

    }


    public static int[] samplegenerator(){
        int randomfinal[]= new int [6];
        int randomSample[]= new int [6];
        int k=0;
        int x=5;

        //sample generator
        for(int i=0;i<6;i++)
            randomSample[i]=i;
        //for loop for generating random numbers
        SecureRandom rd= new SecureRandom();
        for (int i=0;i<6;i++)
        {
            k=rd.nextInt(x);
            randomfinal[i]=randomSample[k];
            randomSample[k]=randomSample[x];
            x--;
            //handling exception of .nextInt
            if (x==0){
                randomfinal[5]=randomSample[0];
                break;
            }
        }
        return randomfinal;
    }

    //return shipcoordinates;
}




