import java.io.*;
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String command = parts[0];

                try {
                    switch (command) {
                    //Made use of Google to verify how switch-case is laid out
                        case "BUILD":
                            for (int i = 1; i < parts.length; i++)
                                bst.insert(Integer.parseInt(parts[i]));
                            break;

                        case "INSERT":
                            bst.insert(Integer.parseInt(parts[1]));
                            break;

                        case "DELETE":
                            bst.delete(Integer.parseInt(parts[1]));
                            break;

                        case "IN_ORDER":
                            System.out.print("IN_ORDER: ");
                            bst.print_in_order();
                            break;

                        case "SIZE":
                            System.out.println("SIZE: " + bst.getSize());
                            break;

                        case "HEIGHT":
                            System.out.println("HEIGHT: " + bst.height());
                            break;

                        case "KTH_SMALLEST":
                            int k = Integer.parseInt(parts[1]);
                            int result = bst.find_kth_smallest(k);

                            if (result != -1) {
                                System.out.println("KTH_SMALLEST: " + result + " (k = " + k + ")");
                            }
                            break;

                        case "SEARCH":
                            boolean found = bst.search(Integer.parseInt(parts[1]));
                            System.out.println("SEARCH " + parts[1] + ": " + found);
                            break;

                        default:
                            System.out.println("Input not valid");
                    }

                } catch (Exception e) {
                    System.out.println("Input not valid");
                }
            }
            br.close();

        } catch (IOException e) {
            System.out.println("File error");
        }
    }
}
