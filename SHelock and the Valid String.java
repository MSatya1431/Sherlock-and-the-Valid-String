import java.util.Scanner;
public class ram
{
    public static String isValid(String s)
    {
        int[] arr=new int[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++;
        }
        int countOne=0;
        int countTwo=0;
        for(int i=0;i<26;i++)
        {
            if(arr[i]==0)
            {
                continue;
            }
            else if(arr[i]==1)
            {
                countOne++;
            }
            else if(arr[i]==2)
            {
                countTwo++;
            }        
            else
            {
                return "YES";
            }
        }
        if(countOne==1&&countTwo==0)
        {
            return "YES";
        }
        for(int i=0;i<26;i++)
        {
            if(arr[i]==0)
            {
                continue;
            }
            arr[i]--;
            int c1=countOne-(arr[i]==0?1:0);
            int c2=countTwo+(arr[i]==1?1:(arr[i]==0?-1:0));
            if(c1==1&&c2==0)
            {
                return "YES";
            }
            arr[i]++;
        }
        return "NO";
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(isValid(s));
        sc.close();
    }
}