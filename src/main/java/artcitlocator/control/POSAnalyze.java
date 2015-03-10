package artcitlocator.control;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class POSAnalyze {

	private MaxentTagger tagger;

	public POSAnalyze() {
		tagger = new MaxentTagger("edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");
	}

	public void tagText(String text) {

		String tagged = tagger.tagString(text);

		System.out.println(tagged);
	}

	public static void main(String[] args) {
		String text = "I loved Paris. I'm with Barack Obama";

		POSAnalyze test = new POSAnalyze();
		
		test.tagText(text);
	}
}
