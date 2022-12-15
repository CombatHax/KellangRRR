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
            Object[] stuff = analyzeLine(line);
            if(stuff == null) return;
            Function func = (Function) stuff[0];
            LinkedList<Object> args = (LinkedList<Object>) stuff[1];
            func.run(args);
        }
    }
    private Object[] analyzeLine(String line) {
        line = line.strip();
        Function f = null;
        LinkedList<Object> args = new LinkedList<>();
        StringBuilder curTok = new StringBuilder();
        int inst = 0;
        boolean inQuote = false;
        for(char c : line.toCharArray()) {
            if(inst == 0) {
                if(c == ' ') {
                    inst = 1;
                    f = Function.getFunction(curTok.toString().strip());
                    if(f == null) return null;
                    curTok = new StringBuilder();
                }
            } else {
                switch (c) {
                    case ',' -> {
                        if (!inQuote) {
                            args.add(getType(curTok.toString().strip()));
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
        args.add(curTok.toString().strip());
        return new Object[]{f, args};
    }

    public Object getType(String val) {
        boolean isNum = true;
        boolean isString = val.charAt(0) == '"' && val.charAt(val.length() - 1) == '"';
        boolean acceptable = false;
        int dots = 0;
        int quotes = 0;
        String nums = "1234567890.";
        for(char c : val.toCharArray()) {
            if(nums.indexOf(c) == -1) isNum = false;
            if(c == '.') dots++;
            else if(c == '\\') acceptable = true;
            else if(c == '"' && !acceptable) return null;
        }
        if(dots > 1) isNum = false;
        if(isNum) return Float.parseFloat(val);
        return val;
    }
}
