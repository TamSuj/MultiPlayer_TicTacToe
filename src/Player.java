public class Player {
    private String mark;

    /**
     * Constructor which initialize the Player object and mark by the passing a string (mark)
     * @param mark
     */
    public Player(String mark) {
        this.mark = mark;
    }

    /**
     * Return the string of mark
     * @return mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * Set the mark of the player by passing a string
     * @param mark
     */
    public void setMark(String mark) {
        this.mark = mark;
    }
}
