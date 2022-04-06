
import java.util.Stack;

public class MaximumElement {
    public static int maxElement(Stack<Integer> s1, Stack<Integer> s2, int k) {
        int n = 0;
        int sum = 0;
        Stack<Integer> temp = s1;
        if (k <= s1.peek() && k <= s2.peek()) {
            return -1;
        }
        else {
            while (!s1.isEmpty() && !s2.empty()) {
                sum = sum + temp.peek();
                if (sum < k && temp == s1) {
                    temp.pop();
                    n++;
                } else if (temp == s2) {
                    if (sum < k) {
                        temp.pop();
                        n++;
                    } else {
                        sum = sum - s2.peek();
                        break;
                    }
                } else {
                    sum = sum - temp.peek();
                    temp = s2;
                }
            }
            return n;
        }
    }


    public static void main(String[] args) {
        Stack<Integer> s1=new Stack<Integer>();
        Stack<Integer> s2 =new Stack<Integer>();
        int k=12;
        s1.push(7);
        s1.push(5);
        s1.push(1);
        s1.push(4);
        s1.push(3);

        s2.push(2);
        s2.push(5);
        s2.push(2);
        s2.push(1);
        System.out.println(maxElement(s1,s2,3));
    }
}
