#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to concatenate two strings using pointers
void concatenateStrings(char *string1, char *string2) {
    // Move pointer to the end of string1
    while (*string1) {
        string1++;
    }
    while (*string2) {
        *string1 = *string2;
        string1++;
        string2++;
    }
    *string1 = '\0';
}

// Function to reverse a string using pointers
void reverseString(char *str, char *null) {
    char temp;
    int length = strlen(str);
    int i, j;

    for (i = 0, j = length - 1; i < j; i++, j--) {
        temp = *(str + i);
        *(str + i) = *(str + j);
        *(str + j) = temp;
    }
}

int main() {
    char *string1, *string2;

    //memory allocation
    string1 = (char *)malloc(100 * sizeof(char));
    string2 = (char *)malloc(100 * sizeof(char));

    printf("Enter the first string: ");
    scanf("%s", string1);
    printf("Enter the second string: ");
    scanf("%s", string2);

    void (*functionPtr[2])(char *,char*);

    functionPtr[0] = concatenateStrings;
    functionPtr[1] = reverseString;

    functionPtr[0](string1, string2);

    printf("Concatenated string: %s\n", string1);

    functionPtr[1](string1,string1);

    printf("Reversed concatenated string: %s\n", string1);

    free(string1);
    free(string2);

    return 0;
}
