#include <iostream>
using namespace std;

class Node{
   public:
   int data;
   Node* next;


   Node(int val){
    data=val;
    next=NULL;
   }

};

class List{
    Node* head;
Node* tail;

public:

List(){
head=tail=NULL;
}

void push_front(int val){
    Node* newNode=new Node(val);
    if(head==NULL){
        head=tail=newNode;
        return;
    }else{
        newNode->next=head;
        head=newNode;
    }
}

void push_back(int val){
Node* newNode=new Node(val);
if(head==NULL){
    head=tail=newNode;
}else{
    tail->next=newNode;
    tail=newNode;
}

}

void pop_front(){
    if (head == NULL) { 
        cout << "List is empty, nothing to pop." << endl;
        return;
    }
    Node* tempo=head;
    head=head->next;
    tempo->next=NULL;
delete tempo;
}

void pop_back(){
Node* tempo=head;
while(tempo->next!=tail){
 
   tempo=tempo->next;   
}
tempo->next=NULL;

delete tail;
tail=tempo;
}




void insert(int val,int pos){
    Node* tempo=head;
   Node* newNode = new Node(val);
    Node* contain;
    if(pos<0){
        cout<<"invallid position";
    }else if (pos == 0) {
        newNode->next = head;
        head = newNode;
        return;
    }else{
    for(int i=0;i<pos-1;i++ ){
        if(tempo==NULL){
            cout<<"invalid position";
        }
tempo=tempo->next;
    }
    
    contain=newNode;
    newNode->next=tempo->next;
    tempo->next=newNode;
}
}


void printll(){
    Node* temp=head;
while(temp!= NULL){
    cout<<temp->data<<" ";
    temp=temp->next;
}
cout<<endl;
}

};



int main(){
List l;
l.push_front(1);
l.push_front(2);
l.push_front(3);
l.push_back(4);
l.printll();
l.pop_front();
l.printll();
l.pop_back();
l.printll();
l.insert(5,1);
l.printll();
}
