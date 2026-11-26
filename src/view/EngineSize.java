package view;

public enum EngineSize {
    cc_50(50),
    cc_125(125),
    cc_250(250),
    cc_400(400),
    cc_650(650),
    cc_800(800),
    cc_950(950);

    private final int cc;

    EngineSize(int cc) {
        this.cc = cc;
    }

    public int getCc() {
        return cc;
    }

    @Override
    public String toString() {
        return cc + "cc";
    }
}
