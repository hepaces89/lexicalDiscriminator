/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lexicaldiscriminator.start;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author hubert
 */
public class test1 {

    public static void main(String[] args) {
        //create a new Stanford CoreNLP object
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse");//, dcoref
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        //input text for analysis
        String text = "Good morning my name is Paul and I have a Guitar. I love to play the guitar. I also play the piano. Yesterday I watched the play Macbeth." + 
				" The bow legged performer used a bow to shoot a bow into a violin. He then tied a bow on to the bow of a boat and took a bow.";

        //create an empty annotation with the empty text
        Annotation document = new Annotation(text);
        
        //run all of the annotators on this text
        pipeline.annotate(document);
        
        //get a list of all the sentences in the text
        //a CoreMap is basically a map that uses class objects as keys and has values with custom types
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);
        
        //loop through all of the sentences
        for(CoreMap sentence : sentences){
            //loop through all the words in each sentence
            //a CoreLabel is basically a CoreMap but with additional token-specific methods
            for(CoreLabel token : sentence.get(TokensAnnotation.class)){
                // get the text of the token
                String word = token.get(TextAnnotation.class);
                //get the part of speech for the current token (word)
                String pos = token.get(PartOfSpeechAnnotation.class);
                // get the named entity tag annotation
                String ne = token.get(NamedEntityTagAnnotation.class);
				//get lemmatized/stemmed version
				String lemma = token.get(LemmaAnnotation.class);
				System.out.println(word + ":" + lemma + ":" + pos + ":" + ne);
            }
            
            //parse tree of the current sentence
            Tree tree = sentence.get(TreeAnnotation.class);
            
            //Stanford dependency graph of the current sentence.
            SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
        }

    }

}
