/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.TFIDF;

import com.mycompany.lexicaldiscriminator.start.KeyToStemEntryFrequencyMapMap;
import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMap;

/**
 *
 * @author hubert
 */
public class TFIDFCombinableResult {
	private Integer numberOfBackgroundDocsProcessed = 0;
	private KeyToStemEntryFrequencyMapMap<String> topicToForeGroundStatDTOMapping;
	private StemEntryFrequencyMap wordToNumberOfBackGroundDocsTheWordOccursInMapping;

	public TFIDFCombinableResult(){
		this.numberOfBackgroundDocsProcessed = 0;
		this.topicToForeGroundStatDTOMapping = new KeyToStemEntryFrequencyMapMap<>();
		this.wordToNumberOfBackGroundDocsTheWordOccursInMapping = new StemEntryFrequencyMap();
	}
	/**
	 * @return the numberOfBackgroundDocsProcessed
	 */
	public Integer getNumberOfBackgroundDocsProcessed() {
		return numberOfBackgroundDocsProcessed;
	}

	/**
	 * @param numberOfBackgroundDocsProcessed the numberOfBackgroundDocsProcessed to set
	 */
	public void setNumberOfBackgroundDocsProcessed(Integer numberOfBackgroundDocsProcessed) {
		this.numberOfBackgroundDocsProcessed = numberOfBackgroundDocsProcessed;
	}

	/**
	 * @return the wordToNumberOfBackGroundDocsTheWordOccursInMapping
	 */
	public StemEntryFrequencyMap getWordToNumberOfBackGroundDocsTheWordOccursInMapping() {
		return wordToNumberOfBackGroundDocsTheWordOccursInMapping;
	}

	/**
	 * @param wordToNumberOfBackGroundDocsTheWordOccursInMapping the wordToNumberOfBackGroundDocsTheWordOccursInMapping to set
	 */
	public void setWordToNumberOfBackGroundDocsTheWordOccursInMapping(StemEntryFrequencyMap wordToNumberOfBackGroundDocsTheWordOccursInMapping) {
		this.wordToNumberOfBackGroundDocsTheWordOccursInMapping = wordToNumberOfBackGroundDocsTheWordOccursInMapping;
	}

	/**
	 * @return the topicToForeGroundStatDTOMapping
	 */
	public KeyToStemEntryFrequencyMapMap<String> getTopicToForeGroundStatDTOMapping() {
		return topicToForeGroundStatDTOMapping;
	}

	/**
	 * @param topicToForeGroundStatDTOMapping the topicToForeGroundStatDTOMapping to set
	 */
	public void setTopicToForeGroundStatDTOMapping(KeyToStemEntryFrequencyMapMap<String> topicToForeGroundStatDTOMapping) {
		this.topicToForeGroundStatDTOMapping = topicToForeGroundStatDTOMapping;
	}
}
