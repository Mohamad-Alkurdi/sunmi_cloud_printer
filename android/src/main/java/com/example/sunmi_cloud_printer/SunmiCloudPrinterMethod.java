package com.example.sunmi_cloud_printer;


import android.content.Context;
import android.graphics.Bitmap;

import com.sunmi.externalprinterlibrary.api.ConnectCallback;
import com.sunmi.externalprinterlibrary.api.PrinterException;
import com.sunmi.externalprinterlibrary.api.SunmiPrinter;
import com.sunmi.externalprinterlibrary.api.SunmiPrinterApi;

import java.util.List;

public class SunmiCloudPrinterMethod {

    private final Context _context;

    public SunmiCloudPrinterMethod(Context _context) {
        this._context = _context;
    }

    public void setCloudPrinter() throws PrinterException {
        SunmiPrinterApi.getInstance().setPrinter(SunmiPrinter.SunmiCloudPrinter);

    }

    public void setBTPrinter() throws PrinterException {
        List<String> macList = SunmiPrinterApi.getInstance().findBleDevice(_context);
        if (macList.size() > 0) {
            SunmiPrinterApi.getInstance().setPrinter(SunmiPrinter.SunmiBlueToothPrinter, macList.get(0));
        }
    }

    public void setNetPrinter() throws PrinterException {
        String ip = "192.168.2.93";
        SunmiPrinterApi.getInstance().setPrinter(SunmiPrinter.SunmiNetPrinter, ip);
    }

    public void connect() throws PrinterException {
        if (!SunmiPrinterApi.getInstance().isConnected()) {
            SunmiPrinterApi.getInstance().connectPrinter(_context, new ConnectCallback() {
                @Override
                public void onFound() {
                    System.out.println("onFound");
                }

                @Override
                public void onUnfound() {
                    System.out.println("onUnfound");
                }

                @Override
                public void onConnect() {
                    System.out.println("onConnect");
                }

                @Override
                public void onDisconnect() {
                    System.out.println("onDisconnect");
                }

            });
        }
    }

    public void printerInit() throws PrinterException {
        SunmiPrinterApi.getInstance().printerInit();
    }

    public void printText(String text) throws PrinterException {
        SunmiPrinterApi.getInstance().printText(text);
    }

    public void lineWrap(int n) throws PrinterException {
        SunmiPrinterApi.getInstance().lineWrap(n);
    }

    public void pixelWrap(int n) throws PrinterException {
        SunmiPrinterApi.getInstance().pixelWrap(n);
    }

    public void tab() throws PrinterException {
        SunmiPrinterApi.getInstance().tab();
    }

    public void setHorizontalTab(int[] k) {
        SunmiPrinterApi.getInstance().setHorizontalTab(k);
    }

    public void printQrCode(String data, int modulesize, int errorlevel) throws PrinterException {
        SunmiPrinterApi.getInstance().printQrCode(data, modulesize, errorlevel);
    }

    public void printBarCode(String code, int type, int width, int height, int hriPos) throws PrinterException {
        SunmiPrinterApi.getInstance().printBarCode(code, type, width, height, hriPos);
    }

    public void cutPaper(int m, int n) throws PrinterException {
        SunmiPrinterApi.getInstance().cutPaper(m, n);
    }

    public void enableBold(Boolean bold) throws PrinterException {
        SunmiPrinterApi.getInstance().enableBold(bold);
    }

    public void enableDouble(Boolean dooble) throws PrinterException {
        SunmiPrinterApi.getInstance().enableDouble(dooble);
    }

    public void enableUnderline(Boolean underline) throws PrinterException {
        SunmiPrinterApi.getInstance().enableUnderline(underline);
    }

    public void printBitmap(Bitmap bitmap, int mode) throws PrinterException {
        SunmiPrinterApi.getInstance().printBitmap(bitmap, mode);
    }

    public void printColumnsText(String[] colsTextArr, int[] colsWidthArr, int[] colsAlign) throws PrinterException {
        SunmiPrinterApi.getInstance().printColumnsText(colsTextArr, colsWidthArr, colsAlign);
    }

    public void endTransBuffer() throws PrinterException {

        SunmiPrinterApi.getInstance().endTransBuffer();
    }

    public void startTransBuffer() throws PrinterException {
        SunmiPrinterApi.getInstance().startTransBuffer();
    }

    public int getPrinterStatus() throws PrinterException {
        return SunmiPrinterApi.getInstance().getPrinterStatus();
    }

    public boolean isConnected() throws PrinterException {
        return SunmiPrinterApi.getInstance().isConnected();
    }

    public void sendRawData(byte[] cmd) throws PrinterException {
        SunmiPrinterApi.getInstance().sendRawData(cmd);
    }

    public void setAlignMode(int type) throws PrinterException {
        SunmiPrinterApi.getInstance().setAlignMode(type);
    }

    public void flush() throws PrinterException {
        SunmiPrinterApi.getInstance().flush();
    }

    public void setFontZoom(int hori, int veri) throws PrinterException {
        SunmiPrinterApi.getInstance().setFontZoom(hori, veri);
    }

}
