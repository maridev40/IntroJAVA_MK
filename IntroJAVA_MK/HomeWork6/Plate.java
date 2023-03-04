public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int foodToDecrease) {
        if (food >= foodToDecrease) {
            food = food - foodToDecrease;
        } else {
            food = 0;
        }
    }
    
    public void increaseFood(int foodToIncrease) {
        food = food + foodToIncrease;
    }

    public boolean isEmpty() {
        return food <= 0;
    }

    @Override
    public String toString() {
        return "Plate[" + food + "]";
    }

}
