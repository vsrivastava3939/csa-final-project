package com.csap3;

/**
 * The type Team stats.
 *
 * @author Tejas Prabhune, Shray Kudva, Vaibhav Srivastava, Sourish Saswade, Saaketh Nandakumar
 */
public class TeamStats extends EntityInfo {

    private int pts;
    private int highPts;

    /**
     * Gets pts.
     *
     * @return the pts
     */
    public int getPts() {
        return pts;
    }

    @Override
	public String toString() {
		return "TeamStats [pts=" + pts + ", highPts=" + highPts + "]";
	}

	/**
	 * @return the highPts
	 */
	public int getHighPts() {
		return highPts;
	}

	/**
	 * @param highPts the highPts to set
	 */
	public void setHighPts(int highPts) {
		this.highPts = highPts;
	}

	/**
     * Sets pts.
     *
     * @param pts the pts to set
     */
    public void setPts(int pts) {
        this.pts = pts;
    }

}
