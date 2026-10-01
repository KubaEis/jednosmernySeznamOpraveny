import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Inicializace 5 úkolů k maturitě (priorita 1 až 4)
        list.add(new Ukol("nezapomenout svačinu", 1));
        list.add(new Ukol("naučit SQL", 2));
        list.add(new Ukol("procvičit Javu", 3));
        list.add(new Ukol("naučit češtinu", 2));
        list.add(new Ukol("naučit literaturu", 4));

        while (true) {
            System.out.println("\n------- SEZNAM ÚKOLŮ K MATURITĚ -------");
            System.out.println("1. (a) Přidání prvku na konec");
            System.out.println("2. (b) Výpis všech prvků seznamu");
            System.out.println("3. (c) Přidání prvku na začátek");
            System.out.println("4. (d) Odebrání prvního prvku");
            System.out.println("5. (e) Odebrání prvku z určité pozice");
            System.out.println("6. (f) Přidání prvku na určitou pozici");
            System.out.println("7. (g) Výpis prvků s konkrétní prioritou");
            System.out.println("8. (h) Vymazání prvku s určitým názvem");
            System.out.println("9. (i) Obrácení seznamu");
            System.out.println("10. Konec");
            System.out.print("Vaše volba: ");

            String volba = sc.nextLine().trim();

            switch (volba) {
                case "1": case "a":
                    System.out.println("\n--- Přidání prvku na konec ---");
                    System.out.print("Název úkolu: ");
                    String text = sc.nextLine();
                    int p = nactiPrioritu();
                    list.add(new Ukol(text, p));
                    break;

                case "2": case "b":
                    System.out.println("\n--- Výpis všech prvků ---");
                    list.printAll();
                    break;

                case "3": case "c":
                    System.out.println("\n--- Přidání prvku na začátek ---");
                    System.out.print("Název úkolu: ");
                    String prvniText = sc.nextLine();
                    int prvniPriorita = nactiPrioritu();
                    list.addFirst(new Ukol(prvniText, prvniPriorita));
                    break;

                case "4": case "d":
                    System.out.println("\n--- Odebrání prvního prvku ---");
                    list.removeFirst();
                    break;

                case "5": case "e":
                    System.out.println("\n--- Odebrání prvku z určité pozice ---");
                    int i = nactiCislo("Index prvku k odebrání: ");
                    list.removeOnIndex(i);
                    break;

                case "6": case "f":
                    System.out.println("\n--- Přidání prvku na určitou pozici ---");
                    System.out.print("Název úkolu: ");
                    String indexText = sc.nextLine();
                    int indexPriorita = nactiPrioritu();
                    int index = nactiCislo("Požadovaný index: ");
                    list.addToIndex(new Ukol(indexText, indexPriorita), index);
                    break;

                case "7": case "g":
                    System.out.println("\n--- Výpis prvků s konkrétní prioritou ---");
                    int hledanaPriorita = nactiPrioritu();
                    list.printAllWithPriority(hledanaPriorita);
                    break;

                case "8": case "h":
                    System.out.println("\n--- Vymazání prvku s určitým názvem ---");
                    System.out.print("Název úkolu k vymazání: ");
                    String nazev = sc.nextLine();
                    list.removeNodeWithName(nazev);
                    break;

                case "9": case "i":
                    System.out.println("\n--- Obrácení seznamu ---");
                    list.flipList();
                    break;

                case "10": case "konec": case "exit":
                    System.out.println("Aplikace byla ukončena. Hodně štěstí u maturity!");
                    return;

                default:
                    System.out.println("Neplatná volba! Zadejte číslo 1–10 nebo písmeno a–i.");
                    break;
            }
        }
    }

    private static int nactiPrioritu() {
        while (true) {
            System.out.print("Priorita úkolu (1 = nejvyšší, 4 = nejnižší): ");
            try {
                int p = Integer.parseInt(sc.nextLine().trim());
                if (p >= 1 && p <= 4) {
                    return p;
                }
                System.out.println("Chyba: Priorita musí být číslo od 1 do 4!");
            } catch (NumberFormatException e) {
                System.out.println("Chyba: Zadejte platné celé číslo!");
            }
        }
    }

    private static int nactiCislo(String vyzva) {
        while (true) {
            System.out.print(vyzva);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Chyba: Zadejte platné celé číslo!");
            }
        }
    }
}