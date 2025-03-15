package org.knit.Solutions.Task9;

class Part {
    private final int id;
    private boolean defective;

    public Part(int id) {
        this.id = id;
        this.defective = Math.random() < 0.2; // 20% шанс брака
    }

    public int getId() {
        return id;
    }

    public boolean isDefective() {
        return defective;
    }
}
