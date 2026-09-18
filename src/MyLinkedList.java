class MyLinkedList {
    private Node head; // začátek seznamu

    // přidání na konec seznamu
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

    // pridani na zacatek seznamu
    public void addFirst(Ukol value) {
        Node newFirstNode = new Node(value);
        newFirstNode.setNext(head);
        head = newFirstNode;
    }

    // pridani na index v seznamu
    public void addToIndex(Ukol value, int index) {
        if (index < 0) return;
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) return;
            current = current.getNext();
        }
        if (current == null) return;

        Node indexNode = new Node(value);
        indexNode.setNext(current.getNext()); // 1. Propojit nový uzel se zbytkem
        current.setNext(indexNode);           // 2. Napojit předchozí na nový
    }

    // odebrani prvniho
    public void removeFirst() {
        if (head != null) {
            head = head.getNext(); // Přesunutí hlavičky na další prvek
        }
    }

    // odebrani na indexu
    public void removeOnIndex(int index) {
        if (head == null || index < 0) {
            System.out.println("Seznam je prázdný nebo neplatný index");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.getNext() == null) return;
            current = current.getNext();
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext()); // Přeskočení odebíraného uzlu
        }
    }

    // vymazání podle názvu
    public void removeNodeWithName(String name) {
        if (head == null) {
            System.out.println("Seznam je prazdny");
            return;
        }
        // Pokud je hledaný prvek hned na začátku
        if (head.getData().getText().equalsIgnoreCase(name)) {
            head = head.getNext();
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().getText().equalsIgnoreCase(name)) {
                current.setNext(current.getNext().getNext()); // Přeskočení nalezeného
                return;
            }
            current = current.getNext();
        }
    }

    // výpis všech prvků
    public void printAll() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData().getText() + " (" + current.getData().getPriorita() + ") -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    // výpis všech prvků s konkrétní prioritou
    public void printAllWithPriority(int priorita) {
        Node current = head;
        while (current != null) {
            if (current.getData().getPriorita() == priorita) {
                System.out.print(current.getData().getText() + " (" + current.getData().getPriorita() + ") -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }

    // obrácení seznamu (přehození ukazatelů)
    public void flipList() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.getNext(); // Uložení následujícího prvku
            current.setNext(prev);    // Otočení ukazatele
            prev = current;           // Posun prev dopředu
            current = next;           // Posun current dopředu
        }
        head = prev; // Nová hlavička je původně poslední prvek
    }
}