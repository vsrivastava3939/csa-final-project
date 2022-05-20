public class Player extends EntityInfo {
	
	private String firstName, lastName, position;
	private String abbreviation, city, conference, division, fullName, teamName;
	private int heightFeet, heightInches, teamId;

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", position=" + position
				+ ", abbreviation=" + abbreviation + ", city=" + city
				+ ", conference=" + conference + ", division=" + division + ", fullName=" + fullName + ", teamName="
				+ teamName + ", heightFeet=" + heightFeet + ", heightInches=" + heightInches
				+ ", teamId=" + teamId + "]";
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the conference
	 */
	public String getConference() {
		return conference;
	}

	/**
	 * @param conference the conference to set
	 */
	public void setConference(String conference) {
		this.conference = conference;
	}

	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the heightFeet
	 */
	public int getHeightFeet() {
		return heightFeet;
	}

	/**
	 * @param heightFeet the heightFeet to set
	 */
	public void setHeightFeet(int heightFeet) {
		this.heightFeet = heightFeet;
	}

	/**
	 * @return the heightInches
	 */
	public int getHeightInches() {
		return heightInches;
	}

	/**
	 * @param heightInches the heightInches to set
	 */
	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}

	/**
	 * @return the teamId
	 */
	public int getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}


}
