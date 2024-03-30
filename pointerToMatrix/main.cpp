#include <iostream>
using namespace std;
void printMatrix(int* mat) {
    for (int i = 0; i < 2; ++i) {
        for (int j = 0; j < 2; ++j) {
            cout << *((mat + i * 2) + j) << " ";
        }
        cout << endl;
    }
}

void addMatrices(int* mat1, int* mat2, int* result) {
    for (int i = 0; i < 2; ++i) {
        for (int j = 0; j < 2; ++j) {
            *((result + i * 2) + j) = *((mat1 + i * 2) + j) + *((mat2 + i * 2) + j);
        }
    }
}

void multiplyMatrices(int* mat1, int* mat2, int* result) {
    for (int i = 0; i < 2; ++i) {
        for (int j = 0; j < 2; ++j) {
            *((result + i * 2) + j) = 0;
            for (int k = 0; k < 2; ++k) {
                *((result + i * 2) + j) += *((mat1 + i * 2) + k) * *((mat2 + k * 2) + j);
            }
        }
    }
}

int main() {
    int matrix1[2][2] = {{1, 2}, {3, 4}};
    int matrix2[2][2] = {{5, 6}, {7, 8}};
    int sumResultMatrix[2][2] = {};
    int MultiplyResultMatrix[2][2] = {};

    int* mat1Ptr = &matrix1[0][0];
    int* mat2Ptr = &matrix2[0][0];
    int* sumResultPtr = &sumResultMatrix[0][0];
    int* MultiplyResultPtr = &MultiplyResultMatrix[0][0];

    cout << "Matrice 1:" << endl;
    printMatrix(mat1Ptr);

    cout << "\nMatrix 2:" << endl;
    printMatrix(mat2Ptr);

    addMatrices(mat1Ptr, mat2Ptr, sumResultPtr);
    cout << "\nSum of matrices:" << endl;
    printMatrix(sumResultPtr);

    multiplyMatrices(mat1Ptr, mat2Ptr, MultiplyResultPtr);
    cout << "\nMultiply of matrices:" << endl;
    printMatrix(MultiplyResultPtr);

    return 0;
}
