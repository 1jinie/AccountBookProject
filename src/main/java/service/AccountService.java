package service;

import vo.AccountVO;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AccountService {
    private static AccountService instance = new AccountService();
    private ArrayList<AccountVO> list;
    private AccountService(){
        list = new ArrayList<>();
        loadFromCSV();
    }

    public static AccountService getInstance(){
        return instance;
    }

    public Calendar setDate(String sd){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(sd);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            return calendar;
        } catch (ParseException e) {
            throw new RuntimeException("날짜 형식 변환에 실패했습니다");
        }
    }

    private void loadFromCSV() {
        try(FileReader fr = new FileReader("Account.csv");
            BufferedReader br = new BufferedReader(fr)){
            br.readLine();
            while(true){
                String str = br.readLine();
                if(str == null) break;
                String[] arr = str.split(",");
                list.add(new AccountVO(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3], arr[4], setDate(arr[5])));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException("올바른 파일이 아닙니다. csv 파일을 입력해주세요.");
        }
    }

    public void exportToCSV(){
        try(FileWriter fw = new FileWriter("Account.csv");
            PrintWriter pw = new PrintWriter(fw)){
            pw.println("id,type,amount,description,category,date");
            list.forEach(item -> pw.println(item.toString()));
            System.out.println("가계부 저장 완료");
        } catch (IOException e) {
            throw new RuntimeException("출력값이 없습니다.");
        }
    }
}
