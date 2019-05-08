import org.openqa.selenium.By;

import java.io.*;
import java.util.Properties;

import static java.lang.System.out;

public class Utils extends TestBase {


    public static void get_2GData(String url_html, Integer nr_auktion) {

        driver.get(url_html);
        String t = "//table[@class='table1 gebotsobjekte'][1]/tbody[1]/tr";
        String s_gesamt;

        String sFilename = "data_2GHz.txt";
        String sFilename2 = "data_36GHz.txt";
        String sFile = System.getProperty("user.dir") + "/" + sFilename;

        File file = new File(sFile);
        BufferedWriter buff = null;
        try {
            buff = new BufferedWriter(new FileWriter(sFile, file.exists() ));
            //buff.append( "Kaufteil nochmal:  " + sFilename+ "\n");
            int i_rowCount = driver.findElements(By.xpath(t)).size();
            int i_cols;
            for (int i = 3; i <= i_rowCount; i++) {
                //System.out.printf("Rowcount: %d ", i);
                // for int j = 1
                s_gesamt = nr_auktion + ";" ;
                i_cols = driver.findElements(By.xpath("//table[@class='table1 gebotsobjekte'][1]/tbody[1]/tr[" + i + "]/td")).size();
                for (int j = 1; j <= i_cols; j++) {
                    //System.out.printf("%s; ", driver.findElement(By.xpath("//div[@id='content']/div/div/table/tbody/tr[" + i + "]/td[" + j + "]")).getText());
                    //System.out.printf("%s; ", driver.findElement(By.xpath("//table[@class='table1 gebotsobjekte'][1]/tbody[1]/tr[" + i + "]/td[" + j + "]")).getText());
                    s_gesamt = s_gesamt +  driver.findElement(By.xpath("//table[@class='table1 gebotsobjekte'][1]/tbody[1]/tr[" + i + "]/td[" + j + "]")).getText() + ";" ;
                    //out.println(s_gesamt);

                }
                out.println(s_gesamt);
                buff.append(s_gesamt);
                buff.newLine();
                s_gesamt = "";
                //out.println();
            }

        buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void get_3GData(String url_html, Integer nr_auktion) {

        driver.get(url_html);
        //String t = "//table[@class='table1 gebotsobjekte'][1]/tbody[1]/tr";
        String t = "//table[@class='table2a gebotsobjekte'][1]/tbody[1]/tr";
        String s_gesamt;

        //String sFilename = "data_2GHz.txt";
        String sFilename = "data_36GHz.txt";
        String sFile = System.getProperty("user.dir") + "/" + sFilename;

        File file = new File(sFile);
        BufferedWriter buff = null;
        try {
            buff = new BufferedWriter(new FileWriter(sFile, file.exists() ));
            int i_rowCount = driver.findElements(By.xpath(t)).size();
            int i_cols;
            for (int i = 3; i <= i_rowCount; i++) {
                s_gesamt = nr_auktion + ";" ;
                i_cols = driver.findElements(By.xpath("//table[@class='table2a gebotsobjekte'][1]/tbody[1]/tr[" + i + "]/td")).size();
                for (int j = 1; j <= i_cols; j++) {
                    s_gesamt = s_gesamt +  driver.findElement(By.xpath("//table[@class='table2a gebotsobjekte'][1]/tbody[1]/tr[" + i + "]/td[" + j + "]")).getText() + ";" ;
                }
                out.println(s_gesamt);
                buff.append(s_gesamt);
                buff.newLine();
                s_gesamt = "";
            }

            t = "//table[@class='table2b gebotsobjekte'][1]/tbody[1]/tr";
            i_rowCount = driver.findElements(By.xpath(t)).size();
            for (int i = 3; i <= i_rowCount; i++) {
                s_gesamt = nr_auktion + ";" ;
                i_cols = driver.findElements(By.xpath("//table[@class='table2b gebotsobjekte'][1]/tbody[1]/tr[" + i + "]/td")).size();
                for (int j = 1; j <= i_cols; j++) {
                    s_gesamt = s_gesamt +  driver.findElement(By.xpath("//table[@class='table2b gebotsobjekte'][1]/tbody[1]/tr[" + i + "]/td[" + j + "]")).getText() + ";" ;
                }
                out.println(s_gesamt);
                buff.append(s_gesamt);
                buff.newLine();
                s_gesamt = "";
            }



            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void UpdateProperty(String p1, String p1_value) {

        try {
            FileOutputStream output = new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/config");
            prop.setProperty(p1, p1_value);
            prop.store(output, "Update");
            output.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void TestWriteFile() {

            Writer fw = null;

            String sFilename = "2G.txt";
            String t = System.getProperty("user.dir") + "/" + sFilename;
            System.out.print(t);

            try
            {
                File file = new File(t);
                BufferedWriter buff = new BufferedWriter(new FileWriter(t, file.exists() ));
                buff.append( "Kaufteil nochmal:  " + sFilename+ "\n");
                // buff.newLine();
                buff.close();


                //fw = new FileWriter( System.getProperty("user.dir") + "/2G.txt" );
                //fw.append( "Dies ist ein Test 2" );
                //fw.append( System.getProperty("line.separator") ); // e.g. "\n"
            }
            catch ( IOException e ) {
                System.err.println( "Konnte Datei nicht erstellen" );
            }
            finally {
                if ( fw != null )
                    try { fw.close(); } catch ( IOException e ) { e.printStackTrace(); }
            }

        }


    public static String get_htmlnr(Integer i) {

        String s;

        if (i < 10) {
            s = "00" + i;

        } else if (i > 9 && i < 100) {

            s = "0" + i;
        } else {

            s = String.valueOf(i) ;
        }
        return s;
    }
}







