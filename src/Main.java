/**Для исполнения программы нужно увеличить размер кучи до 8192мб*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void setIp(int[] ipI, String ipS) {
        String[] ipStr = ipS.split("\\.");
        for (int i = 0; i < 4; i++)
            ipI[i] = Integer.parseInt(ipStr[i]);
    }

    public static void main(String[] args) throws IOException {
        String path = "Test.txt";
        long unique = 0;                                                //счетчик уникальных значений Ip
        String str;                                                     //строка, которую считываем из файла- ххх.ххх.ххх.ххх
        int[] ip = new int[4];                                          //массив, в который преобразуем строку
        byte[][][][] uniqueArray = new byte[256][256][256][256];        //массив 0/1, где 0- ip еще не встречался, а 1- встречался
        BufferedReader bR = new BufferedReader(new FileReader(path));

        long t = System.currentTimeMillis();
        while(true) {
            if ((str = bR.readLine()) == null) {
                break;
            }
            else {
                setIp(ip, str);
                if (uniqueArray[ip[0]][ip[1]][ip[2]][ip[3]] == 0) {     //если поступивший в обработку ip уникаклен (в массиве - 0)
                    uniqueArray[ip[0]][ip[1]][ip[2]][ip[3]] = 1;        //"стреляем" в массив единичкой и добавляемк счетчику единицу
                    unique ++;
                }
            }
        }
        System.out.println(unique);
        System.out.println(System.currentTimeMillis() - t);
    }
}