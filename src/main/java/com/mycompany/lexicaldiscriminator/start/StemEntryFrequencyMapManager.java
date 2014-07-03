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
public class StemEntryFrequencyMapManager {
	public static void mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(StemEntryFrequencyMap firstMap, StemEntryFrequencyMap secondMap) {
		for(StemEntry stem : firstMap.keySet()){
			Integer curStemCount = firstMap.get(stem);
			secondMap.add(stem, curStemCount);
		}
	}
}
