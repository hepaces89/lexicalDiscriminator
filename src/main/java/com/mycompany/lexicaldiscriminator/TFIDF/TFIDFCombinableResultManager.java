/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.TFIDF;

import com.mycompany.lexicaldiscriminator.start.KeyToStemEntryFrequencyMapMap;
import com.mycompany.lexicaldiscriminator.start.KeyToStemEntryFrequencyMapMapManager;
import com.mycompany.lexicaldiscriminator.start.StemEntry;
import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMap;
import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMapManager;
import com.mycompany.lexicaldiscriminator.start.StemEntryRunner;
import com.mycompany.lexicaldiscriminator.start.StemEntryWeightMappingEntryComparator;
import edu.stanford.nlp.pipeline.Annotation;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedSet;

/**
 *
 * @author hubert
 */
public class TFIDFCombinableResultManager {
	
    /**
     * Calculates the TFIDF weight for a stem (word) for a given topic using the data from the TFIDFCombinableResult
     * @param stem
     * @param topic
     * @param result
     * @return 
     */
	public static double calculateTFIDFWeightForWordForTopic(StemEntry stem, String topic, TFIDFCombinableResult result){
		double weight = 0.0;
		Integer numberOfTimesWordAppearedInTopicRelatedTexts = result.getStemFrequenciesByTopic().get(topic).get(stem);
		if(numberOfTimesWordAppearedInTopicRelatedTexts == null){
			numberOfTimesWordAppearedInTopicRelatedTexts = 0;
		}
		Integer numberOfBackGroundDocsInWhichWordOccured = result.getDocumentCountsPerStemMapping().get(stem);
		Double idfWeight = Math.log(result.getProcessedDocumentCount().doubleValue()/numberOfBackGroundDocsInWhichWordOccured.doubleValue());
		weight = numberOfTimesWordAppearedInTopicRelatedTexts.doubleValue() * idfWeight;
		return weight;
	}
	
        /**
         * Gets the set of TFIDWeight entries for a particular topic sorted by weight
         * @param result
         * @param topic
         * @return 
         */
	public static SortedSet<Entry<StemEntry, Double>> getSortedTFIDFWeightSetForTopic(TFIDFCombinableResult result, String topic){
		SortedSet<Entry<StemEntry, Double>> sortedSet = new java.util.TreeSet<>(new StemEntryWeightMappingEntryComparator());
		StemEntryFrequencyMap topicSEFM = result.getStemFrequenciesByTopic().get(topic);
                if(topicSEFM != null){
                    for(StemEntry stem : topicSEFM.keySet()){
			sortedSet.add(new AbstractMap.SimpleEntry<StemEntry,Double>(stem, calculateTFIDFWeightForWordForTopic(stem, topic, result)));
                    }
                }
		
		return sortedSet;
	}
	
	/**
	 * 
	 * @param documentTopics - documentTopics associated with the current document
	 * @param document - the document to process
	 * @param result - the TFIDFCombinableResult to store the results in
	 * @param runner - the code to process the document
	 */
	public static void processDocument(List<String> documentTopics, Annotation document, TFIDFCombinableResult result, TFIDFStemEntryRunner runner){
		StemEntryFrequencyMap docFreqMap = new StemEntryFrequencyMap();
		StemEntryFrequencyMap docPresenceMap = new StemEntryFrequencyMap();
		StemEntryFrequencyMap[] sefms = {docFreqMap, docPresenceMap};
		runner.processDocument(document, sefms);
		StemEntryFrequencyMapManager.mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(docPresenceMap, result.getDocumentCountsPerStemMapping());
		KeyToStemEntryFrequencyMapMap<String> tempKTSEFMM = new KeyToStemEntryFrequencyMapMap<>(documentTopics, docFreqMap);
		KeyToStemEntryFrequencyMapMapManager.mergeFirstKeyToStemEntryFrequencyMapMapIntoSecondKeyToStemEntryFrequencyMapMap(tempKTSEFMM, result.getStemFrequenciesByTopic());
		result.setProcessedDocumentCount(1 + result.getProcessedDocumentCount());
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
		KeyToStemEntryFrequencyMapMap<String> firstMapping = firstResult.getStemFrequenciesByTopic();
		KeyToStemEntryFrequencyMapMap<String> secondMapping = secondResult.getStemFrequenciesByTopic();
		for(String topic : firstMapping.keySet()){
			if(secondMapping.containsKey(topic)){
				StemEntryFrequencyMapManager.mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(firstMapping.get(topic), secondMapping.get(topic));
			} else {
				secondMapping.put(topic, firstMapping.get(topic));
			}
		}
	}
	
	private static void mergeFirstResultIntoSecondResult_wordToNumberOfBackGroundDocsTheWordOccursInMapping(TFIDFCombinableResult firstResult, TFIDFCombinableResult secondResult){
		StemEntryFrequencyMap firstMap = firstResult.getDocumentCountsPerStemMapping();
		StemEntryFrequencyMap secondMap = secondResult.getDocumentCountsPerStemMapping();
		StemEntryFrequencyMapManager.mergeFirstStemEntryFrequencyMapIntoSecondStemEntryFrequencyMap(firstMap, secondMap);
	}

	
	
	private static void mergeFirstResultIntoSecondResult_numberOfBackgroundDocsProcessed(TFIDFCombinableResult firstResult, TFIDFCombinableResult secondResult){
		 secondResult.setProcessedDocumentCount(secondResult.getProcessedDocumentCount() + firstResult.getProcessedDocumentCount());
	}
}
