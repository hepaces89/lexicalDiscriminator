/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author hubert
 */
public class StemEntryWeightMappingEntryComparator implements Comparator<java.util.Map.Entry<StemEntry, Double>> {

	@Override
	public int compare(Map.Entry<StemEntry, Double> t, Map.Entry<StemEntry, Double> t1) {
		int result = Double.compare(t1.getValue(), t.getValue());
		int strResult = t.getKey().compareTo(t1.getKey());
		if(result == 0){
			result = result + strResult;
		}
		return result;
	}
}
