public class TowerofHanoi {
    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n==0) return;
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("Move "+n+" disk from "+src+" to "+dest);
        towerOfHanoi(n-1, helper, src, dest);
    }
    public static void main(String[] args) {
        towerOfHanoi(3,"src","helper","dest");
    }
}
