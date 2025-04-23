package org.devSayan;

public class JavaMemoryManagement {
    int id ;
    String name;
    String address;

    public JavaMemoryManagement() {
    }

    public JavaMemoryManagement(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "JavaMemoryManagement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("Hello architect!");
        JavaMemoryManagement javaMemoryManagement = new JavaMemoryManagement(12,"Sayan","jjj");
        System.out.println(javaMemoryManagement.address + " " + javaMemoryManagement.id);

        
    }
}
