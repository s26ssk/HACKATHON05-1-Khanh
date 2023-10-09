package ra.run;

import ra.bussiness.IBook;
import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    private static List<Book> books = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choise;
        do {
            System.out.println("********************** JAVA-HACKATHON-05-BASIC-MENU *************************");
            System.out.println("1. Nhập số sách và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choise = scanner.nextInt();
            scanner.nextLine();

            switch (choise){
                case 1:
                    inputBooks();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    sortBooksByInterest();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBookByName();
                    break;
                case 6:
                    changeBookStatus();
                    break;
                case 7:
                    System.out.println("Đã thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        }while (choise != 7);
    }
    // case 1
    private static void inputBooks() {
        System.out.print("Nhập số sách cần nhập thông tin: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numBooks; i++) {
            Book book = new Book();
            book.inputData();
            books.add(book);
        }
    }

    // case 2
    private static void displayBooks() {
        for (IBook book : books) {
            book.displayData();
        }
    }

    // case 3
    private static void sortBooksByInterest() {
        Collections.sort(books);
        System.out.println("Sách đã được sắp xếp theo lợi nhuận giảm dần.");
    }

    // case 4
    private static void deleteBook() {
        System.out.print("Nhập mã sách cần xóa: ");
        int bookIdToDelete = scanner.nextInt();
        boolean found = false;

        for (IBook book : books) {
            if (((Book) book).getBookId() == bookIdToDelete) {
                books.remove(book);
                System.out.println("Sách có mã sách " + bookIdToDelete + " đã được xóa.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách có mã sách " + bookIdToDelete);
        }
    }

    // case 5
    private static void searchBookByName() {
        System.out.print("Nhập tên sách cần tìm: ");
        String bookNameToSearch = scanner.nextLine();
        boolean found = false;

        for (IBook book : books) {
            if (((Book) book).getBookName().equalsIgnoreCase(bookNameToSearch)) {
                book.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách có tên sách " + bookNameToSearch);
        }
    }

    // case 6
    private static void changeBookStatus() {
        System.out.print("Nhập mã sách cần thay đổi trạng thái: ");
        int bookIdToChangeStatus = scanner.nextInt();
        boolean found = false;

        for (IBook book : books) {
            if (((Book) book).getBookId() == bookIdToChangeStatus) {
                ((Book) book).setBookStatus(!((Book) book).isBookStatus());
                System.out.println("Trạng thái của sách có mã sách " + bookIdToChangeStatus + " đã được thay đổi.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách có mã sách " + bookIdToChangeStatus);
        }
    }
}
