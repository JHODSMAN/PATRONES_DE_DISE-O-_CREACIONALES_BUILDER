public class Computadora {
    private String procesador;
    private int ram;
    private int almacenamiento;
    private boolean tarjetaGrafica;
    private boolean wifi;

    private Computadora(ComputadoraBuilder builder) {
        this.procesador = builder.procesador;
        this.ram = builder.ram;
        this.almacenamiento = builder.almacenamiento;
        this.tarjetaGrafica = builder.tarjetaGrafica;
        this.wifi = builder.wifi;
    }

    public String getProcesador() {
        return procesador;
    }

    public int getRam() {
        return ram;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public boolean tieneTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public boolean tieneWifi() {
        return wifi;
    }

    @Override
    public String toString() {
        return "Computadora [Procesador: " + procesador + ", RAM: " + ram + 
               " GB, Almacenamiento: " + almacenamiento + " GB, Tarjeta Gráfica: " + 
               tarjetaGrafica + ", WiFi: " + wifi + "]";
    }

    public static class ComputadoraBuilder {
        private String procesador;
        private int ram;
        private int almacenamiento;
        private boolean tarjetaGrafica;
        private boolean wifi;

        public ComputadoraBuilder(String procesador, int ram) {
            this.procesador = procesador;
            this.ram = ram;
        }

        public ComputadoraBuilder setAlmacenamiento(int almacenamiento) {
            this.almacenamiento = almacenamiento;
            return this;
        }

        public ComputadoraBuilder setTarjetaGrafica(boolean tarjetaGrafica) {
            this.tarjetaGrafica = tarjetaGrafica;
            return this;
        }

        public ComputadoraBuilder setWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public Computadora build() {
            return new Computadora(this);
        }
    }
}
