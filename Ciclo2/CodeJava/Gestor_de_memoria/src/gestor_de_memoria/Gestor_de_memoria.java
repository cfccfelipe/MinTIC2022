/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor_de_memoria;

/**
 *
 * @author carlos
 */
//
// Gestor_de_memoria
//
import static java.lang.String.format;
import static jdk.nashorn.tools.ShellFunctions.input;

class Gestor_de_memoria {

    static final int MAX_PROCESOS = 8, // Maximo numero de procesos
            NADA = -1,
            LRU_GLOBAL = 0,
            LRU_LOCAL = 1,
            LFU_GLOBAL = 2,
            INVALIDA = 0,
            VALIDA = 1;
    // Clase para las paginas de procesos

    static class Clase_pagina {

        int bit_validez, marco;

        Clase_pagina() {
            bit_validez = INVALIDA;
            marco = NADA;
        }
    }
    // Clase para la informacion de procesos

    static class Clase_proceso {

        private int m_talla;
        Clase_pagina[] Tabla_paginas;
        private int m_ultima_pagina;

        int talla() {
            return m_talla;
        }

        void talla(int talla) {
            int i;
            m_talla = talla;
            m_ultima_pagina = (talla + Tamanyo_pagina - 1) / Tamanyo_pagina - 1;
            Tabla_paginas = new Clase_pagina[m_ultima_pagina + 1];
            for (i = 0; i <= m_ultima_pagina; i++) {
                Tabla_paginas[i] = new Clase_pagina();
            }
        }

        int Ultima_pagina() {
            return m_ultima_pagina;
        }

        Clase_proceso(int v_talla) {
            talla(v_talla);
        }
    }

    // Clase para la informacion de marcos
    static class Clase_marco {

        int pid, pagina, contador;

        Clase_marco() {
            // Hay que inicializar la memoria
            pid = NADA;
            pagina = NADA;
            // 01@@@ Inicializar el campo contador
        }
    }
    // Implementacion de la tabla de procesos
    static Clase_proceso[] Tabla_procesos;
    static int Ultimo_proceso;
    // Implementacion de la memoria
    static Clase_marco[] Memoria;
    static int Ultimo_marco;
    // Datos iniciales calculados
    static int Tamanyo_pagina;
    // FUNCIONES
    // Para elevar un numero a otro

    static int Elevar_a(int a, int b) {
        int i, resultado;
        if (a != 2) {
            resultado = 1;
            for (i = 1; i <= b; i++) {
                resultado *= a;
            }
        } else {
            resultado = 1 << b;
        }
        return resultado;
    }
    // Procedimiento auxiliar para imprimir la memoria

    static void Escribe_memoria() {
        int i;
        output pantalla = new output();
        format f3 = new format(3);
        pantalla.writeln("Contenido de la MEMORIA:");
        pantalla.writeln(" POSICION PID PAGINA CONTADOR");
        pantalla.writeln(" ======== === ====== ========");
        for (i = 0; i <= Ultimo_marco; i++) {
            pantalla.writeln(" " + f3.fmt(i) + " "
                    + f3.fmt(Memoria[i].pid) + " " + f3.fmt(Memoria[i].pagina)
                    + " " + f3.fmt(Memoria[i].contador));
        }
    } // Escribe_memoria
    // Procedimiento auxiliar para imprimir la tabla de procesos

    static void Escribe_Tabla_procesos() {
        int i, j;
        output pantalla = new output();
        format f4 = new format(4), f6 = new format(6);
        pantalla.writeln("Contenido de la TABLA de PROCESOS: ");
        for (i = 0; i <= Ultimo_proceso; i++) {
            pantalla.writeln(" Proceso " + i);
            pantalla.writeln(" Talla = "
                    + f6.fmt(Tabla_procesos[i].talla()));
            pantalla.writeln(" Numero de paginas = "
                    + f4.fmt(Tabla_procesos[i].Ultima_pagina() + 1));
            pantalla.writeln(" Tabla de paginas: ");
            for (j = 0; j <= Tabla_procesos[i].Ultima_pagina(); j++) {
                if (Tabla_procesos[i].Tabla_paginas[j].bit_validez == VALIDA) {
                    pantalla.writeln(j + " "
                            + Tabla_procesos[i].Tabla_paginas[j].marco);
                }
            }
            pantalla.writeln();
        }
    } // Escribe_Tabla_procesos
    // Funcion que encuentra una victima segun una politica LFU global

    static int Aplica_LFU_GLOBAL() {
        // 10@@@ Buscar el marco con menor valor del campo contador
        return 0; // 10@@@ Devolver el marco encontrado
    } // Aplica_LFU_GLOBAL
    // EL PROGRAMA PRINCIPAL

    public static void main(String args[]) {
        // Ficheros involucrados en E/S
        input Fich_sistema, Fich_tamproc, Fich_dirlog, Fich_proc;
        output Fich_fallos, Fich_dirfis;
        // Tabla de procesos
        Tabla_procesos = new Clase_proceso[MAX_PROCESOS];
        // Datos iniciales del fichero sistema
        int p, m, e, n_politica;
        // Datos iniciales calculados
        int Tamanyo_e_logico, politica;
        // Contador de direcciones generadas
        int Contador_refs;
        // Variables para leer la dir. logica y calcular la dir. fisica
        int tamanyo, n_proceso, dir_logica, n_pagina, desplazamiento, n_marco,
                dir_fisica, pag_victima;
        // Variables auxiliares
        int i;
        output pantalla = new output();
        format f2 = new format(2),
                f3 = new format(3),
                f4 = new format(4),
                f6 = new format(6);
        // Primero, abrir los ficheros
        Fich_sistema = new input("SISTEMA");
        Fich_tamproc = new input("TAMPROC");
        Fich_dirlog = new input("DIRLOG");
        Fich_proc = new input("PROC");
        Fich_dirfis = new output("DIRFIS");
        Fich_fallos = new output("FALLOS");
        // Ahora, analizarlos
        // Primero, el de sistema:
        p = Fich_sistema.readint();
        m = Fich_sistema.readint();
        e = Fich_sistema.readint();
        n_politica = Fich_sistema.readint();
        Fich_sistema.close();
        // Obtener los parametros del sistema
        Tamanyo_pagina = Elevar_a(2, p);
        Tamanyo_e_logico = Elevar_a(2, e);
        Ultimo_marco = Elevar_a(2, m) - 1;
        if (n_politica != LFU_GLOBAL) {
            pantalla.writeln("Solo esta programado el LFU global");
        }
        politica = LFU_GLOBAL;
        pantalla.writeln("Tamanyo pagina = " + Tamanyo_pagina);
        pantalla.writeln("Espacio logico = " + Tamanyo_e_logico);
        pantalla.writeln("Numero marcos = " + (Ultimo_marco + 1));
        pantalla.write("Politica = ");
        switch (politica) {
            case LFU_GLOBAL:
                pantalla.writeln("LFU global");
        }
        pantalla.writeln();
        // Y ahora leer e inicializar la tabla de procesos:
        Ultimo_proceso = -1;
        while (Ultimo_proceso + 1 < MAX_PROCESOS && Fich_tamproc.more()) {
            Ultimo_proceso++;
            tamanyo = Fich_tamproc.readint();
            Tabla_procesos[Ultimo_proceso] = new Clase_proceso(tamanyo);
        }
        Fich_tamproc.close();
        Escribe_Tabla_procesos();
        // Vector de marcos = MEMORIA
        Memoria = new Clase_marco[Ultimo_marco + 1];
        // Inicializar la memoria
        for (i = 0; i <= Ultimo_marco; i++) {
            Memoria[i] = new Clase_marco();
        }
        // El bucle principal
        for (Contador_refs = 1; Fich_proc.more(); Contador_refs++) {
            pantalla.writeln("Referencia numero " + f3.fmt(Contador_refs));
            pantalla.writeln("=====================");
            // Leer la referencia actual
            n_proceso = Fich_proc.readint();
            if (n_proceso >= MAX_PROCESOS) {
                n_proceso = 0; // Por si acaso
            }
            dir_logica = Fich_dirlog.readint();
            // Calcular la pagina y el desplazamiento
            n_pagina = 0; // 02@@@
            desplazamiento = 0; // 02@@@
            pantalla.writeln("Proc. " + f2.fmt(n_proceso)
                    + " @Logica = " + f6.fmt(dir_logica)
                    + " => " + f3.fmt(n_pagina) + " + " + f4.fmt(desplazamiento));
            // Pertenece esta pagina al proceso?
            if (false) { // 03@@@ SI SE HACE REFERENCIA A UNA PAGINA
                // QUE NO EXISTE EN EL PROCESO, ...
                Fich_fallos.writeln("ERROR");
                Fich_dirfis.writeln("ERROR");
                pantalla.writeln("Direccion erronea.");
            } else { // Es una referencia valida para ese proceso
                // Comprobar si esa pagina esta en memoria.
                if (true) { // 09@@@ Si la pagina no esta en memoria
                    Fich_fallos.writeln("F");
                    pantalla.writeln("FALLO de PAGINA: Procesando...");
                    // SI EXISTE UN MARCO LIBRE, UTILIZARLO.
                    // Asignar a la variable i el valor resultante
                    // de la busqueda.
                    i = 0;
                    // 07@@@
                    if (true) // 08@@@ Si existe un marco libre,
                    // identificado por i
                    {
                        pag_victima = i;
                    } else { // Si no,
                        // UTILIZAR UN ALG. DE REEMPLAZO DE PAGINAS
                        // PARA ELEGIR UNA VICTIMA
                        switch (politica) {
                            case LFU_GLOBAL:
                                pag_victima = Aplica_LFU_GLOBAL();
                                break;
                            default:
                                pag_victima = 0;
                        }
                        pantalla.writeln(
                                "Alg. de Reemplazo --> Marco seleccionado ="
                                + f3.fmt(pag_victima));
                    } // De si no existe un marco libre
                    // ACTUALIZAR LA TABLA DE PAGINAS Y LA TABLA DE MARCOS
                    // Una vez se tiene la pagina-victima, se ocupa con
                    // la pagina que ha producido el fallo
                    if (Memoria[pag_victima].pagina != NADA)
 // Si estaba ocupada, se desocupa
 ;// 11@@@
                    // Actualizar la memoria
                    // 04@@@
                    // Y registrar el marco en la tabla de paginas del proceso
                    // 05@@@
                    // Viene bien anotarse en la variable n_marco el numero
                    // de marco en que hemos puesto la pagina
                    n_marco = pag_victima;
                    // Ahora (para el LFU global), poner a cero el contador de
                    // referencias de la pagina a la que se esta accediendo
                    // Memoria[...].contador = 12@@@;
                } // De si la pagina no esta en memoria
                else {
                    Fich_fallos.writeln();
                    // Viene bien anotarse en la variable n_marco el numero
                    // de marco en que esta la pagina
                    n_marco
                            = Tabla_procesos[n_proceso].Tabla_paginas[n_pagina].marco;
                    // Ahora (para el LFU global), incrementar el contador de
                    // referencias de la pagina a la que se esta accediendo
                    // Memoria[...].contador = 12@@@;
                }
                // Al final, calcular la direccion fisica
                dir_fisica = 0; // 06@@@
                // Y escribirla en el fichero
                pantalla.writeln(
                        ">>>>>>==========================>>> @FISICA = "
                        + f6.fmt(dir_fisica));
                Fich_dirfis.writeln(dir_fisica);
            } // De si es una referencia valida para el proceso
            Escribe_memoria();
            pantalla.writeln(
                    "###########################################################");
            pantalla.writeln();
        } // Del bucle de lectura de referencias logicas
        // Para finalizar, cerrar los ficheros
        Fich_proc.close();
        Fich_dirlog.close();
        Fich_dirfis.close();
        Fich_fallos.close();
    }
}
