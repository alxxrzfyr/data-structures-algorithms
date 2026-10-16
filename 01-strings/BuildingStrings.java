/*
    ==== BUILDING TEXT WITH STRINGBUILDER ====

    Repeatedly joining immutable strings can copy the growing result many times. StringBuilder
    keeps a mutable character buffer, making repeated appends efficient. Convert it to a String
    when construction is complete.

    Complexity: Appending n single characters takes amortized O(n) total time and O(n) storage;
    producing the result also takes O(n).
    Try: Build a comma-separated list without putting a comma after the last item.
*/

public class BuildingStrings {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();

        for (char letter = 'a'; letter <= 'f'; letter++) {
            builder.append(letter);                    // <---- Reuse the buffer instead of copying a new immutable prefix each time.
        }

        String result = builder.toString();

        System.out.println(result);
    }
}
