public class ProfesorTC extends Teacher{
    private int _comision = 500;
    ProfesorTC(String nombre) {
        super(nombre);
    }
    int Sueldo() {
        return _salarioBaseMensual;
    }
}
