package com.fieldlens.URLReader;

import com.google.inject.ImplementedBy;

import java.util.List;

/**
 * Created by oebueno on 1/28/17.
 */

@ImplementedBy(URLTextReader.class)
public interface URLReader {
    public List<String> URLList();
    public String getURL(String url);

}
