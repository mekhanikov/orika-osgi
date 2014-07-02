package ma.glasnost.orika;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Person {
	private Name name;
	private List<Name> knownAliases;
	private Date birthDate;

	public Person(Name name, Date birthDate, 
			List<Name> knownAliases) {
		this.name = name;
		this.birthDate = (Date) birthDate.clone();
		this.knownAliases = new ArrayList<Name>(knownAliases);
	}
	public List<Name> getKnownAliases() {
		return Collections.unmodifiableList(knownAliases);
	}
	public Name getName() {
		return name;
	}
	public Date getBirthDate() {
		return (Date) birthDate.clone();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", knownAliases=" + knownAliases
				+ ", birthDate=" + birthDate + "]";
	}
	
}
