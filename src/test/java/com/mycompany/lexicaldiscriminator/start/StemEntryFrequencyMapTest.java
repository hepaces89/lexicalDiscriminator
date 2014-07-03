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

/**
 *
 * @author hubert
 */
public class StemEntryFrequencyMapTest {
	StemEntry stemEntryA = new StemEntry("bob", "bob", "v");
	StemEntry stemEntryB = new StemEntry("bob", "bob", "v");
	StemEntry stemEntryC = new StemEntry("cancerous", "cancer", "adj");
	StemEntry stemEntryD = new StemEntry("cancer", "cancer", "n");
	StemEntry stemEntryE = new StemEntry("chuck", "chuck", "v");
	
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
		System.out.println(sefm);
		sefm.add(stemEntryA);
		sefm.add(stemEntryB);
		sefm.add(stemEntryC);
		sefm.add(stemEntryD);
		sefm.add(stemEntryE);
		sefm.add(stemEntryE, 2);
		Assert.assertTrue("Size of sefm should by 4, the actual size was " + sefm.size(), 4 == sefm.size());
		Assert.assertTrue("There should be two bob, bob, v entries, there were actually " + sefm.get(stemEntryA)
				, 2 == sefm.get(stemEntryA));
		Assert.assertTrue(1 == sefm.get(stemEntryC));
		Assert.assertTrue(3 == sefm.get(stemEntryE));
		
		System.out.println(sefm);
		
	}
}
