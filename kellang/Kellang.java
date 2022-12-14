package kellang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Kellang {
    private File file;
    public static Function[] functions;

    public Kellang(File file) throws FileNotFoundException {
        if(!file.exists()) {
            throw new FileNotFoundException();
        }
        this.file = file;
    }
    public void run() throws FileNotFoundException {
        Scanner sc = new Scanner(this.file);
        String line;
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            analyzeLine(line);
        }
    }
    private LinkedList<String> analyzeLine(String line) {
        line = line.strip();
        LinkedList<String> tokens = new LinkedList<>();
        StringBuilder curTok = new StringBuilder();
        int inst = 0;
        boolean inQuote = false;
        for(char c : line.toCharArray()) {
            if(inst == 0) {
                if(c == ' ') {
                    inst = 1;
                    tokens.add(curTok.toString());
                    curTok = new StringBuilder();
                }
            } else {
                switch (c) {
                    case ',' -> {
                        if (!inQuote) {
                            tokens.add(curTok.toString().strip());
                            curTok = new StringBuilder();
                        }
                        continue;
                    }
                    case ' ' -> {
                        if (!inQuote) continue;
                    }
                    case '"' -> inQuote = !inQuote;
                }
            }
            if(c != '"') curTok.append(c);
        }
        tokens.add(curTok.toString().strip());
        return tokens;
    }
}
