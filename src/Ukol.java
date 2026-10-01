public class Ukol {
    private String text;
    private int priorita; // Priorita 1 (nejvyšší) až 4 (nejnižší)

    public Ukol(String text, int priorita) {
        this.text = text;
        setPriorita(priorita);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPriorita() {
        return priorita;
    }

    public void setPriorita(int priorita) {
        if (priorita < 1 || priorita > 4) {
            this.priorita = 4; // Výchozí nejnižší priorita při neplatném zadání
        } else {
            this.priorita = priorita;
        }
    }

    @Override
    public String toString() {
        return text + " (priorita: " + priorita + ")";
    }
}