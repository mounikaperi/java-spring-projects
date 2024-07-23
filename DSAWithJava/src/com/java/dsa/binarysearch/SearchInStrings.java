import java.util.Arrays;

class SearchInStrings {
    public static void main(String[] args) {
       String name = "Shinchan";
       char target = 'z';
       System.out.println(isCharPresentInString(name, target));
    }
    static boolean isCharPresentInString(String name, char target) {
        if (name.length() == 0) return false;
        for (char ch: name.toCharArray())
            if (ch == target) return true;
        return false;
    }
}
