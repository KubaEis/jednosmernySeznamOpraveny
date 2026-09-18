public class Ukol {
    private String text;
    private int priorita;
    public Ukol(String text, int priorita) {
        this.text = text;
        this.priorita = priorita;
    }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public int getPriorita() { return priorita; }
    public void setPriorita(int priorita) {this.priorita = priorita;}
}
