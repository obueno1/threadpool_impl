package com.fieldlens.URLReader;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by oebueno on 1/28/17.
 */
public class URLTextReaderTest {
    @Test
    public void getFilename() throws Exception{
        URLTextReader utr = new URLTextReader("urls.txt");
        assertEquals("urls.txt", utr.getFilename());
    }

    @Test
    public void URLList() throws IOException{
        URLTextReader utr = new URLTextReader("urls.txt");
        List<String> actual = utr.URLList();
        List<String> expected = new ArrayList<String>();
        //System.out.println(actual.toArray().toString());
        actual = utr.URLList().subList(0, 2);
        //expected.add("");
        expected.add("facebook.com/");
        expected.add("twitter.com/");
        assertThat(actual, is(expected));
    }
}