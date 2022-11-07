#include"testReceiver.h"

void getLines(vector<string> &lines){
    string line;
    do{
        getline(cin,line,'\n');
        lines.push_back(line);
    }while(line != "");
}

int main(){
    vector<string> lines;
    getLines(lines);
    void (*printPtr)(stats) = &printStats;
    processStringLines(lines,printPtr);
    testReceiver();
    cout<<"All the Test cases are passed"<<endl;
}

