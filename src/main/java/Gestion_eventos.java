public class Gestion_eventos {
    public static void main(String[] args) {
        String entradas [][] =new String[10][5];
        agregarPersona(entradas, "Marco", "20", "VIP", "1", "False");
        agregarPersona(entradas, "Ana", "15", "General", "0", "False");

    }
    public static String[][] agregarPersona(String entradas[][], String nombre, String edad, String tipoEntrada, String invitados, String ingresado ){
        for (int i = 0; i < entradas.length; i++) {
            if (entradas[i][0] == null) {
               entradas[i][0] = nombre;
               entradas[i][1] = edad;
               entradas[i][2] = tipoEntrada;
               entradas[i][3] = invitados;
               entradas[i][4] = ingresado;
            }

        }
        return entradas;
    }
    public static boolean verificarEdad (String entradas[][], String nombre){
        for (int i = 0; i < entradas.length; i++) {
            if (entradas[i][0] != null && entradas [i][0].equals(nombre)) {
                int edad = Integer.parseInt(entradas[i][1]);
                if (edad >= 18){
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    public static String verificarBoleto (String entradas[][], String nombre){
        for (int i = 0; i < entradas.length; i++) {
            if (entradas[i][0] != null && entradas[i][0].equals(nombre)) {
                String tipoEntrada = entradas[i][2];
                if (tipoEntrada.equals("General") || tipoEntrada.equals("VIP")) {
                    return tipoEntrada;
                } else {
                    return "false";
                }
            }
        }
        return "false";
    }
    public static boolean validarInvitado (String entradas[][], String nombre){
        for (int i = 0; i < entradas.length; i++) {
            if (entradas[i][0] == null && entradas[i][0].equals(nombre)) {
                if (entradas[i][2] != null  && entradas[i][2].equals("VIP")) {
                    int invitados = Integer.parseInt(entradas[i][3]);
                    if (invitados > 2) {
                        return false;
                    }
                }
                break;
            }
        }
        return true;
    }
    public static int aforoDisponible(String entradas[][], String tipoEntrada){
        int aforoMaxVIP = 50;
        int aforoMaxGeneral =200;
        int contador = 0;
        for (int i = 0; i < entradas.length; i++) {
            if (entradas[i][2] == null && entradas[i][2].equals(tipoEntrada)) {
                contador++;
                int invitados = Integer.parseInt(entradas[i][3]);
                contador += invitados;
            }
        }
        if (tipoEntrada.equals("VIP")) {
            return aforoMaxVIP - contador;

        } else if (tipoEntrada.equals("General")) {
            return aforoMaxGeneral - contador;
        } else{
            return -1;
        }
    }
    public static boolean permitirEntrada (String entradas[][], int fila) {
        if (fila < 0 || fila >= entradas.length || entradas[fila][0] == null) {
            return false;
        }
        String nombre = entradas[fila][0];
        boolean esMayorDeEdad = verificarEdad(entradas, nombre);
        String tipoEntrada = verificarBoleto(entradas, nombre);
        int aforoRestante = aforoDisponible(entradas, tipoEntrada);

        if (!esMayorDeEdad) {
            return false;
        }
        if (!tipoEntrada.equals("General") && !tipoEntrada.equals("VIP")) {
            return false;
        }
        if (aforoRestante <= 0) {
            return false;
        }
        return true;
    }
    public static Boolean removerPersona (String entradas[][], String nombre){
        for (int i = 0; i < entradas.length; i++) {
            if (entradas[i][0] != null && entradas[i][0].equals(nombre)) {
                entradas[i][1] = null;
                entradas[i][2] = null;
                entradas[i][3] = null;
                entradas[i][4] = "False";
                System.out.println("Persona " + nombre + " removida correctamente.");
                return true;



            }
        }
        System.out.println("La persona " + nombre + " no está registrada en la lista.");
        return false;
    }








}
