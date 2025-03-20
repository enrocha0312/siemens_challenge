#include <stdio.h>
#include <stdlib.h>

int stringLength(char userString[]);

int main(void) {
    char *userWord = NULL;  //using pointer instead of vector
    int size = 100;  
    int index = 0;  // index for anexing character dinamically
    char c;  

    // memory allocation
    userWord = (char *)malloc(size * sizeof(char));
    printf("Type a word:\n");

    // Reading character by character
    while ((c = getchar()) != '\n' && c != EOF) {
        userWord[index++] = c;
        if (index >= size) {
            size *= 2;  // make the size greater(by 2)
            // memory reallocation
            userWord = (char *)realloc(userWord, size * sizeof(char));
        }
    }

    userWord[index] = '\0';  // defining the end the string

    int length = stringLength(userWord);
    printf("Length of the typed string: %i\n", length);

    free(userWord);  // free memory
    return 0;
}

int stringLength(char userString[]) {
    int numCharacters = 0;
    while (userString[numCharacters] != '\0') { 
        ++numCharacters;
    }
    return numCharacters;
}
