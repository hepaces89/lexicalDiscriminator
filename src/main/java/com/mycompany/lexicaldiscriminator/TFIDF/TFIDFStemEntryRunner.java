/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.TFIDF;

import com.mycompany.lexicaldiscriminator.start.StemEntry;
import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMap;
import com.mycompany.lexicaldiscriminator.start.StemEntryRunner;

/**
 *
 * @author hubert
 */
public class TFIDFStemEntryRunner extends StemEntryRunner{
	
	public TFIDFStemEntryRunner(){
		super();
	}
	
	@Override
	protected void processStemEntry(StemEntryFrequencyMap[] stemEntryFrequencyMaps, StemEntry stemEntry) {
		stemEntryFrequencyMaps[0].add(stemEntry);
		stemEntryFrequencyMaps[1].put(stemEntry, 1);
	}
}