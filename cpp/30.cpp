#include<iostream>
#include<math.h>
using namespace std;
int  main()
{
	long long total=0;
	for(int i=2;i<=295245;i++)
	{
		int num=i,temp=0;
		for(;num>0;num/=10)
		{
			int p=num%10;
			temp=temp+pow(p,5);
		}
		if(temp==i)
		{
			total=total+i;
		}
		
	}
	cout<<total;
}
