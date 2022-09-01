package dial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator{

	@Override
	public boolean isValid(String string) {
		Pattern pattern = Pattern.compile("\\w+@[a-zA-Z]+?\\.[a-zA-Z]{2,6}");
		Matcher matcher = pattern.matcher(string);	
		if(matcher.lookingAt()) {
			return true;
		}
		return false;
	}

	
}