package com.Shipsink;


import java.util.Scanner;

public class UserInput {
    String [] shipnameinputs = new String[3];
    int [] shipcoordinateinputs = new int[6];
    int [][] values = new int [3][6];
    int [] value = new int [3];
    boolean destroy=false;


    void shipnames(int[][] shipcoord){
    Scanner sc = new Scanner(System.in);
        System.out.println("" );
        System.out.print("*** Authorisation Required - " );
        String [] codered= {"C","O","D","E"," ","R","E","D"};
        for(int timeslow =0;timeslow<8;timeslow++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(codered[timeslow]);

        }
        System.out.print(" ***" );
        System.out.println("" );
        System.out.print(" Facial detection in progress");
        for(int timeslow =0;timeslow<5;timeslow++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("" );
        System.out.print("Verification completed, Access Granted");
        for(int timeslow =0;timeslow<3;timeslow++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println("" );
        System.out.println("" );
        System.out.println("***  YOUR EYES ONLY ***" );

                System.out.println("Enter the code names for the three ship which entered the Indian Ocean");

    for(int i=0;i<3;i++){
        System.out.println("Code Name of Ship "+(i+1)+" : " );
        shipnameinputs[i]=sc.nextLine();}
    System.out.println("Enemys have breached the 7x7 Matrix perimeter, "+
            "Enter the coordinates for launching attack : ");
        System.out.println("( -- 3 Missiles are required for destroying one ship, "
                + "Enter the coordinates in (x1,y1,x2,y2,x3,y3) for launching --)");
        String [] coordinate2= {"(X1)","(Y1)","(X2)","(Y2)","(X3)","(Y3)"};
    for(int i=0;i<6;i++){
            System.out.println("Enter Coordinate "+coordinate2[i]+" : " );
            shipcoordinateinputs[i]=sc.nextInt();}

        for(int i=0;i<3;i++){
            for(int j=0;j<6;j++) {
                if (shipcoord[i][j] == shipcoordinateinputs[j]){
                    values[i][j] = 1;
                    //System.out.print(i+"postion "+values[i][j]);
                }
            }
           // System.out.println("");
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<6;j++){
                value[i]+=values[i][j];}
            if (value[i]==6){
                System.out.println("Ship "+shipnameinputs[i]+" has been destroyed" );
                destroy=true;
            }

    }
        if (destroy==false)
            System.out.println("No ships destroyed - Enemies have won the battle" );
        System.out.println("" );
        System.out.println("-------------------------------------------" );
        System.out.println("" );
        System.out.println("Refer Coordinates of the ships given below" );
        //Coordinates of ship
        for(int i=0;i<3;i++){
            System.out.println("");
            System.out.print((i+1)+"). Ship "+shipnameinputs[i]+" Coordinates are: ");
            for(int j=0;j<6;j++){
                System.out.print(shipcoord[i][j]);}
                        }



    }}
