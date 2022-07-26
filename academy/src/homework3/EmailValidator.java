package homework3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class EmailValidator {

	
	@Override
    public boolean validate(String number) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9]+[\\-]?[A-Za-z0-9]+[\\.]?[A-Za-z0-9]+@(yandex\\.ru|mail.ru|gmail\\.com)");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
	
}
