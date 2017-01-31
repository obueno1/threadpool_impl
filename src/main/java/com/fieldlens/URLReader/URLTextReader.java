package com.fieldlens.URLReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by oebueno on 1/28/17.
 */
public class URLTextReader implements URLReader{
    private String filename;
    public List<String> list = new ArrayList();

    public URLTextReader(String filename){
        this.filename = filename;

    }

    @Override
    public String getURL(String lineWithURL) {
        String [] lineArray;
        lineArray = lineWithURL.split(",");
        return (!lineArray[1].contains("URL")) ? lineArray[1].replace("\"", "") : "";
    }

    public List<String> URLList(){
        try(Stream<String> stream = Files.lines(Paths.get(this.filename))){
            list = stream.map((urlstring)->getURL(urlstring)).collect(Collectors.toList());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        list.remove(0);

        return list;
    }

    public String getFilename(){
        return filename;
    }

}
