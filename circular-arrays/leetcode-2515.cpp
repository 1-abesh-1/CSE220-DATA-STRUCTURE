class Solution {
    vector<string> arr;
    int rear;
    int front;
int r_c=0;
int f_c=0;
int cap;
public:
void push(){
    r_c++;
rear=(rear+1)%cap;
}
void pop(){
    f_c++;
    front=((front-1)%cap+cap)%cap;
}
    int closestTarget(vector<string>& words, string target, int startIndex) {
        arr=words;
cap=arr.size();
rear=startIndex;
front=startIndex;
bool exists=false;
for(int i=0;i<cap;i++){
    if(arr[i]==target){
        exists=true;
        break;
    }
}
if(exists){
while(arr[front]!=target){
pop();
}
while(arr[rear]!=target){
push();
}
if(f_c<=r_c){
    return f_c;
}else{
    return r_c;
}
}else{
    return -1;
}



    }
};
