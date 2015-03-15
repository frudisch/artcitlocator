package artcitlocator.control;

import java.util.ArrayList;

import artcitlocator.wikipedia.crawling.control.data.Entity;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class POSAnalyze {

	private MaxentTagger tagger;

	public POSAnalyze() {
		tagger = new MaxentTagger("edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");
	}

	public ArrayList<Entity> tagText(String text) {
		ArrayList<Entity> rc = new ArrayList<Entity>();
		String tagged = tagger.tagString(text);
		
		String[] tagArr = tagged.split(" ");
		for (int i = 0; i < tagArr.length; i++) {
			String name = tagArr[i].split("_")[0].trim().toLowerCase();
			String type = tagArr[i].split("_")[1].trim().toLowerCase();
			rc.add(new Entity(name, type));
		}
		
		return rc;
	}

	public static void main(String[] args) {
		String text = "I loved Paris. I'm with Barack Obama";

		POSAnalyze test = new POSAnalyze();
		
		ArrayList<Entity> reCode = test.tagText(text);
		
		for (Entity entity : reCode) {
			System.out.println(entity.getName() + " Type: " + entity.getType());
		}
	}
}
