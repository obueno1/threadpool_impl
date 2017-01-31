package com.fieldlens.URLReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by oebueno on 1/30/17.
 */
public class URLTextWriter implements URLWriter{
    private String url = "";
    private String filename = "results.txt";

    public URLTextWriter(String filename){
        this.filename = (filename == null) ? "results.txt" : filename;
    }

    public void clear(){
        try{
            PrintWriter writer = new PrintWriter(filename);
            writer.print("");
            writer.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public void write(String url){

        try(FileWriter fw = new FileWriter(filename, true);
            BufferedWriter writer = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(writer);) {

            out.println(url);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
