/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hubert
 */
public class StemEntryFrequencyMapTest {
	StemEntry stemEntryA = new StemEntry();
	StemEntry stemEntryB = new StemEntry();
	StemEntry stemEntryC = new StemEntry();
	StemEntry stemEntryD = new StemEntry();
	StemEntry stemEntryE = new StemEntry();
	
	public StemEntryFrequencyMapTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		stemEntryA.setPartOfSpeech("NN");
		stemEntryA.setStem("bob");
		
		stemEntryB.setStem("bob");
		stemEntryB.setPartOfSpeech("NN");
		
		stemEntryC.setStem("bib");
		stemEntryC.setPartOfSpeech("NN");
		
		stemEntryD.setStem("bob");
		stemEntryD.setPartOfSpeech("VB");
		
		stemEntryE.setStem("big");
		stemEntryE.setPartOfSpeech("JJ");
	}
	
	@After
	public void tearDown() {
	}

    // TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}
	
	@Test
	public void testAddEntries(){
		StemEntryFrequencyMap sefm = new StemEntryFrequencyMap();
		sefm.add(stemEntryA);
		sefm.add(stemEntryB);
		sefm.add(stemEntryC);
		sefm.add(stemEntryD);
		sefm.add(stemEntryE);
		Assert.assertTrue("Size of sefm should by 4", 4 == sefm.size());
		Assert.assertTrue(2 == (Integer)sefm.get(stemEntryA));
		
		
	}
}
