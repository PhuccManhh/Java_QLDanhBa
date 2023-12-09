package buoi13.baitap5;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Contact {
    private  String ten;
    private String soDienThoai;
    private Set<String> Setemail;

    public Contact(){
           this.Setemail = new HashSet<>();
    }

    public String getTen(){
        return ten;
    }

    public void setTen(String ten){
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Set<String> getSetemail() {
        return Setemail;
    }

    public void setSetemail(Set<String> setemail) {
        Setemail = setemail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(soDienThoai, contact.soDienThoai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soDienThoai);
    }

    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("mời nhập tên");
        this.ten = sc.nextLine();
        System.out.println("mời nhập số điện thoại");
        this.soDienThoai = sc .nextLine();
        System.out.println("nhập email");
        System.out.println("số lượng email");
        int  p = new Scanner(System.in).nextInt();
        for (int i = 0; i < p; i++){
            System.out.println("nhập vào email thứ " + (i + 1));
                    String email = new Scanner(System.in).nextLine();
                    Setemail.add(email);
        }
    }
    public void hienThiThongTinContact(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "=> Thông Tin Người Trong Danh Bạ [ " +
                "" + "Họ Và Tên : " + ten + " / "
                + "Số Điện Thoại : " + soDienThoai + " / "
                + "Gmail : " + String.join(", " , Setemail)
                + ']';
    }


}
