/**
 * Lop cha KhachHang - Cau 1.2
 * Da bo sung phuong thuc static inTieuDe() va phuong thuc inDL()
 */
public class KhachHang {
    protected String maKH;
    protected String hoTen;
    protected DiaChi diaChi;

    // Constructor mac dinh
    public KhachHang() {
        this.maKH = "";
        this.hoTen = "";
        this.diaChi = new DiaChi();
    }

    // Constructor day du tham so
    public KhachHang(String maKH, String hoTen, DiaChi diaChi) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
    }

    // Getter / Setter
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * PHUONG THUC STATIC: in tieu de cot
     * Goi truc tiep: KhachHang.inTieuDe();
     */
    public static void inTieuDe() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n",
                "MAKH", "HO TEN", "DUONG", "PHUONG", "QUAN", "THANH PHO");
    }

    /**
     * Phuong thuc in du lieu cua 1 khach hang
     * Goi qua doi tuong: kh.inDL();
     */
    public void inDL() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n",
                maKH,
                hoTen,
                diaChi.getDuong(),
                diaChi.getPhuong(),
                diaChi.getQuan(),
                diaChi.getThanhPho());
    }

    @Override
    public String toString() {
        return "KhachHang{maKH=" + maKH + ", hoTen='" + hoTen + "', diaChi=" + diaChi + "}";
    }

    /**
     * Phuong thuc nhap thong tin khach hang tu ban phim
     * (Lop con se goi super.nhap() truoc)
     */
    public void nhap() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ma KH: ");
        maKH = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap duong: ");
        String duong = sc.nextLine();
        System.out.print("Nhap phuong: ");
        String phuong = sc.nextLine();
        System.out.print("Nhap quan: ");
        String quan = sc.nextLine();
        System.out.print("Nhap thanh pho: ");
        String thanhPho = sc.nextLine();
        diaChi = new DiaChi(duong, phuong, quan, thanhPho);
    }
}
