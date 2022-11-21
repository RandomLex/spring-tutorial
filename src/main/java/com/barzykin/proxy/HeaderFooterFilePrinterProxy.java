package com.barzykin.proxy;

public class HeaderFooterFilePrinterProxy implements Printer {
    private final Printer printer;

    public HeaderFooterFilePrinterProxy() {
        printer = new FilePrinter();
    }


    @Override
    public void print(String filename) {
        long begin = System.currentTimeMillis();
        printer.print(filename);
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения метода: " + (end - begin) + " миллисекунд");
    }
}
