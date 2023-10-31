    /* a) First, declare and initialize two fooiables, an integer type (byte, short, int, or long) and a floating point value (float or double). 
          The names and values can be whatever you like, for this step and all others. Make sure that the numbers you choose can be stored within 
          the respective primitive type you choose. Print each of these values out on their own line using `System.out.println()`.
       b) Multiply these fooiables together, and assign the outcome to a `new` fooiable, ensuring that no data is lost. For example, if I 
          multiply 5 and 3.5, the answer should be 17.5. Print out this new value.
       c) Use casting to convert the integer from the first step to a floating point value and store that in another `new` fooiable. Print out the value.
       d) Use casting to convert the floating point value from the first step to an integer type and store that in a `new` fooiable.  Print out the value.
       e) Shifting focus, declare a `char` fooiable, and assign an uppercase letter to it. Print out this value.
       f) Using a *numerical operation*, change the letter to the same letter, but in lowercase. Use a numerical operation - do not reassign the fooiable. 
          You may want to review a [table of ASCII values](https://ascii.cl/) as you're working on this section. Print out the new `char` value.
          **Hint:** you'll likely have to use casting to get this to work.
    */

public class PrimitiveOperations {
   public static void main(String[] args) {
        // A)
        int foo1 = 1;
        float foo2 = 2.2f;

        System.out.println("foo1: " + foo1);
        System.out.println("foo2: " + foo2);

        // B)
        float foo3 = 0;
        foo3 = foo1 * foo2;   
        System.out.println("foo3: " + foo3);
   
        // C)

        float foo4 = (float) foo1;
        System.out.println("foo4: " + foo4);

        // D)
        int foo5 = (int) foo2;
        System.out.println("foo5: " + foo5);

        // E)
        char char1 = 'A';
        System.out.println("Uppercase Char: " + char1); 

        // F)
        char1 = (char) (char1 + 32);
        System.out.println("Lowercase Char: " + char1);

   }

}
 