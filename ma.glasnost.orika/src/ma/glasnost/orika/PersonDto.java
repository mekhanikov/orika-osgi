package ma.glasnost.orika;

import java.util.Arrays;
import java.util.Date;

public class PersonDto {
	  private String firstName;
	  private String lastName;
	  private Date birthDate;
	  private String[][] aliases;
	  
	  public String getFirstName() {
	    return firstName;
	  }
	  public String getLastName() {
	    return lastName;
	  }
	  public Date getBirthDate() {
	    return birthDate;
	  }
	  public String[][] getAliases() {
	    return aliases;
	  }
	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }
	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }
	  public void setBirthDate(Date birthDate) {
	    this.birthDate = birthDate;
	  }
	  public void setAliases(String[][] aliases) {
	    this.aliases = aliases;
	  }
	@Override
	public String toString() {
		return "PersonDto [firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", aliases="
				+ Arrays.toString(aliases) + "]";
	}
	  
	}