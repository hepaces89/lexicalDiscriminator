/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.TFIDF;

import com.mycompany.lexicaldiscriminator.start.StemEntry;
import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMap;
import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMapManager;

/**
 *
 * @author hubert
 */
public class TFIDFCombinableResultManager {
	public static void mergeFirstResultIntoSecondResult(TFIDFCombinableResult firstResult, TFIDFCombinableResult secondResult){
		//MergeForeGroundData
		mergeFirstResultIntoSecondResult_topicToForeGroundStatDTOMapping(firstResult, secondResult);
		//merge background data
		mergeFirstResultIntoSecondResult_wordToNumberOfBackGroundDocsTheWordOccursInMapping(firstResult, secondResult);
		//merge the numberOfBackgroundDocsProcessed values
		mergeFirstResultIntoSecondResult_numberOfBackgroundDocsProcessed(firstResult, secondResult);
	}
	
	private static void mergeFirstResultIntoSecondResult_topicToForeGroundStatDTOMapping(TFIDFCombinableResult firstResult, TFIDFCombinableResult secondResult){
		java.util.HashMap<String, ForeGroundStatDTO> firstMapping = firstResult.getTopicToForeGroundStatDTOMapping();
		java.util.HashMap<String, ForeGroundStatDTO> secondMapping = secondResult.getTopicToForeGroundStatDTOMapping();
		for(String topic : firstMapping.keySet()){
			if(secondMapping.containsKey(topic)){
				StemEntryFrequencyMapManager.mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(firstMapping.get(topic), secondMapping.get(topic));
			} else {
				secondMapping.put(topic, firstMapping.get(topic));
			}
		}
	}
	
	private static void mergeFirstResultIntoSecondResult_wordToNumberOfBackGroundDocsTheWordOccursInMapping(TFIDFCombinableResult firstResult, TFIDFCombinableResult secondResult){
		StemEntryFrequencyMap firstMap = firstResult.getWordToNumberOfBackGroundDocsTheWordOccursInMapping();
		StemEntryFrequencyMap secondMap = secondResult.getWordToNumberOfBackGroundDocsTheWordOccursInMapping();
		StemEntryFrequencyMapManager.mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(firstMap, secondMap);
	}

	
	
	private static void mergeFirstResultIntoSecondResult_numberOfBackgroundDocsProcessed(TFIDFCombinableResult firstResult, TFIDFCombinableResult secondResult){
		 secondResult.setNumberOfBackgroundDocsProcessed(secondResult.getNumberOfBackgroundDocsProcessed() + firstResult.getNumberOfBackgroundDocsProcessed());
	}
}
