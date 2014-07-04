/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.TFIDF;

import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMap;
import edu.stanford.nlp.pipeline.Annotation;
import java.util.Collections;
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
public class TestTFIDFStemEntryRunner {
	TFIDFStemEntryRunner tser = new TFIDFStemEntryRunner();
	public TestTFIDFStemEntryRunner() {
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
	public void testRun(){
		//This string was sourced from the John Young Brown Wikipedia article on 28June2014 @ http://en.wikipedia.org/wiki/John_Y._Brown_(politician,_born_1835)
		String wikiExcerpt = "John Young Brown (June 28, 1835 – January 11, 1904) was a politician from the US state of Kentucky. He represented the state in the United States House of Representatives and served as its 31st governor. Brown was elected to the House of Representatives for three non-consecutive terms, each of which was marred by controversy. He was first elected in 1859, despite his own protests that he was not yet twenty-five years old; the minimum age set by the Constitution for serving in the legislature. The voters of his district elected him anyway, but he was not allowed to take his seat until the Congress' second session, after he was of legal age to serve. After moving to Henderson, Kentucky, Brown was elected from that district in 1866. On this occasion, he was denied his seat because of alleged disloyalty to the Union during the Civil War. Voters in his district refused to elect another representative, and the seat remained vacant throughout the term to which Brown was elected. After an unsuccessful gubernatorial bid in 1871, Brown was again elected to the House in 1872 and served three consecutive terms. During his final term, he was officially censured for delivering a speech excoriating Massachusetts Representative Benjamin F. Butler. The censure was later expunged from the congressional record. After his service in the House, Brown took a break from politics, but re-entered the political arena as a candidate for governor of Kentucky in 1891. He secured the Democratic nomination in a four-way primary election, then convincingly won the general election over his Republican challenger, Andrew T. Wood. Brown's administration, and the state Democratic Party, were split between gold standard supporters (including Brown) and supporters of the free coinage of silver. Brown's was also the first administration to operate under the Kentucky Constitution of 1891, and most of the legislature's time was spent adapting the state's code of laws to the new constitution. Consequently, little of significance was accomplished during Brown's term. Brown hoped the legislature would elect him to the U.S. Senate following his term as governor. Having already alienated the free silver faction of his party, he backed \"Goldbug\" candidate Cassius M. Clay, Jr. for the Democratic nomination in the upcoming gubernatorial election. However, the deaths of two of Brown's children ended his interest in the gubernatorial race and his own senatorial ambitions. At the Democratic nominating convention of 1899, candidate William Goebel used questionable tactics to secure the gubernatorial nomination, and a disgruntled faction of the party held a separate nominating convention, choosing Brown to oppose Goebel in the general election. Goebel was eventually declared the winner of the election, but was assassinated. Brown became the legal counsel for former Kentucky Secretary of State Caleb Powers, an accused conspirator in the assassination. Brown died in Henderson on January 11, 1904.";		
		Annotation document = new Annotation(wikiExcerpt);
		StemEntryFrequencyMap sefm = new StemEntryFrequencyMap();
		StemEntryFrequencyMap sefmp = new StemEntryFrequencyMap();
		StemEntryFrequencyMap[] sefms = {sefm, sefmp};
		this.tser.processDocument(document, sefms);
		System.out.println(sefm);
		System.out.println(sefmp);
		Assert.assertTrue(Collections.max(sefmp.values()) == 1);
		Assert.assertTrue(sefmp.toString().compareToIgnoreCase(sefmpExpected) == 0);
		Assert.assertTrue(sefm.toString().compareToIgnoreCase(sefmExpected) == 0);
	}
	
	private String sefmExpected = "{\n" +
"[[accused, accuse, VBN] | 1]\n" +
"[[M., M., NNP] | 1]\n" +
"[[Representatives, Representatives, NNPS] | 2]\n" +
"[[assassinated, assassinate, VBN] | 1]\n" +
"[[its, its, PRP$] | 1]\n" +
"[[Young, Young, NNP] | 1]\n" +
"[[operate, operate, VB] | 1]\n" +
"[[State, State, NNP] | 1]\n" +
"[[set, set, VBN] | 1]\n" +
"[[of, of, IN] | 21]\n" +
"[[Brown, Brown, NNP] | 11]\n" +
"[[convention, convention, NN] | 2]\n" +
"[[Having, have, VBG] | 1]\n" +
"[[took, take, VBD] | 1]\n" +
"[[service, service, NN] | 1]\n" +
"[[during, during, IN] | 3]\n" +
"[[after, after, IN] | 4]\n" +
"[[28, 28, CD] | 1]\n" +
"[[free, free, JJ] | 2]\n" +
"[[the, the, DT] | 42]\n" +
"[[session, session, NN] | 1]\n" +
"[[again, again, RB] | 1]\n" +
"[[Secretary, Secretary, NNP] | 1]\n" +
"[[John, John, NNP] | 1]\n" +
"[[Powers, Powers, NNP] | 1]\n" +
"[[protests, protest, NNS] | 1]\n" +
"[[elected, elect, VBN] | 5]\n" +
"[[eventually, eventually, RB] | 1]\n" +
"[[deaths, death, NNS] | 1]\n" +
"[[arena, arena, NN] | 1]\n" +
"[[break, break, NN] | 1]\n" +
"[[Representative, Representative, NNP] | 1]\n" +
"[[first, first, JJ] | 2]\n" +
"[[little, little, JJ] | 1]\n" +
"[[Democratic, Democratic, NNP] | 1]\n" +
"[[re-entered, re-enter, VBD] | 1]\n" +
"[[following, follow, VBG] | 1]\n" +
"[[elected, elect, VBD] | 1]\n" +
"[[congressional, congressional, JJ] | 1]\n" +
"[[race, race, NN] | 1]\n" +
"[[1835, 1835, NNP] | 1]\n" +
"[[alleged, allege, VBN] | 1]\n" +
"[[serve, serve, VB] | 1]\n" +
"[[US, US, NNP] | 1]\n" +
"[[silver, silver, NN] | 2]\n" +
"[[He, he, PRP] | 11]\n" +
"[[House, House, NNP] | 4]\n" +
"[[However, however, RB] | 1]\n" +
"[[age, age, NN] | 2]\n" +
"[[held, hold, VBD] | 1]\n" +
"[[officially, officially, RB] | 1]\n" +
"[[occasion, occasion, NN] | 1]\n" +
"[[by, by, IN] | 2]\n" +
"[[-RRB-, -rrb-, -RRB-] | 2]\n" +
"[[marred, mar, VBN] | 1]\n" +
"[[this, this, DT] | 1]\n" +
"[[elect, elect, VB] | 2]\n" +
"[[used, use, VBD] | 1]\n" +
"[[as, as, IN] | 3]\n" +
"[[Union, Union, NNP] | 1]\n" +
"[[At, at, IN] | 1]\n" +
"[[June, June, NNP] | 1]\n" +
"[[was, be, VBD] | 19]\n" +
"[[tactics, tactic, NNS] | 1]\n" +
"[[record, record, NN] | 1]\n" +
"[[two, two, CD] | 1]\n" +
"[[new, new, JJ] | 1]\n" +
"[[former, former, JJ] | 1]\n" +
"[[moving, move, VBG] | 1]\n" +
"[[interest, interest, NN] | 1]\n" +
"[[31st, 31st, JJ] | 1]\n" +
"[[Cassius, Cassius, NNP] | 1]\n" +
"[[disloyalty, disloyalty, NN] | 1]\n" +
"[[coinage, coinage, NN] | 1]\n" +
"[[old, old, JJ] | 1]\n" +
"[[bid, bid, NN] | 1]\n" +
"[[counsel, counsel, NN] | 1]\n" +
"[[between, between, IN] | 1]\n" +
"[[then, then, RB] | 1]\n" +
"[[later, later, RB] | 1]\n" +
"[[won, win, VBD] | 1]\n" +
"[[non-consecutive, non-consecutive, JJ] | 1]\n" +
"[[that, that, DT] | 1]\n" +
"[[adapting, adapt, VBG] | 1]\n" +
"[[general, general, JJ] | 2]\n" +
"[[Andrew, Andrew, NNP] | 1]\n" +
"[[refused, refuse, VBD] | 1]\n" +
"[[political, political, JJ] | 1]\n" +
"[[conspirator, conspirator, NN] | 1]\n" +
"[[senatorial, senatorial, JJ] | 1]\n" +
"[[remained, remain, VBD] | 1]\n" +
"[[Clay, Clay, NNP] | 1]\n" +
"[[not, not, RB] | 2]\n" +
"[[legal, legal, JJ] | 2]\n" +
"[[state, state, NN] | 4]\n" +
"[[consecutive, consecutive, JJ] | 1]\n" +
"[[also, also, RB] | 1]\n" +
"[[his, he, PRP$] | 12]\n" +
"[[each, each, DT] | 1]\n" +
"[[already, already, RB] | 1]\n" +
"[[primary, primary, JJ] | 1]\n" +
"[[Benjamin, Benjamin, NNP] | 1]\n" +
"[[choosing, choose, VBG] | 1]\n" +
"[[politician, politician, NN] | 1]\n" +
"[[which, which, WDT] | 2]\n" +
"[[-LRB-, -lrb-, -LRB-] | 2]\n" +
"[[secured, secure, VBD] | 1]\n" +
"[[Constitution, Constitution, NNP] | 2]\n" +
"[[Goldbug, Goldbug, NNP] | 1]\n" +
"[[Congress, Congress, NNP] | 1]\n" +
"[[hoped, hope, VBD] | 1]\n" +
"[[nominating, nominating, JJ] | 2]\n" +
"[[for, for, IN] | 6]\n" +
"[[Massachusetts, Massachusetts, NNP] | 1]\n" +
"[[represented, represent, VBD] | 1]\n" +
"[[in, in, IN] | 15]\n" +
"[[winner, winner, NN] | 1]\n" +
"[[election, election, NN] | 5]\n" +
"[[would, would, MD] | 1]\n" +
"[[convincingly, convincingly, RB] | 1]\n" +
"[[upcoming, upcome, VBG] | 1]\n" +
"[[a, a, DT] | 9]\n" +
"[[three, three, CD] | 2]\n" +
"[[laws, law, NNS] | 1]\n" +
"[[children, child, NNS] | 1]\n" +
"[[Brown, brown, JJ] | 4]\n" +
"[[censure, censure, NN] | 1]\n" +
"[[accomplished, accomplish, VBN] | 1]\n" +
"[[Civil, civil, JJ] | 1]\n" +
"[[time, time, NN] | 1]\n" +
"[[but, but, CC] | 3]\n" +
"[[F., F., NNP] | 1]\n" +
"[[1866, 1866, NNP] | 1]\n" +
"[[legislature, legislature, NN] | 3]\n" +
"[[constitution, constitution, NN] | 1]\n" +
"[[1891, 1891, CD] | 2]\n" +
"[[serving, serve, VBG] | 1]\n" +
"[[1859, 1859, CD] | 1]\n" +
"[[served, serve, VBD] | 2]\n" +
"[[candidate, candidate, NN] | 3]\n" +
"[[term, term, NN] | 4]\n" +
"[[significance, significance, NN] | 1]\n" +
"[[Republican, republican, JJ] | 1]\n" +
"[[;, ;, :] | 1]\n" +
"[[--, --, :] | 1]\n" +
"[[standard, standard, JJ] | 1]\n" +
"[[final, final, JJ] | 1]\n" +
"[[declared, declare, VBN] | 1]\n" +
"[['s, 's, POS] | 6]\n" +
"[[Butler, Butler, NNP] | 1]\n" +
"[[Democratic, democratic, JJ] | 3]\n" +
"[[oppose, oppose, VB] | 1]\n" +
"[[Wood, Wood, NNP] | 1]\n" +
"[[spent, spend, VBN] | 1]\n" +
"[[Party, Party, NNP] | 1]\n" +
"[[most, most, JJS] | 1]\n" +
"[[speech, speech, NN] | 1]\n" +
"[[1899, 1899, CD] | 1]\n" +
"[[became, become, VBD] | 1]\n" +
"[[because, because, IN] | 1]\n" +
"[['', '', ''] | 1]\n" +
"[[``, ``, ``] | 1]\n" +
"[[yet, yet, RB] | 1]\n" +
"[[States, States, NNP] | 1]\n" +
"[[disgruntled, disgruntled, JJ] | 1]\n" +
"[[voters, voter, NNS] | 2]\n" +
"[[U.S., U.S., NNP] | 1]\n" +
"[[take, take, VB] | 1]\n" +
"[[gold, gold, JJ] | 1]\n" +
"[[vacant, vacant, JJ] | 1]\n" +
"[[Jr., Jr., NNP] | 1]\n" +
"[[questionable, questionable, JJ] | 1]\n" +
"[[despite, despite, IN] | 1]\n" +
"[[from, from, IN] | 4]\n" +
"[[twenty-five, twenty-five, CD] | 1]\n" +
"[[Goebel, Goebel, NNP] | 3]\n" +
"[[assassination, assassination, NN] | 1]\n" +
"[[backed, back, VBD] | 1]\n" +
"[[', ', POS] | 1]\n" +
"[[11, 11, CD] | 2]\n" +
"[[1871, 1871, CD] | 1]\n" +
"[[T., T., NNP] | 1]\n" +
"[[unsuccessful, unsuccessful, JJ] | 1]\n" +
"[[allowed, allow, VBN] | 1]\n" +
"[[censured, censure, VBN] | 1]\n" +
"[[governor, governor, NN] | 3]\n" +
"[[died, die, VBD] | 1]\n" +
"[[gubernatorial, gubernatorial, JJ] | 4]\n" +
"[[1872, 1872, CD] | 1]\n" +
"[[supporters, supporter, NNS] | 2]\n" +
"[[January, January, NNP] | 2]\n" +
"[[administration, administration, NN] | 2]\n" +
"[[Kentucky, Kentucky, NNP] | 5]\n" +
"[[separate, separate, JJ] | 1]\n" +
"[[., ., .] | 23]\n" +
"[[minimum, minimum, JJ] | 1]\n" +
"[[until, until, IN] | 1]\n" +
"[[terms, term, NNS] | 2]\n" +
"[[Consequently, consequently, RB] | 1]\n" +
"[[challenger, challenger, NN] | 1]\n" +
"[[1904, 1904, CD] | 2]\n" +
"[[another, another, DT] | 1]\n" +
"[[own, own, JJ] | 2]\n" +
"[[Senate, Senate, NNP] | 1]\n" +
"[[ambitions, ambition, NNS] | 1]\n" +
"[[four-way, four-way, JJ] | 1]\n" +
"[[party, party, NN] | 2]\n" +
"[[delivering, deliver, VBG] | 1]\n" +
"[[code, code, NN] | 1]\n" +
"[[On, on, IN] | 2]\n" +
"[[over, over, IN] | 1]\n" +
"[[United, United, NNP] | 1]\n" +
"[[anyway, anyway, RB] | 1]\n" +
"[[Caleb, Caleb, NNP] | 1]\n" +
"[[to, to, TO] | 13]\n" +
"[[alienated, alienate, VBN] | 1]\n" +
"[[throughout, throughout, IN] | 1]\n" +
"[[,, ,, ,] | 29]\n" +
"[[ended, end, VBD] | 1]\n" +
"[[seat, seat, NN] | 3]\n" +
"[[representative, representative, NN] | 1]\n" +
"[[politics, politics, NNS] | 1]\n" +
"[[excoriating, excoriate, VBG] | 1]\n" +
"[[that, that, IN] | 1]\n" +
"[[War, war, NN] | 1]\n" +
"[[district, district, NN] | 3]\n" +
"[[and, and, CC] | 8]\n" +
"[[controversy, controversy, NN] | 1]\n" +
"[[William, William, NNP] | 1]\n" +
"[[faction, faction, NN] | 2]\n" +
"[[Henderson, Henderson, NNP] | 2]\n" +
"[[nomination, nomination, NN] | 3]\n" +
"[[under, under, IN] | 1]\n" +
"[[split, split, VBN] | 1]\n" +
"[[expunged, expunge, VBN] | 1]\n" +
"[[including, include, VBG] | 1]\n" +
"[[second, second, JJ] | 1]\n" +
"[[secure, secure, VB] | 1]\n" +
"[[denied, deny, VBN] | 1]\n" +
"[[years, year, NNS] | 1]\n" +
"}";
	private final String sefmpExpected = "{\n" +
"[[accused, accuse, VBN] | 1]\n" +
"[[M., M., NNP] | 1]\n" +
"[[Representatives, Representatives, NNPS] | 1]\n" +
"[[assassinated, assassinate, VBN] | 1]\n" +
"[[its, its, PRP$] | 1]\n" +
"[[Young, Young, NNP] | 1]\n" +
"[[operate, operate, VB] | 1]\n" +
"[[State, State, NNP] | 1]\n" +
"[[set, set, VBN] | 1]\n" +
"[[of, of, IN] | 1]\n" +
"[[Brown, Brown, NNP] | 1]\n" +
"[[convention, convention, NN] | 1]\n" +
"[[Having, have, VBG] | 1]\n" +
"[[took, take, VBD] | 1]\n" +
"[[service, service, NN] | 1]\n" +
"[[during, during, IN] | 1]\n" +
"[[after, after, IN] | 1]\n" +
"[[28, 28, CD] | 1]\n" +
"[[free, free, JJ] | 1]\n" +
"[[the, the, DT] | 1]\n" +
"[[session, session, NN] | 1]\n" +
"[[again, again, RB] | 1]\n" +
"[[Secretary, Secretary, NNP] | 1]\n" +
"[[John, John, NNP] | 1]\n" +
"[[Powers, Powers, NNP] | 1]\n" +
"[[protests, protest, NNS] | 1]\n" +
"[[elected, elect, VBN] | 1]\n" +
"[[eventually, eventually, RB] | 1]\n" +
"[[deaths, death, NNS] | 1]\n" +
"[[arena, arena, NN] | 1]\n" +
"[[break, break, NN] | 1]\n" +
"[[Representative, Representative, NNP] | 1]\n" +
"[[first, first, JJ] | 1]\n" +
"[[little, little, JJ] | 1]\n" +
"[[Democratic, Democratic, NNP] | 1]\n" +
"[[re-entered, re-enter, VBD] | 1]\n" +
"[[following, follow, VBG] | 1]\n" +
"[[elected, elect, VBD] | 1]\n" +
"[[congressional, congressional, JJ] | 1]\n" +
"[[race, race, NN] | 1]\n" +
"[[1835, 1835, NNP] | 1]\n" +
"[[alleged, allege, VBN] | 1]\n" +
"[[serve, serve, VB] | 1]\n" +
"[[US, US, NNP] | 1]\n" +
"[[silver, silver, NN] | 1]\n" +
"[[He, he, PRP] | 1]\n" +
"[[House, House, NNP] | 1]\n" +
"[[However, however, RB] | 1]\n" +
"[[age, age, NN] | 1]\n" +
"[[held, hold, VBD] | 1]\n" +
"[[officially, officially, RB] | 1]\n" +
"[[occasion, occasion, NN] | 1]\n" +
"[[by, by, IN] | 1]\n" +
"[[-RRB-, -rrb-, -RRB-] | 1]\n" +
"[[marred, mar, VBN] | 1]\n" +
"[[this, this, DT] | 1]\n" +
"[[elect, elect, VB] | 1]\n" +
"[[used, use, VBD] | 1]\n" +
"[[as, as, IN] | 1]\n" +
"[[Union, Union, NNP] | 1]\n" +
"[[At, at, IN] | 1]\n" +
"[[June, June, NNP] | 1]\n" +
"[[was, be, VBD] | 1]\n" +
"[[tactics, tactic, NNS] | 1]\n" +
"[[record, record, NN] | 1]\n" +
"[[two, two, CD] | 1]\n" +
"[[new, new, JJ] | 1]\n" +
"[[former, former, JJ] | 1]\n" +
"[[moving, move, VBG] | 1]\n" +
"[[interest, interest, NN] | 1]\n" +
"[[31st, 31st, JJ] | 1]\n" +
"[[Cassius, Cassius, NNP] | 1]\n" +
"[[disloyalty, disloyalty, NN] | 1]\n" +
"[[coinage, coinage, NN] | 1]\n" +
"[[old, old, JJ] | 1]\n" +
"[[bid, bid, NN] | 1]\n" +
"[[counsel, counsel, NN] | 1]\n" +
"[[between, between, IN] | 1]\n" +
"[[then, then, RB] | 1]\n" +
"[[later, later, RB] | 1]\n" +
"[[won, win, VBD] | 1]\n" +
"[[non-consecutive, non-consecutive, JJ] | 1]\n" +
"[[that, that, DT] | 1]\n" +
"[[adapting, adapt, VBG] | 1]\n" +
"[[general, general, JJ] | 1]\n" +
"[[Andrew, Andrew, NNP] | 1]\n" +
"[[refused, refuse, VBD] | 1]\n" +
"[[political, political, JJ] | 1]\n" +
"[[conspirator, conspirator, NN] | 1]\n" +
"[[senatorial, senatorial, JJ] | 1]\n" +
"[[remained, remain, VBD] | 1]\n" +
"[[Clay, Clay, NNP] | 1]\n" +
"[[not, not, RB] | 1]\n" +
"[[legal, legal, JJ] | 1]\n" +
"[[state, state, NN] | 1]\n" +
"[[consecutive, consecutive, JJ] | 1]\n" +
"[[also, also, RB] | 1]\n" +
"[[his, he, PRP$] | 1]\n" +
"[[each, each, DT] | 1]\n" +
"[[already, already, RB] | 1]\n" +
"[[primary, primary, JJ] | 1]\n" +
"[[Benjamin, Benjamin, NNP] | 1]\n" +
"[[choosing, choose, VBG] | 1]\n" +
"[[politician, politician, NN] | 1]\n" +
"[[which, which, WDT] | 1]\n" +
"[[-LRB-, -lrb-, -LRB-] | 1]\n" +
"[[secured, secure, VBD] | 1]\n" +
"[[Constitution, Constitution, NNP] | 1]\n" +
"[[Goldbug, Goldbug, NNP] | 1]\n" +
"[[Congress, Congress, NNP] | 1]\n" +
"[[hoped, hope, VBD] | 1]\n" +
"[[nominating, nominating, JJ] | 1]\n" +
"[[for, for, IN] | 1]\n" +
"[[Massachusetts, Massachusetts, NNP] | 1]\n" +
"[[represented, represent, VBD] | 1]\n" +
"[[in, in, IN] | 1]\n" +
"[[winner, winner, NN] | 1]\n" +
"[[election, election, NN] | 1]\n" +
"[[would, would, MD] | 1]\n" +
"[[convincingly, convincingly, RB] | 1]\n" +
"[[upcoming, upcome, VBG] | 1]\n" +
"[[a, a, DT] | 1]\n" +
"[[three, three, CD] | 1]\n" +
"[[laws, law, NNS] | 1]\n" +
"[[children, child, NNS] | 1]\n" +
"[[Brown, brown, JJ] | 1]\n" +
"[[censure, censure, NN] | 1]\n" +
"[[accomplished, accomplish, VBN] | 1]\n" +
"[[Civil, civil, JJ] | 1]\n" +
"[[time, time, NN] | 1]\n" +
"[[but, but, CC] | 1]\n" +
"[[F., F., NNP] | 1]\n" +
"[[1866, 1866, NNP] | 1]\n" +
"[[legislature, legislature, NN] | 1]\n" +
"[[constitution, constitution, NN] | 1]\n" +
"[[1891, 1891, CD] | 1]\n" +
"[[serving, serve, VBG] | 1]\n" +
"[[1859, 1859, CD] | 1]\n" +
"[[served, serve, VBD] | 1]\n" +
"[[candidate, candidate, NN] | 1]\n" +
"[[term, term, NN] | 1]\n" +
"[[significance, significance, NN] | 1]\n" +
"[[Republican, republican, JJ] | 1]\n" +
"[[;, ;, :] | 1]\n" +
"[[--, --, :] | 1]\n" +
"[[standard, standard, JJ] | 1]\n" +
"[[final, final, JJ] | 1]\n" +
"[[declared, declare, VBN] | 1]\n" +
"[['s, 's, POS] | 1]\n" +
"[[Butler, Butler, NNP] | 1]\n" +
"[[Democratic, democratic, JJ] | 1]\n" +
"[[oppose, oppose, VB] | 1]\n" +
"[[Wood, Wood, NNP] | 1]\n" +
"[[spent, spend, VBN] | 1]\n" +
"[[Party, Party, NNP] | 1]\n" +
"[[most, most, JJS] | 1]\n" +
"[[speech, speech, NN] | 1]\n" +
"[[1899, 1899, CD] | 1]\n" +
"[[became, become, VBD] | 1]\n" +
"[[because, because, IN] | 1]\n" +
"[['', '', ''] | 1]\n" +
"[[``, ``, ``] | 1]\n" +
"[[yet, yet, RB] | 1]\n" +
"[[States, States, NNP] | 1]\n" +
"[[disgruntled, disgruntled, JJ] | 1]\n" +
"[[voters, voter, NNS] | 1]\n" +
"[[U.S., U.S., NNP] | 1]\n" +
"[[take, take, VB] | 1]\n" +
"[[gold, gold, JJ] | 1]\n" +
"[[vacant, vacant, JJ] | 1]\n" +
"[[Jr., Jr., NNP] | 1]\n" +
"[[questionable, questionable, JJ] | 1]\n" +
"[[despite, despite, IN] | 1]\n" +
"[[from, from, IN] | 1]\n" +
"[[twenty-five, twenty-five, CD] | 1]\n" +
"[[Goebel, Goebel, NNP] | 1]\n" +
"[[assassination, assassination, NN] | 1]\n" +
"[[backed, back, VBD] | 1]\n" +
"[[', ', POS] | 1]\n" +
"[[11, 11, CD] | 1]\n" +
"[[1871, 1871, CD] | 1]\n" +
"[[T., T., NNP] | 1]\n" +
"[[unsuccessful, unsuccessful, JJ] | 1]\n" +
"[[allowed, allow, VBN] | 1]\n" +
"[[censured, censure, VBN] | 1]\n" +
"[[governor, governor, NN] | 1]\n" +
"[[died, die, VBD] | 1]\n" +
"[[gubernatorial, gubernatorial, JJ] | 1]\n" +
"[[1872, 1872, CD] | 1]\n" +
"[[supporters, supporter, NNS] | 1]\n" +
"[[January, January, NNP] | 1]\n" +
"[[administration, administration, NN] | 1]\n" +
"[[Kentucky, Kentucky, NNP] | 1]\n" +
"[[separate, separate, JJ] | 1]\n" +
"[[., ., .] | 1]\n" +
"[[minimum, minimum, JJ] | 1]\n" +
"[[until, until, IN] | 1]\n" +
"[[terms, term, NNS] | 1]\n" +
"[[Consequently, consequently, RB] | 1]\n" +
"[[challenger, challenger, NN] | 1]\n" +
"[[1904, 1904, CD] | 1]\n" +
"[[another, another, DT] | 1]\n" +
"[[own, own, JJ] | 1]\n" +
"[[Senate, Senate, NNP] | 1]\n" +
"[[ambitions, ambition, NNS] | 1]\n" +
"[[four-way, four-way, JJ] | 1]\n" +
"[[party, party, NN] | 1]\n" +
"[[delivering, deliver, VBG] | 1]\n" +
"[[code, code, NN] | 1]\n" +
"[[On, on, IN] | 1]\n" +
"[[over, over, IN] | 1]\n" +
"[[United, United, NNP] | 1]\n" +
"[[anyway, anyway, RB] | 1]\n" +
"[[Caleb, Caleb, NNP] | 1]\n" +
"[[to, to, TO] | 1]\n" +
"[[alienated, alienate, VBN] | 1]\n" +
"[[throughout, throughout, IN] | 1]\n" +
"[[,, ,, ,] | 1]\n" +
"[[ended, end, VBD] | 1]\n" +
"[[seat, seat, NN] | 1]\n" +
"[[representative, representative, NN] | 1]\n" +
"[[politics, politics, NNS] | 1]\n" +
"[[excoriating, excoriate, VBG] | 1]\n" +
"[[that, that, IN] | 1]\n" +
"[[War, war, NN] | 1]\n" +
"[[district, district, NN] | 1]\n" +
"[[and, and, CC] | 1]\n" +
"[[controversy, controversy, NN] | 1]\n" +
"[[William, William, NNP] | 1]\n" +
"[[faction, faction, NN] | 1]\n" +
"[[Henderson, Henderson, NNP] | 1]\n" +
"[[nomination, nomination, NN] | 1]\n" +
"[[under, under, IN] | 1]\n" +
"[[split, split, VBN] | 1]\n" +
"[[expunged, expunge, VBN] | 1]\n" +
"[[including, include, VBG] | 1]\n" +
"[[second, second, JJ] | 1]\n" +
"[[secure, secure, VB] | 1]\n" +
"[[denied, deny, VBN] | 1]\n" +
"[[years, year, NNS] | 1]\n" +
"}";
}
