/*
    ==== BITWISE OR ====

    Bitwise OR makes a result bit 1 if either input bit is 1. Use separate bits as flags, then
    combine them to store several permissions in one integer.

    Complexity: One primitive integer operation is O(1).
    Try: Add a flag and remove it with AND plus a complemented mask.
*/

public class BitwiseOr {
    public static void main(String[] args) {
        int READ = 1, WRITE = 2, EXECUTE = 4;
        int permissions = READ | EXECUTE;               // <---- Combine the READ and EXECUTE flags in one integer.

        System.out.println((permissions & WRITE) != 0);

        permissions |= WRITE;                           // <---- Set the WRITE flag without clearing the existing flags.

        System.out.println(permissions);
    }
}
