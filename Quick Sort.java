// bc=O(nlogn), wc=O(n^2)
import java.util.*;
class A
{
    public static int pivot(int a[],int low,int high)
    {
        int i=low+1,j=high,pivot=a[low];
        while(i<=j)
        {
            while(i<=high && a[i]<pivot)  i++;
            while(j>=low && a[j]>pivot)  j--;
            if(i<j)
            {
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
            //since 1st elt is pivot then ofcourse j is closer to pivot            
        }
        a[low]=a[j];
        a[j]=pivot;
        return j;
    }
    public static void quicksort(int a[],int i,int j)
    {
        if(i<j){
        int k=pivot(a,i,j);
        quicksort(a,i,k-1);
        quicksort(a,k+1,j);}
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int a[]=new int[10];
        for(int i=0;i<10;i++)
        {
            // a[i]=i;//BEST CASE
            a[i]=9-i;//WORST CASE
            // a[i]=(int)(Math.random()*100);//AVERAGE CASE
        }
        int i1=0,j=10-1;
        System.out.println("Before merge:");
        for(int i=0;i<10;i++)   System.out.print(a[i]);
        quicksort(a,i1,j);
        System.out.println("\n After merge sort:");
        for(int i=0;i<10;i++)   System.out.print(a[i]);
    }
}
//

//way:(HERE TAKING PIVOT AS 1ST ELT IN ALL ROUNDS)
//pivot lo ek elt ko bacha half mei left end ko i lo and right end ko j
//i ko aage badhao if getting any elt greater than pivot stop 
//j ko piche badhao if getting any elt less than pivot elt stop
//if i>=j exchange pivot with nearer one(i or j)th elt
//if i<j exchange i and j th elts                    |  
//if this happens        <---------------------------|
//pivot jaha bhi aaya its in sorted position(means elt rhs to it are greater than it and lhs are smaller than it)
//now work on lhs half till it gets fully sorted(divide) and conquer by sorting
//for this half consider it as the original array take 1st elt of LHS half as pivot next to it as i 
//and last elt of this half as j

//use partition and quick sort 2 functions
//BC & AC = nlogn , WC=n^2

//.......rem 1 pass means until pivot swaps...pivot has come to correct position..now do same thing with lhs and rhs halves
