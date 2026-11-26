package Model;

public class Motorcycle {
    private String engineSize;
    private String type;
    private String primaryColour;
    private String secondaryColour;
    private double price;

    public Motorcycle() {
        engineSize = "50cc";
        type = "Naked";
        primaryColour = "unpainted";
        secondaryColour = "unpainted";
        price = setPrice(engineSize, type, primaryColour, secondaryColour);
    }

    public Motorcycle(
            String engineSize,
            String type,
            String primaryColour,
            String secondaryColour,
            double price
    ) {
        setEngineSize(engineSize);
        setType(type);
        setPrimaryColour(primaryColour);
        setSecondaryColour(secondaryColour);
        setPrice(engineSize, type, primaryColour, secondaryColour);
    }


}
