package com.csap3;

/**
 * The type Player.
 * @author Tejas Prabhune, Sourish Saswade, Saaketh Nandakumar
 */
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
     * Gets first name.
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Gets abbreviation.
     *
     * @return the abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets abbreviation.
     *
     * @param abbreviation the abbreviation to set
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets conference.
     *
     * @return the conference
     */
    public String getConference() {
        return conference;
    }

    /**
     * Sets conference.
     *
     * @param conference the conference to set
     */
    public void setConference(String conference) {
        this.conference = conference;
    }

    /**
     * Gets division.
     *
     * @return the division
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets division.
     *
     * @param division the division to set
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * Gets full name.
     *
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets team name.
     *
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Sets team name.
     *
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Gets height feet.
     *
     * @return the heightFeet
     */
    public int getHeightFeet() {
        return heightFeet;
    }

    /**
     * Sets height feet.
     *
     * @param heightFeet the heightFeet to set
     */
    public void setHeightFeet(int heightFeet) {
        this.heightFeet = heightFeet;
    }

    /**
     * Gets height inches.
     *
     * @return the heightInches
     */
    public int getHeightInches() {
        return heightInches;
    }

    /**
     * Sets height inches.
     *
     * @param heightInches the heightInches to set
     */
    public void setHeightInches(int heightInches) {
        this.heightInches = heightInches;
    }

    /**
     * Gets team id.
     *
     * @return the teamId
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Sets team id.
     *
     * @param teamId the teamId to set
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }


}
