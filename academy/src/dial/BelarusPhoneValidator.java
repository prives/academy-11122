package dial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BelarusPhoneValidator implements Validator {
	
	@Override
	public boolean isValid(String string) {

		Pattern pattern = Pattern.compile("\\+375\\d{2}-?\\d{3}-?\\d{2}-?\\d{2}");
		Matcher matcher = pattern.matcher(string);	
		if(matcher.find()) {
			return true;
			}
			return false;
	 }			
}