package org.lbustos.appfacturas;

import org.lbustos.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNombre("Luis Bustos");
        cliente.setNif("1075293947");

        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese la descripción de la factura: ");
        String descipcion = in.nextLine();

        Factura factura = new Factura(descipcion,cliente);

        Producto producto;
/*        String nombre;
        float precio;
        int cantidad;*/

        System.out.println();

        for (int i = 0; i < 5; i++) {
            producto = new Producto();
            System.out.print("Ingrese producto n° " + producto.getCodigo()+ ": ");
            producto.setNombre(in.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(in.nextFloat());

            System.out.print("Ingrese la cantidad: ");

            factura.addItemFactura(new ItemFactura(producto,in.nextInt()));

            System.out.println();
            in.nextLine();
        }

        System.out.println(factura);

    }
}
