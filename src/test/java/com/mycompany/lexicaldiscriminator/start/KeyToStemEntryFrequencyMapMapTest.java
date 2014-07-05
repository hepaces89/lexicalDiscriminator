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
public class KeyToStemEntryFrequencyMapMapTest {
	
	StemEntry stemEntryBobV1 = new StemEntry("bob", "bob", "v");
	StemEntry stemEntryBobV2 = new StemEntry("bob", "bob", "v");
	StemEntry stemEntryCancerousCancer = new StemEntry("cancerous", "cancer", "adj");
	StemEntry stemEntryCancerCancer = new StemEntry("cancer", "cancer", "n");
	StemEntry stemEntryChuckChuckV = new StemEntry("chuck", "chuck", "v");
	StemEntry stemEntryChuckChuckN = new StemEntry("chuck", "chuck", "n");
	
	public KeyToStemEntryFrequencyMapMapTest() {
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
	public void testAdd(){
		KeyToStemEntryFrequencyMapMap<String> ktsefmm = new KeyToStemEntryFrequencyMapMap<>();
		StemEntryFrequencyMap sefm1 = new StemEntryFrequencyMap();
		sefm1.add(stemEntryBobV1);
		ktsefmm.add("topicA", sefm1);
		
		StemEntryFrequencyMap sefm2 = new StemEntryFrequencyMap();
		sefm2.add(this.stemEntryCancerCancer);
		sefm2.add(stemEntryBobV1);
		sefm2.add(this.stemEntryChuckChuckN);
		ktsefmm.add("topicB", sefm2);
		
		StemEntryFrequencyMap sefm3 = new StemEntryFrequencyMap();
		sefm3.add(stemEntryBobV1);
		sefm3.add(this.stemEntryCancerCancer);
		ktsefmm.add("topicA", sefm3);
		
		System.out.println("topicA:\n" + ktsefmm.get("topicA"));
		System.out.println("topicB:\n" + ktsefmm.get("topicB"));
		
		Assert.assertTrue(ktsefmm.size() == 2);
		Assert.assertTrue(ktsefmm.get("topicB").size() == 3);
		Assert.assertTrue(ktsefmm.get("topicA").size() == 2);
		Assert.assertTrue(ktsefmm.get("topicA").get(this.stemEntryBobV1) == 2);
		Assert.assertTrue(ktsefmm.get("topicA").get(this.stemEntryCancerCancer) == 1);
		Assert.assertTrue(ktsefmm.get("topicA").get(this.stemEntryChuckChuckN) == 0);
		Assert.assertTrue(ktsefmm.get("topicB").get(this.stemEntryChuckChuckN) == 1);
	}
}
