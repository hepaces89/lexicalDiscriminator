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
 */
public class StemEntryFrequencyTreeMap extends java.util.TreeMap<StemEntry, Integer>{
    public StemEntryFrequencyTreeMap(){
        super();
    }
    
    public StemEntryFrequencyTreeMap(StemEntryFrequencyMap sefm){
        this.putAll(sefm);
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
}
