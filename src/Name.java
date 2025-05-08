public class Name {
	private final String secondName;
	private final String firstName;
	private final String lastName;

	public Name() {
		this.secondName = null;
		this.firstName = null;
		this.lastName = null;
	}

	Name(String secondName, String firstName, String lastName) {
		this.secondName = secondName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (secondName != null) sb.append(secondName).append(" ");
		if (firstName != null) sb.append(firstName).append(" ");
		if (lastName != null) sb.append(lastName).append(" ");
		return sb.toString().trim();
	}
}


