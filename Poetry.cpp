#include <iostream>
#include <string>
#include <vector>

using namespace std;

int cycles[1000];
string line;

int main() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", &cycles[i]);
    getline(cin, line);
    getline(cin, line);
    vector<string> words;
    int last = 0;
    for (int i = 1; i < line.length(); i++) {
        if (line[i] == ' ') {
            words.push_back(line.substr(last, i-last));
            last = i+1;
        }
    }
    words.push_back(line.substr(last));
    int pos = 0;
    bool done = false;
    int index = 0;
    while (!done) {
        int l = 0;
        if (words[index].length() <= cycles[pos]) {
            l += words[index].length();
            for (char i : words[index]) printf("%c", i);
            if (index == words.size() - 1) break;
            index++;
        }
        else {
            for (char i : words[index].substr(0, cycles[pos])) printf("%c", i);
            printf("\n");
            words[index] = words[index].substr(cycles[pos]);
            pos = (pos+1) % n;
            continue;
        }
        for (; index < words.size(); index++) {
            if (l+words[index].length() + 1 <= cycles[pos]) {
                l += words[index].length() + 1;
                printf(" ");
                for (char i : words[index]) printf("%c", i);
                if (index == words.size() - 1) done = true;
            }
            else break;
        }
        pos = (pos+1) % n;
        printf("\n");
    }
    return 0;
}
