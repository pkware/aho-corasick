package org.arabidopsis.ahocorasick;

import java.util.Set;


/**
   <p>Holds the result of the search so far.  Includes the outputs where
   the search finished as well as the last index of the matching.</p>

   <p>(Internally, it also holds enough state to continue a running
   search, though this is not exposed for public use.)</p>
 */
public class SearchResult<T> {
    State<T> lastMatchedState;
    byte[] bytes;
    int lastIndex;

    SearchResult(State<T> s, byte[] bs, int i) {
	this.lastMatchedState = s;
	this.bytes = bs;
	this.lastIndex = i;
    }


    /**
       Returns a list of the outputs of this match.
     */
    public Set<T> getOutputs() {
	return lastMatchedState.getOutputs();
    }


    /**
       Returns the index where the search terminates.  Note that this
       is one byte after the last matching character.
     */
    public int getLastIndex() {
	return lastIndex;
    }
}
