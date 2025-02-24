public class Zad3 {
    public static void main(String[] args) {
        int[] Tab = new int[]{5,3,8,4,2,2,0};
        int s=Tab.length;
        int a;
        for(int i=0; i<s; i++){
            for(int j=i+1; j<s; j++){
                if(Tab[i]>Tab[j]){
                    a=Tab[i];
                    Tab[i]=Tab[j];
                    Tab[j]=a;
                }
            }
        }
        for(int i=0; i<s; i++){
            System.out.println(Tab[i]+" ");
        }
    }
}
