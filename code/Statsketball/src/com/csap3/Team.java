package com.csap3;

/**
 * The type Team.
 *
 * @author Tejas Prabhune, Sourish Saswade, Saaketh Nandakumar
 */
public class Team extends EntityInfo {
    private String abbreviation, city, conference, division, fullName, name;

    @Override
    public String toString() {
        return "Team [abbreviation=" + abbreviation + ", city=" + city + ", conference=" + conference + ", division="
                + division + ", fullName=" + fullName + ", name=" + name + "]";
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
