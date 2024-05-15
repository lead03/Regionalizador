package app.componentes;

public enum Provincia {
	BUENOS_AIRES(0),
    CATAMARCA(1),
    CHACO(2),
    CHUBUT(3),
    CORDOBA(4),
    CORRIENTES(5),
    ENTRE_RIOS(6),
    FORMOSA(7),
    JUJUY(8),
    LA_PAMPA(9),
    LA_RIOJA(10),
    MENDOZA(11),
    MISIONES(12),
    NEUQUEN(13),
    RIO_NEGRO(14),
    SALTA(15),
    SAN_JUAN(16),
    SAN_LUIS(17),
    SANTA_CRUZ(18),
    SANTA_FE(19),
    SANTIAGO_DEL_ESTERO(20),
    TIERRA_DEL_FUEGO(21),
    TUCUMAN(22);
    
    private int valor;

    // Constructor para asignar el valor int a cada constante
    Provincia(int valor) {
        this.valor = valor;
    }

    // Método para obtener el valor int de la provincia
    public int getValor() {
        return valor;
    }
}
