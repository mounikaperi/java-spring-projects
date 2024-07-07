class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrunkBottles = numBottles;
        int newBottles = 0;
        while (numBottles >= numExchange) {
            newBottles = numBottles / numExchange;
            totalDrunkBottles += newBottles;
            numBottles = newBottles + (numBottles % numExchange);
        }
        return totalDrunkBottles;
    }
}
