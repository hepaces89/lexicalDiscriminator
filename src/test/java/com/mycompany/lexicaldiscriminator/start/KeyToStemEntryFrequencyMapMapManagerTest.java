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
public class KeyToStemEntryFrequencyMapMapManagerTest {
	
	StemEntry stemEntryBobV1 = new StemEntry("bob", "bob", "v");
	StemEntry stemEntryBobV2 = new StemEntry("bob", "bob", "v");
	StemEntry stemEntryCancerousCancer = new StemEntry("cancerous", "cancer", "adj");
	StemEntry stemEntryCancerCancer = new StemEntry("cancer", "cancer", "n");
	StemEntry stemEntryChuckChuckV = new StemEntry("chuck", "chuck", "v");
	StemEntry stemEntryChuckChuckN = new StemEntry("chuck", "chuck", "n");
	
	public KeyToStemEntryFrequencyMapMapManagerTest() {
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
	public void testMerge(){
		KeyToStemEntryFrequencyMapMap<String> ktsefmm = new KeyToStemEntryFrequencyMapMap<>();
		StemEntryFrequencyMap sefm1 = new StemEntryFrequencyMap();
		sefm1.add(stemEntryBobV1);
		ktsefmm.add("topicA", sefm1);
		
		StemEntryFrequencyMap sefm2 = new StemEntryFrequencyMap();
		sefm2.add(this.stemEntryCancerCancer);
		sefm2.add(stemEntryBobV1);
		ktsefmm.add("topicB", sefm2);
		
		StemEntryFrequencyMap sefm3 = new StemEntryFrequencyMap();
		sefm3.add(stemEntryBobV1);
		sefm3.add(this.stemEntryCancerCancer);
		ktsefmm.add("topicA", sefm3);
		
		StemEntryFrequencyMap sefm4 = new StemEntryFrequencyMap();
		sefm4.add(stemEntryBobV1);
		sefm4.add(this.stemEntryCancerCancer);
		ktsefmm.add("topicD", sefm4);
		
		KeyToStemEntryFrequencyMapMap<String> ktsefmm2 = new KeyToStemEntryFrequencyMapMap<>();
		StemEntryFrequencyMap sefm1b = new StemEntryFrequencyMap();
		sefm1b.add(stemEntryBobV1);
		ktsefmm2.add("topicA", sefm1b);
		
		StemEntryFrequencyMap sefm2b = new StemEntryFrequencyMap();
		sefm2b.add(this.stemEntryCancerCancer);
		sefm2b.add(stemEntryBobV1);
		ktsefmm2.add("topicB", sefm2b);
		
		StemEntryFrequencyMap sefm3b = new StemEntryFrequencyMap();
		sefm3b.add(stemEntryBobV1);
		sefm3b.add(this.stemEntryCancerCancer);
		ktsefmm2.add("topicC", sefm3b);
		
		KeyToStemEntryFrequencyMapMapManager.mergeFirstKeyToStemEntryFrequencyMapMapIntoSecondKeyToStemEntryFrequencyMapMap(ktsefmm, ktsefmm2);
		
		Assert.assertTrue(ktsefmm2.size() == 4);
		Assert.assertTrue(ktsefmm2.get("topicC").size() == 2);
		Assert.assertTrue(ktsefmm2.get("topicC").get(this.stemEntryCancerCancer) == 1);
		Assert.assertTrue(ktsefmm2.get("topicA").get(this.stemEntryBobV1) == 3);
		Assert.assertTrue(ktsefmm2.get("topicD").get(this.stemEntryBobV1) == 1);
	}
}
