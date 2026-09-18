import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add(new Ukol("naučit SQL",2));
        list.add(new Ukol("procvičit Javu",3));
        list.add(new Ukol("nezapomenout svačinu",1));
        list.add(new Ukol("naučit literaturu",5));
        list.add(new Ukol("naučit češtinu",4));



        while (true) {
            System.out.println("\n-------MENU-------");
            System.out.println("1. Přidání prvku na konec");
            System.out.println("2. Výpis všech prvků seznamu");
            System.out.println("3. Přidání prvku na začátek");
            System.out.println("4. Odebrání prvního prvku");
            System.out.println("5. Odebrání prvku z určité pozice");
            System.out.println("6. Přidání prvku na určitou pozici");
            System.out.println("7. Výpis prvků s konkrétní prioritou");
            System.out.println("8. Vymazání prvku s určitým názvem");
            System.out.println("9. Obrácení seznamu");
            System.out.println("10. Konec");
            System.out.print("Vase volba: ");

            int vyber = sc.nextInt();
            sc.nextLine();

            switch (vyber) {
                case 1:
                    System.out.println("-----Přidání prvku na konec-----");
                    System.out.println("Nazev ukolu:");
                    String text = sc.nextLine();
                    System.out.println("Priorita:");
                    int priorita = sc.nextInt();
                    sc.nextLine();
                    list.add(new Ukol(text,priorita));
                    break;
                case 2:
                    list.printAll();
                    break;
                case 3:
                    System.out.println("-----Přidání prvku na začátek-----");
                    System.out.println("Nazev ukolu:");
                    String prvniText = sc.nextLine();
                    System.out.println("Priorita:");
                    int prvniPriorita = sc.nextInt();
                    sc.nextLine();
                    list.addFirst(new Ukol(prvniText,prvniPriorita));
                    break;
                case 4:
                    System.out.println("-----Odebrání prvního prvku-----");
                    list.removeFirst();
                    break;
                case 5:
                    System.out.println("-----Odebrání prvku z určité pozice-----");
                    System.out.println("Index:");
                    int i = sc.nextInt();
                    sc.nextLine();
                    list.removeOnIndex(i);
                    break;
                case 6:
                    System.out.println("-----Přidání prvku na určitou pozici-----");
                    System.out.println("Nazev ukolu:");
                    String indexText = sc.nextLine();
                    System.out.println("Priorita:");
                    int indexPriorita = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Index:");
                    int index = sc.nextInt();
                    sc.nextLine();
                    list.addToIndex(new Ukol(indexText,indexPriorita),index);
                    break;
                case 7:
                    System.out.println("-----Výpis prvků s konkrétní prioritou-----");
                    System.out.println("Priorita:");
                    int hledanaPriorita = sc.nextInt();
                    sc.nextLine();
                    list.printAllWithPriority(hledanaPriorita);
                    break;
                case 8:
                    System.out.println("-----Vymazání prvku s určitým názvem-----");
                    System.out.println("Nazev ukolu:");
                    String nazev = sc.nextLine();
                    list.removeNodeWithName(nazev);
                    break;
                case 9:
                    System.out.println("-----Obrácení seznamu-----");
                    list.flipList();
                    System.out.println("Seznam byl úspěšně obrácen.");
                    break;
                default:
                    break;
            }
        }
    }
}