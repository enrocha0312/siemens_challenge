#include <iostream>
using namespace std;

void reverseString(char* startPointer, char* endPointer) {
    //comparing address
	while (startPointer < endPointer) {
		//putting the content by using ASCII math. start receives the sum of start and end
		//the end substract it, receiving the content of start in the end
		//the startPOinter receives the same, but the endpointer is its value, so, what rests is the endPointer
        *startPointer = *startPointer + *endPointer;
        *endPointer = *startPointer - *endPointer;
        *startPointer = *startPointer - *endPointer;
        startPointer++;
        endPointer--;
    }
}

int main() {
	string userWord;
    cout << "Type a word:\n";
    cin >> userWord;
    // a pointer for start and another pointer for the end of the word
    char* start = &userWord[0];  
    char* end = &userWord[userWord.size() - 1]; 
    reverseString(start, end); 
    cout << "Reversed word: " << userWord << endl;
    return 0;
}
