#include <iostream>
using namespace std;

int main() {
    int arr[100];
    int n = 0;
    int choice;

    do {
        cout << "\n----- MENU -----\n";
        cout << "1. CREATE\n";
        cout << "2. DISPLAY\n";
        cout << "3. INSERT\n";
        cout << "4. DELETE\n";
        cout << "5. LINEAR SEARCH\n";
        cout << "6. EXIT\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {

        case 1:
            cout << "Enter number of elements: ";
            cin >> n;

            cout << "Enter the elements:\n";
            for (int i = 0; i < n; i++) {
                cin >> arr[i];
            }

            cout << "Array created successfully.\n";
            break;

        case 2:
            if (n == 0) {
                cout << "Array is empty.\n";
            } else {
                cout << "Array elements: ";
                for (int i = 0; i < n; i++) {
                    cout << arr[i] << " ";
                }
                cout << endl;
            }
            break;

        case 3: {
            int pos, value;

            if (n >= 100) {
                cout << "Array is full.\n";
                break;
            }

            cout << "Enter position for insertion: ";
            cin >> pos;

            cout << "Enter value: ";
            cin >> value;

            if (pos < 0 || pos > n) {
                cout << "Invalid position.\n";
            } else {
                for (int i = n; i > pos; i--) {
                    arr[i] = arr[i - 1];
                }

                arr[pos] = value;
                n++;

                cout << "Element inserted successfully.\n";
            }
            break;
        }

        case 4: {
            int pos;

            if (n == 0) {
                cout << "Array is empty.\n";
                break;
            }

            cout << "Enter position to delete: ";
            cin >> pos;

            if (pos < 0 || pos >= n) {
                cout << "Invalid position.\n";
            } else {
                for (int i = pos; i < n - 1; i++) {
                    arr[i] = arr[i + 1];
                }

                n--;

                cout << "Element deleted successfully.\n";
            }
            break;
        }

        case 5: {
            int value;
            bool found = false;

            cout << "Enter element to search: ";
            cin >> value;

            for (int i = 0; i < n; i++) {
                if (arr[i] == value) {
                    cout << "Element found at position " << i << ".\n";
                    found = true;
                    break;
                }
            }

            if (!found) {
                cout << "Element not found.\n";
            }
            break;
        }

        case 6:
            cout << "Program ended.\n";
            break;

        default:
            cout << "Invalid choice. Try again.\n";
        }

    } while (choice != 6);

    return 0;
}