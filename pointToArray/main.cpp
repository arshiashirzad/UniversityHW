#include <iostream>
using namespace std;

int searchNumber(int* arr, int size, int number) {
    for (int i = 0; i < size; ++i) {
        if (*(arr + i) == number) {
            return i;
        }
    }
    return -1;
}
void printArray(int* arr, int size) {
    for (int i = 0; i < size; ++i) {
        cout << *(arr + i) << " ";
    }
    cout << endl;
}

void sortArray(int* arr, int size) {
    for (int i = 0; i < size - 1; ++i) {
        for (int j = 0; j < size - i - 1; ++j) {
            if (*(arr + j) > *(arr + j + 1)) {
                int temp = *(arr + j);
                *(arr + j) = *(arr + j + 1);
                *(arr + j + 1) = temp;
            }
        }
    }
}


int main() {
    const int size = 7; 
    int arr[size] = {5, 3, 7, 2, 8, 1, 4};
    int* arrPtr = arr;
    cout << "Original array: ";
    printArray(arrPtr, size);

    int numberToFind;
    cout << "Enter the number you want to find: ";
    cin >> numberToFind;

    int index = searchNumber(arrPtr, size, numberToFind);
    if (index != -1) {
        cout << "Number found at index: " << index << endl;
    } else {
        cout << "Number not found in the array." << endl;
    }
    sortArray(arrPtr, size);

    cout << "Sorted array: ";
    printArray(arrPtr, size);

    return 0;
}
