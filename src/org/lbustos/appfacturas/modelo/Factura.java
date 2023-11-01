package org.lbustos.appfacturas.modelo;

import java.text.SimpleDateFormat;
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

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFactura item: this.items) {
            if (item == null) {
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String verDetalle() {
        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(id)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescipción: ")
                .append(this.description)
                .append("\n")
                .append("Fecha Emisión: ").append(df.format(this.fecha)).append("\n")
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");


        for (ItemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            sb.append(item)
                    .append("\n");
            /*.getProducto().getCodigo())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())
                    .append("\n");*/
        }
        sb.append("\nGranTotal: ")
                .append(calcularTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return verDetalle();
    }
}
