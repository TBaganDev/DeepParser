package data;

public class Version implements Comparable<Version> {
    private final int v1, v2, v3;

    public Version(int v1, int v2, int v3) {
        this.v1 = v1; this.v2 = v2; this.v3 = v3;
    }

    @Override
    public String toString() {
        return "v" + v1 + '.' + v2 + '.' + v3;
    }

    @Override
    public int compareTo(Version version) {
        int o1 = version.getFirst(); int o2 = version.getSecond(); int o3 = version.getThird();
        if(v1 > o1 || v2 > o2 || v3 > o3) {
            return 1;
        } else if(v1 < o1 || v2 < o2 || v3 < o3) {
            return -1;
        }
        return 0;
    }

    public int getFirst() { return v1; }

    public int getSecond() { return v2; }

    public int getThird() { return v3; }

}
