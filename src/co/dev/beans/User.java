package co.dev.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserDetails")
public class User {



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;



    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "gender")
    private String gender;



    @Column(name = "city")
    private String City;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="email")
    private String email;

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

	
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;

    }


    public String getFirstName() {
        return firstName;

    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }


    public String getLastName() {
        return lastName;

    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getGender() {
        return gender;

    }

    public void setGender(String gender) {
        this.gender = gender;

    }


    public String getCity() {
        return City;
    }


    public void setCity(String city) {
        City = city;
    }
    
}

