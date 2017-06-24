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
	private Integer processedDocumentCount = 0;
	private KeyToStemEntryFrequencyMapMap<String> stemFrequenciesByTopic;
	private StemEntryFrequencyMap documentCountsPerStem;

	public TFIDFCombinableResult(){
		this.processedDocumentCount = 0;
		this.stemFrequenciesByTopic = new KeyToStemEntryFrequencyMapMap<>();
		this.documentCountsPerStem = new StemEntryFrequencyMap();
	}
	/**
	 * @return the numberOfBackgroundDocsProcessed
	 */
	public Integer getProcessedDocumentCount() {
		return processedDocumentCount;
	}

	/**
	 * @param numberOfBackgroundDocsProcessed the numberOfBackgroundDocsProcessed to set
	 */
	public void setProcessedDocumentCount(Integer numberOfBackgroundDocsProcessed) {
		this.processedDocumentCount = numberOfBackgroundDocsProcessed;
	}

	/**
	 * @return the wordToNumberOfBackGroundDocsTheWordOccursInMapping
	 */
	public StemEntryFrequencyMap getDocumentCountsPerStemMapping() {
		return documentCountsPerStem;
	}

	/**
	 * @param wordToNumberOfBackGroundDocsTheWordOccursInMapping the wordToNumberOfBackGroundDocsTheWordOccursInMapping to set
	 */
	public void setDocumentCountsPerStem(StemEntryFrequencyMap wordToNumberOfBackGroundDocsTheWordOccursInMapping) {
		this.documentCountsPerStem = wordToNumberOfBackGroundDocsTheWordOccursInMapping;
	}

	/**
	 * @return the topicToForeGroundStatDTOMapping
	 */
	public KeyToStemEntryFrequencyMapMap<String> getStemFrequenciesByTopic() {
		return stemFrequenciesByTopic;
	}

	/**
	 * @param topicToForeGroundStatDTOMapping the topicToForeGroundStatDTOMapping to set
	 */
	public void setStemFrequenciesByTopic(KeyToStemEntryFrequencyMapMap<String> topicToForeGroundStatDTOMapping) {
		this.stemFrequenciesByTopic = topicToForeGroundStatDTOMapping;
	}
}
