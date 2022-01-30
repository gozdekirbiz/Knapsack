package knapsack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knapsack {
	public static void knapsack(int W[], int V[], int cap, int numofitem) {
		int B[][] = new int[numofitem + 1][cap + 1];
		
		for (int i=0; i<=numofitem; i++)
			for (int j=0; j<=cap; j++) {
				B[i][j] = 0;
			}
		
		for (int i = 1; i <= numofitem; i++) {
			for (int j = 0; j <= cap; j++) {
				B[i][j] = B[i - 1][j];
				
				if ((j >= W[i-1]) && (B[i][j] < B[i - 1][j - W[i - 1]] + V[i - 1])) 
				{
					B[i][j] = B[i - 1][j - W[i - 1]] + V[i - 1]; 
				}
			}
		}
		System.out.println("\nMaximum Deger:" + B[numofitem][cap]);
		System.out.println("En iyi cozum: ");
		while (numofitem != 0) {
			if (B[numofitem][cap] != B[numofitem - 1][cap]) 
			{
				System.out.println("\tItem " + numofitem + " W = " + W[numofitem - 1] + " Value = " + V[numofitem - 1]);
				cap = cap - W[numofitem-1];
			}
			
			numofitem--;
		}
	
	}
	public static void printSubset(int arr[], int data[], int n, int dataIndex, int arrIndex) {
        if (arrIndex == n) { 
            System.out.print("["); 
            for (int j = 0; j < n; j++) {
                System.out.print(data[j] == 0 ? "" : data[j]);
            }
            System.out.print("]"+"\t");
            return;
        }
        data[dataIndex] = arr[arrIndex];
        printSubset(arr, data, n, dataIndex + 1, arrIndex + 1);
        data[dataIndex] = 0;
        printSubset(arr, data, n, dataIndex, arrIndex + 1);
    }
  
	static void subsetSums(int []arr, int l, int r, int sum)
	{
		if (l > r)
		{ 
			System.out.print(sum +"\t");
		    return;
		}
		subsetSums(arr, l + 1, r,sum + arr[l]);
		subsetSums(arr, l + 1, r, sum);
	}

	public static void main(String args[])
	{
		int kapasite;
		Scanner sc=new Scanner(System.in);
		System.out.print("Kapasiteyi giriniz:");
		kapasite=sc.nextInt();
		if(kapasite>=5&&kapasite<=25)
		{
			List<Item> items = new ArrayList<>();
			for(int i=0;i<5;i++)
			{
				int weight,value;
				Scanner s=new Scanner(System.in);
				Scanner s2=new Scanner(System.in);
				System.out.print(i+1 +". item:");
				System.out.print("\nWeight:");
				weight=s.nextInt();
				System.out.print("Value:");
				value=s2.nextInt();
				items.add(i, new Item(weight,value,kapasite));
			}
			int []W=new int [5];
			int []V=new int [5];
			for(int j=0;j<5;j++)
			{
				W[j]=items.get(j).weight;
				V[j]=items.get(j).value;
			}
			int n = V.length;
			int []arr= {1,2,3,4,5};
			int []data = new int[arr.length];
			System.out.print("\t");
			printSubset(arr, data, 5, 0, 0);
			System.out.print("\n"+"Weight:");
			System.out.print("\t");
			subsetSums(W,0,W.length-1,0);
			System.out.print("\n"+"Values:");
			System.out.print("\t");
			subsetSums(V,0,V.length-1,0);
			System.out.println();
			knapsack(W,V,kapasite,n);
		}
	}
}
