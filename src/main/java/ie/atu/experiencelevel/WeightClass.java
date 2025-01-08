package ie.atu.experiencelevel;

public class WeightClass {

    private Long id;
    private String weightRange;
    private int squat;
    private int deadlift;
    private int rdl;
    private int hstCurl;
    private int quadExt;
    private int dbBench;
    private int pulldown;
    private int row;
    private int latRaise;
    private int curls;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeightRange() {
        return weightRange;
    }

    public void setWeightRange(String weightRange) {
        this.weightRange = weightRange;
    }

    public int getSquat() {
        return squat;
    }

    public void setSquat(int squat) {
        this.squat = squat;
    }

    public int getDeadlift() {
        return deadlift;
    }

    public void setDeadlift(int deadlift) {
        this.deadlift = deadlift;
    }

    public int getRdl() {
        return rdl;
    }

    public void setRdl(int rdl) {
        this.rdl = rdl;
    }

    public int getHstCurl() {
        return hstCurl;
    }

    public void setHstCurl(int hstCurl) {
        this.hstCurl = hstCurl;
    }

    public int getQuadExt() {
        return quadExt;
    }

    public void setQuadExt(int quadExt) {
        this.quadExt = quadExt;
    }

    public int getDbBench() {
        return dbBench;
    }

    public void setDbBench(int dbBench) {
        this.dbBench = dbBench;
    }

    public int getPulldown() {
        return pulldown;
    }

    public void setPulldown(int pulldown) {
        this.pulldown = pulldown;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getLatRaise() {
        return latRaise;
    }

    public void setLatRaise(int latRaise) {
        this.latRaise = latRaise;
    }

    public int getCurls() {
        return curls;
    }

    public void setCurls(int curls) {
        this.curls = curls;
    }
    public WeightClass(Long id, String weightRange, int squat, int deadlift, int rdl, int hstCurl, int quadExt, int dbBench, int pulldown, int row, int latRaise, int curls) {
        this.id = id;
        this.weightRange = weightRange;
        this.squat = squat;
        this.deadlift = deadlift;
        this.rdl = rdl;
        this.hstCurl = hstCurl;
        this.quadExt = quadExt;
        this.dbBench = dbBench;
        this.pulldown = pulldown;
        this.row = row;
        this.latRaise = latRaise;
        this.curls = curls;
    }
}