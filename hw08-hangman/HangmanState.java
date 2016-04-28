/**
 * 
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @section [Section Letter]
 * @date [date]
 *
 */

// You may not import any additional classes or packages.
import java.util.*;

public class HangmanState {
	//Do not change any of these global fields.
	public static final int NORMAL_MODE = 0;
	public static final int HURTFUL_MODE = 1;
	public static final int HELPFUL_MODE = 2;

	public String theAnswer;
	public Set<String> lettersGuessed;
	public String feedbackToUser;
	public Set<String> possibleAnswers;

	/**
	 * Complete the HangmanState constructor as indicated in the spec.
	 */
	public HangmanState(Set<String> knownWords) {
		Random ran = new Random();
		int n = ran.nextInt(knownWords.size());
		Iterator<String> ite = knownWords.iterator();
		for(int i = 0; i < n; i++){
			theAnswer = ite.next();
		}
		
		lettersGuessed = new HashSet<String>();
		feedbackToUser = "";
		for(int i = 0; i < theAnswer.length(); i++){
			feedbackToUser += "-";
		}
		
		possibleAnswers = new HashSet<String>();
		for(String s : knownWords){
			if(s.length() == theAnswer.length())
				possibleAnswers.add(s);
		}
		updatePossibleAnswers();
	}

	/**
	 * Complete the feedbackFor method as indicated in the spec.
	 */
	public String feedbackFor(String answer) {
		String s = answer;
		String res = "";
		StringIterator ite = new StringIterator(s);
		while(ite.hasNext()){
			String str = ite.next();
			if(lettersGuessed.contains(str))
				res += str;
			else
				res += "-";
		}
		return res;
	}

	/**
	 * Complete the wrongGuesses method as indicated in the spec.
	 */
	public Set<String> wrongGuesses() {
		Set<String> res = new HashSet<String>();
		for(String s : lettersGuessed){
			if(feedbackToUser.toLowerCase().contains(s.toLowerCase()))
				continue;
			res.add(s);
		}
		return res;
	}

	/**
	 * Complete the letterGuessedByUser method as indicated in the spec.
	 */
	public void letterGuessedByUser(String letter, int mode) {
		if(mode == NORMAL_MODE){
			lettersGuessed.add(letter);
			feedbackToUser = feedbackFor(theAnswer);
			updatePossibleAnswers();
		}else if(mode == HURTFUL_MODE){
			lettersGuessed.add(letter);
			Map<String, Integer> map = generateFeedbackMap();
			feedbackToUser = mostCommonFeedback(map);
			updatePossibleAnswers();
		}else if(mode == HELPFUL_MODE){
			lettersGuessed.add(letter);
			Map<String, Integer> map = generateFeedbackMap();
			if(map.size() == 1){
				Set<String> keys = map.keySet();
				for(String eleKey : keys){
					feedbackToUser = eleKey;
				}
				updatePossibleAnswers();
				return;
			}
			String tmp = mostCommonFeedback(map);
			while(!tmp.contains(letter)){
				map.remove(tmp);
				tmp = mostCommonFeedback(map);
			}
			feedbackToUser = tmp;
			updatePossibleAnswers();
		}else;
	}

	/**
	 * Complete the updatePossibleAnswers() as indicated in the spec.
	 */
	public void updatePossibleAnswers() {
		Set<String> wrong = wrongGuesses();
		Set<String> tmp = new HashSet<String>();
		for(String s : possibleAnswers){
			boolean f = false;
			for(String ele : wrong){
				if(s.contains(ele)){
					tmp.add(s);
					f = true;
					break;
				}		
			}
			if(f) continue;
			StringIterator sIte = new StringIterator(s);
			StringIterator ansIte = new StringIterator(feedbackToUser);
			while(sIte.hasNext()){
				String eleS = sIte.next();
				String eleAns = ansIte.next();
				if(!eleAns.equals("-") && !eleAns.equals(eleS)){
					tmp.add(s);
					break;
				}
			}
		}
		possibleAnswers.removeAll(tmp);
	}

	/**
	 * Complete the generateFeedbackMap method as indicated in the spec.
	 */
	public Map<String, Integer> generateFeedbackMap() {
		Map<String, Integer> res = new HashMap<String, Integer>();
		for(String s : possibleAnswers){
			String key = feedbackFor(s);
			if(res.containsKey(key)){
				int val = res.get(key);
				res.put(key, val + 1);
			}else
				res.put(key, 1);
		}
		return res;
	}

	/**
	 * Complete the mostCommonFeedback method as indicated in the spec.
	 */
	public String mostCommonFeedback(Map<String, Integer> feedbackMap) {
		Set<String> keys = feedbackMap.keySet();
		String res = "";
		int val = 0;
		for(String s : keys){
			res = (feedbackMap.get(s) > val) ? s : res; 
			val = Math.max(val, feedbackMap.get(s));
		}
		return res;
	}

    /* Do not modify the methods below. */

	public String getFeedbackToUser() {
		return feedbackToUser;
	}

	public String toString() {
		return feedbackToUser + "\t\t" + wrongGuesses() + "\t\t"
				+ possibleAnswers.size();
	}
//	public static void main(String[] args){
//		Set<String> s = new HashSet<String>();
//		s.add("secret");
//		s.add("element");
//		s.add("bad");
//		HangmanState h = new HangmanState(s);
//		System.out.println(h.feedbackFor("e"));
//	}
}
