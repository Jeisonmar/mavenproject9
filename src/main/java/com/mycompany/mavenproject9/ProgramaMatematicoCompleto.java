import java.util.Random;

public class ProgramaMatematicoCompleto {

    public static class GestorInteraccion {
        Random random;

        public GestorInteraccion() {
            random = new Random();
        }

        public void mostrarMensaje(String mensaje) {
            System.out.println(mensaje);
        }

        public void mostrarMensajePositivo() {
            String[] mensajesPositivos = {
                "¡Muy bien!",
                "¡Excelente!",
                "¡Buen trabajo!",
                "¡Sigue así!"
            };

            int indiceAleatorio = random.nextInt(mensajesPositivos.length);
            System.out.println(mensajesPositivos[indiceAleatorio]);
        }

        public void mostrarMensajeNegativo() {
            String[] mensajesNegativos = {
                "Incorrecto. Intenta una vez más.",
                "No es correcto, inténtalo de nuevo.",
                "Lamentablemente, esa no es la respuesta correcta.",
                "Sigue intentando."
            };

            int indiceAleatorio = random.nextInt(mensajesNegativos.length);
            System.out.println(mensajesNegativos[indiceAleatorio]);
        }
    }

    public static class OperacionesMatematicas {
        int nivelDificultad;
        int tipoProblema;
        Random generador;

        public OperacionesMatematicas(int nivelDificultad, int tipoProblema) {
            this.nivelDificultad = nivelDificultad;
            this.tipoProblema = tipoProblema;
            this.generador = new Random();
        }

        public int[] generarOperandos() {
            int limite = (int) Math.pow(10, nivelDificultad) - 1;
            int numero1 = generador.nextInt(limite) + 1;
            int numero2 = generador.nextInt(limite) + 1;
            return new int[]{numero1, numero2};
        }

        public String generarPregunta(int numero1, int numero2) {
            String signo = "";
            if (tipoProblema == 1) signo = " + ";
            else if (tipoProblema == 2) signo = " - ";
            else if (tipoProblema == 3) signo = " x ";
            else if (tipoProblema == 4) signo = " / ";
            return "¿Cuánto es " + numero1 + signo + numero2 + "?";
        }

        public int calcularRespuesta(int numero1, int numero2) {
            if (tipoProblema == 1) return numero1 + numero2;
            else if (tipoProblema == 2) return numero1 - numero2;
            else if (tipoProblema == 3) return numero1 * numero2;
            else if (tipoProblema == 4) return numero1 / numero2;
            else return 0;
        }
    }

    public static void main(String[] args) {
        // La interacción con el usuario y la lógica del juego se añadirán en futuros commits.
    }
}

