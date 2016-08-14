package demo;

public class HTMLParser {

	private boolean tag;
	
	public String removeTag(String htmlText){
		
		String output = "";
		
		char[] cList = htmlText.toCharArray();
		
		for(int i=0; i<htmlText.length(); i++){
			char charPrevious = (i>0) ? cList[i-1] : '#';
			char charNext = (i<htmlText.length()-1) ? cList[i+1] : '#';
			
			char thisChar = cList[i];
			output = modifyOutput(output, thisChar);
		}
		return output;
	}
	
	private String modifyOutput(String output, char c){
		String newOutput = output;
		if(c == '<'){
			tag = true;
		}
		else if(c == '>'){
			tag = false;
		}
		else if(!tag){
			newOutput = newOutput + c;
		}
		return newOutput;
	}
	
	public static void main(String[] args) {
		HTMLParser main = new HTMLParser();
		String input = "<a href=\">\">test</a>";
		
		String output = main.removeTag(input);
		System.out.println(output.equals("test"));

	}

}
