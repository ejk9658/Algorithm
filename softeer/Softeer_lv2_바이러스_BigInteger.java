package softeer;

import java.util.*;
import java.io.*;
import java.math.*;

public class Softeer_lv2_바이러스_BigInteger
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger k = new BigInteger(st.nextToken());
        BigInteger p = new BigInteger(st.nextToken());
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger answer = p.modPow(n,BigInteger.valueOf(1000000007));	// 제곱 후 나머지 연산
        answer = answer.multiply(k).mod(BigInteger.valueOf(1000000007));	// 곱셈 후 나머지 연산
        System.out.println(answer);
    }
}
/*
2 3 2

*/