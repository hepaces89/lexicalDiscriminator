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
public class StemEntryFrequencyMap extends java.util.HashMap<StemEntry, Integer> {

	public StemEntryFrequencyMap() {
		super();
	}

	public void add(StemEntry stemEntry) {
		this.add(stemEntry, 1);
	}
	
	public void add(StemEntry stemEntry, Integer anotherCount) {
		if (this.containsKey(stemEntry)) {
			Integer oldValue = (Integer) this.get(stemEntry);
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

	public void main(String[] args) {

	}

}
