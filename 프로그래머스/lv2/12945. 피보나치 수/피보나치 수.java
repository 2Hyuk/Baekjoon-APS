class Solution{
    static int[] fibo;
    public int solution(int n) {
        fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        
        return fibo(n);
    }
    
    public int fibo(int n){
        if(n > 0 && fibo[n] == 0){
            fibo[n] = fibo(n - 1) + fibo(n - 2);
        }
        
        return fibo[n] % 1234567;
    }
}