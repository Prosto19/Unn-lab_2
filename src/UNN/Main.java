package UNN;

public class Main {
    public static void main(String[] args) {
        Program p = new Program();

        p.add(new Comand("init 10 20"));
        p.add(new Comand("init 11 25"));
        p.add(new Comand("ld a 10"));
        p.add(new Comand("ld b 11"));
        p.add(new Comand("add"));
        p.add(new Comand("st d 12"));
        p.add(new Comand("ld c 12"));
        p.add(new Comand("print"));

        System.out.println(p.groupCommands().keySet());
        System.out.println(p.mostPopularInstruction());
        System.out.println(p.sortedInstructions());
        System.out.println(p.getMemoryAddressRange());

        for (Comand c : p.findbyRegister("a")) {
            System.out.println(c.get_text());
        }

        CPU cpu = new CPU();
        for (Comand c : p) {
            cpu.exec(c);
        }
    }
}

