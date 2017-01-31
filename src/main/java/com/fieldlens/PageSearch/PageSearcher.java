package com.fieldlens.PageSearch;

/**
 * Created by oebueno on 1/30/17.
 */
public class PageSearcher {

    public boolean contains(String needle, String haystack){
        return haystack.toLowerCase().contains(needle.toLowerCase()) ? true : false;
    }
}
