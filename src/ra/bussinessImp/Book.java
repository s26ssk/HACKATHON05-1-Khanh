package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

import static ra.run.BookManagement.scanner;

public class Book implements IBook, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;

    public Book(){

    }
    public Book(int bookId, String bookNane, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookNane;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookNane) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    private boolean bookStatus;
    @Override
    public void inputData() {
        System.out.println("Nhập vào mã sách");
        bookId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào tên sách");
        bookName = scanner.nextLine();
        System.out.println("Nhập vào tiêu đề sách");
        title = scanner.nextLine();
        System.out.println("Nhập vào số trang sách");
        numberOfPages = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào giá nhập sách");
        importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào giá bán sách");
        exportPrice = Float.parseFloat(scanner.nextLine());
        interest = exportPrice - importPrice;
        System.out.println("Nhập vào trạng thái sách");
        bookStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Số trang sách: " + numberOfPages);
        System.out.println("Giá nhập sách: " + importPrice);
        System.out.println("Giá bán sách: " + exportPrice);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Trạng thái sách: " + (bookStatus ? "Đang bán" : "Không bán"));
        System.out.println("--------------------------------------");
    }

    @Override
    public int compareTo(Book o) {
        float profit1 = this.getInterest();
        float profit2 = o.getInterest();
        return Float.compare(profit2, profit1);
    }
}
