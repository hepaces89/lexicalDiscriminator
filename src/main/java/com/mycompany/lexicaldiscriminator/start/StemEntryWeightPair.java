/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

import com.mycompany.lexicaldiscriminator.start.StemEntry;

/**
 *
 * @author hubert
 */
public class StemEntryWeightPair {
	private StemEntry stemEntry;
	private Double weight;

	public StemEntryWeightPair(){
		this(null, null);
	}
	
	public StemEntryWeightPair(StemEntry stemEntry, Double weight){
		this.stemEntry = stemEntry;
		this.weight = weight;
	}
	
	/**
	 * @return the stemEntry
	 */
	public StemEntry getStemEntry() {
		return stemEntry;
	}

	/**
	 * @param stemEntry the stemEntry to set
	 */
	public void setStemEntry(StemEntry stemEntry) {
		this.stemEntry = stemEntry;
	}

	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
