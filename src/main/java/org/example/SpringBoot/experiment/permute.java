package src.main.java.org.example.SpringBoot.experiment;

public class permute {
    public static void main(String[] args)
    {
        String str = "12345678901234";
        int n = str.length();
        org.example.SpringBoot.WordCalculator.Permutation permutation = new org.example.SpringBoot.WordCalculator.Permutation();
       // permutation.getStrings(str, 0, n - 1);
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void getStrings(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
              //  str = swap(str, l, i);
             //   permute(str, l + 1, r);
              //  str = swap(str, l, i);
            }
        }
    }

}
