#include <iostream>
using namespace std;
void triangle(int height){
    for (int i = 1; i <= height; i++) {
        for (int j = 1; j <= height - i; j++) {
            cout << " ";
        }
        for (int j = 1; j <= (2 * i - 1); j++) {
            if (j == 1 || j == (2 * i - 1) || i == height)
                cout << "*";
            else
                cout << " ";
        }
        cout << endl;
    }
}
void firstRectangle(int columns,int rows){

    for (int i = 1; i <= rows; i++) {
        for (int space = 1; space <= (rows/2)+1 ; space ++) {
            cout << " ";
        }
        for (int j = 1; j <= columns; j++) {
            if (i == 1 || i == rows || j == 1 || j == columns)
                cout << "*";
            else
                cout << " ";
        }
        cout << endl;
    }
}
void secondRectangle(int columns,int rows){
        for (int i = 1; i <= rows; i++) {
            for (int space = 1; space <= (rows/2) +1 ; space ++) {
                cout << " ";
            }
            for (int j = 1; j <= columns; j++) {
                if (i == 1 || i == rows || j == 1 || j == columns)
                    cout << "*";
                else
                    cout << " ";
            }
            cout << endl;
        }
}
int main() {
    triangle(8);
    firstRectangle(4,9);
    secondRectangle(9,4);
    return 0;
}
