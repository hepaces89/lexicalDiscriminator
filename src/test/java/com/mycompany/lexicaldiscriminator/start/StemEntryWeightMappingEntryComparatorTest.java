/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lexicaldiscriminator.start;

import java.util.AbstractMap;
import java.util.Map.Entry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author hubert
 */
public class StemEntryWeightMappingEntryComparatorTest {

	public StemEntryWeightMappingEntryComparatorTest() {
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
	public void doesTheComparatorWork() {
		StemEntry stemEntryBobV1 = new StemEntry("bob", "bob", "v");
		StemEntry stemEntryBobV2 = new StemEntry("bob", "bob", "v");
		StemEntry stemEntryBobV3 = new StemEntry("bobbing", "bob", "v");
		StemEntry stemEntryCancerAdj = new StemEntry("cancerous", "cancer", "adj");
		StemEntry stemEntryCancerN = new StemEntry("cancer", "cancer", "n");
		StemEntry stemEntryChuckV = new StemEntry("chuck", "chuck", "v");
		
		Entry<StemEntry, Double> a = new AbstractMap.SimpleEntry<>(stemEntryBobV1, 4.2);
		Entry<StemEntry, Double> b = new AbstractMap.SimpleEntry<>(stemEntryBobV1, 3.2);
		Entry<StemEntry, Double> c = new AbstractMap.SimpleEntry<>(stemEntryBobV1, 4.2);
		
		StemEntryWeightMappingEntryComparator sewmec = new StemEntryWeightMappingEntryComparator();
		
		Assert.assertTrue(sewmec.compare(b,b) == 0);
		Assert.assertTrue(sewmec.compare(a,b) > 0);
		Assert.assertTrue(sewmec.compare(b,a) < 0);
		Assert.assertTrue(sewmec.compare(a,c) == 0);
	}
}
