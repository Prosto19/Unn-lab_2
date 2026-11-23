package UNN;

public class  CPU implements ICpu {
    private int a;
    private int b;
    private int c;
    private int d;
    private int [] memory = new int[1024];
    private Instructions instructions = new Instructions();
    public int getMemory(int address) {
        return memory[address];
    }

    public void setMemory(int address, int value) {
        memory[address] = value;
    }
    public int getRegister(String name) {
        switch (name) {
            case "a":
                return a;
            case "b":
                return b;
            case "c":
                return c;
            case "d":
                return d;
        }
        return 0;
    }
    public void setRegister(String name, int value) {
        switch (name) {
            case "a":
                a = value;
                break;
            case "b":
                b = value;
                break;
            case "c":
                c = value;
                break;
            case "d":
                d = value;
                break;
        }
    }

       public void print() {
           System.out.println(a + " " + b + " " + c + " " + d);
       }
    public void exec(Comand command) {

        String text = command.get_text();

        String[] parts = text.split(" ");
        switch (parts[0]) {

            case "init":
                instructions.init(this,
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                break;

            case "ld":
                instructions.ld(this, parts[1], Integer.parseInt(parts[2]));
                break;

            case "st":
                instructions.st(this, parts[1], Integer.parseInt(parts[2]));
                break;

            case "mv":
                instructions.mv(this, parts[1], parts[2]);
                break;

            case "add":
                instructions.add(this);
                break;

            case "sub":
                instructions.sub(this);
                break;

            case "mult":
                instructions.mult(this);
                break;

            case "div":
                instructions.div(this);
                break;

            case "print":
                instructions.print(this);
                break;

        }
    }
}
