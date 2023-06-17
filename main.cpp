#include<iostream>
void main(){
int n,i;
int fact = 1;
cout<<"Program to find factorial of a given number"<<endl;
cout<<"Enter the value of n: "<<endl;
cin>>n;
for(i = 1;i<=n;i++){
    fact*=i;
}
cout<<"The factorial of"<<n<<" is: "<<fact;
}