/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lexicaldiscriminator.start;

import java.util.Iterator;
import java.util.Map;

/**
 * This class is a specialized map that keeps track of the StemEntries found and an Integer
 * associated with the StemEntry (i.e. a word count or a presence count)
 * @author hubert
 */
public class StemEntryFrequencyMap extends java.util.HashMap<StemEntry, Integer> {

	public StemEntryFrequencyMap() {
		super();
	}

	/**
	 * Adds the stem entry to the hashmap.
	 * If a collision occurs the Integer associated with the stem will be incremented by one
	 * If no collision occurs, then a new entry for the stem will be created that is mapped
	 * to a value of one.
	 * @param stemEntry 
	 */
	public void add(StemEntry stemEntry) {
		this.add(stemEntry, 1);
	}
	
	public Integer get(StemEntry stemEntry){
		Integer returnVal = super.get(stemEntry);
		if(returnVal == null){
			returnVal = 0;
		}
		return returnVal;
	}
	
	/**
	 * Adds the stemEntry to the hashmap. If the stemEntry provided is not already
	 * present in the map, a new entry is created that is mapped to the provided "anotherCount"
	 * If a collision occurs, the existing value that is mapped to by the stem
	 * is incremented by the "anotherCount" value.
	 * @param stemEntry
	 * @param anotherCount 
	 */
	public void add(StemEntry stemEntry, Integer anotherCount) {
		if (this.containsKey(stemEntry)) {
			Integer oldValue = this.get(stemEntry);
			this.put(stemEntry, anotherCount + oldValue);
		} else {
			this.put(stemEntry, anotherCount);
		}
	}

	@Override
	public String toString() {
		String output = "{";
		Iterator it = this.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<StemEntry, Integer> ent = (Map.Entry<StemEntry, Integer>) it.next();
			output = output + "\n[" + ent.getKey().toString() + " | " + ent.getValue() + "]";
		}
		output = output + "\n}";
		return output;
	}

	/**
	 *
	 * @param other
	 * @return
	 */
	@Override
	public boolean equals(Object other){
		boolean serve = false;
		if(other instanceof StemEntryFrequencyMap){
			StemEntryFrequencyMap oSEFM = (StemEntryFrequencyMap) other;
			if(this.size() == oSEFM.size()){
				serve = org.apache.commons.collections4.CollectionUtils.isEqualCollection(this.entrySet(), oSEFM.entrySet());
			}
		}
		return serve;
	}
	public void main(String[] args) {

	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
