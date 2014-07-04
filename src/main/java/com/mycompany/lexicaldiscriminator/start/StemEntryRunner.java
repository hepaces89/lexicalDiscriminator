/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lexicaldiscriminator.start;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author hubert
 */
public class StemEntryRunner{
	Logger logger = Logger.getLogger("StemEntryRunner-"+this.hashCode());
	private StanfordCoreNLP textProcessor;
	public StemEntryRunner(){
		//create a new Stanford CoreNLP object
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");//, dcoref
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		this.textProcessor = pipeline;
	}
	
	/**
	 * Processes the document adding all of the component words into the StemEntryFrequencyMap
	 * @param document
	 * @param stemEntryFrequencyMap 
	 */
	public void processDocument(Annotation document, StemEntryFrequencyMap[] stemEntryFrequencyMaps){
		this.textProcessor.annotate(document);
		//get a list of all the sentences in the text
        //a CoreMap is basically a map that uses class objects as keys and has values with custom types
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
		//loop through all of the sentences
		StemEntry stemEntry = null;
        for(CoreMap sentence : sentences){
            //loop through all the words in each sentence
            //a CoreLabel is basically a CoreMap but with additional token-specific methods
            for(CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)){
                // get the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                //get the part of speech for the current token (word)
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
				//get lemmatized/stemmed version
				String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
				
				logger.debug("Processing " + word + ":" + lemma + ":" + pos);
				stemEntry = new StemEntry(word, lemma, pos);
				
				processStemEntry(stemEntryFrequencyMaps, stemEntry);
            }

        }
	}

	protected void processStemEntry(StemEntryFrequencyMap[] stemEntryFrequencyMaps, StemEntry stemEntry) {
		stemEntryFrequencyMaps[0].add(stemEntry);
	}
}
