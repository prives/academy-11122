package dial;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexDeal {
	
	protected boolean result;
	
	public RegexDeal() {
		super();
	}
	public boolean regexA (String date) {
		Pattern pattern = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");		
		Matcher matcher = pattern.matcher(date);
		
			if (matcher.find()) {
				return true;

			} else {
				return false;
			}
	}
	
	public boolean regexB (String date) {
		Pattern pattern = Pattern.compile("\\d{2}\\-\\d{2}\\-\\d{4}");		
		Matcher matcher = pattern.matcher(date);
		
			if (matcher.find()) {
				return true;
			} else {
				return false;
			}
	}
	
	public RegexDeal (String date) {
			Pattern pattern = Pattern.compile("\\d{2}(\\-|\\/)\\d{2}(\\-|\\/)\\d{4}");		
				
			Matcher matcher = pattern.matcher(date);
				
				if (matcher.find()) {
					this.result=true;
					
				} else {
					this.result=false;
				}
	}
	
}