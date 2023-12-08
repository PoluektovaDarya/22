// Источник напряжения 380 Вольт
class Voltage380V {
    public int provideVoltage() {
        return 320;
    }
}

// Зарядное устройство 220 Вольт
class Charger220V {
    public void chargeWith220V() {
        System.out.println("Заряжаем устройство от 220 Вольт");
    }
}

// Адаптер для зарядного устройства
class Adapter {
    private Voltage380V voltage380V;

    public Adapter(Voltage380V voltage380V) {
        this.voltage380V = voltage380V;
    }

    public void chargeWith220V() {
        int voltage = voltage380V.provideVoltage();
        if (voltage == 380) {
            Charger220V charger220V = new Charger220V();
            charger220V.chargeWith220V();
        } else {
            System.out.println("Неверное напряжение: " + voltage + " Вольт. Зарядка невозможна.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Voltage380V source380V = new Voltage380V();
        Adapter adapter = new Adapter(source380V);

        adapter.chargeWith220V();
    }
}
