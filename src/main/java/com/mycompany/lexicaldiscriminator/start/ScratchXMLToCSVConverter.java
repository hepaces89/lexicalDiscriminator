/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lexicaldiscriminator.start;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hubert
 */
public class ScratchXMLToCSVConverter {
    class entry {
        String date;
        String author;
        String text;
        String favorite;
    }
    
    public static void main(String[] args){
        try {
            java.util.Scanner aScan = new java.util.Scanner(new java.io.File("D:\\stuff\\aiStuff\\OpinRankDataset\\cars\\2008\\2008_acura_tsx"));
            String curLine = "";
            while(aScan.hasNextLine()){
                curLine = aScan.nextLine();
                if(curLine.startsWith("<TEXT>")){
                    System.out.println(curLine.substring(6, curLine.length() - 7));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScratchXMLToCSVConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
