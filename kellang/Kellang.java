package kellang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Kellang {
    private File file;

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
            LinkedList<Object> tokens = analyzeLine(line);
            HashMap<>
        }
    }
    private LinkedList<Object> analyzeLine(String line) {
        line = line.strip();
        LinkedList<Object> tokens = new LinkedList<>();
        StringBuilder curTok = new StringBuilder();
        int inst = 0;
        boolean inQuote = false;
        for(char c : line.toCharArray()) {
            if(inst == 0) {
                if(c == ' ') {
                    inst = 1;
                    /*
                    Object val = getType(curTok.toString().strip());
                    if(!(val instanceof String)) {
                        return null;
                    } else {
                        tokens.add(val);
                    }
                     */
                    Function func = Function.getFunction(curTok.toString().strip());
                    if(func == null) return null;
                    tokens.add(func);
                    curTok = new StringBuilder();
                }
            } else {
                switch (c) {
                    case ',' -> {
                        if (!inQuote) {
                            tokens.add(getType(curTok.toString().strip()));
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
            curTok.append(c);
        }
        tokens.add(curTok.toString().strip());
        return tokens;
    }

    public Object getType(String val) {
        boolean isNum = true;
        boolean isString = val.charAt(0) == '"' && val.charAt(val.length() - 1) == '"';
        boolean acceptable = false;
        String nums = "1234567890.";
        for(char c : val.toCharArray()) {
            if(nums.indexOf(c) == -1) isNum = false;
        }
        if(isNum) return Float.parseFloat(val);
        return val;
    }
}
