public class Cat {

    private String name;
    private int appetite;
    private volatile int satiety = 0;

    public Cat(String name) {
        this(name, 10, 3);
    }

    public Cat(String name, int appetite, int satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;

        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {
                if (this.satiety < this.appetite) {
                    this.satiety++;
                }
                try {
                    Thread.sleep(5 * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void eat(Plate plate) {
        if (satiety > 0) {
            plate.decreaseFood(appetite - satiety);
        }
    }

    public boolean isHungry() {
        return appetite > satiety;
    }

    @Override
    public String toString() {
        return name + "{appetite=" + appetite + ", satiety=" + satiety + "}";
    }
}
