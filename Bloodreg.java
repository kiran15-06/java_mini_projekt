import java.util.ArrayList;
import java.util.Scanner;

class Donor {
    int sno;
    String name;
    int age;
    String bloodGroup;
    String contact;

    Donor(int sno, String name, int age, String bloodGroup, String contact) {
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.contact = contact;
    }
}

public class Bloodreg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Donor> donors = new ArrayList<>();
        int sno = 1;

        while (true) {
            System.out.print("Enter Donor Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Blood Group: ");
            String bloodGroup = sc.nextLine();

            System.out.print("Enter Contact Number: ");
            String contact = sc.nextLine();

            donors.add(new Donor(sno, name, age, bloodGroup, contact));
            sno++;

            System.out.print("Do you want to add another donor? (yes/no): ");
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("no")) {
                break;
            }
        }

        while (true) {
            System.out.print("Enter donor name to search (or 'exit' to quit): ");
            String searchName = sc.nextLine().trim();

            if (searchName.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Registry Search.");
                break;
            }

            boolean found = false;
            for (Donor d : donors) {
                if (d.name.equalsIgnoreCase(searchName)) {
                    System.out.println("\n---------------- DONOR FOUND ----------------");
                    System.out.printf("S.No        : %d%n", d.sno);
                    System.out.printf("Name        : %s%n", d.name);
                    System.out.printf("Age         : %d%n", d.age);
                    System.out.printf("Blood Group : %s%n", d.bloodGroup);
                    System.out.printf("Contact No. : %s%n", d.contact);
                    System.out.println("---------------------------------------------\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("⚠ Donor not found in registry.\n");
            }
        }

        sc.close();
    }
}
