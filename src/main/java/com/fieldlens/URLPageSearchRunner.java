package com.fieldlens;

import com.fieldlens.PageSearch.SearchPage;
import com.fieldlens.ThreadPool.ThreadPool;
import com.fieldlens.URLReader.URLReader;
import com.fieldlens.URLReader.URLTextReader;
import com.fieldlens.URLReader.URLTextWriter;
import com.fieldlens.URLReader.URLWriter;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oebueno on 1/28/17.
 */
public class URLPageSearchRunner {
    public static URLWriter uw = new URLTextWriter("results.txt");
    public static URLReader ur = new URLTextReader("urls.txt");
    public static final Logger logger = Logger.getLogger(URLPageSearchRunner.class);

    public static void main(String[] args) {
        uw.clear();
//        List<String> testList = new ArrayList<String>();
//        testList.add("facebook.com/");
//        testList.add("google.com/");
//        testList.add("twitter.com/");

        ThreadPool tp = new ThreadPool(20,1);
        int count = 1;
        for(String i : ur.URLList()){

            SearchPage sp = new SearchPage(i, "o", uw, count) ;
            count++;
            logger.info(i);
            tp.execute(sp);
        }

        tp.stop();
    }
}
