package com.barzykin.proxy;

public class FilePrintDemo {
    public static void main(String[] args) {
        Printer printer = new HeaderFooterFilePrinterProxy();
        printer.print("C:\\Users\\Alexej_Barzykin\\1111\\text.txt");
    }
}
