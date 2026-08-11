#include <iostream>
using namespace std;

int main() {
    int arr[10][10];
    int rows, columns;

    cout << "Enter number of rows: ";
    cin >> rows;

    cout << "Enter number of columns: ";
    cin >> columns;

    cout << "Enter the elements:\n";

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            cin >> arr[i][j];
        }
    }

    cout << "\nSum of each row:\n";

    for (int i = 0; i < rows; i++) {
        int rowSum = 0;

        for (int j = 0; j < columns; j++) {
            rowSum += arr[i][j];
        }

        cout << "Row " << i + 1 << " = " << rowSum << endl;
    }

    cout << "\nSum of each column:\n";

    for (int j = 0; j < columns; j++) {
        int columnSum = 0;

        for (int i = 0; i < rows; i++) {
            columnSum += arr[i][j];
        }

        cout << "Column " << j + 1 << " = " << columnSum << endl;
    }

    return 0;
}