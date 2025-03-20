#include <stdio.h>

int stringLength(char userString[]);

int main(void) {
    char userWord[100];

    printf("Type a word:\n");
    fgets(userWord, sizeof(userWord), stdin);

    int length = stringLength(userWord);

    // removing the line brake
    if (length > 0 && userWord[length - 1] == '\n') {
        userWord[length - 1] = '\0';
        length--;
    }

    printf("Length of the typed string: %i\n", length);

    return 0;
}

int stringLength(char userString[]) {
    int numCharacters = 0;
    while (userString[numCharacters] != '\0') { 
        ++numCharacters;
    }
    return numCharacters;
}
