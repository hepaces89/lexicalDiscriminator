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
public class StemEntry implements Comparable{
	private String word;
	private String stem;
	private String partOfSpeech;

	@Override
	public int compareTo(Object t){
		//guard statements
		if(t.getClass() != this.getClass()){
			return -1;
		}
		StemEntry stemEntryT = (StemEntry) t;
		int wordComparison = this.stem.compareTo(stemEntryT.getStem());
		int posComparison = this.partOfSpeech.compareTo(stemEntryT.getPartOfSpeech());
		int result = wordComparison + posComparison;
		if(result == 0 && (wordComparison != 0 || posComparison !=0) ){
			result = 1;
		}
		return result;
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
