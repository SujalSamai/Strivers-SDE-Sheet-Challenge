### Question
- You're given two strings. 'text' of length 'n' and 'pattern' of length 'm', consisting of lowercase characters
- find all occurrences of the string 'pattern' in text
- for each occurrence, print the index from where it starts in the string 'text'(1-indexed)

### Sample Input
    text= cxyzghxyzvjkxyz,  pattern= xyz
    text= ababacabab,  pattern= aba

### Sample Output
    2 7 13
    1 3 7

### How it works
- The Rabin-Karp algorithm slides the pattern one by one. But unlike the Naive algorithm, the Rabin Karp algorithm matches the hash value of the pattern with the hash value of the current substring of text, and if the hash values match then only it starts matching individual characters.  The hash function suggested by Rabin and Karp calculates an integer value.
- The number of possible characters is higher than 10 (256 in general) and the pattern length can be large. So the numeric values cannot be practically stored as an integer. Therefore, the numeric value is calculated using modular arithmetic to make sure that the hash values can be stored in an integer variable (can fit in memory words). To do rehashing, we need to take off the most significant digit and add the new least significant digit for in hash value.

### Solution
- First we will define q as any prime number to make hash function strong and d=256 (no. of total characters)
- Calculate the value of h, which is pow(d,m-1)%q
- Now calculate the hash of both pattern and first window of text using ``d * p + pattern[i] % q`` & ``d * t + text[i] % q``
- Now traverse the text from 1st index to n-m index, if hash value of p & t is same then, check one by one the characters of both pattern and chosen window of text, if they aren't same break
- if all characters are same then add it to our ans
- if hash of pattern & text are different & we are within bounds, then slide our pattern to next character of text & calculate the hash of next window
- First remove leading character & then add the next text using this formula:
  ``t = (d * (t - text[i] * h) + text[i+m])) % q``
- We may get a negative value, in such case add q to t

### Code
    public static List<Integer> stringMatch(String text, String pattern){
        int M = pattern.length();
        int N = text.length();
        int q=101, d=256;
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;
        List<Integer> res= new ArrayList<>();

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
            // Check the hash values of current window of text and pattern.
            // If the hash values match then only check for characters one by one
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) break;
                }
                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M) res.add(i+1);
            }

            // Calculate hash value for next window of text:
            if (i < N - M) {
                // Remove leading digit, add trailing digit
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;
                // We might get negative value of t, converting it to positive
                if (t < 0) t = (t + q);
            }
        }
        return res;
    }

### Edge Cases
- NA

### Other Techniques
- NA

### Complexity
1. Time Complexity - O(N*M), where N is length of one string and M is the length of prefix
2. Space Complexity - O(M)