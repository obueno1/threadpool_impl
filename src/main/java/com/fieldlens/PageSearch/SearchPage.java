package com.fieldlens.PageSearch;

import com.fieldlens.URLReader.URLTextWriter;
import com.fieldlens.URLReader.URLWriter;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.URI;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by oebueno on 1/29/17.
 */
public class SearchPage implements Runnable {
    private String url;
    private String searchTerm = "";
    private int count;
    private URLWriter uw;
    private final static Logger logger = Logger.getLogger(SearchPage.class);
    ReentrantLock lock = new ReentrantLock();

    private final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.97 Safari/537.11";

    public SearchPage(String url, String searchTerm, URLWriter uw, int count){
        this.url = url;
        this.count = count;
        this.searchTerm = searchTerm;
        this.uw = uw;
    }

    public synchronized void run(){
        logger.info(count + " " + url + " started running");
        URIBuilder builder = new URIBuilder();
        HttpClient client = new DefaultHttpClient();

        builder.setHost(url);
        builder.setScheme("http");


        try{
            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.addHeader("User-Agent", USER_AGENT);

            HttpResponse response = client.execute(request);
            InputStream is = response.getEntity().getContent();
            String responseString = IOUtils.toString(is, "UTF-8");
            PageSearcher ps = new PageSearcher();
//            System.out.println("hi");
            if(ps.contains(searchTerm, responseString)){
                uw.write(url);
            }
            logger.info(count + " " + url + " finished running");
        }
        catch(Exception e){
            logger.warn(url + " " + e.getMessage());
        }
    }
}
