package dial;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User{
		
	private String nickname;
	private double money;
	private String phone;
	private String email;
	private String dateOfBirth;
	
	public User () {
		super();
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		RegexDeal regexp = new RegexDeal(dateOfBirth);
		if (regexp.result==true) {
			this.dateOfBirth=dateOfBirth;
			System.out.println("Введенная строка является датой.");
		} else {
			System.out.println("Введенная строка не является датой.");
		}
	}
			
	public void setNickname (String nickname) {
		this.nickname=nickname;
	}
	public String getNickname () {
		return nickname;
	}
	public void setMoney (double money) {
		this.money=money;
	}
	public double getMoney () {
		return money;
	}
	public void setPhone (String phone) {
		this.phone=phone;
	}
	
	public boolean setValidPhone(String phone) {
		Validator bpv = new BelarusPhoneValidator();				
		if (bpv.isValid(phone)) {
			this.phone=phone;
			System.out.println("Введен корректный белорусский номер телефона.");
			return true;
		} else {
			System.out.println("Введен некорректный белорусский номер телефона.");
			return false;
		}
	}
	public void setValidAmericanPhone(String phone) {
		Validator apv = new AmericanPhoneValidator();				
		if (apv.isValid(phone)) {
			this.phone=phone;
			System.out.println("Введен американский номер телефона: "+phone);
		} else {
			System.out.println("Введенный номер телефона не является американским: "+phone);
		}
	}
	
	public String getPhone () {
		return phone;
	}
	
	public void setEmail (String email) {
		this.email=email;
	}
	
	public boolean setValidEmail(String email) {
		Validator ev = new EmailValidator();				
		if (ev.isValid(email)) {
			this.email=email;
			System.out.println("Email принят.");
			return true;
		} else {
			System.out.println("Email неккоректен.");
			return false;
		}
	}

	public String getEmail () {
		return email;
	}
	
	public String getDateOfBirth () {
		return dateOfBirth;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(money, nickname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Double.doubleToLongBits(money) == Double.doubleToLongBits(other.money)
				&& Objects.equals(nickname, other.nickname);
	}
	
	public String toString() {
		StringBuilder stbU = new StringBuilder();
		stbU.append("Пользователь: [имя=");
		stbU.append(nickname);
		stbU.append(", деньги=");
		stbU.append(money);
		stbU.append(", номер телефона=");
		stbU.append(phone);
		stbU.append(", электронная почта=");
		stbU.append(email);
		stbU.append("]");
		return stbU.toString();
	}
}