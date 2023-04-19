class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while(!isMeet(a, b)){
            answer++;
            a = getNextOrder(a);
            b = getNextOrder(b);
        }

        return answer;
    }
    
    public int getNextOrder(int order){
        if(order % 2 == 1){
            order += 1;
        }
        return order / 2;
    }
    
    public boolean isMeet(int firstOrder, int secondOrder){
        if((firstOrder % 2 == 0 && secondOrder % 2 == 1 && secondOrder + 1 == firstOrder) 
           || (firstOrder % 2 == 1 && secondOrder % 2 == 0 && firstOrder + 1 == secondOrder)){
            return true;
        }
        return false;
    }
}