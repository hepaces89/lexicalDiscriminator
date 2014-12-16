/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lexicaldiscriminator.start;

/**
 *
 * @author hubert
 */
public class PrintFirstXLines {
    public static void main(String[] args){
        int numLines = 10;
        String targetFile = "";
        if(args.length > 0){
            targetFile = args[0];
            if(args.length > 1){
                numLines = Integer.parseInt(args[1]);
                printFirstXLines(targetFile, numLines);
            }
            
        }
    }
    
    public static void printFirstXLines(String fileLoc, int lines){
        java.io.File file = new java.io.File(fileLoc);
        try{
            java.util.Scanner fileScanner = new java.util.Scanner(file);
            int i = 0;
            while((fileScanner.hasNext()) && (i < lines)){
                System.out.println(fileScanner.nextLine());
                lines++;
            }
        } catch(java.io.FileNotFoundException e){
            System.out.println("Sorry unable to find the file at: " + fileLoc);
        }
    }
}
