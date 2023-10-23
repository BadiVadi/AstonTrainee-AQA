package org.example;
import org.apache.commons.lang3.StringUtils;
public class Execrise4 {
    public static void main(String[] args) {
        printStringTimes("Добрый вечер!", 3);
    }
    public static void printStringTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }
}


/* ВТОРОЕ РЕШЕНИЕ
package org.example;
import org.apache.commons.lang3.StringUtils;
public class Execrise4 {
    public static void main(String[] args) {
        printStringTimes();
    }
    public static void printStringTimes() {
        String str = "Repeat this line ";
        String repeated = StringUtils.repeat(str, 3);
        System.out.println(repeated);
    }
}
 */

