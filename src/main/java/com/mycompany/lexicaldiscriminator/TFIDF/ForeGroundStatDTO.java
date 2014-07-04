/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.TFIDF;

import com.mycompany.lexicaldiscriminator.start.StemEntryFrequencyMap;

/**
 * A StemEntryFrequencyMap (hashmap) of words mapped to the number of times 
 * those words appeared in the foreground doc set associated with the foreGroundTopic.
 * @author hubert
 */
public class ForeGroundStatDTO extends StemEntryFrequencyMap{
	private String foreGroundTopic = "";

	/**
	 * @return the foreGroundTopic
	 */
	public String getForeGroundTopic() {
		return foreGroundTopic;
	}

	/**
	 * @param foreGroundTopic the foreGroundTopic to set
	 */
	public void setForeGroundTopic(String foreGroundTopic) {
		this.foreGroundTopic = foreGroundTopic;
	}
	
}
