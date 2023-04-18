import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.sql.Array;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.RecursiveAction;

public class Main {
    public static void main(String[] args) {
//        floatInput();
//        task002();
//        task003();
        task004();
    }

/*
1) Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
вместо этого, необходимо повторно запросить у пользователя ввод данных.
*/
    public static void floatInput(){
        try {
            Scanner in = new Scanner(System.in);
            boolean flag = true;
            while (flag) {
                try {
                    System.out.print("Input float number: ");
                    float a = in.nextFloat();
                    System.out.println(a);
                    flag = false;
                    in.close();
                } catch (InputMismatchException e) {
                    System.out.println("Incorrect input. Only float numbers!");
                    in.next();
                }
            }
        }
        catch (Exception e){
            throw new RuntimeException("Непредвиденная ошибка: " + e.getMessage());
            }
        }

/*
2) Если необходимо, исправьте данный код
 */
// Задание 2
    public static void task002() {
        int[] intArray = new int[] {1,2,3};
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected exception: " + e.getStackTrace());
        }
    }

/*
3) Дан следующий код, исправьте его там, где требуется
 */
// Задание 3

//    public static void main(String[] args) throws Exception {
    public static void task003(){
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1,2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null! \n" + ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера! \n" + ex.getMessage());
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так... \n" + ex.getMessage());
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

/*
4) Исправьте код, примените подходящие способы обработки исключений.
 */

//    public static void main(String[] args) {
    public static void task004(){
        InputStream inputStream;
        try {
            String[] strings = {"apple", "orange"};
            String strings1 = strings[1];
            test();
            int a = 1 / 0;
            inputStream = new FileInputStream("/broken_reference");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("На ноль делить нельзя");
        } catch (StackOverflowError error) {
            error.printStackTrace();
            System.out.println("Что-то сломалось");
        } catch (Throwable e) {
            e.getMessage();
            System.out.printf("Unexpected exception: " + e.getMessage() + "\n");
        } finally {
            System.out.println("Я все равно выполнился");
        }
        System.out.println("Я жив!");
    }

    private static void test() {

        try {
            File file = new File("1");
            file.createNewFile();
            FileReader reader = new FileReader(file);
            reader.read();
            test();
        } catch (FileNotFoundException | FileAlreadyExistsException e) {
            System.out.println("Что-то не так с файлом: " + e.getMessage());
        } catch (StackOverflowError e){
            System.out.println("Переполнение ");
        } catch (Exception e){
            e.getLocalizedMessage();
        }
    }

}
