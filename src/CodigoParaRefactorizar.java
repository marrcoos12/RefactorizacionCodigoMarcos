public class CodigoParaRefactorizar{

    private static final double IVA = 0.21;

    private double calcularIva(double precioBase) {
        return precioBase * (1 + IVA);
    }

    public double calcularIvaSinDescuento(double precioBase) {
        return calcularIva(precioBase);
    }

    public double calcularIvaConDescuento(double precioBase, double porcentajeDescuento) {
        double precioConIva = calcularIva(precioBase);
        return precioConIva - (precioConIva * porcentajeDescuento / 100);
    }

    public int obtenerDiasDelMes(int mes, int anio) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return esBisiesto(anio) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Mes inválido");
        }
    }

    private boolean esBisiesto(int anio) {
        return (anio % 400 == 0) || (anio % 4 == 0 && anio % 100 != 0);
    }

    public double subirPrecioConIva(double precioBase, double subida) {
        double nuevoPrecioBase = precioBase + subida;
        double precioConIva = calcularIva(nuevoPrecioBase);
        mostrarPrecios(nuevoPrecioBase, precioConIva);
        return nuevoPrecioBase;
    }

    private void mostrarPrecios(double nuevoPrecioBase, double precioConIva) {
        System.out.println("El nuevo precio base es " + nuevoPrecioBase);
        System.out.println("El precio con IVA es " + precioConIva);
    }
}

