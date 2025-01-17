package org.arabidopsis.ahocorasick;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
   Quick and dirty code: measures the amount of time it takes to
   construct an AhoCorasick tree out of all the words in
   <tt>/usr/share/dict/words</tt>.
 */

public class TimeTrial {
    static public void main(String[] args) throws IOException {
	long startTime = System.currentTimeMillis();
	AhoCorasick<Object> tree = new AhoCorasick<>();
	BufferedReader reader = new BufferedReader
	    (new InputStreamReader
	     (new FileInputStream("/usr/share/dict/words")));
	String line;
	while ((line = reader.readLine()) != null) {
	    tree.add(line.getBytes(), null);
	}
	tree.prepare();
	long endTime = System.currentTimeMillis();
	System.out.println("endTime - startTime = " + 
			   (endTime - startTime) + 
			   " milliseconds");
    }
}
