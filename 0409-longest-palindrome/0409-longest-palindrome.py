class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = {}
        count = 0
        singleele = False
        for ch in s:
            freq[ch] = freq.get(ch,0)+1
        print(freq)
        for key in freq:
            if(freq[key]%2 == 0):
                count+=freq[key]
            else:
                if count%2==0:
                    count+=freq[key]
                else:
                    count+=freq[key]-1

        return count        