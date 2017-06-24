package com.mycompany.lexicaldiscriminator.TFIDF;

import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMap;

public class TfidfPrerequisites {
	StemEntryFrequencyMap docFreqMap = new StemEntryFrequencyMap();
	StemEntryFrequencyMap docPresenceMap = new StemEntryFrequencyMap();
	
	public TfidfPrerequisites(){
		this(null, null);
	}
	
	public TfidfPrerequisites(StemEntryFrequencyMap docFreqMap, StemEntryFrequencyMap docPresenceMap){
		this.setDocFreqMap(docFreqMap);
		this.setDocPresenceMap(docPresenceMap);
	}
	
	public StemEntryFrequencyMap getDocFreqMap() {
		return docFreqMap;
	}
	public void setDocFreqMap(StemEntryFrequencyMap docFreqMap) {
		this.docFreqMap = docFreqMap;
	}
	public StemEntryFrequencyMap getDocPresenceMap() {
		return docPresenceMap;
	}
	public void setDocPresenceMap(StemEntryFrequencyMap docPresenceMap) {
		this.docPresenceMap = docPresenceMap;
	}

}
