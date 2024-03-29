#include <iostream>
using namespace std;
void square( int n ){
    for( int i = 1; i <= n; i++ ) {
        for(int j = 1; j <= n; j++ ) {
            cout << "*";
        }
        cout << endl;
    }
}
int main() {
    int num;
    cout<< "SQUARE PRINTER:"<<endl;
    cout << "enter the length of square:"<< endl;
    cin>> num;
    square(num);
    return 0;
}
