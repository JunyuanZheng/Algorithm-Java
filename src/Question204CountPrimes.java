public class Question204CountPrimes {
    // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    public int countPrimes(int n) {
        boolean[] tmp = new boolean[n];
        int counter = 0;
        for (int i = 2; i < n; i += 1) {
            if (!tmp[i]) {
                counter += 1;
                for (int j = 1; j * i < n; j += 1) {
                    tmp[i * j] = true;
                }
            }
        }
        return counter;
    }
}
