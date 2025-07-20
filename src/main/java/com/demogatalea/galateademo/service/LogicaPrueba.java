package com.demogatalea.galateademo.service;

public class LogicaPrueba{

        public static boolean validacionPalabraClave(String[] Json) {

            //Con esto sé cuantas palabras me llegan
            int filas = Json.length;
            
            //con este se el tamaño de la primera palabra
            int columnas = Json[0].length();

            // voy a recorrer por filas y luego columnas
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    char letraActual = Json[i].charAt(j);

                    // voy a recorrer de forma horizontal la matriz de derecha a izquierda
                    if (j + 3 < columnas &&
                            letraActual == Json[i].charAt(j + 1) &&
                            letraActual == Json[i].charAt(j + 2) &&
                            letraActual == Json[i].charAt(j + 3)) {
                        return true;
                    }

                    // voy a recorrer de forma vertical la matriz
                    if (i + 3 < filas &&
                            letraActual == Json[i + 1].charAt(j) &&
                            letraActual == Json[i + 2].charAt(j) &&
                            letraActual == Json[i + 3].charAt(j)) {
                        return true;
                    }

                    // voy a recorrer de forma diagonal de izquierda a derecha la matriz
                    if (i + 3 < filas && j + 3 < columnas &&
                            letraActual == Json[i + 1].charAt(j + 1) &&
                            letraActual == Json[i + 2].charAt(j + 2) &&
                            letraActual == Json[i + 3].charAt(j + 3)) {
                        return true;
                    }

                    // voy a recorrer de forma diagonal de derecha a izquierda la matriz
                    if (i + 3 < filas && j - 3 >= 0 &&
                            letraActual == Json[i + 1].charAt(j - 1) &&
                            letraActual == Json[i + 2].charAt(j - 2) &&
                            letraActual == Json[i + 3].charAt(j - 3)) {
                        return true;
                    }
                }
            }

            return false;
        }

    }

