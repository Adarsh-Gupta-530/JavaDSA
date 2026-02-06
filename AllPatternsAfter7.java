public class AllPatternsAfter7 {
    static void Pattern8(){ // inverse pyramid 
        int n=5;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n-1-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<n-1-i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void Pattern9(){// Dimand pattern 
        int n=5;
        for(int i=0;i<n;i++){ // for upper half
            for(int j=0;j<n-i-1;j++){ // print spaces  
                System.out.print( " ");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print( "*");
            }
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        for(int i=n-1;i>=0;i--){ //for lower half
            for(int j=0;j<n-1-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<n-1-i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void Pattern10(){
        // *
        // **
        // ***
        // ****
        // *****
        // ****
        // ***
        // **
        // *
        int n=5;
        for(int i=1;i<=2*n-1;i++){
            int stars = i;

            if(i>n) stars = 2*n-i;// for last 4 rows to print reverse star pyramid
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }


    }
    
    static void Pattern11(){
        int n=5;

        int start=1;

        for(int i=0;i<n;i++){

            if(i%2==0) start =1; // if row is even starts with 1
            else start=0; // if odd starts with 0

            for(int j=0;j<=i;j++){
                System.out.print(start);
                start=1-start; 
                // it flip the start value to 0->1 and 1->0 
            }
            System.out.println();
        }
    }
    
    static void Pattern12(){
        // 1      1
        // 12    21
        // 123  321
        // 12344321
        int n=4;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int j=1; j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=i;j>0;j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    static void Pattern13(){
        // 1
        // 2 3
        // 4 5 6 
        // 7 8 9 10
        // 11 12 13 14 15 
        int n=5;
        int number=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(number++ +" ");
            }
            System.out.println();
        }
    }
    
    static void Pattern14(){
        int n=5;
        for(int i=0;i<n;i++){

            // type->1
            // char ch='A';
            // for(int j=0;j<=i;j++){
            //     System.out.print(ch++ +" ");
            // }
            for(char ch='A';ch<='A'+i ; ch++){ // -> here ("A"+1) means 'B' and ("A"+2) means "C" same as ("A"+i)-. means till "A"+i
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
    
    static void Pattern15(){
        int n=5;
        for(int i=n-1;i>=0;i--){
            for(char ch='A';ch<='A'+i;ch++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    static void Pattern16(){
        int n=5;
        char ch='A';
        for(int i=1;i<=n;i++){
            // char ch = 'A' + i;-> way 2
            for(int j=1;j<=i;j++){
                System.out.print(ch);
            }
            ch++;
            System.out.println();
        }
    }

    static void Pattern17(){
        int n=5;
        for(int i=0;i<n;i++){
            // spaces 
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            // chars 
           char ch='A';
           int breakPoint=(2*i+1)/2;
           for(int j=1;j<=2*i + 1;j++){
                System.out.print(ch);
                if(j<=breakPoint) ch++;
                else ch--;
           }            
           // spaces 
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void Pattern18(){
        int n=5;
        for(int i=0;i<n;i++){
            for(char ch2 = (char)('E'-i);ch2<='E';ch2++){
                System.out.print(ch2);
            }
            System.out.println();
        }
    }

    static void Pattern19(){
        int n=5;
        for(int i=0;i<n;i++){

            // first halve
            // star
            for(int j=1;j<=n-i;j++){
                System.out.print("*");
            }
            // space
            for(int j=0;j<2*i;j++){
                System.out.print(" ");
            }
            // star
            for(int j=1;j<=n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            // star
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            // space
            for(int j=0;j<2*(n-i);j++){
                System.out.print(" ");
            }
            // star
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void Pattern20(){
        int n = 5;
        int spaces = 2*n-2;
        for(int i=1; i<=2*n-1;i++){
            int stars=i;
            if(i>n) stars=2*n-i;
            //starts 
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            //spaces
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
            if(i<n) spaces-=2;
            else spaces+=2;
        }
    }
    
    static void Pattern21(){ //hollow rectangle
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==n-1 || j==n-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
             
        }
    }

    // static void Pattern22(){ // way1
    //     int n=7;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             if(i==0 || j==0 || i==n-1 || j==n-1){
    //                 System.out.print("4");
    //             }else if(i==1 || j==1 || i==n-2 || j==n-2){
    //                 System.out.print("3");
    //             }else if(i==2 || j==2 || i==n-3 || j==n-3){
    //                 System.out.print("2");
    //             }else if(i==j){
    //                 System.out.print("1");
    //             }
    //         }
    //         System.out.println();
    //     }
    // }

    static void Pattern22(){//
        int n=4;
        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++){
                int top=i;
                int left=j;
                int right=(2*n-2)-j;
                int down=(2*n-2)-i;
                System.out.print(n-Math.min(Math.min(top,down),Math.min(left,right)));
            }
            System.out.println();
        }

    }
    
    static void Pattern23(){ // butterfly pattern
        int n=5;
        // upper halve
        for(int i=1;i<=n;i++){
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            } 
            //spaces
            for(int j=0;j<2*(n-i);j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            } 
            System.out.println();
        }
        // second halve
        for(int i=0;i<n;i++){
            //stars
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            //spaces
            for(int j=0;j<2*i;j++){
                System.out.print(" ");
            }
            //stars
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void Pattern24(){//solid rhombus
        int n=5;
        for(int i=0;i<n;i++){
            //spaces
            for(int j=0;j<n-1-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void Pattern25(){ //hollow rhombus
        int n=5;
        for(int i=0;i<n;i++){
            //spaces
            for(int j=0;j<n-1-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==n-1 || j==n-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void Pattern26(){// numbers pyramid
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    static void Pattern27(){
        int n=5;
        for(int i=0;i<n;i++){
            // spaces
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            // nums
            int nums=i;
            int range=2*i+1;
            for(int j=1;j<=range;j++){
                System.out.print(nums+1);

                if(j>(range/2)) nums++;
                else nums--;
            }
            // spaces
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        Pattern27();
    }
}
