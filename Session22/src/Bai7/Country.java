package Bai7;

class Country {
    private int id;
    private String code;
    private String name;

    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("[ ID: %-5d | CODE: %-10s | NAME: %-15s ]", id, "\"" + code + "\"", "\"" + name + "\"");
    }
}
