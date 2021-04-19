package org.arabidopsis.ahocorasick;

import junit.framework.TestCase;

public class TestState extends TestCase {
    public void testSimpleExtension() {
	State<Byte> s = new State<>(0);
	State<Byte> s2 = s.extend("a".getBytes()[0]);
	assertTrue(s2 != s && s2 != null);
	assertEquals(2, s.size());
    }


    public void testSimpleExtensionSparse() {
	State<Byte> s = new State<>(50);
	State<Byte> s2 = s.extend((byte) 3);
	assertTrue(s2 != s && s2 != null);
	assertEquals(2, s.size());
    }

    public void testSingleState() {
	State<Object> s = new State<>(0);
	assertEquals(1, s.size());
    }

    public void testSingleStateSparse() {
	State<Object> s = new State<>(50);
	assertEquals(1, s.size());
    }

    public void testExtendAll() {
	State<byte[]> s = new State<>(0);
	State<byte[]> s2 = s.extendAll("hello world".getBytes());
	assertEquals(12, s.size());
    }

    public void testExtendAllTwiceDoesntAddMoreStates() {
	State<byte[]> s = new State<>(0);
	State<byte[]> s2 = s.extendAll("hello world".getBytes());
	State<byte[]> s3 = s.extendAll("hello world".getBytes());
	assertEquals(12, s.size());
	assertTrue(s2 == s3);
    }


    public void testExtendAllTwiceDoesntAddMoreStatesSparse() {
	State<byte[]> s = new State<>(50);
	State<byte[]> s2 = s.extendAll("hello world".getBytes());
	State<byte[]> s3 = s.extendAll("hello world".getBytes());
	assertEquals(12, s.size());
	assertTrue(s2 == s3);
    }



    public void testAddingALotOfStatesIsOk() {
	State<Byte> s = new State<>(0);
	for (int i = 0; i < 256; i++)
	    s.extend((byte) i);
	assertEquals(257, s.size());
    }


    public void testAddingALotOfStatesIsOkOnSparseRep() {
	State<Byte> s = new State<>(50);
	for (int i = 0; i < 256; i++)
	    s.extend((byte) i);
	assertEquals(257, s.size());
    }


}
