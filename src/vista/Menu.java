package vista;

import modelos.Exchange;
import modelos.Moneda;
import servicios.Conversion;
import servicios.Cuenta;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

        public void iniciaMenu() {
            Scanner teclado = new Scanner(System.in);

            try {
                while (true) {
                    System.out.println("""
                        
                        Elija una opción.
                        1.- DOLARES ---> a PESOS ARGENTINOS.
                        2.- PESOS ARGENTINOS ---> a DOLARES.
                        3.- DÓLARES ---> a REALES BRASILEÑOS.
                        4.- REALES BRASILEÑOS ---> a DÓLARES.
                        5.- DÓLARES ---> a PESOS COLOMBIANOS.
                        6.- PESOS COLOMBIANOS ---> A DOLARES.
                        7.- SALIR""");

                    int opcionNumerica = Integer.parseInt(teclado.nextLine());

                    if (opcionNumerica >= 1 && opcionNumerica <= 6) {
                        while (true) {
                            System.out.println("Ingrese el monto a convertir:");
                            String montoIngresado = teclado.nextLine().trim();
                            double montoAConvertir = Double.parseDouble(montoIngresado);

                            // Validar que el monto sea positivo
                            if (montoAConvertir <= 0) {
                                System.out.println("El monto ingresado debe ser mayor que cero.");
                                continue; // Volver a solicitar el monto
                            }

                            String codigoMonedaOrigen = null;
                            String codigoMonedaFinal = null;

                            switch (opcionNumerica) {
                                case 1:
                                    codigoMonedaOrigen = Moneda.USD.getCodigo();
                                    codigoMonedaFinal = Moneda.ARS.getCodigo();
                                    break;
                                case 2:
                                    codigoMonedaOrigen = Moneda.ARS.getCodigo();
                                    codigoMonedaFinal = Moneda.USD.getCodigo();
                                    break;
                                case 3:
                                    codigoMonedaOrigen = Moneda.USD.getCodigo();
                                    codigoMonedaFinal = Moneda.BRL.getCodigo();
                                    break;
                                case 4:
                                    codigoMonedaOrigen = Moneda.BRL.getCodigo();
                                    codigoMonedaFinal = Moneda.USD.getCodigo();
                                    break;
                                case 5:
                                    codigoMonedaOrigen = Moneda.USD.getCodigo();
                                    codigoMonedaFinal = Moneda.COP.getCodigo();
                                    break;
                                case 6:
                                    codigoMonedaOrigen = Moneda.COP.getCodigo();
                                    codigoMonedaFinal = Moneda.USD.getCodigo();
                                    break;
                            }

                            System.out.printf("Usted eligió la opción %d: %s a %s.%n", opcionNumerica, codigoMonedaOrigen, codigoMonedaFinal);
                            System.out.printf("Monto a convertir: %.4f%n", montoAConvertir);

                            Conversion conversion = new Conversion();
                            double tasaDeConversion = conversion.ConsultaAPI(codigoMonedaOrigen, codigoMonedaFinal);

                            // Mostrar la tasa de conversión obtenida
                            System.out.printf("Tasa de conversión obtenida: %.4f%n", tasaDeConversion);
                            double total =0;
                            Cuenta cuenta = new Cuenta();

                            total= cuenta.convierteMonto(montoAConvertir,tasaDeConversion);
                            Exchange exchange = new Exchange(codigoMonedaOrigen, codigoMonedaFinal, tasaDeConversion);
                            exchange.toString();
                            System.out.println(montoAConvertir+ " "+codigoMonedaOrigen+ " corresponden a "+ total+" "+codigoMonedaFinal);
                            break; // Salir del bucle de ingreso de monto
                        }
                    } else if (opcionNumerica == 7) {
                        System.out.println("¡Hasta luego! Gracias por usar el conversor de tipos de cambio.");
                        break; // Salir del método iniciarMenu()
                    } else {
                        System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 7.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Debe ingresar un número del 1 al 7.");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                System.out.println("Error al consultar la API de conversión. Inténtelo nuevamente.");
            } finally {
                teclado.close(); // Cerrar el scanner al salir del método
            }
        }
    }



/*

        public String iniciaMenu() {
            Scanner teclado = new Scanner(System.in);
            int opcionNumerica = 0;
           // double montoAConvertir = 0.0;
            String codigoMonedaOrigen=null;
            String codigoMonedaFinal=null;


            while (true) {
                //var CodigoMoneda=" ";

                System.out.println("""
                    ¡Bienvenido al conversor de tipos de cambio!
                    Elija una opción.
                    1.- DOLARES ---> a PESOS ARGENTINOS.
                    2.- PESOS ARGENTINOS ---> a DOLARES.
                    3.- DÓLARES ---> a REALES BRASILEÑOS.
                    4.- REALES BRASILEÑOS ---> a DÓLARES.
                    5.- DÓLARES ---> a PESOS COLOMBIANOS.
                    6.- PESOS COLOMBIANOS ---> A DOLARES.
                    7.- SALIR""");

                try {
                    opcionNumerica = Integer.parseInt(teclado.nextLine());

                    if (opcionNumerica >= 1 && opcionNumerica <= 6) {
                        while (true) {
                            System.out.println("Ingrese el monto a convertir:");
                            String montoIngresado = teclado.nextLine().trim();
                            //double montoAConvertir = Double.parseDouble(montoIngresado);

                            try {
                                double montoAConvertir = Double.parseDouble(montoIngresado);

                                // Validar que el monto sea positivo
                                if (montoAConvertir <= 0) {
                                    System.out.println("El monto ingresado debe ser mayor que cero.");
                                    continue; // Volver a solicitar el monto
                                }

                                // Mostrar opción seleccionada y monto a convertir
                                switch (opcionNumerica) {
                                    case 1:
                                        codigoMonedaOrigen= Moneda.USD.getCodigo();
                                        codigoMonedaFinal=Moneda.ARS.getCodigo();
                                        break;
                                    case 2:
                                        codigoMonedaOrigen= Moneda.ARS.getCodigo();
                                        codigoMonedaFinal= Moneda.USD.getCodigo();
                                        break;
                                    case 3:
                                        codigoMonedaOrigen=Moneda.USD.getCodigo();
                                        codigoMonedaFinal=Moneda.BRL.getCodigo();
                                        break;
                                    case 4:
                                        codigoMonedaOrigen=Moneda.BRL.getCodigo();
                                        codigoMonedaFinal=Moneda.USD.getCodigo();
                                        break;
                                    case 5:
                                        codigoMonedaOrigen=Moneda.USD.getCodigo();
                                        codigoMonedaFinal=Moneda.COP.getCodigo();
                                        break;
                                    case 6:
                                        codigoMonedaOrigen=Moneda.COP.getCodigo();
                                        codigoMonedaFinal=Moneda.USD.getCodigo();
                                        break;
                                }
                                System.out.printf("Usted eligió la opción %d: %s.%n", opcionNumerica, codigoMonedaOrigen + " a " + codigoMonedaFinal);
                                System.out.printf("Monto a convertir: %.4f%n", montoAConvertir);

                                Conversion conversion = new Conversion();
                               double tasaDeConversion = conversion.ConsultaAPI(codigoMonedaOrigen);

                                // Aquí podrías procesar la respuestaAPI según tus necesidades
                                System.out.println("Tasa de conversión obtenida: %.4f%n" + tasaDeConversion);
                                break; // Salir del bucle de ingreso de monto
/*
                            } catch (NumberFormatException e) {
                                System.out.println("El monto ingresado no es válido. Intente nuevamente.");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }*/
/*
                    } else if (opcionNumerica == 7) {
                        System.out.println("¡Hasta luego! Gracias por usar el conversor de tipos de cambio.");
                        break; // Salir del método iniciarMenu()
                    } else {
                        System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 7.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Debe ingresar un número del 1 al 7.");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                System.out.println("Error al consultar la API de conversión. Inténtelo nuevamente.");
            }
        }
            teclado.close(); // Cerrar el scanner al salir del método
            return codigoMonedaOrigen;
        }
    }



    /*
    public void iniciaMenu() {



            Scanner teclado = new Scanner(System.in);
            int opcionNumerica = 0;
            String montoIngresado = "";
            double montoAConvertir=0;

            while (true) {
                System.out.println("""
                        ¡Bienvenido al conversor de tipos de cambio!
                        Elija una opción.
                        1.- DOLARES ---> a PESOS ARGENTINOS.
                        2.- PESOS ARGENTINOS ---> a DOLARES.
                        3.- DÓLARES ---> a REALES BRASILEÑOS.
                        4.- REALES BRASILEÑOS ---> a DÓLARES.
                        5.- DÓLARES ---> a PESOS COLOMBIANOS.
                        6.- PESOS COLOMBIANOS ---> A DOLARES.
                        7.- SALIR""");

                try {
                    opcionNumerica = Integer.parseInt(teclado.nextLine());

                    if (opcionNumerica >= 1 && opcionNumerica <= 6) {
                        System.out.println("Ingrese el monto a convertir:");
                        montoAConvertir = Double.parseDouble(teclado.nextLine());
                        if (montoAConvertir <= 0) {
                            System.out.println("El monto ingresado debe ser mayor que cero.");
                            continue; // Volver a solicitar la opción
                        }
                        switch (opcionNumerica) {
                            case 1:
                                System.out.println("Usted eligió la opción 1: DOLARES ---> a PESOS ARGENTINOS.");
                                System.out.println(montoAConvertir);
                                break;
                            case 2:
                                System.out.println("Usted eligió la opción 2: PESOS ARGENTINOS ---> a DOLARES.");
                                System.out.println(montoAConvertir);
                                break;
                            case 3:
                                System.out.println("Usted eligió la opción 3: DÓLARES ---> a REALES BRASILEÑOS.");
                                System.out.println(montoAConvertir);
                                break;
                            case 4:
                                System.out.println("Usted eligió la opción 4: REALES BRASILEÑOS ---> a DÓLARES.");
                                System.out.println(montoAConvertir);
                                break;
                            case 5:
                                System.out.println("Usted eligió la opción 5: DÓLARES ---> a PESOS COLOMBIANOS.");
                                System.out.println(montoAConvertir);
                                break;
                            case 6:
                                System.out.println("Usted eligió la opción 6: PESOS COLOMBIANOS ---> A DOLARES.");
                                System.out.println(montoAConvertir);
                                break;
                        }
                    } else if (opcionNumerica == 7) {
                        System.out.println("¡Hasta luego! Gracias por usar el conversor de tipos de cambio.");
                        break; // Salir del método iniciarMenu()
                    } else {
                        System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 7.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Opción inválida. Debe ingresar un número del 1 al 7.");
                }

            }
            teclado.close(); // Cerrar el scanner al salir del método
        }
    }

*/