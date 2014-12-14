/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

/**
 *
 * @author hubert
 */
public class StemEntry implements Comparable<StemEntry>{
	private String word;
	private String stem;
	private String partOfSpeech;

	/**
	 * Checks to see if the StemEntry is equal to the object obj provided.
	 * @param obj
	 * @return true of the StemEntries are equivalent
	 * 
	 * Two stem entries are equivalent iff both objects are of class StemEntry,
	 * and the String contents of their stem and part of speech fields are the same.
	 * 
	 */
	@Override
	public boolean equals(Object obj){
		boolean isEquals = false;
		if(obj.getClass() == this.getClass()){
			StemEntry otherEntry = (StemEntry) obj;
			boolean stemComparison = org.apache.commons.lang3.StringUtils.equals(this.getStem(), otherEntry.getStem());
			boolean posComparison = org.apache.commons.lang3.StringUtils.equals(this.getPartOfSpeech(), otherEntry.getPartOfSpeech());
			isEquals = stemComparison && posComparison;
		}
		return isEquals;
	}
	
	@Override
	public int hashCode(){
		String combinedStemAndPOS = this.getStem()+this.getPartOfSpeech();
		return combinedStemAndPOS.hashCode();
	}
	
	@Override
	public int compareTo(StemEntry t) {
		StemEntry stemEntryT = (StemEntry) t;
		int stemComparison = this.stem.compareTo(stemEntryT.getStem());
		int posComparison = this.partOfSpeech.compareTo(stemEntryT.getPartOfSpeech());
		int result = stemComparison;
                
                if(result == 0){
                    result = result + posComparison;
                }
                
		return result;
	}
	
	public StemEntry(String word, String stem, String partOfSpeech){
		this.word = word;
		this.stem = stem;
		this.partOfSpeech = partOfSpeech;
	}
	
	public StemEntry(){
		this("","","");
	}
	
	@Override
	public String toString(){
		return "[" + this.word + ", " + this.stem + ", " + this.partOfSpeech + "]";
	}
	
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the stem
	 */
	public String getStem() {
		return stem;
	}

	/**
	 * @param stem the stem to set
	 */
	public void setStem(String stem) {
		this.stem = stem;
	}

	/**
	 * @return the partOfSpeech
	 */
	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	/**
	 * @param partOfSpeech the partOfSpeech to set
	 */
	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}

}
