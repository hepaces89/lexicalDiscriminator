/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

import edu.stanford.nlp.pipeline.Annotation;
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
public class StemEntryRunnerTest {
	StemEntryRunner ser = new StemEntryRunner();
	public StemEntryRunnerTest() {
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
	public void testProcessDocument(){
		//This string was sourced from the John Young Brown Wikipedia article on 28June2014 @ http://en.wikipedia.org/wiki/John_Y._Brown_(politician,_born_1835)
		String wikiExcerpt = "John Young Brown (June 28, 1835 – January 11, 1904) was a politician from the US state of Kentucky. He represented the state in the United States House of Representatives and served as its 31st governor. Brown was elected to the House of Representatives for three non-consecutive terms, each of which was marred by controversy. He was first elected in 1859, despite his own protests that he was not yet twenty-five years old; the minimum age set by the Constitution for serving in the legislature. The voters of his district elected him anyway, but he was not allowed to take his seat until the Congress' second session, after he was of legal age to serve. After moving to Henderson, Kentucky, Brown was elected from that district in 1866. On this occasion, he was denied his seat because of alleged disloyalty to the Union during the Civil War. Voters in his district refused to elect another representative, and the seat remained vacant throughout the term to which Brown was elected. After an unsuccessful gubernatorial bid in 1871, Brown was again elected to the House in 1872 and served three consecutive terms. During his final term, he was officially censured for delivering a speech excoriating Massachusetts Representative Benjamin F. Butler. The censure was later expunged from the congressional record. After his service in the House, Brown took a break from politics, but re-entered the political arena as a candidate for governor of Kentucky in 1891. He secured the Democratic nomination in a four-way primary election, then convincingly won the general election over his Republican challenger, Andrew T. Wood. Brown's administration, and the state Democratic Party, were split between gold standard supporters (including Brown) and supporters of the free coinage of silver. Brown's was also the first administration to operate under the Kentucky Constitution of 1891, and most of the legislature's time was spent adapting the state's code of laws to the new constitution. Consequently, little of significance was accomplished during Brown's term. Brown hoped the legislature would elect him to the U.S. Senate following his term as governor. Having already alienated the free silver faction of his party, he backed \"Goldbug\" candidate Cassius M. Clay, Jr. for the Democratic nomination in the upcoming gubernatorial election. However, the deaths of two of Brown's children ended his interest in the gubernatorial race and his own senatorial ambitions. At the Democratic nominating convention of 1899, candidate William Goebel used questionable tactics to secure the gubernatorial nomination, and a disgruntled faction of the party held a separate nominating convention, choosing Brown to oppose Goebel in the general election. Goebel was eventually declared the winner of the election, but was assassinated. Brown became the legal counsel for former Kentucky Secretary of State Caleb Powers, an accused conspirator in the assassination. Brown died in Henderson on January 11, 1904.";		
		Annotation document = new Annotation(wikiExcerpt);
		StemEntryFrequencyMap sefm = new StemEntryFrequencyMap();
		StemEntryFrequencyMap[] sefms = {sefm};
		this.ser.processDocument(document, sefms);
                StemEntryFrequencyTreeMap sefmT = new StemEntryFrequencyTreeMap(sefm);
		System.out.println(sefmT);
		
		//Assert.assertTrue(sefmT.toString().compareToIgnoreCase(expected) == 0);
	}
}
