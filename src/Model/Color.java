package Model;

public enum Color {
    Or,
    Solaire,
    Lunaire,
    Gloire;

    public static String enumToString(Color c){
        switch (c){
            case Or: return "Or";
            case Lunaire: return "Lunaire";
            case Solaire: return "Solaire";
            case Gloire: return "Gloire";
        }
        return "error";
    }
}
