/**
 * Lop thuc thi Main - Cau 3
 * Su dung ArrayList (Collection), doc/ghi file (IO), tim don hang thanh toan cao nhat
 */
import java.io.*;
import java.util.*;

public class QLDonHang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- NHAP DANH SACH (Collection ArrayList) ---
        System.out.print("Nhap so luong don hang n: ");
        int n = sc.nextInt();
        sc.nextLine(); // doc bo dem

        ArrayList<DonHang> ds = new ArrayList<>(); // Collection

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhap don hang thu " + (i + 1) + " ---");
            DonHang dh = new DonHang();
            dh.nhap();
            ds.add(dh);
        }

        // --- IN RA MAN HINH ---
        System.out.println("\n=== DANH SACH DON HANG ===");
        KhachHang.inTieuDe(); // tieu de cot khach hang
        // In tieu de them cot don hang (co the in them 1 dong thong bao)
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n",
                "MA DON HANG", "NGAY DAT", "TONG TIEN", "THUE VAT", "TONG TT", "TRANG THAI");
        for (DonHang dh : ds) {
            dh.inDL();
        }

        // --- TIM DON HANG CO TONG THANH TOAN CAO NHAT ---
        DonHang max = null;
        for (DonHang dh : ds) {
            if (max == null || dh.tinhTongThanhToan() > max.tinhTongThanhToan()) {
                max = dh;
            }
        }

        System.out.println("\n=== DON HANG CO TONG THANH TOAN CAO NHAT ===");
        if (max != null) {
            KhachHang.inTieuDe();
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n",
                    "MA DON HANG", "NGAY DAT", "TONG TIEN", "THUE VAT", "TONG TT", "TRANG THAI");
            max.inDL();
        }

        // --- NHAP XUAT IO: doc tu donhang.txt va ghi ketqua.txt ---
        try (BufferedReader br = new BufferedReader(new FileReader("donhang.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("ketqua.txt"))) {

            // Doc dong dau la so luong
            String line = br.readLine();
            int count = Integer.parseInt(line.trim());

            ArrayList<DonHang> dsFile = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String maKH = br.readLine();
                String hoTen = br.readLine();
                String duong = br.readLine();
                String phuong = br.readLine();
                String quan = br.readLine();
                String thanhPho = br.readLine();
                String maDH = br.readLine();
                String ngayDat = br.readLine();
                double tongTien = Double.parseDouble(br.readLine().trim());
                String trangThai = br.readLine();

                DiaChi dc = new DiaChi(duong, phuong, quan, thanhPho);
                DonHang dh = new DonHang(maKH, hoTen, dc, maDH, ngayDat, tongTien, trangThai);
                dsFile.add(dh);
            }

            // Ghi ket qua ra file
            bw.write("DANH SACH DON HANG TU FILE:\n");
            bw.write(String.format("%-10s %-20s %-20s %-20s %-20s %-20s%n",
                    "MAKH", "HO TEN", "DUONG", "PHUONG", "QUAN", "THANH PHO"));
            for (DonHang dh : dsFile) {
                bw.write(String.format("%-10s %-20s %-20s %-20s %-20s %-20s%n",
                        dh.getMaKH(), dh.getHoTen(),
                        dh.getDiaChi().getDuong(), dh.getDiaChi().getPhuong(),
                        dh.getDiaChi().getQuan(), dh.getDiaChi().getThanhPho()));
                bw.write(String.format("%-15s %-15s %-15.2f %-15.2f %-15.2f %-15s%n",
                        dh.getMaDonHang(), dh.getNgayDat(), dh.getTongTien(),
                        dh.tinhThueVAT(), dh.tinhTongThanhToan(), dh.getTrangThai()));
            }

            // Tim max trong danh sach file
            DonHang maxFile = null;
            for (DonHang dh : dsFile) {
                if (maxFile == null || dh.tinhTongThanhToan() > maxFile.tinhTongThanhToan()) {
                    maxFile = dh;
                }
            }

            bw.write("\nDON HANG CAO NHAT:\n");
            if (maxFile != null) {
                bw.write(String.format("Ma DH: %s | Tong thanh toan: %.2f%n",
                        maxFile.getMaDonHang(), maxFile.tinhTongThanhToan()));
            }

            System.out.println("\nDa doc xong donhang.txt va ghi ket qua ra ketqua.txt");

        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file donhang.txt (bo qua buoc IO neu chua co file).");
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
