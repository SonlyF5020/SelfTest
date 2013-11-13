public interface Parkable {
    public void park(MyCar myCar);
    public MyCar getOut(String token);
    public boolean contains(MyCar myCar);

    public boolean isAvaiable();

    public String toList();
}
