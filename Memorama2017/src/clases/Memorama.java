/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author ca_tics
 */
public class Memorama {

    private String[] tablero = new String[28];
    private String jugador1;
    private String jugador2;
    private int paresJ1;
    private int paresJ2;
    private int catego;
    private int fondo;
    private boolean turnoJ1;    // true= Tira el jugador1, false= Tira el jugador2
    private boolean banNuevo;   // false= No se han registrado los datos de un nuevo juego
    // true= Ya se registraron los datos de un nuevo juego
    private int tiro1;      //Primer tiro
    private int tiro2;      //Segundo tiro
    private boolean banTiro1 = true;  //true = tiro1, false = tiro2
    private boolean[] volteadas = new boolean[28];
    private int nSel;   //Número de tarjetas seleccionadas

    /**
     * En este método se inicializa el juego desde el principio, se manda llamar
     * en el main para reiniciar los valores a como estaban desde el principio
     */
    public void Memorama() {
        paresJ1 = 0;
        paresJ2 = 0;
        catego = 0;
        turnoJ1 = true;
        banNuevo = false;
        banTiro1 = true;
        nSel = 0;
        for ( int i = 0; i < 28; i++ ) {
            volteadas[i] = false;
        }
    }

    /**
     * Se obtiene el número del fondo para después cambiar de fondo.
     * @param fondo 
     */
    public void setFondo(int fondo) {
        this.fondo = fondo;
    }
    
    /**
     * En este método se inicializa el juego desde el principio, se manda llamar
     * en el main para reiniciar los valores a como estaban desde el principio
     */
    public void inicializar() {
        paresJ1 = 0;
        paresJ2 = 0;
        //catego = 0;
        turnoJ1 = true;
        banNuevo = false;
        banTiro1 = true;
        nSel = 0;
        for ( int i = 0; i < 28; i++ ) {
            volteadas[i] = false;
        }
    }

    /**
     * Se obtiene el tiro de los jugadores.
     * Si es true = Tiro Jugador 1
     * Si es false = Tiro Jugador 2
     * @return 
     */
    public boolean isBanTiro1() {
        return banTiro1;
    }

    /**
     * Se obtiene el tiro del jugador 1 y se registra más adelante
     * para conocer el ganador
     * @return 
     */
    public int getTiro1() {
        return tiro1;
    }

    /**
     * Se obtiene el tiro del jugador 2 y se registra más adelante
     * para conocer el ganador
     * @return 
     */
    public int getTiro2() {
        return tiro2;
    }

    /**
     * Se obtiene el fondo de las tarjetas
     * @return 
     */
    public int getFondo() {
        return fondo;
    }

    /**
     * En este método se verifica el tiro para conocer el tirador y asi, poder
     * cambiar de turno
     * @param tiro 
     */
    public void setTiro(int tiro) {
        if (!volteadas[tiro]) { // No ha sido volteada esa tarjeta ?
            if (banTiro1) { //Tiro 1
                tiro1 = tiro;
                banTiro1 = false;
            } else {
                tiro2 = tiro;
                banTiro1 = true;
            }
            volteadas[tiro] = true;
            nSel++;
        }
    }

    /**
     * En este método se verifica si las dos tarjetas que han sido volteadas 
     * son iguales, entonces se considera par y se registra en la variable 
     * paresJ1 o paresJ2
     * @return 
     */
    public boolean verificar() {
        if (nSel != 0 && tablero[tiro1].equals(tablero[tiro2])) {
            if (turnoJ1) {  //Es turno del jugador 1
                paresJ1++;
                nSel = 0;
            } else {
                paresJ2++;
                nSel = 0;
            }
            return true;
        } else {
            volteadas[tiro1] = false; //Disponibles ambas tarjetas
            volteadas[tiro2] = false;
            turnoJ1 = !turnoJ1;  //cambiar de turno 
            nSel = 0;
            return false;
        }
    }

    /**
     * En este método se obtiene la tarjeta que esta seleccionada
     * @return nombre tarjeta
     */
    public int getnSel() {
        return nSel;
    }
    
    /**
     * En este método sirve para conocer si existe un juego nuevo.
     * @param banNuevo 
     */
    public void setBanNuevo(boolean banNuevo) {
        this.banNuevo = banNuevo;
    }

    /**
     * En este método devuelve si ya se inicio el juego o no
     * @return true / false
     */
    public boolean isBanNuevo() {
        return banNuevo;
    }

    /**
     * En este método se guarda el nombre del jugador 1
     * @param jugador1 
     */
    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    /**
     * En este método se guarda el nombre del jugador 2
     * @param jugador2 
     */
    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    /**
     * En este método se guarda el número de la categoria que se selecciono
     * @param catego 
     */
    public void setCatego(int catego) {
        this.catego = catego;
    }

    /**
     * Se obtiene el número de la categoria
     * @return 
     */
    public int getCatego() {
        return catego;
    }

    /**
     * Se obtiene el nombre de la categoria
     * @return 
     */
    public String getNomCatego() {
        if (catego == 1) {
            return "Famosos";
        } else if (catego == 2) {
            return "Caricaturas";
        } else if (catego == 3) {
            return "Jugadores";
        } else if (catego == 4) {
            return "Yugioh";
        } else {
            return null;
        }
    }

    /**
     * Se obtiene el nombre del jugador 1
     * @return 
     */
    public String getJugador1() {
        return jugador1;
    }

    /**
     * Se obtiene el nombre del jugador 2
     * @return 
     */
    public String getJugador2() {
        return jugador2;
    }

    /**
     * Se obtiene el número de pares del jugador 1 que se va acumulando para conocer al
     * ganador más adelante
     * @return 
     */
    public int getParesJ1() {
        return paresJ1;
    }

    /**
     * Se obtiene el número de pares del jugador 1 que se va acumulando para conocer al
     * ganador más adelante
     * @return 
     */
    public int getParesJ2() {
        return paresJ2;
    }

    /**
     * Se obtiene las posiciones dentro del tablero
     * @param pos
     * @return 
     */
    public String getTablero(int pos) {
        return tablero[pos];
    }

    /**
     * Método que devuelve el ganador del juego
     * @return 1: Gana el jugador 1; 2: Gana el jugador 2; 3: Empate!!; 
     * 0: Aún no termina el juego
     */
    public int ganador() {
        if ( paresJ1 + paresJ2 == 14) {
            if(paresJ1 > paresJ2) {
                return 1;    // Gano el jugador uno
            } else if (paresJ2 > paresJ1) {
                return 2;   // Gano el jugador dos
            } else {
                return 3; //Empate!!!
            }
        } else {
            return 0;   // Aún no termina el juego 
        }
    }
    
    /**
     * Se obtiene el turno del jugador
     * @return 
     */
    public boolean isTurnoJ1() {
        return turnoJ1;
    }

    /**
     * Este método se utiliza para cambiar de fondo 
     */
    private void cambiarFondo(){   
        switch (fondo) {
            case 1:     //duke
                for (int i = 0; i < 28; i++) {
                        tablero[i] = "/fondos/reverso.jpg";
                    }
            break;
            case 2:     //Yu-Gi-Oh
                for (int i = 0; i < 28; i++) {
                        tablero[i] = "/fondos/fondoy.jpg";
                    }
                break;
            case 3:     //pony   
                for (int i = 0; i < 28; i++) {
                        tablero[i] = "/fondos/f4.jpg";
                    }
            break;
            case 4:     //hermoso       
                for (int i = 0; i < 28; i++) {
                        tablero[i] = "/fondos/f1.jpg";
                    }
            break;
            case 5:     //baraja      
                for (int i = 0; i < 28; i++) {
                        tablero[i] = "/fondos/f2.png";
                }
            break;
        }
    }
    
    /**
     * Se obtiene la categoria y se cambia, si el usuario lo desea puede
     * cambiar de categoria antes de iniciar el juego
     */
    public void seleccionarImagenes() {
        boolean[] seleccionadas = new boolean[30];
        Random r1 = new Random();
        int pos = 0;
        int i = 0;        //<-----
        switch (catego) {
            case 1:     //famosos
                while (i < 14) {
                    pos = r1.nextInt(30);
                    if (seleccionadas[i] == false) {
                        tablero[i] = "/famosos/c" + (i + 1) + ".jpg";
                        tablero[i + 14] = "/famosos/c" + (i + 1) + ".jpg";
                        seleccionadas[i] = true;
                        i++;
                    }
                }
                break;
            case 2:     //caricaturas
                while (i < 14) {
                    pos = r1.nextInt(30);
                    if (!seleccionadas[i]) {
                        tablero[i] = "/caricaturas/c" + (i + 1) + ".jpg";
                        tablero[i + 14] = "/caricaturas/c" + (i + 1) + ".jpg";
                        seleccionadas[i] = true;
                        i++;
                    }
                }
                break;
            case 3:   //Jugadores
                while (i < 14) {
                    pos = r1.nextInt(30);
                    if (!seleccionadas[i]) {
                        tablero[i] = "/jugadores/j" + (i + 1) + ".jpg";
                        tablero[i + 14] = "/jugadores/j" + (i + 1) + ".jpg";
                        seleccionadas[i] = true;
                        i++;
                    }
                }
                break;
            case 4:   //YUGIOH
                while (i < 14) {
                    pos = r1.nextInt(30);
                    if (!seleccionadas[i]) {
                        tablero[i] = "/yugioh/y" + (i + 1) + ".jpg";
                        tablero[i + 14] = "/yugioh/y" + (i + 1) + ".jpg";
                        seleccionadas[i] = true;
                        i++;
                    }
                }
                break;
        }
    }

    /**
     * Con este método se mezclan las imagenes al comenzar el juego
     */
    public void mezclarImagenes() {
        Random r1 = new Random();
        int x;
        int y;
        String tempo = "";
        for (int i = 0; i < 500; i++) {
            x = r1.nextInt(28);
            y = r1.nextInt(28);
            tempo = tablero[x];
            tablero[x] = tablero[y];
            tablero[y] = tempo;
        }
    }
}
