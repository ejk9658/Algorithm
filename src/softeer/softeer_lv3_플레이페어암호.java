package softeer;

import java.util.*;
import java.io.*;


public class softeer_lv3_플레이페어암호
{
    static char cmap[][];
    static int imap[];
    static StringBuilder sb;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String msg = br.readLine();
        String key = br.readLine();

        // 1. key를 5*5 크기의 표로 만들고, 1차원 정수형 배열도 만든다.
        makeMap(key);

        // 2. msg를 두 글자씩 나누면서 암호화한다.
        go(msg);
        System.out.println(sb.toString());
    }
    static void makeMap(String key) {
        cmap = new char[5][5];
        imap = new int[25];  // 각 알파벳 위치 정보(정수)가 담겨있음
        boolean isContains[] = new boolean[26];
        char keys[] = key.toCharArray();
        int count = 0;
        for(char k: keys) {
            if(isContains[k-'A']) continue;
            isContains[k-'A'] = true;
            cmap[count/5][count%5] = k;
            int idx = k-'A'<9?k-'A':k-'A'-1;
            imap[idx] = count++;
        }
        for(int i=0; i<26; i++) {
            if(isContains[i] || i==9) continue;
            cmap[count/5][count%5] = (char)(i+'A');
            imap[i<9?i:i-1] = count++;
        }
    }
    static void go(String msg) {
        char msgs[] = msg.toCharArray();
        int n = msgs.length;
        String temp = "";
        for(int i=0; i<n; i++) {
            if(temp.length() == 0) {
                temp += msgs[i];
            } else {
                if(temp.equals(msgs[i]+"")) {
                    temp += temp.equals("X")?"Q":"X";
                    change(temp);
                    i--;
                } else {
                    temp += msgs[i];
                    change(temp);
                }
                temp = "";
            }
        }
        if(temp.length()==1) change(temp+"X");
    }
    static void change(String str) {
        int idx1 = str.toCharArray()[0]-'A';
        idx1 -= idx1<9?0:1;
        int idx2 = str.toCharArray()[1]-'A';
        idx2 -= idx2<9?0:1;

        int row1 = imap[idx1]/5;  // 첫 번째 문자의 위치
        int col1 = imap[idx1]%5;
        int row2 = imap[idx2]/5;  // 두 번째 문자의 위치
        int col2 = imap[idx2]%5;
        
        if(row1 == row2) {  // 2-1. 두 글자가 같은 행에 존재하는 경우
            sb.append(cmap[row1][(col1+1)%5]).append(cmap[row2][(col2+1)%5]);
        } else if(col1 == col2) {   // 2-2. 2-1의 경우를 만족하지 않으면서, 두 글자가 같은 열에 존재하는 경우
            sb.append(cmap[(row1+1)%5][col1]).append(cmap[(row2+1)%5][col2]);
        } else {    // 2-3. 2-1,2-2의 경우를 만족하지 않으면서, 두 글자가 서로 다른 행, 열에 존재하는 경우
            sb.append(cmap[row1][col2]).append(cmap[row2][col1]);
        }
    }
}
/*
HELLOWORLD
PLAYFAIRCIPHERKEY

*/
