import java.util.*;
public class ReverseQueue {

        public static Queue<Integer> reverseQueue(Queue<Integer> q) {
            Stack<Integer> s1=new Stack<>();
            while(!q.isEmpty()){
                s1.push(q.remove());
            }
            while(!s1.isEmpty()){
                q.add(s1.pop());
            }
            return q;
        }
        public static void main(String[] args) {
            Queue<Integer> q =new LinkedList<>();//using 2 Stack
            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);
            q.add(5);
            q.add(6);
            q.add(7);
            q.add(8);
            q.add(9);
            q.add(10);
            reverseQueue(q);
            while(!q.isEmpty()) {
                System.out.print(q.peek()+" ");
                q.remove();
            }
        }
}

