package com.qld.quanlydiem.Model;

public class PointBroad {
    private PointBoardItem pointBoardItem;
    private String tongKet10;
    private String tongKetChu;
    private String ketQua;

    public PointBroad() {
    }

    public PointBroad(PointBoardItem pointBoardItem, String tongKet10, String tongKetChu, String ketQua) {
        this.pointBoardItem = pointBoardItem;
        this.tongKet10 = tongKet10;
        this.tongKetChu = tongKetChu;
        this.ketQua = ketQua;
    }

    public PointBoardItem getPointBoardItem() {
        return pointBoardItem;
    }

    public void setPointBoardItem(PointBoardItem pointBoardItem) {
        this.pointBoardItem = pointBoardItem;
    }

    public String getTongKet10() {
        return tongKet10;
    }

    public void setTongKet10(String tongKet10) {
        this.tongKet10 = tongKet10;
    }

    public String getTongKetChu() {
        return tongKetChu;
    }

    public void setTongKetChu(String tongKetChu) {
        this.tongKetChu = tongKetChu;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }
}
