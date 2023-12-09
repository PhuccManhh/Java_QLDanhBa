package buoi13.baitap5;
import java.util.*;

public class AddressBook {
    private Set<Contact> SetContact;
    private Map<String, Contact> MapContact;

    public AddressBook(){
        this.SetContact = new HashSet<>();
        this.MapContact = new HashMap<>();
    }

   public void themMoi(){
       System.out.println("nhập thông tin liên hệ mới");
       Contact newcontact = new Contact();
       newcontact.nhapThongTin();
       boolean invalPhone = false;
       for (Contact oldcontact : SetContact) {
           if (oldcontact.getSoDienThoai().equals(newcontact.getSoDienThoai())){
               invalPhone = true;
               break;
           }
       }
       if (invalPhone){
           System.out.println("liên hệ vừa nhập vào đã trùng số điện thoại trong danh sách");
           return;
       }else {
           SetContact.add(newcontact);
           MapContact.put(newcontact.getSoDienThoai(),newcontact);
       }
   }

    public void capNhapSoDienthoai() {
        System.out.println("nhập số điện thoại cần cập nhập ");
        String soDienThoaiCapNhap = new Scanner(System.in).nextLine();
        Contact lienHeCanSua = null;
        for (Contact oldContact : SetContact) {
            if (oldContact.getSoDienThoai().equals(soDienThoaiCapNhap)) {
                lienHeCanSua = oldContact;
            }
        }
        if (lienHeCanSua != null) {
            Contact contact1 = new Contact();
            System.out.println("đã tìm thấy liên hệ cần sửa");
            lienHeCanSua.hienThiThongTinContact();
            System.out.println("nhập vào thông tin mới");
            contact1.nhapThongTin();
            lienHeCanSua.setSoDienThoai(contact1.getSoDienThoai());
            lienHeCanSua.setSetemail(contact1.getSetemail());
            lienHeCanSua.setTen(contact1.getTen());
            SetContact.add(lienHeCanSua);
            SetContact.remove(lienHeCanSua);
            MapContact.remove(soDienThoaiCapNhap);
            MapContact.put(contact1.getSoDienThoai(), lienHeCanSua);
            System.out.println("bạn cập nhập thông tin thành công !");
        } else {
            System.out.println("không tìm thấy số liên hệ bạn cần tìm");
        }

    }

    public void timKiemNhanhThongTin(){
        System.out.println("nhập vào số điện thoại tìm kiếm");
        String p = new Scanner(System.in).nextLine();
        Contact lienHeCanTimKiem = MapContact.get(p);

        if (lienHeCanTimKiem != null ){
            System.out.println("liên hệ cần tìm là: ");
            lienHeCanTimKiem.hienThiThongTinContact();
        }else {
            System.out.println("không tìm thấy liên hệ cần tìm kiếm ");
        }
    }
    public void xoaLienHe() {
        System.out.println("nhập số điện thoại cần xóa");
        String soDienThoai = new Scanner(System.in).nextLine();
        Contact lienHeCanXoa = MapContact.get(soDienThoai);
        if (lienHeCanXoa != null) {
            SetContact.remove(lienHeCanXoa);
            MapContact.remove(soDienThoai);
            System.out.println("bạn xóa thành công trong Danh Bạ!");
        } else {
            System.out.println("bạn xóa không thành công vì số này không có trong Danh Bạ!");
        }

    }

   public void hienThiThongTin(){
        if (SetContact.isEmpty()){
            System.out.println("Danh sách liên hệ trống !");
        }else {
            System.out.println("liên hệ có trong danh sách");
        }
        for (Contact hienThi : SetContact){
            hienThi.hienThiThongTinContact();
        }
   }
   }

