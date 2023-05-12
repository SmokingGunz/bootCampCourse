package com.coderscampus.lesson1;

public class Person {
	private Integer ssn;
	private String firstName;
	private String lastName;

	public Person(int ssn, String firstName, String lastName) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
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

	@Override
	public String toString() {
		return "Person [ssn=" + ssn + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	// Source > Generate hashCode() and equals will allow you to set which value to
	// use when comparing entries. in this case we use ssn. Do this when storing
	// POJO inside of a data structure like LinkedHashSet etc.

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}

}
