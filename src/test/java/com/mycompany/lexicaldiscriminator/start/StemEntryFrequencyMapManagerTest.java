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

/**
 *
 * @author hubert
 */
public class StemEntryFrequencyMapManagerTest {
	StemEntry stemEntryBobV1 = new StemEntry("bob", "bob", "v");
	StemEntry stemEntryBobV2 = new StemEntry("bob", "bob", "v");
	StemEntry stemEntryCancerousCancer = new StemEntry("cancerous", "cancer", "adj");
	StemEntry stemEntryCancerCancer = new StemEntry("cancer", "cancer", "n");
	StemEntry stemEntryChuckChuckV = new StemEntry("chuck", "chuck", "v");
	StemEntry stemEntryChuckChuckN = new StemEntry("chuck", "chuck", "n");
	
	public StemEntryFrequencyMapManagerTest() {
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
	public void testMergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(){
		StemEntryFrequencyMap sefm1 = new StemEntryFrequencyMap();
		StemEntryFrequencyMap sefm2 = new StemEntryFrequencyMap();
		StemEntryFrequencyMapManager.mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(sefm1, sefm2);
		Assert.assertTrue(sefm2.isEmpty());
		
		sefm1.add(stemEntryBobV1);
		StemEntryFrequencyMapManager.mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(sefm1, sefm2);
		Assert.assertTrue(sefm2.containsKey(stemEntryBobV1) && sefm2.get(stemEntryBobV1).intValue() == 1 && sefm2.size() == 1);
		
		sefm1.clear();
		sefm2.clear();
		Assert.assertTrue(sefm2.isEmpty());
		
		sefm2.add(stemEntryBobV1, 2);
		StemEntryFrequencyMapManager.mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(sefm1, sefm2);
		Assert.assertTrue(sefm2.containsKey(stemEntryBobV1) && sefm2.get(stemEntryBobV1) == 2 && sefm2.size() == 1);
		
	}
}
