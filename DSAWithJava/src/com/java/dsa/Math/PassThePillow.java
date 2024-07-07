class PassThePillow {
    public int passThePillow(int n, int time) {
        int completeRounds = time / (n - 1);
        int remainingTime = time % (n - 1);
        return completeRounds % 2 == 0 ? remainingTime + 1 : n - remainingTime;
    }   
}
