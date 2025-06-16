// @tag:LinkedIn
public class PowerOF2 {

    public boolean check(int n) {
        if(n<=0) return false;
        while (n%2==0) {
            n/=2;
        }
        return n==1;
    }

    public static void main(String[] args) {
        PowerOF2 solution = new PowerOF2();
        System.out.println("Result for 4: "+solution.check(4));
        System.out.println("Result for 3: "+solution.check(3));
    }
}
