package org.lbustos.appfacturas.modelo;

import java.util.Date;

public class Factura {
    private Cliente cliente;
    private ItemFactura[] items;
    private int indexItems;
    private int id;
    private String description;
    private Date fecha;
    public static final int MAX_ITEMS = 12;
    private static int ultimoID;

    public Factura(String description, Cliente cliente) {
        this.description = description;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.id = ++ultimoID;
        this.fecha = new Date();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void addItemFactura(ItemFactura item) {
        if (indexItems < items.length) {
            this.items[indexItems++] = item;
        }

    }

    public double calcularTotal() {
        return 0.0;
    }

    public String verDetalle() {
        return "";
    }

}
