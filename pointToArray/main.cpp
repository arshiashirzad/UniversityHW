#include <iostream>
using namespace std;

void printArray(int* arr, int size) {
    for (int i = 0; i < size; arr++ && i++) {
      cout << *arr << " ";
    }
    cout << endl;
}

int main() {
    int arr[] = {4, 9, 16, 25, 36};
    int size = sizeof(arr) / sizeof(int);
    printArray(arr, size);
    return 0;
}
