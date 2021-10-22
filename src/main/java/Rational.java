public class Rational
{
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;
    
    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b) {
        numerator = a;
        denominator = b;
    }
    public static int findLCM(int a, int b){
        int max = a * b;
        int smallestNum = 0;
        if(a < b || a == b){
            smallestNum = a;
        }
        else{
            smallestNum = b;
        }
        for (int i = 0; i < max; i+=smallestNum){
            if (i != 0 && (i % a == 0 && i % b == 0)){
                return i;
            }
        }
        return a * b;
    }
    public static Rational add(Rational r, Rational s) {
        // REPLACE WITH YOUR CODE HERE
        int Lcm = findLCM(r.denominator, s.denominator);
        Rational newR = new Rational(r.numerator * (Lcm / r.denominator), r.denominator * (Lcm / r.denominator));
        Rational newS = new Rational(s.numerator * (Lcm / s.denominator), s.denominator * (Lcm / s.denominator));

        return simplify(new Rational(newR.numerator + newS.numerator, newR.denominator));
    }

    // This method takes two Rationals, subtracts thems up,
    // and returns a Rational equal to the difference
    public static Rational subtract(Rational r, Rational s) {
        int Lcm = findLCM(r.denominator, s.denominator);
        Rational newR = new Rational(r.numerator * (Lcm / r.denominator), r.denominator * (Lcm / r.denominator));
        Rational newS = new Rational(s.numerator * (Lcm / s.denominator), s.denominator * (Lcm / s.denominator));

        return  simplify(new Rational(newR.numerator - newS.numerator, newR.denominator));
    }

    public static Rational multiply(Rational r, Rational s) {
        // REPLACE WITH YOUR CODE HERE
        return simplify(new Rational(r.numerator * s.numerator, r.denominator * s.denominator));
    }

    public static Rational divide(Rational r, Rational s) {
        // REPLACE WITH YOUR CODE HERE
        return simplify(new Rational(r.numerator * s.denominator, r.denominator * s.numerator));
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor, find the largest number x
    // such that a and b are both multiples of x
    public static int greatestCommonFactor(int a, int b){
        for (int i = a; i >= 0; i--) {
            if (a % i == 0 && b % i == 0){
                return i;
            }

        }
        return 1;
    }

    // This method is given a rational, and returns a simplified version
    // of the input rational
    // Use the greatestCommonFactor method here
    // e.g. simplify(2/4) => 1/2
    //      simplify(1/2) => 1/2
    public static Rational simplify(Rational r) {
        // REPLACE WITH YOUR CODE HERE
        int gcf = greatestCommonFactor(r.numerator, r.denominator);
        return new Rational(r.numerator / gcf, r.denominator / gcf);
    }

    // This following method is NOT static, we'll talk about it next class!
    // This returns a string representation of a Rational (e.g. "1/2")








    // *****
    // Here are all of our NON-STATIC methods:
    // *****

    // Returns whether or not the numerator is greater than or equal
    // to the denominator
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.isImproper()) // true
    public boolean isImproper() {
       return (this.numerator >= this.denominator);
    }

    // Returns whether or not the Rational is currently simplified
    // or not
    // Example:
    // Rational r = new Rational(6,12);
    // System.out.println(r.isSimplified()) // false
    public boolean isSimplified() {
        if(greatestCommonFactor(this.numerator, this.denominator) == 1){
            return true;
        }
        return false;// YOUR CODE HERE
    }

    // Calculates the double value of our Rational
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.calculateDecimalValue()) // 0.75
    public double calculateDecimalValue() {
        return  ((double) this.numerator / (double) this.denominator); // YOUR CODE HERE
    }

    // Returns the Rational we get from raising the rational number to an integer power
    // Example:
    // Rational r = new Rational(2,5);
    // System.out.println(r.pow(2)) // 4/25
    public Rational pow(int exponent) {
        int x = 1;
        int y = 1;
        for (int i = 0; i < exponent; i++) {
            x *= this.numerator;
            y *= this.denominator;

        }
        return new Rational(x, y); // YOUR CODE HERE
    }

    // Checks to see if either the numerator or denominator match a given number
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.contains(3)) // true
    public boolean contains(int x) {
        return this.numerator == x || this.denominator == x;// YOUR CODE HERE
    }

    // This returns a string representation of a Rational (e.g. "1/2")
    // This method has already been written for you
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    // *********
    // Here are is an example of a void method that changes the original Rational:
    // *********

    // This is a non-static version of simplify that returns a Rational
    // Example usage:
    // Rational r = new Rational(2, 4);
    // Rational s = r.simplify2(); // s = 1/2
    public Rational simplify2() {
        int gcf = gcf(this.numerator, this.denominator);
        int nume = this.numerator/gcf;
        int denom = this.denominator/gcf;
        Rational x = new Rational(nume, denom);
        return x;
    }

    // This is a non-static version of simplify that **changes** the original Rational
    // Note that the method is **void** because it doesn't need to return anything
    // Example usage:
    // Rational r = new Rational(2, 4);
    // r.simplify3(); // r is now equal to 1/2
    public void simplify3() {
        int gcf = gcf(this.numerator, this.denominator);
        this.numerator = this.numerator/gcf;
        this.denominator = this.denominator/gcf;
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor,
    public static int gcf(int a, int b){
        int maxNum = 1;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                maxNum = i;
            }
        }
        return maxNum;
    }

    // *********
    // Here are some methods that you will write later in class:
    // *********
    // Increments the current value of our Rational (increases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(3, 5);
    // r.increment(); // r is now 8/5
    public void increment() {
        // YOUR CODE HERE
        this.numerator += this.denominator;
    }

    // Decrements the current value of our Rational (decreases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(6, 5);
    // r.decrement(); // r is now 1/5
    public void decrement() {
        // YOUR CODE HERE
        this.numerator -= this.denominator;
    }

    // Given an int input representing the new denominator, changes the
    // current Rational to an equivalent fraction with that new denominator
    // You can assume that the numerator will always end up as a whole number
    // Rational r = new Rational(3, 8);
    // r.changeToEquivalentFraction(64); // r is now 24/64 (which is equivalent to 3/8)
    public void changeToEquivalentFraction(int newDenominator) {
        // YOUR CODE HERE
        numerator *= ((double) newDenominator/ (double) denominator);
        denominator *= ((double) newDenominator/ (double) denominator);
    }

    // **********
    // Methods you'll write for homework:
    // **********
    // Returns whether or not the Rational is a negative number
    // Example:
    // Rational r = new Rational(-3,4);
    // System.out.println(r.isNegative()) // true
    public boolean isNegative() {
        boolean a = this.numerator < 0;
        boolean b = this.denominator < 0;
        return (!a || !b) && (a || b);// YOUR CODE HERE
    }

    // Calculates the reciprocal of a Rational number.
    // The reciprocal of 3/4 is 4/3, the reciprocal of 1/2 is 2/1
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.reciprocal()) // 2/5
    public Rational reciprocal() {
        return new Rational(this.denominator, this.numerator); // YOUR CODE HERE
    }

    // Checks whether the current Rational is the exactly the same as other
    // Example:
    // Rational r = new Rational(2,5);
    // Rational s = new Rational(2,4);
    // System.out.println(r.equals(s)) // false
    public boolean equals(Rational other) {
        if(this.numerator == other.numerator && this.denominator == other.denominator){
            return true;
        }
        return false; // YOUR CODE HERE
    }

    // Rounds the current Rational to the nearest whole number value
    // Example:
    // Rational r = new Rational(3, 2);
    // r.round(); // r is now 2/1
    public void round() {
        // YOUR CODE HERE
        double newNum = (double) numerator / (double) denominator;
        int newNum2 = (int) (newNum + 0.5);
        this.numerator = newNum2;
        this.denominator = 1;
    }
}













