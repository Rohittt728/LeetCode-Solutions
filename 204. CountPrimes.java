/*

Link : https://leetcode.com/problems/count-primes/

Count the number of prime numbers less than a non-negative number, n.

Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

*/


// Sieve Of Eratosthenes
class Solution {
    public int countPrimes(int n) {
        boolean isPrime[] = new boolean[n];		// Boolean array to keep track
        Arrays.fill(isPrime, true);
        
        for (int i = 2; i * i < n; i++) {		// iterating over all numbers till sqrt(n)
            if (!isPrime[i])
                continue;
            for (int j = i * i; j < n; j += i)	// setting all i's multiples as not prime
                isPrime[j] = false;
        }
        
        int ans = 0;
        for (int i = 2; i < n; i++) {			// counting primes from the boolean array
            if (isPrime[i])
                ans ++;
        }
        return ans;
    }
}