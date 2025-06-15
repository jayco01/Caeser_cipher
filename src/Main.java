import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String selected = "";
        boolean selectedIsValid = false;
        while (true) {

            MenuHelper.printMenu();

            selected = scanner.nextLine().trim();
            selectedIsValid = Validator.isValidMenuOption(selected);

            int selectedInt = (selectedIsValid) ? Integer.parseInt(selected) : -1;
            if (selectedInt == 0) { break; }
            else if (selectedInt == -1) { continue; }

            try
            {
                MenuHelper.selectService(selectedInt, scanner);
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}