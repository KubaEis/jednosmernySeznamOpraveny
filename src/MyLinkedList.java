public class MyLinkedList {
    private Node head; // Začátek seznamu

    // a. Přidání prvku na konec
    public void add(Ukol value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    // b. Výpis všech prvků seznamu
    public void printAll() {
        if (head == null) {
            System.out.println("Seznam úkolů je prázdný.");
            return;
        }
        Node current = head;
        int index = 0;
        while (current != null) {
            System.out.println("[" + index + "] " + current.getData());
            current = current.getNext();
            index++;
        }
    }

    // c. Přidání prvku na začátek
    public void addFirst(Ukol value) {
        Node newFirstNode = new Node(value);
        newFirstNode.setNext(head);
        head = newFirstNode;
    }

    // d. Odebrání prvního prvku
    public void removeFirst() {
        if (head == null) {
            System.out.println("Seznam je prázdný, nelze odebrat prvek.");
            return;
        }
        head = head.getNext();
        System.out.println("První úkol byl úspěšně odebrán.");
    }

    // e. Odebrání prvku z určité pozice
    public void removeOnIndex(int index) {
        if (head == null) {
            System.out.println("Seznam je prázdný.");
            return;
        }
        if (index < 0) {
            System.out.println("Index nemůže být záporný.");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.getNext() == null) {
                System.out.println("Index " + index + " je mimo rozsah seznamu.");
                return;
            }
            current = current.getNext();
        }
        if (current == null || current.getNext() == null) {
            System.out.println("Index " + index + " je mimo rozsah seznamu.");
            return;
        }
        current.setNext(current.getNext().getNext());
        System.out.println("Úkol na pozici " + index + " byl úspěšně odebrán.");
    }

    // f. Přidání prvku na určitou pozici
    public void addToIndex(Ukol value, int index) {
        if (index <= 0) {
            addFirst(value);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                System.out.println("Index " + index + " je mimo rozsah, úkol bude přidán na konec.");
                add(value);
                return;
            }
            current = current.getNext();
        }
        if (current == null) {
            add(value);
            return;
        }
        Node newNode = new Node(value);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        System.out.println("Úkol byl úspěšně přidán na pozici " + index + ".");
    }

    // g. Výpis prvků s konkrétní prioritou
    public void printAllWithPriority(int priorita) {
        if (head == null) {
            System.out.println("Seznam je prázdný.");
            return;
        }
        Node current = head;
        boolean found = false;
        System.out.println("Úkoly s prioritou " + priorita + ":");
        while (current != null) {
            if (current.getData().getPriorita() == priorita) {
                System.out.println("- " + current.getData().getText());
                found = true;
            }
            current = current.getNext();
        }
        if (!found) {
            System.out.println("Žádný úkol s touto prioritou nebyl nalezen.");
        }
    }

    // h. Vymazání prvku s určitým názvem
    public void removeNodeWithName(String name) {
        if (head == null) {
            System.out.println("Seznam je prázdný.");
            return;
        }
        boolean found = false;
        while (head != null && head.getData().getText().equalsIgnoreCase(name)) {
            head = head.getNext();
            found = true;
        }
        Node current = head;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getData().getText().equalsIgnoreCase(name)) {
                current.setNext(current.getNext().getNext());
                found = true;
            } else {
                current = current.getNext();
            }
        }
        if (found) {
            System.out.println("Úkol(y) s názvem '" + name + "' byly úspěšně odebrány.");
        } else {
            System.out.println("Úkol s názvem '" + name + "' nebyl nalezen.");
        }
    }

    // i. Obrácení seznamu
    public void flipList() {
        if (head == null || head.getNext() == null) {
            System.out.println("Seznam má méně než 2 prvky, pořadí se nemění.");
            return;
        }
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
        System.out.println("Seznam byl úspěšně obrácen.");
    }
}