/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

/**
 *
 * @author hubert
 */
public class KeyToStemEntryFrequencyMapMapManager {
	public static void mergeFirstKeyToStemEntryFrequencyMapMapIntoSecondKeyToStemEntryFrequencyMapMap(KeyToStemEntryFrequencyMapMap firstMap, KeyToStemEntryFrequencyMapMap secondMap) {
		for(Object key : firstMap.keySet()){
			Object value = firstMap.get(key);
			if(value == null || !(value instanceof StemEntryFrequencyMap)){
				value = new StemEntryFrequencyMap();
			}
			StemEntryFrequencyMap value2 = (StemEntryFrequencyMap) value;
			secondMap.add(key, value2);
		}
	}
}
