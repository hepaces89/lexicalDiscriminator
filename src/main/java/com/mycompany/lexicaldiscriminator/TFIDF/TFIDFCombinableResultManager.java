/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.TFIDF;

import com.mycompany.lexicaldiscriminator.start.KeyToStemEntryFrequencyMapMap;
import com.mycompany.lexicaldiscriminator.start.StemEntry;
import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMap;
import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMapManager;
import com.mycompany.lexicaldiscriminator.start.StemEntryRunner;
import edu.stanford.nlp.pipeline.Annotation;
import java.util.List;

/**
 *
 * @author hubert
 */
public class TFIDFCombinableResultManager {
	
	/**
	 * 
	 * @param documentTopics - documentTopics associated with the current document
	 * @param document - the document to process
	 * @param result - the TFIDFCombinableResult to store the results in
	 * @param runner - the code to process the document
	 */
	public static void processDocument(List<String> documentTopics, Annotation document, TFIDFCombinableResult result, StemEntryRunner runner){
		StemEntryFrequencyMap docFreqMap = new StemEntryFrequencyMap();
		StemEntryFrequencyMap docPresenceMap = new StemEntryFrequencyMap();
		StemEntryFrequencyMap[] sefms = {docFreqMap, docPresenceMap};
		runner.processDocument(document, sefms);
		StemEntryFrequencyMapManager.mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(docPresenceMap, result.getWordToNumberOfBackGroundDocsTheWordOccursInMapping());
		for(String topic : documentTopics){
			result.getTopicToForeGroundStatDTOMapping().add(topic, docFreqMap);
		}
		result.setNumberOfBackgroundDocsProcessed(1 + result.getNumberOfBackgroundDocsProcessed());
	}
	
	public static void mergeFirstResultIntoSecondResult(TFIDFCombinableResult firstResult, TFIDFCombinableResult secondResult){
		//MergeForeGroundData
		mergeFirstResultIntoSecondResult_topicToForeGroundStatDTOMapping(firstResult, secondResult);
		//merge background data
		mergeFirstResultIntoSecondResult_wordToNumberOfBackGroundDocsTheWordOccursInMapping(firstResult, secondResult);
		//merge the numberOfBackgroundDocsProcessed values
		mergeFirstResultIntoSecondResult_numberOfBackgroundDocsProcessed(firstResult, secondResult);
	}
	
	private static void mergeFirstResultIntoSecondResult_topicToForeGroundStatDTOMapping(TFIDFCombinableResult firstResult, TFIDFCombinableResult secondResult){
		KeyToStemEntryFrequencyMapMap<String> firstMapping = firstResult.getTopicToForeGroundStatDTOMapping();
		KeyToStemEntryFrequencyMapMap<String> secondMapping = secondResult.getTopicToForeGroundStatDTOMapping();
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