import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class person {
    private String name;
    private Date dob;
    private int age;

    public person(String name, String dob) throws ParseException {
        this.name = name;
        this.dob = new SimpleDateFormat("dd-mm-yyyy").parse(dob);
        this.age = calculateAge();
    }

    private int calculateAge() {
        Date today = new Date();
        long ageInMillis = today.getTime() - dob.getTime();
        return (int) (ageInMillis / (1000 * 60 * 60 * 24 * 365));
    }

    public void displayPersonDetails() {
        System.out.println("NAME:" + name);
        System.out.println("DATE OF BIRTH:" + new SimpleDateFormat("dd-mm-yyyy").format(dob));
        System.out.println("AGE:" + age);
    }

    public static void main(String[] args) throws ParseException {
        person person = new person("jhon DOE", "10-05-1985");
        person.displayPersonDetails();
    }
}