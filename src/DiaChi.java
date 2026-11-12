/**
 * Lop thanh phan DiaChi - Cau 1.1
 */
public class DiaChi {
    private String duong;
    private String phuong;
    private String quan;
    private String thanhPho;

    // Constructor mac dinh
    public DiaChi() {
        this.duong = "";
        this.phuong = "";
        this.quan = "";
        this.thanhPho = "";
    }

    // Constructor day du tham so
    public DiaChi(String duong, String phuong, String quan, String thanhPho) {
        this.duong = duong;
        this.phuong = phuong;
        this.quan = quan;
        this.thanhPho = thanhPho;
    }

    // Getter / Setter
    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    @Override
    public String toString() {
        return duong + ", " + phuong + ", " + quan + ", " + thanhPho;
    }
}
