/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

/**
 *
 * @author hubert
 * @param <K>
 */
public class KeyToStemEntryFrequencyMapMap<K> extends java.util.HashMap<K, StemEntryFrequencyMap>{
	public KeyToStemEntryFrequencyMapMap(){
		super();
	}
	
	public void add(K key,StemEntryFrequencyMap value) {
		if (this.containsKey(key)) {
			StemEntryFrequencyMap oldValue = this.get(key);
			StemEntryFrequencyMapManager.mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(value, oldValue);
		} else {
			this.put(key, value);
		}
	}
}
