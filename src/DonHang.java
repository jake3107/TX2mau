/**
 * Lop con DonHang extends KhachHang - Cau 2
 */
public class DonHang extends KhachHang {
    private String maDonHang;
    private String ngayDat;
    private double tongTien;
    private String trangThai;

    // Constructor mac dinh
    public DonHang() {
        super();
        this.maDonHang = "";
        this.ngayDat = "";
        this.tongTien = 0.0;
        this.trangThai = "";
    }

    // Constructor day du tham so goi super(...)
    public DonHang(String maKH, String hoTen, DiaChi diaChi,
                   String maDonHang, String ngayDat, double tongTien, String trangThai) {
        super(maKH, hoTen, diaChi);
        this.maDonHang = maDonHang;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    // Getter / Setter
    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    // Tinh thue VAT 8%
    public double tinhThueVAT() {
        return tongTien * 0.08;
    }

    // Tinh tong thanh toan sau thue
    public double tinhTongThanhToan() {
        return tongTien + tinhThueVAT();
    }

    /**
     * Ghi de nhap(): goi super.nhap() truoc, nhap them thong tin don hang
     */
    @Override
    public void nhap() {
        super.nhap(); // nhap phan KhachHang
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ma don hang: ");
        maDonHang = sc.nextLine();
        System.out.print("Nhap ngay dat: ");
        ngayDat = sc.nextLine();
        System.out.print("Nhap tong tien: ");
        tongTien = sc.nextDouble();
        sc.nextLine(); // doc xuong dong con lai
        System.out.print("Nhap trang thai: ");
        trangThai = sc.nextLine();
    }

    /**
     * Ghi de inDL(): goi super.inDL() truoc, in them thong tin don hang
     */
    @Override
    public void inDL() {
        super.inDL(); // in phan KhachHang
        System.out.printf("%-15s %-15s %-15.2f %-15.2f %-15.2f %-15s%n",
                maDonHang,
                ngayDat,
                tongTien,
                tinhThueVAT(),
                tinhTongThanhToan(),
                trangThai);
    }

    @Override
    public String toString() {
        return "DonHang{" + "maDonHang=" + maDonHang + ", ngayDat=" + ngayDat
                + ", tongTien=" + tongTien + ", trangThai='" + trangThai + '\'' + '}';
    }
}
