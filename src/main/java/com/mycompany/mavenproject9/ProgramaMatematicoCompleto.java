import java.util.Random;
import java.util.Scanner;

public class ProgramaMatematicoCompleto {
    private static Scanner entrada = new Scanner(System.in);

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
            switch (tipoProblema) {
                case 1:
                    return numero1 + numero2;
                case 2:
                    return numero1 - numero2;
                case 3:
                    return numero1 * numero2;
                case 4:
                    return numero1 / numero2;
                default:
                    return 0; 
            }
        }
    }

    public static void main(String[] args) {
        GestorInteraccion gestorInteraccion = new GestorInteraccion();

        gestorInteraccion.mostrarMensaje("Elige el nivel de dificultad (1 o 2):");
        int nivelDificultad = entrada.nextInt();

        gestorInteraccion.mostrarMensaje("Elige el tipo de problema aritmético (1: Suma, 2: Resta, 3: Multiplicación, 4: División):");
        int tipoProblema = entrada.nextInt();

        OperacionesMatematicas operacionesMatematicas = new OperacionesMatematicas(nivelDificultad, tipoProblema);

        int aciertos = 0;
        int errores = 0;
        int totalPreguntas = 10;

        while (aciertos + errores < totalPreguntas) {
            int[] operandos = operacionesMatematicas.generarOperandos();
            String pregunta = operacionesMatematicas.generarPregunta(operandos[0], operandos[1]);
            int respuestaCorrecta = operacionesMatematicas.calcularRespuesta(operandos[0], operandos[1]);

            gestorInteraccion.mostrarMensaje(pregunta);
            int respuestaUsuario = entrada.nextInt();

            if (respuestaUsuario == respuestaCorrecta) {
                aciertos++;
                gestorInteraccion.mostrarMensajePositivo();
            } else {
                errores++;
                gestorInteraccion.mostrarMensajeNegativo();
            }
        }

        gestorInteraccion.mostrarMensaje("Resultados:");
        gestorInteraccion.mostrarMensaje("Aciertos: " + aciertos);
        gestorInteraccion.mostrarMensaje("Errores: " + errores);
    }
}
