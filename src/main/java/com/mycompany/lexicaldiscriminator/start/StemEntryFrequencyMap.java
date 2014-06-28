/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

/**
 *
 * @author hubert
 * @param <StemEntry>
 * @param <Integer>
 */
public class StemEntryFrequencyMap extends java.util.HashMap{
	public StemEntryFrequencyMap(){
		super();
	}
	

	public void add(StemEntry stemEntry){
		if(this.containsKey(stemEntry)){
			Integer oldValue = (Integer)this.get(stemEntry);
			this.put(stemEntry, 1 + oldValue);
		} else {
			this.put(stemEntry, 1);
		}
		
	}
	
	public void main(String[] args){

	}
	
}
