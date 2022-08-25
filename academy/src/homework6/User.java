package homework6;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

//Создайте класс User с полями Имя, Фамилия, Возраст и конструктором(Имя, Фамилия, Возраст).
//В классе Main создайте ArrayList<User>, добавьте 10 пользователей в коллекцию. Создайте каталог(папку)
//users и для каждого пользователя создайте файл в этом каталоге. Назовите файл Имя_Фамилия.txt.
//Сериализуйте информацию о пользователе и положите в файл пользователя. Не забываем закрывать потоки.
//В блоке catch выводим сообщение ошибки на экран (System.err.println(e.getMessage());)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Ivan", "Ivanov", 23));
        users.add(new User("Sergey", "Petrov", 25));
        users.add(new User("Petr", "Sidorov", 24));
        users.add(new User("Masha", "Kozlova", 26));
        users.add(new User("Natasha", "Orlova", 23));
        users.add(new User("Marina", "Vasileva", 27));
        users.add(new User("Vasiliy", "Terkin", 23));
        users.add(new User("Stepan", "Paramonov", 29));
        users.add(new User("Igor", "Zaharov", 24));
        users.add(new User("Olga", "Lopuhina", 29));

        File dir = new File("src/io/users");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        for (int i = 0; i < users.size(); i++) {
            String fileName = users.get(i).getName() + "_" + users.get(i).getSurname() + ".txt";
            File newFile = new File(dir, fileName);
            if (!newFile.exists()) {
                newFile.createNewFile();
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
                     ObjectOutputStream oos = new ObjectOutputStream(bos)) {
                    oos.writeObject(users.get(i).toString());

                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }

            }
        }
    }
}