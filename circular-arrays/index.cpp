#include <iostream>

using namespace std;
class cirularArr{
int* arr;
int currSize=0;
int cap;
int front,rare;



public:
cirularArr(int size){
cap=size;
arr=new int[cap];
front=0;
rare=-1;
}

void push(int data){
if(currSize==cap){
   cout << "memory full\n";
   return;
}

rare=(rare+1)%cap;
arr[rare]=data;
currSize++;
}
 
void pop(){
if(empty()){
   cout<<"empty";
   return;
}

front=(front+1)%cap;
currSize--;
}

int front_view(){
if(empty()){
   cout<<"empty";
   return -1;
}
return arr[front];
}

bool empty(){
   return currSize==true;
}

void printArr(){
   for(int i=0;i<cap;i++){
      cout<<arr[i]<<" ";
   }
   cout<<endl;
}

};

int main() {
  cirularArr abesh(5);
abesh.push(1);
abesh.push(2);
abesh.push(3);
abesh.push(4);
abesh.push(5);
abesh.push(6);
cout<<"after pushing"<<endl;
abesh.printArr();
abesh.pop();
cout<<"after popping"<<endl;
abesh.printArr();
abesh.push(8);
cout<<"after pushing new"<<endl;
abesh.printArr();
     return 0;
    }
//A circular array is an array where the end connects back to the start, like a ring.
//It lets you reuse space efficiently by wrapping indices around with modulo (index % size).




   


