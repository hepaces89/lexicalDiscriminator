/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.TFIDF;

import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMap;

/**
 *
 * @author hubert
 */
public class TFIDFCombinableResult {
	private Integer numberOfBackgroundDocsProcessed = 0;
	private java.util.HashMap<String, ForeGroundStatDTO> topicToForeGroundStatDTOMapping;
	private StemEntryFrequencyMap wordToNumberOfBackGroundDocsTheWordOccursInMapping;

	public TFIDFCombinableResult(){
		this.numberOfBackgroundDocsProcessed = 0;
		this.topicToForeGroundStatDTOMapping = new java.util.HashMap<String, ForeGroundStatDTO>();
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
	 * @return the topicToForeGroundStatDTOMapping
	 */
	public java.util.HashMap<String, ForeGroundStatDTO> getTopicToForeGroundStatDTOMapping() {
		return topicToForeGroundStatDTOMapping;
	}

	/**
	 * @param topicToForeGroundStatDTOMapping the topicToForeGroundStatDTOMapping to set
	 */
	public void setTopicToForeGroundStatDTOMapping(java.util.HashMap<String, ForeGroundStatDTO> topicToForeGroundStatDTOMapping) {
		this.topicToForeGroundStatDTOMapping = topicToForeGroundStatDTOMapping;
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
}
