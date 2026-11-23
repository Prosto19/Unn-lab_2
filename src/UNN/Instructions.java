package UNN;

public class Instructions { //Сложение двух регистров
    public void add(CPU cpu) {
        int a = cpu.getRegister("a");
        int b = cpu.getRegister("b");

        cpu.setRegister("d", a + b);
    }
    public void sub(CPU cpu) { //Вычитание и сохранение в d
        int result = cpu.getRegister("a") - cpu.getRegister("b");
        cpu.setRegister("d", result);
    }
    public void mult(CPU cpu) { //Умножение и сохраение в d
        int result = cpu.getRegister("a") * cpu.getRegister("b");
        cpu.setRegister("d", result);
    }

    public void div(CPU cpu) { //Деление и сохранение в d
        int result = cpu.getRegister("a") / cpu.getRegister("b");
        cpu.setRegister("d", result);
    }
    public void init(CPU cpu, int address, int value) { //Запись чисал в память
        cpu.setMemory(address, value);
    }
    public void ld(CPU cpu, String register, int address)  { //Из памяти в регистр
        int value = cpu.getMemory(address);
        cpu.setRegister(register, value);
    }
    public void st(CPU cpu, String register, int address) { //Из регистра в память
        int value = cpu.getRegister(register);
        cpu.setMemory(address, value);
    }
    public void mv(CPU cpu, String destination, String source) { //Копироание
        int value = cpu.getRegister(source);
        cpu.setRegister(destination, value);
    }
    public void print(CPU cpu) {
        System.out.println(cpu.getRegister("a") + " " +
                cpu.getRegister("b") + " " +
                cpu.getRegister("c") + " " +
                cpu.getRegister("d"));
    }

}
