package homework3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Date {

	
	 public boolean checkDate1 (String date) {
	        Pattern pattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[012])\\/((19[4-9][0-9])|(20[0,1][0-9])|(202[0-2]))");
	        Matcher matcher = pattern.matcher(date);
	        return matcher.matches();
	    }

	    public boolean checkDate2 (String date){
	        Pattern pattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])\\-(0[1-9]|1[012])\\-((19[4-9][0-9])|(20[0,1][0-9])|(202[0-2]))");
	        Matcher matcher = pattern.matcher(date);
	        return matcher.matches();
	    }
}
