#include <iostream>
using namespace std;
bool isPrime(int n)
{
    if (n <= 1)
        return false;
    for (int i = 2; i <= n / 2; i++)
        if (n % i == 0)
            return false;
    return true;
}
int main() {
    int num;
    cout << "PRIME CHECKER:" <<endl;
    cout<< "enter your number:"<< endl;
    cin >>num;
    if(isPrime(num)){
    cout << "prime"<<endl;
    }
    else{
        cout << "composite"<<endl;
    }
    return 0;
}
