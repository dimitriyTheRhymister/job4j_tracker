package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() { }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo() {
        System.out.print(active + " ");
        System.out.print(status + " ");
        System.out.print(message + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Error err = new Error();
        Error err1 = new Error(false, 403, "Forbidden Error");
        Error err2 = new Error(true, 200, "the request has succeeded");
        Error err3 = new Error(false, 500, "Internal Server Error");
        err.showInfo();
        err1.showInfo();
        err2.showInfo();
        err3.showInfo();
    }
}
