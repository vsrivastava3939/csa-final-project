package com.csap3;

/**
 * The type Team stats.
 *
 * @author Tejas Prabhune, Shray Kudva, Vaibhav Srivastava Sourish Saswade, Saaketh Nandakumar
 */
public class TeamStats extends EntityInfo {

    private double pts;
    private int wins;

    /**
     * Gets pts.
     *
     * @return the pts
     */
    public double getPts() {
        return pts;
    }

    /**
     * Sets pts.
     *
     * @param pts the pts to set
     */
    public void setPts(double pts) {
        this.pts = pts;
    }

    /**
     * Gets wins.
     *
     * @return the wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Sets wins.
     *
     * @param wins the wins to set
     */
    public void setWins(int wins) {
        this.wins = wins;
    }
}
