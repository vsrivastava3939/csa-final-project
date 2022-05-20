package com.csap3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The type Player stats.
 *
 * @author Tejas Prabhune, Shray Kudva, Vaibhav Srivastava Sourish Saswade, Saaketh Nandakumar
 */
@JsonIgnoreProperties
public class PlayerStats extends EntityInfo {
    private double fg3a, blk, ftPct, fga, ast, dreb, stl, fgm;
    private double fgPct, reb, pts, fta, fg3m, oreb, gamesPlayed;
    private double pf, season, turnover, fg3Pct, ftm, playerId;
    private String min;

    @Override
    public String toString() {
        return "PlayerStats [fg3a=" + fg3a + ", blk=" + blk + ", ftPct=" + ftPct + ", fga=" + fga + ", ast=" + ast
                + ", dreb=" + dreb + ", stl=" + stl + ", fgm=" + fgm + ", fgPct=" + fgPct + ", reb=" + reb + ", pts="
                + pts + ", fta=" + fta + ", min=" + min + ", fg3m=" + fg3m + ", oreb=" + oreb + ", gamesPlayed="
                + gamesPlayed + ", pf=" + pf + ", season=" + season + ", turnover=" + turnover + ", fg3Pct=" + fg3Pct
                + ", ftm=" + ftm + ", playerId=" + playerId + "]";
    }

    /**
     * Gets fg 3 a.
     *
     * @return the fg3a
     */
    public double getFg3a() {
        return fg3a;
    }

    /**
     * Sets fg 3 a.
     *
     * @param fg3a the fg3a to set
     */
    public void setFg3a(double fg3a) {
        this.fg3a = fg3a;
    }

    /**
     * Gets blk.
     *
     * @return the blk
     */
    public double getBlk() {
        return blk;
    }

    /**
     * Sets blk.
     *
     * @param blk the blk to set
     */
    public void setBlk(double blk) {
        this.blk = blk;
    }

    /**
     * Gets ft pct.
     *
     * @return the ftPct
     */
    public double getFtPct() {
        return ftPct;
    }

    /**
     * Sets ft pct.
     *
     * @param ftPct the ftPct to set
     */
    public void setFtPct(double ftPct) {
        this.ftPct = ftPct;
    }

    /**
     * Gets fga.
     *
     * @return the fga
     */
    public double getFga() {
        return fga;
    }

    /**
     * Sets fga.
     *
     * @param fga the fga to set
     */
    public void setFga(double fga) {
        this.fga = fga;
    }

    /**
     * Gets ast.
     *
     * @return the ast
     */
    public double getAst() {
        return ast;
    }

    /**
     * Sets ast.
     *
     * @param ast the ast to set
     */
    public void setAst(double ast) {
        this.ast = ast;
    }

    /**
     * Gets dreb.
     *
     * @return the dreb
     */
    public double getDreb() {
        return dreb;
    }

    /**
     * Sets dreb.
     *
     * @param dreb the dreb to set
     */
    public void setDreb(double dreb) {
        this.dreb = dreb;
    }

    /**
     * Gets stl.
     *
     * @return the stl
     */
    public double getStl() {
        return stl;
    }

    /**
     * Sets stl.
     *
     * @param stl the stl to set
     */
    public void setStl(double stl) {
        this.stl = stl;
    }

    /**
     * Gets fgm.
     *
     * @return the fgm
     */
    public double getFgm() {
        return fgm;
    }

    /**
     * Sets fgm.
     *
     * @param fgm the fgm to set
     */
    public void setFgm(double fgm) {
        this.fgm = fgm;
    }

    /**
     * Gets fg pct.
     *
     * @return the fgPct
     */
    public double getFgPct() {
        return fgPct;
    }

    /**
     * Sets fg pct.
     *
     * @param fgPct the fgPct to set
     */
    public void setFgPct(double fgPct) {
        this.fgPct = fgPct;
    }

    /**
     * Gets reb.
     *
     * @return the reb
     */
    public double getReb() {
        return reb;
    }

    /**
     * Sets reb.
     *
     * @param reb the reb to set
     */
    public void setReb(double reb) {
        this.reb = reb;
    }

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
     * Gets fta.
     *
     * @return the fta
     */
    public double getFta() {
        return fta;
    }

    /**
     * Sets fta.
     *
     * @param fta the fta to set
     */
    public void setFta(double fta) {
        this.fta = fta;
    }

    /**
     * Gets min.
     *
     * @return the min
     */
    public String getMin() {
        return min;
    }

    /**
     * Sets min.
     *
     * @param min the min to set
     */
    public void setMin(String min) {
        this.min = min;
    }

    /**
     * Gets fg 3 m.
     *
     * @return the fg3m
     */
    public double getFg3m() {
        return fg3m;
    }

    /**
     * Sets fg 3 m.
     *
     * @param fg3m the fg3m to set
     */
    public void setFg3m(double fg3m) {
        this.fg3m = fg3m;
    }

    /**
     * Gets oreb.
     *
     * @return the oreb
     */
    public double getOreb() {
        return oreb;
    }

    /**
     * Sets oreb.
     *
     * @param oreb the oreb to set
     */
    public void setOreb(double oreb) {
        this.oreb = oreb;
    }

    /**
     * Gets games played.
     *
     * @return the gamesPlayed
     */
    public double getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     * Sets games played.
     *
     * @param gamesPlayed the gamesPlayed to set
     */
    public void setGamesPlayed(double gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    /**
     * Gets pf.
     *
     * @return the pf
     */
    public double getPf() {
        return pf;
    }

    /**
     * Sets pf.
     *
     * @param pf the pf to set
     */
    public void setPf(double pf) {
        this.pf = pf;
    }

    /**
     * Gets season.
     *
     * @return the season
     */
    public double getSeason() {
        return season;
    }

    /**
     * Sets season.
     *
     * @param season the season to set
     */
    public void setSeason(double season) {
        this.season = season;
    }

    /**
     * Gets turnover.
     *
     * @return the turnover
     */
    public double getTurnover() {
        return turnover;
    }

    /**
     * Sets turnover.
     *
     * @param turnover the turnover to set
     */
    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    /**
     * Gets fg 3 pct.
     *
     * @return the fg3Pct
     */
    public double getFg3Pct() {
        return fg3Pct;
    }

    /**
     * Sets fg 3 pct.
     *
     * @param fg3Pct the fg3Pct to set
     */
    public void setFg3Pct(double fg3Pct) {
        this.fg3Pct = fg3Pct;
    }

    /**
     * Gets ftm.
     *
     * @return the ftm
     */
    public double getFtm() {
        return ftm;
    }

    /**
     * Sets ftm.
     *
     * @param ftm the ftm to set
     */
    public void setFtm(double ftm) {
        this.ftm = ftm;
    }

    /**
     * Gets player id.
     *
     * @return the playerId
     */
    public double getPlayerId() {
        return playerId;
    }

    /**
     * Sets player id.
     *
     * @param playerId the playerId to set
     */
    public void setPlayerId(double playerId) {
        this.playerId = playerId;
    }


}
