import java.util.Scanner;

public class AplikasiTodolist {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodolist();
    }

    // testing

    public static void tesShowTodolist(){
        model[0] = "Belajar java dasar";
        model[1] = "Belajar java oop";
        model[2] = "Belajar databse";
        model[3] = "Belajar studikasus";
        showTodolist();
    }

    /**
     * Method untuk menampilkan todolist
     */
    public static void showTodolist(){
        System.out.println("TO DO LIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var nomor = i+1;

            if(todo != null){
                System.out.println(nomor + ". " + todo);
            }
        }
    }

    /**
     * Method untuk menambahkan todolist
     */
    public static void addTodolist(String todo){
        //cek apakah model penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if(model[i]==null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        //jika penuh kita resize ukuran array 2x lipat
        if(isFull){
            var temp = model;
            model = new String[model.length*2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        //tambahkan ke posisi array yang datanya Null
        for (int i = 0; i < model.length; i++) {
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    // testing
    public static void tesAddTodolist(){
        for (int i = 0; i < 11; i++) {
            addTodolist("Nomor: " + i);
        }
        showTodolist();
    }

    public static String input(String info){
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }
    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    /**
     * Method untuk menghapus todolist
     */
    public static boolean delTodolist(Integer nomor){
        if((nomor - 1) >= model.length){
            return false;
        }else if(model[nomor-1] == null){
            return false;
        }else{
            for (int i = (nomor - 1); i < model.length; i++) {
                if (i == (model.length-1)){
                    model[i] = null;
                }else{
                    model[i] = model[i+1];
                }
            }
            return true;
        }
    }

    //testing
    public static void testDelTodolist(){
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        addTodolist("Lima");
        var result = delTodolist(11);
        System.out.println(result);

        result = delTodolist(7);
        System.out.println(result);

        result = delTodolist(1);
        showTodolist();

    }

    /**
     * Method menampilkan view todolist
     */
    public static void viewShowTodolist(){
        while (true){
            showTodolist();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Exit");

            var input = input("Pilih");
            if(input.equals("1")){
                viewAddTodolist();
            }else if (input.equals("2")){
                viewDelTodolist();
            }else if(input.equals("x")){
                break;
            }
            else{
                System.out.println("Pilihan tidak mengerti");
            }
        }
    }
    //testing
    public static void tesViewShowTodolist(){
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        viewShowTodolist();
    }

    /**
     * Method menampilkan view tambah todolist
     */
    public static void viewAddTodolist(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x Jika Batal)");

        if(todo.equals("x")){

        } else {
            addTodolist(todo);
        }
    }

    public static void testViewAddTodolist() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");

        viewAddTodolist();
        showTodolist();
    }

    /**
     * Method menampilkan view delete todolist
     */
    public static void viewDelTodolist(){
        System.out.println("MENAMBAH TODOLIST");

        var number = input("Nomor yang dihapus (x Jika Batal)");

        if(number.equals("x")){

        } else {
           boolean success =  delTodolist(Integer.valueOf(number));
           if (!success){
               System.out.println("Gagal menghapus todolist: " + number);
           }
        }
    }

    public static void testViewDelTodlist(){
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");

        showTodolist();

        viewDelTodolist();

        showTodolist();
    }

}
