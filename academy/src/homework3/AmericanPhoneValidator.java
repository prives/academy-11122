package homework3;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AmericanPhoneValidator implements Validator {
	
	
	
	 @Override
	    public boolean validate(String number) {
	        Pattern pattern = Pattern.compile("\\+1\\d{10}");
	        Matcher matcher = pattern.matcher(number);
	        return matcher.matches();
	    }
}
