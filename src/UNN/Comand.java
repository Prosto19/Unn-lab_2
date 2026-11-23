package UNN;

public class Comand {
    private String text;
    public Comand(String text) {
        this.text = text;
    }
    public  String get_text() {
        return text;
    }
    public String getName() {
        return text.split(" ")[0];
    }
    public boolean usesRegister(String r) {
        String[] p = text.split(" ");
        String name = p[0];

        if (name.equals("ld") || name.equals("st"))
            return p[1].equals(r);

        if (name.equals("mv"))
            return p[1].equals(r) || p[2].equals(r);

        if (name.equals("add") || name.equals("sub") ||
                name.equals("mult") || name.equals("div"))
            return r.equals("a") || r.equals("b") || r.equals("d");

        if (name.equals("print"))
            return r.equals("a") || r.equals("b") ||
                    r.equals("c") || r.equals("d");

        return false;
    }
    public int getAddress() {
        String[] p = text.split(" ");

        if (p[0].equals("init"))
            return Integer.parseInt(p[1]);

        if (p[0].equals("ld") || p[0].equals("st"))
            return Integer.parseInt(p[2]);

        return -1;
    }



}
