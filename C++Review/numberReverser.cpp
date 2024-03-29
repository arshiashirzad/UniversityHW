#include <iostream>
using namespace std;
int reverseDigits(int num)
{
    int revNum = 0;
    while (num > 0) {
        revNum = revNum * 10 + num % 10;
        num = num / 10;
    }
    return revNum;
}
int main() {
 cout << "NUMBER REVERSER"<< endl;
 cout << "enter a number:"<< endl;
 int num ;
 cin >> num;
 cout<< " reversed number is: "<< reverseDigits(num);
 return 0;
}
