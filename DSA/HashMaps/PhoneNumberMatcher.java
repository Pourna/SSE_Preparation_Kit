/*
Given the standard mapping from English letters to digits on a phone keypad (1 → "" 2 -> a,b,c 3 -> d,e,f 4 -> g,h,i 5 -> j,k,l 6 -> m,n,o 7 -> p,q,r,s 8 -> t,u,v 9 -> w,x,y,z),

write a program that outputs all words that can be formed from any n-digit phone number from the list of given KNOWN_WORDS considering the mapping mentioned above.

KNOWN_WORDS= ['careers', 'linkedin', 'hiring', 'interview', 'linkedgo']

phoneNumber: 2273377

Output: ['careers']

phoneNumber: 54653346

Output: ['linkedin', 'linkedgo']
*/

//Time Complexity: O(n × k) - wordToDigitString is O(k): Main loop is O(n × k):
//n = number of words in KNOWN_WORDS    k = average length of a word

//Space Complexity: O(n) - letterToDigitMap: O(26) result: O(n)

/*
Steps involved:
1. String of Array to keep all chars respective to the index in array
2. HashMap to keep each character's number in char format eg: 'a' : '2', 'b':'2'
3. Loop every word and find if it matches phone number length
     if yes: find all digits in char format for every character in the word using wordToDigit in a string
             compare if the string is equal to phone number if yes add to result list
     if no: skip the word and continue rest
4. Return the list
*/
import java.util.*;

public class PhoneNumberMatcher {

    public static void main(String[] args) {
        List<String> KNOWN_WORDS = Arrays.asList("careers", "linkedin", "hiring", "interview", "linkedgo");

        String phone1 = "2273377";
        String phone2 = "54653346";

        System.out.println("Matches for " + phone1 + ": " + matchPhoneNumber(phone1, KNOWN_WORDS));
        System.out.println("Matches for " + phone2 + ": " + matchPhoneNumber(phone2, KNOWN_WORDS));
    }

    public static List<String> matchPhoneNumber(String number, List<String> knownWords) {
        List<String> result = new ArrayList<>();

        String[] digits = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyx"};

        Map<Character, Character> letterToDigit = new HashMap<>();
        for (int i=2; i<=9; i++) {
            for(char c : digits[i].toCharArray()) {
                letterToDigit.put(c, (char)('0'+i));
            }
        }

        for(String word: knownWords) {
            if(word.length()!=number.length())
                continue;
            String digitString = wordToDigit(word, letterToDigit);
            if(digitString.equals(number))
                result.add(word);
        }
        return result;
    }

    public static String wordToDigit (String word, Map<Character, Character> letterToDigit) {
        StringBuilder str = new StringBuilder();
        for(char c : word.toCharArray()) {
            str.append(letterToDigit.getOrDefault(c,'?'));
        }
        return str.toString();
    }
}
