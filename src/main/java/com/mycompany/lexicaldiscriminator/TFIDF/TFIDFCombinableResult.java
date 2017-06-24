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
	private KeyToStemEntryFrequencyMapMap<String> stemFrequencysByTopic;
	private StemEntryFrequencyMap documentPresenceMap;

	public TFIDFCombinableResult(){
		this.numberOfBackgroundDocsProcessed = 0;
		this.stemFrequencysByTopic = new KeyToStemEntryFrequencyMapMap<>();
		this.documentPresenceMap = new StemEntryFrequencyMap();
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
		return documentPresenceMap;
	}

	/**
	 * @param wordToNumberOfBackGroundDocsTheWordOccursInMapping the wordToNumberOfBackGroundDocsTheWordOccursInMapping to set
	 */
	public void setWordToNumberOfBackGroundDocsTheWordOccursInMapping(StemEntryFrequencyMap wordToNumberOfBackGroundDocsTheWordOccursInMapping) {
		this.documentPresenceMap = wordToNumberOfBackGroundDocsTheWordOccursInMapping;
	}

	/**
	 * @return the topicToForeGroundStatDTOMapping
	 */
	public KeyToStemEntryFrequencyMapMap<String> getTopicToForeGroundStatDTOMapping() {
		return stemFrequencysByTopic;
	}

	/**
	 * @param topicToForeGroundStatDTOMapping the topicToForeGroundStatDTOMapping to set
	 */
	public void setTopicToForeGroundStatDTOMapping(KeyToStemEntryFrequencyMapMap<String> topicToForeGroundStatDTOMapping) {
		this.stemFrequencysByTopic = topicToForeGroundStatDTOMapping;
	}
}
