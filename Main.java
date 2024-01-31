// Класс, работающий с напряжением 380 вольт
class Voltage330Device {
    public void provide330V() {
        System.out.println("Предоставляет 330V");
    }
}

// Класс, работающий с зарядным устройством 220 вольт
class Voltage220Device {
    public void chargeWith220V() {
        System.out.println("Заряжается от 220V");
    }
}

// Адаптер для зарядного устройства
class Adapter220vTo330v extends Voltage330Device {
    private Voltage220Device voltage220Device;

    public Adapter220vTo330v(Voltage220Device voltage220Device) {
        this.voltage220Device = voltage220Device;
    }

    @Override
    public void provide330V() {
        System.out.println("Адаптер преобразует напряжение...");
        voltage220Device.chargeWith220V();
    }
}

// Пример использования
public class AdapterPatternExample {
    public static void main(String[] args) {
        Voltage330Device voltage330Device = new Voltage330Device();
        Voltage220Device voltage220Device = new Voltage220Device();

        Adapter220vTo330v adapter = new Adapter220vTo330v(voltage220Device);

        // Используем адаптер для зарядки телефона через напряжение 330 вольт
        voltage330Device.provide330V();
        adapter.provide330V();
    }
}
