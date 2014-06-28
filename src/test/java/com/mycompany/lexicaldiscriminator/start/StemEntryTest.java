/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hubert
 */
public class StemEntryTest {
	StemEntry stemEntryA = new StemEntry();
	StemEntry stemEntryB = new StemEntry();
	StemEntry stemEntryC = new StemEntry();
	StemEntry stemEntryD = new StemEntry();
	StemEntry stemEntryE = new StemEntry();
	
	public StemEntryTest() {
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
	public void stemEntriesSharingTheSameStemAndPOS_shouldBeConsideredTheSame(){
		int expected = 0;
		
		int result = stemEntryA.compareTo(stemEntryB);
		Assert.assertTrue(result == expected);
		
		result = stemEntryA.compareTo(stemEntryA);
		Assert.assertTrue(result == expected);	
	}
	
	@Test
	public void stemEntriesThatDoNotShareTheSameStemAndPOS_shouldNotBeConsideredTheSame(){
		int result = stemEntryA.compareTo(stemEntryC);
		Assert.assertFalse(result == 0);
		
		result = stemEntryA.compareTo(stemEntryD);
		Assert.assertFalse(result == 0);
		
		result = stemEntryA.compareTo(stemEntryE);
		Assert.assertFalse(result == 0);
	}
}
