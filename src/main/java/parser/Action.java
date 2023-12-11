package parser;

public class Action {
    public act action;
    public int number;

    public Action(act action, int number) {
        this.action = action;
        this.number = number;
    }

    public String toString() {
        return switch (action) {
            case accept -> "acc";
            case shift -> "s" + number;
            case reduce -> "r" + number;
        };
    }
}

enum act {
    shift, reduce, accept
}
