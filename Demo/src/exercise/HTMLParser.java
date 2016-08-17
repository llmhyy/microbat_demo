package exercise;

public class HTMLParser {

	private boolean tag;
	private boolean quote = false;
	
	public String removeTag(String htmlText){
		
		String output = "";
		
		char[] cList = htmlText.toCharArray();
		
		for(int i=0; i<htmlText.length(); i++){
			String charPrevious = (i>0) ? String.valueOf(cList[i-1]) : "NA";
			String charNext = (i<htmlText.length()-1) ? String.valueOf(cList[i+1]) : "NA";
			
			char thisChar = cList[i];
			output = modifyOutput(output, thisChar);
		}
		return output;
	}
	
	private String modifyOutput(String output, char c){
		String newOutput = output;
		if(c == '<' && !quote){
			tag = true;
		}
		else if(c == '>' && !quote){
			tag = false;
		}
		else if(c == '\"' || c == '\'' && tag){
			quote = !quote;
		}
		else if(!tag){
			newOutput = newOutput + c;
		}
		return newOutput;
	}
	
	public static void main(String[] args) {
		HTMLParser main = new HTMLParser();
		String input = "<a>\"test\"</a>";
//		String input = "<a href=\">\">test</a>";
		
		String output = main.removeTag(input);
		System.out.println(output.equals("\"test\""));
//		System.out.println(output.equals("test"));

	}

}
