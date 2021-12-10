public class Administrativo extends Teacher{
    private int _bonus = 100;
    Administrativo(String nombre) {
        super(nombre);
    }
    int Sueldo(){
        return this._bonus + this._salarioBaseMensual;
    }
}
