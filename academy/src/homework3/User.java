package homework3;

import java.util.Objects;

public class User {

	 private String name;
	    private double money;
	    private String dateOfBirch;
	    private String phone;
	    private String email;

	    public User(String name, double money) {
	        this.name = name;
	        this.money = money;
	    }

	    public String getDateOfBirch() {
	        return dateOfBirch;
	    }

	    public void setDateOfBirch(String dateOfBirch) {
	        this.dateOfBirch = dateOfBirch;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getMoney() {
	        return money;
	    }

	    public void setMoney(double money) {
	        this.money = money;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        User user = (User) o;
	        return Double.compare(user.money, money) == 0 && Objects.equals(name, user.name) && Objects.equals(dateOfBirch, user.dateOfBirch) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email);
	    }

	    @Override
	    public String toString() {
	        return "User{" +
	                "name='" + name + '\'' +
	                ", money=" + money +
	                ", dateOfBirch='" + dateOfBirch + '\'' +
	                ", phone='" + phone + '\'' +
	                ", email='" + email + '\'' +
	                '}';
	    }
	
}
