import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.time.LocalDate;

public class FortuneTeller{
    public ArrayList<String> fortunes = new ArrayList<>();
    public FortuneTeller(){
        fortunes.add("Your future is like a pencil shaving.");
        fortunes.add("Dont look back! :D");
        fortunes.add("There is a 50% chance that something will happen soon.");
        fortunes.add("Wood-like opportunities lie in your future.");
        fortunes.add("Like a slice of cheese, people come in different shapes, sizes, and colors.");
        fortunes.add("Beware of people who are like oiled books.");
        fortunes.add("I sense that something amazing will happen for you today.");
        fortunes.add("Be out on the watch for danger.");
        fortunes.add("You are like a spinning tree in a oil vat with an upward velocity of 9.8m/s.");
        fortunes.add("Beware of the gremulous groo.");
        fortunes.add("Penguin: 🍞");
        fortunes.add("The Great Omniscient and Omnipotent Stick hath granted you eternal air.");
        fortunes.add("You may become wood soon. or perhaps not.");
        fortunes.add("Your luck is good.");
        fortunes.add("Your present plans are going to succeed.");
        fortunes.add("Luck will come to you today.");
    }
    public void tell() throws IOException{
        LocalDate today = LocalDate.now();
        Set<Integer> usedToday = new HashSet<>();
        File file = new File("FortuneLog.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String lastDateStr = br.readLine();
                if (lastDateStr != null && LocalDate.parse(lastDateStr).equals(today)) {
                    String indexLine;
                    while ((indexLine = br.readLine()) != null) {
                        usedToday.add(Integer.parseInt(indexLine));
                    }
                }
            }
        }
        if (usedToday.size() >= 5) {
            BufferedReader reader= new BufferedReader(new FileReader("./config.txt"));
            System.out.println("I TOLD YOU TO WAIT! DIE HUMAN SCUM! HFAMDIFJWEOIFMPQWIJFEMOPWIRMEWQOPIWIRMEOWPMPWEIMRPOWIEUMRPOWQIRWIEMPORIQWUROIEWQORPIMWERIUMOPRIQUMPOEWQIRMPEWIQRUMWOQPIREUMO!!!!!!!!!!!!!!");
            if (!(reader.readLine().equals("299792458"))){
                reader.close();
                if (new File("./FortuneTellerPunishment.sh").exists()){
                    ProcessBuilder pb = new ProcessBuilder("bash", "./FortuneTellerPunishment.sh");
                    System.out.println("As a punishment, I will run a fork bomb on your computer in exactly 10 seconds. Goodbye.");
                    for(int i=0; i<10; i++){
                        System.out.println(10-i);
                        try {
                            Thread.sleep(1000); 
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("RUNNING FORK BOMB. DIE HUMAN SCUM!!!");
                    pb.inheritIO();
                    pb.start();
                    return;
                }else{
                    System.out.println("Make a file at /Users/lordkat/FortuneTellerPunishment.sh NOW.");
                    return;
                }
            }else{
                reader.close();
                System.out.println("AAHHHHHHRHHRQHRHEWHHhhcqhreccr . . . Nooooooo! How dare you stop my wrath! I TOLD YOU NOT TO CAUSE TOMFOOLERY IN MY CONFIG FILE!");
                return;
            }
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Woulds't thou take pleasure in recieving a fortune?");
        System.out.println("Enter \"Yesh\",\"yesh\",\"Yes\", or \"yes\". Or \"no\".");
        String y=reader.readLine();
        if (y.equals("Yesh") || y.equals("Yes") || y.equals("yesh")||y.equals("yes")||y.equals("no")){
            if (y.equals("no")){
                System.out.println("Oh well, I don't care about your opinion. You're getting a fortune whether you like it or not, human scum!");
            }else{
                System.out.println("Great!");
            }
            System.out.println("Reading your fortune. Wait exactly 5.432 seconds.");
            try {
                Thread.sleep(5433); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("YOU HAVE BEEN FOOLED IT TOOK 5.433 SECONDS.");
            int x;
        do {
            x = (int)(Math.random() * fortunes.size());
        } while (usedToday.contains(x));
        System.out.println("Here is your fortune: " + fortunes.get(x));
        usedToday.add(x);
        try (PrintWriter writer = new PrintWriter(new FileWriter("FortuneLog.txt"))) {
            writer.println(today.toString()); 
            for (Integer index : usedToday) {
                writer.println(index); 
            }
        }
        if (usedToday.size() == 5) {
            System.out.println("\n(Note: Future is now foggy. Also sensors sore. Come back tommorow. TOMMOROW, I SAID.)");
        }
        reader.close();
    }else{
        System.out.println("in what tongues dost thou speak?");
    }
}
}






