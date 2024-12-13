public enum Zona {
    AMERICA_DEL_NORTE(12, "America del Norte", 2.75f),

    AMERICA_CENTRAL(15, "America Central", 1.89f),

    AMERICA_DEL_SUR(18, "America del Sur", 1.60f),
    EUROPA(19, "Europa", 3.50f),

    ASIA(23, "Asia", 4.50f),

    AFRICA(25, "Africa", 3.10f),

    OCEANIA(29, "Oceania", 3.00f),

    RESTO_DEL_MUNDO(31, "Resto del Mundo", 6.00f);

    private final int clave;
    private final String nombre;
    private final float costoMinuto;

    Zona(int clave, String nombre, float costoMinuto) {
        this.clave = clave;
        this.nombre = nombre;
        this.costoMinuto = costoMinuto;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public float getCostoMinuto() {
        return costoMinuto;
    }

    public static Zona obtenerZonaPorClave(int clave) {
        for (Zona zona : values()) {
            if (zona.getClave() == clave) {
                return zona;
            }
        }
        return null;
    }
}