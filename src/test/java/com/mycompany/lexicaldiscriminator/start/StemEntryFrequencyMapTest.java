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
	StemEntry stemEntryBobV1 = new StemEntry("bob", "bob", "v");
	StemEntry stemEntryBobV2 = new StemEntry("bob", "bob", "v");
	StemEntry stemEntryBobV3 = new StemEntry("bobbing", "bob", "v");
	StemEntry stemEntryCancerAdj = new StemEntry("cancerous", "cancer", "adj");
	StemEntry stemEntryCancerN = new StemEntry("cancer", "cancer", "n");
	StemEntry stemEntryChuckV = new StemEntry("chuck", "chuck", "v");
	
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
		sefm.add(stemEntryBobV1);
		sefm.add(stemEntryBobV2);
		sefm.add(stemEntryCancerAdj);
		sefm.add(stemEntryCancerN);
		sefm.add(stemEntryChuckV);
		sefm.add(stemEntryChuckV, 2);
		sefm.add(stemEntryBobV3);
		
		System.out.println(sefm);
		
		Assert.assertTrue("Size of sefm should by 4, the actual size was " + sefm.size(), 4 == sefm.size());
		Assert.assertTrue("There should be three bob, v entries, there were actually " + sefm.get(stemEntryBobV1)
				, 3 == sefm.get(stemEntryBobV1));
		Assert.assertTrue(1 == sefm.get(stemEntryCancerAdj));
		Assert.assertTrue(3 == sefm.get(stemEntryChuckV));
		
		
		
	}
}
