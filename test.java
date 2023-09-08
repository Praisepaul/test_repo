import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test {
    static void simpleSieve(int n) {
        boolean b[] = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            b[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            for (int p = i * i; p <= n; p += i) {
                b[p] = false;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (b[i] == true) {
                System.out.print(i + " ");
            }
        }
    }

    static void segmentedSieve(int L, int H) {
        boolean b[] = new boolean[H + 1];
        for (int i = 2; i * i <= H; i++) {
            int sm = (L / i) * i;
            while (sm < L) {
                sm += i;
            }
            for (int p = sm; p <= H; p += i) {
                if (p != i) {
                    b[p] = true;
                }
            }
        }
        for (int i = 2; i <= H; i++) {
            if (b[i] == false) {
                System.out.print(i + " ");
            }
        }
    }

    static int eulerPhi(int n) {
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    static boolean isStrobogrammatic(String num) {
        Map<Character, Character> m = new HashMap<Character, Character>();
        m.put('9', '6');
        m.put('6', '9');
        m.put('0', '0');
        m.put('1', '1');
        m.put('8', '8');
        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            if (!m.containsKey(num.charAt(l)))
                return false;
            if (m.get(num.charAt(l)) != num.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    static int chineeseRemainder(int size, int div[], int rem[]) {
        int j, x = 1;
        while (true) {
            for (j = 0; j < size; j++) {
                if (x % div[j] != rem[j]) {
                    break;
                }
            }
            if (j == size) {
                return x;
            }
            x++;
        }
    }

    static int aliceApple(int total) {
        int count = 0;
        int sum = 0;
        while (sum < total) {
            count++;
            sum += 12 * count * count;
        }
        return 8 * count;
    }

    static void toggleSwitch(int n) {
        boolean b[] = new boolean[n + 1];
        int c = 0;
        int o = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i * j <= n; j++) {
                if (b[j] == false) {
                    b[j] = true;
                } else {
                    b[j] = false;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (b[i] == true) {
                o++;
            }
            if (b[i] == false) {
                c++;
            }
        }
        System.out.println("No. of Open Doors: " + o);
        System.out.println("No. of Closed Doors: " + c);
    }

    static boolean isPalindrome(int x) {
        int reversed = 0;
        int original = x;
        while (x > 0) {
            reversed <<= 1;
            reversed |= (x & 1);
            x >>= 1;
        }
        return reversed == original;
    }

    public static int boothMultiplication(int multiplicand, int multiplier) {
        int product = 0;
        int accumulator = 0;
        int qMinus1 = 0; // Q_-1, initially set to 0

        int numBits = 32; // Assuming 32-bit signed integers

        for (int i = 0; i < numBits; i++) {
            int q0 = multiplier & 1; // Q_0
            int qMinusQ0 = (qMinus1 ^ q0) & 1; // Q_-1 XOR Q_0

            if (q0 == 1 && qMinus1 == 0) {
                accumulator += multiplicand;
            } else if (q0 == 0 && qMinus1 == 1) {
                accumulator -= multiplicand;
            }

            if ((accumulator & 1) == 0) {
                accumulator >>= 1;
            } else if (accumulator < 0) {
                accumulator = (accumulator >> 1) + (1 << (numBits - 1));
            } else {
                accumulator = (accumulator >> 1);
            }

            qMinus1 = q0;
            multiplier >>= 1;
        }

        product = (accumulator << numBits) | multiplier;
        return product;
    }

    public static long karatsubaMultiply(long x, long y) {
        if (x < 10 || y < 10) {
            return x * y;
        }

        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());
        int half = (n + 1) / 2;

        long a = x / (long) Math.pow(10, half);
        long b = x % (long) Math.pow(10, half);
        long c = y / (long) Math.pow(10, half);
        long d = y % (long) Math.pow(10, half);

        long ac = karatsubaMultiply(a, c);
        long bd = karatsubaMultiply(b, d);
        long adbc = karatsubaMultiply(a + b, c + d) - ac - bd;

        return (long) (ac * Math.pow(10, 2 * half) + adbc * Math.pow(10, half) + bd);
    }

    public static int longestSequenceOfOnes(int binaryNumber) {
        int count = 0;
        int maxCount = 0;

        while (binaryNumber > 0) {
            if ((binaryNumber & 1) == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
            binaryNumber >>= 1;
        }

        return maxCount;
    }

    public static int longestConsecutiveOnesAfterFlip(int n) {
        String binary = Integer.toBinaryString(n);
        int maxLength = 0;
        int currentLength = 0;
        int previousLength = 0;
        for (char bit : binary.toCharArray()) {
            if (bit == '1') {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength + previousLength + 1);
                previousLength = currentLength;
                currentLength = 0;
            }
        }
        maxLength = Math.max(maxLength, currentLength + previousLength + 1);
        return maxLength;
    }

    public static byte swapNibbles(byte b) {
        // Extract the upper and lower nibbles
        byte upperNibble = (byte) ((b & 0xF0) >>> 4);
        byte lowerNibble = (byte) (b & 0x0F);

        // Shift the nibbles and combine them
        byte swappedByte = (byte) ((lowerNibble << 4) | upperNibble);

        return swappedByte;
    }

    static int findMaxSum(int[][] mat, int R, int C) {
        int max_sum = 0;
        int sum;

        if (R < 3 || C < 3) {
            System.out.println("Not possible");
            System.exit(0);
        }

        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {
                sum = (mat[i][j] + mat[i][j + 1] + mat[i][j + 2]) +
                        (mat[i + 1][j + 1]) +
                        (mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2]);
                max_sum = Math.max(max_sum, sum);
            }
        }

        return max_sum;
    }

    static int maxWeightedSubstring(String s, int[] weights) {
        int maxWeight = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int weight = 0;
            for (int j = i; j < s.length(); j++) {
                int charIndex = s.charAt(j) - 'a'; // Convert character to index (assuming lowercase)
                weight += weights[charIndex];
                maxWeight = Math.max(maxWeight, weight);
            }
        }

        return maxWeight;
    }

    public static String moveHyphenToBeginning(String string) {
        if (string.contains("-")) {
            int hyphenIndex = string.indexOf("-");
            return "-" + string.substring(0, hyphenIndex) + string.substring(hyphenIndex + 1);
        } else {
            return string;
        }
    }

    public static void findLongestPalindromicString(String text) {
        int N = text.length();
        if (N == 0) {
            return;
        }
        N = 2 * N + 1; // Position count
        int[] L = new int[N + 1]; // LPS Length Array
        L[0] = 0;
        L[1] = 1;
        int C = 1; // centerPosition
        int R = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int start = -1;
        int end = -1;
        int diff = -1;
        for (i = 2; i < N; i++) {
            iMirror = 2 * C - i;
            L[i] = 0;
            diff = R - i;

            if (diff > 0) {
                L[i] = Math.min(L[iMirror], diff);
            }

            while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&
                    (((i + L[i] + 1) % 2 == 0) ||
                            (text.charAt((i + L[i] + 1) / 2) == text.charAt((i - L[i] - 1) / 2)))) {
                L[i]++;
            }

            // Update the right boundary and center position if palindrome centered at i
            // expands past R
            if (i + L[i] > R) {
                C = i;
                R = i + L[i];
            }

            // If palindrome centered at i expands past current R,
            // adjust center based on expanded palindrome.
            if (i + L[i] == R && i - L[i] > 0) {
                L[i]++;

                // Reset center position to expand palindrome centered at i
                C = i;

                // Update the result if the current palindrome's length is greater
                if (L[i] > maxLPSLength) {
                    maxLPSLength = L[i];
                    maxLPSCenterPosition = i;
                }
            }

            // Update the starting and ending indexes if the current palindrome's length is
            // greater
            if (L[i] > L[start]) {
                start = i;
                end = i;
            }
        }

        start = (maxLPSCenterPosition - maxLPSLength) / 2;
        end = start + maxLPSLength - 1;
        System.out.println("Longest Palindromic Substring: " + text.substring(start, end + 1));
    }

    public static void main(String[] args) {
        int div[] = { 3, 5, 7 };
        int rem[] = { 2, 3, 2 };
        simpleSieve(20);

        System.out.println();

        segmentedSieve(2, 20);
        System.out.println();

        System.out.println(eulerPhi(60));

        System.out.println(isStrobogrammatic("11001"));

        System.out.println(chineeseRemainder(3, div, rem));

        System.out.println(aliceApple(10));

        toggleSwitch(10);

        System.out.println(isPalindrome(16));

        System.out.println(boothMultiplication(30, 4));

        System.out.println(karatsubaMultiply(40, 80));

        System.out.println(longestSequenceOfOnes(1100010110));

        System.out.println(longestConsecutiveOnesAfterFlip(0b100111001));

        byte byteValue = (byte) 0xAB; // 1010 1011 in binary
        byte swappedByte = swapNibbles(byteValue);
        System.out.println("Original byte: " + Integer.toBinaryString(byteValue & 0xFF));
        System.out.println("Swapped byte: " + Integer.toBinaryString(swappedByte & 0xFF));

        Scanner sc = new Scanner(System.in); // Watch hour Glass
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] mat = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int res = findMaxSum(mat, R, C);
        System.out.println("Maximum sum of hour glass = " + res);

        String s = "abcd"; // Input string
        int[] weights = { 1, 2, 3, 4 }; // Weights of characters a, b, c, d
        int maxWeight = maxWeightedSubstring(s, weights);
        System.out.println("Maximum weighted substring: " + maxWeight);

        String originalString = "face-prep";
        String transformedString = moveHyphenToBeginning(originalString);
        System.out.println(transformedString);

        String text = "babad"; // Input text
        findLongestPalindromicString(text);
    }
}
