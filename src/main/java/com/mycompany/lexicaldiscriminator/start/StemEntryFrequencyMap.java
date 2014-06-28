/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

import java.util.Iterator;
import java.util.Map;

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
	
	@Override
	public String toString(){
		String output = "{";
		Iterator it = this.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<StemEntry, Integer> ent = (Map.Entry<StemEntry, Integer>)it.next();
			output = output + "\n[" + ent.getKey().toString() + " | " + ent.getValue() + "]";
		}
		output = output + "\n}";
		return output;
	}
	
	public void main(String[] args){

	}
	
}
