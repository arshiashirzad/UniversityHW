#include <iostream>
using namespace std;
bool isIn(float c_x, float c_y, float r, float x, float y)
{
     float distance = sqrt(pow(x - c_x, 2) + pow(y - c_y, 2));
     if (distance <= r) {
        return true;
    } else {
        return false;
    }
}
int main() {
    float c_x,c_y,r,x,y;
    cout<< "INSIDE OR OUTSIDE OF THE CIRCLE?"<<endl;
    cout<< "enter the x of the center:";
    cin>> c_x;
    cout<< endl;
    cout<< "enter the y of the center:";
    cin>> c_y;
    cout<< endl;
    cout<< "enter the radius of the center:";
    cin>> r;
    cout<< endl;
    cout<< "enter the x of the point:";
    cin>> x;
    cout<< endl;
    cout<< "enter the y of the point:";
    cin>> y;
    cout<< endl;
    if(isIn(c_x,c_y,r,x,y)){
        cout<<"the point is inside of the circle";
    }else{
        cout<< "the point is outside of the circle";
    }
    return 0;
}
