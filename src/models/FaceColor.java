package models;

public enum FaceColor {
    Or,
    Solaire,
    Lunaire,
    Gloire;

    public static String enumToString(FaceColor c){
        switch (c){
            case Or: return "Or";
            case Lunaire: return "Lunaire";
            case Solaire: return "Solaire";
            case Gloire: return "Gloire";
        }
        return "error";
    }
}
